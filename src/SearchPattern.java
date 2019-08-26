import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchPattern {
    public static void main(String[] args) {
        String s="BBC ABCDABDABCDABCDABDE";
        String p="ABCDABD";

//        // Time complexity: O(m+n)
//        // Space complexity: O(m)
//        // Comparing to zSearch, this is a streaming search
//        List<Integer> loc=kmpSearch(s, p);

//        // Time complexity: worst O(m+(n-m+1)*m), expected O(m+n)
//        // Space complexity: in-place
//        List<Integer> loc=rabinKarpSearch(s, p);

//        // Time complexity: worst O(m*n) when no match, best O(n/m) when s: b^n  p: a^(m-1)b
//        // Space complexity: O(m+k), k is the size of the char set
//        List<Integer> loc=boyerMooreSearch(s, p);

        // Time complexity: O(m+n)
        // Space complexity: O(m)
        List<Integer> loc=zSearch(s, p);

//        System.out.println(loc);
    }

    private static List<Integer> zSearch(String s, String p) {
        List<Integer> result=new ArrayList<>();
        String ps=p+s;
        int l=ps.length(), pl=p.length();
        int[] z=new int[l];
        int L=0, R=0;
        for(int i=1; i<=l-pl; i++){
            if(i<=R){
                z[i]=Math.min(R-i+1, z[i-L]);
            }
            while(i+z[i]<l && ps.charAt(i+z[i])==ps.charAt(z[i])){
                z[i]++;
            }
            if(i+z[i]-1>R){
                L=i;
                R=i+z[i]-1;
            }
            if(z[i]==pl){
                result.add(i-pl);
            }
        }
        return result;
    }

    private static List<Integer> boyerMooreSearch(String s, String p) {
        int pl=p.length();

        // bsDist stores when there's a bad char mismatch, the distance need to be moved for p against s
        // to match the last occurrence of the bad char
        int[] bsDist=new int[256];
        Arrays.fill(bsDist, pl);
        for(int i=0; i<pl; i++) {
            bsDist[p.charAt(i)]=pl-1-i;
        }

        // suff stores the suffix length at each char
        int[] suff=new int[pl];
        int st=pl-1, ed=pl-1;
        for(int i=pl-1; i>=0; i--){
            if(i==pl-1){
                suff[i]=pl;
            } else{
                if(i>ed && suff[pl-1-(st-i)]<i-ed){
                    suff[i]=suff[pl-1-(st-i)];
                } else{
                    if(i<ed){
                        ed=i;
                    }
                    st=i;
                    while(ed>=0 && p.charAt(ed)==p.charAt(pl-1-(st-ed))){
                        ed--;
                    }
                    suff[i]=st-ed;
                }
            }
        }

        // gsDist stores when there's a mismatch but have a good suffix, the distance p needs to be moved against s
        // to make the suffix match a previous same suffix
        int[] gsDist=new int[pl];
        // init to pl, which is the value when there's no previous occurrence of matched suffix
        Arrays.fill(gsDist, pl);
        // update for when previous suffix(can be partial) happens at the beginning of p
        int idx=0;
        for(int i=pl-1; i>=0; i--){
            if(suff[i]==i+1){
                while(idx<pl-1-i){
                    if(gsDist[idx]==pl){
                        gsDist[idx]=pl-1-i;
                    }
                    idx++;
                }
            }
        }
        // update for when previous suffix(can't be partial) not at the beginning of p
        for(int i=0; i<pl-1; i++){
            gsDist[pl-1-suff[i]]=pl-1-i;
        }

        int sl=s.length();
        List<Integer> result=new ArrayList<>();
        int i=0, j=pl-1;
        while(i<=sl-pl){
            while(j>=0 && s.charAt(i+j)==p.charAt(j)){
                j--;
            }
            if(j==-1){
                result.add(i);
                i++;
                j=pl-1;
            } else{
                // Here it can be further simplified to below from:
                // i+=Math.max(Math.max(bsDist[s.charAt(i+j)]-(pl-1-j), 1), gsDist[j]);
                // because gsDist will always be no less than 1.
                // Note if only using bad char part logic, the 1 needs to be added to ensure p doesn't travel backwards
                i+=Math.max(bsDist[s.charAt(i+j)]-(pl-1-j), gsDist[j]);
            }
        }

        return result;
    }

    private static List<Integer> rabinKarpSearch(String s, String p) {
        List<Integer> result=new ArrayList<>();
        int pl=p.length(), sl=s.length();
        int d=256, mod=1000000009;
        long h=1;
        for(int i=0; i<pl-1; i++) {
            h=(h*d)%mod;
        }
        long pHash=0, sHash=0;
        for(int i=0; i<pl; i++) {
            pHash=(pHash*d+p.charAt(i))%mod;
            sHash=(sHash*d+s.charAt(i))%mod;
        }
        for(int i=1; i<=sl-pl+1; i++) {
            if(pHash==sHash) {
                // excludes false positives(conflicts)
                if(s.substring(i-1, i-1+pl).equals(p)) {
                    result.add(i-1);
                }
            }
            if(i<=sl-pl) {
                sHash=(((sHash-s.charAt(i-1)*h)*d+s.charAt(i+pl-1))%mod+mod)%mod;
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
