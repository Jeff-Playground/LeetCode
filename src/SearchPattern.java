import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchPattern {
    public static void main(String[] args) {
        String s="BBC ABCDABDABCDABCDABDE";
        String p="ABCDABD";

//        // Time complexity: O(m+n)
//        // Space complexity: O(m)
//        // Comparing to zSearch, this is better in regards to it can be used to search against a stream
//        List<Integer> loc=kmpSearch(s, p);

        // Time complexity: worst O(m+(n-m+1)*m), expected O(m+n)
        // Space complexity: in-place
        List<Integer> loc=rabinKarpSearch(s, p);

//        // Time complexity: worst O(m*n) when no match, best O(n/m) when s: b^n  p: a^(m-1)b
//        // Space complexity: O(m+k), k is the size of the char set
//        // A good reference: https://writings.sh/post/algorithm-string-searching-boyer-moore
//        List<Integer> loc=boyerMooreSearch(s, p);

//        // Time complexity: O(m+n)
//        // Space complexity: O(m)
//        List<Integer> loc=zSearch(s, p);

        System.out.println(loc);
    }

    private static List<Integer> zSearch(String s, String p) {
        List<Integer> result=new ArrayList<>();
        StringBuilder ps=new StringBuilder(p);
        // Note here append a special char that can't appear in both s and p
        ps.append('#');
        ps.append(s);
        int psl=ps.length(), pl=p.length();
        int[] z=new int[psl];
        // [left, right] here is a window for which ps.substring(left, right) is a prefix for ps, note this is not
        // necessarily the biggest window, but it's the RIGHTMOST window
        int left=0, right=0;
        for(int i=pl+1; i<psl; i++){
            if(i<=right){
                z[i]=Math.min(z[i-left], right-i+1);
            }
            while(i+z[i]<psl && ps.charAt(i+z[i])==ps.charAt(z[i])){
                z[i]++;
            }
            if(i+z[i]-1>right){
                left=i;
                right=i+z[i]-1;
            }
            if(z[i]==pl){
                result.add(i-pl-1);
            }
        }
        return result;
    }

    private static List<Integer> boyerMooreSearch(String s, String p) {
        int pl=p.length();

        // badCharDist stores when there's a bad char mismatch, the distance need to be moved for p against s
        // to match the LAST occurrence of the bad char
        // size is 256 for extended ASCII
        int[] badCharDist=new int[256];
        // when the char is not in p, move pl which is the length of p
        Arrays.fill(badCharDist, pl);
        for(int i=0; i<pl; i++) {
            badCharDist[p.charAt(i)]=pl-1-i;
        }

        int[] goodSuffixDist=new int[pl];
        int curPrefixLength=0;
        goodSuffixDist[pl-1]=1;
        for(int i=pl-2; i>=0; i--){
            int curSuffixLength=pl-1-i;
            if(p.startsWith(p.substring(i+1))){
                curPrefixLength=curSuffixLength;
            }
            goodSuffixDist[i]=pl+curSuffixLength-curPrefixLength;
        }
        for(int i=0; i<pl-1; i++){
            int longestCommonSuffixLength=0, j=pl-1;
            while(i-longestCommonSuffixLength>=0 && p.charAt(i-longestCommonSuffixLength)==p.charAt(j)){
                j--;
                longestCommonSuffixLength++;
            }
            if(longestCommonSuffixLength>0){
                goodSuffixDist[pl-1-longestCommonSuffixLength]=pl-1-i+longestCommonSuffixLength;
            }
        }

        int sl=s.length();
        List<Integer> result=new ArrayList<>();
        int i=pl-1;
        while(i<sl){
            int j=pl-1;
            while(j>=0 && s.charAt(i)==p.charAt(j)){
                i--;
                j--;
            }
            if(j==-1){
                result.add(i+1);
                i+=p.length()+1;
            } else{
                i+=Math.max(badCharDist[s.charAt(i)], goodSuffixDist[j]);
            }
        }

        return result;
    }

    private static List<Integer> rabinKarpSearch(String s, String p) {
        List<Integer> result=new ArrayList<>();
        int pl=p.length(), sl=s.length();
        int d=256, mod=1_000_000_009;
        long h=1;
        for(int i=0; i<pl-1; i++) {
            h=h*d%mod;
        }
        long pHash=0, sHash=0;
        for(int i=0; i<pl; i++) {
            pHash=(pHash*d+p.charAt(i))%mod;
            sHash=(sHash*d+s.charAt(i))%mod;
        }
        for(int i=pl; i<=sl; i++) {
            if(pHash==sHash) {
                // excludes false positives(conflicts)
                if(s.substring(i-pl, i).equals(p)) {
                    result.add(i-pl);
                }
            }
            if(i<sl) {
                sHash=(((sHash-s.charAt(i-pl)*h)%mod+mod)%mod*d%mod+s.charAt(i))%mod;
            }
        }
        return result;
    }

    private static List<Integer> kmpSearch(String s, String p) {
        int pl=p.length();
        int[] next=new int[pl];
        next[0]=-1;
        int i=-1, j=0;
        while(j<p.length()-1){
            if(i==-1 || p.charAt(i)==p.charAt(j)){
                i++;
                j++;
                // Optimized
                if(p.charAt(i)!=p.charAt(j)){
                    next[j]=i;
                } else{
                    next[j]=next[i];
                }
                // Non-optmized
                // next[j]=i;
            } else{
                i=next[i];
            }
        }

        List<Integer> result=new ArrayList<>();
        int sl=s.length();
        i=0;
        j=0;
        while(i<sl && j<pl){
            if(j==-1 || s.charAt(i)==p.charAt(j)){
                i++;
                j++;
                if(j==pl){
                    result.add(i-pl);
                    j=0;
                }
            } else{
                j=next[j];
            }
        }
        return result;
    }
}
