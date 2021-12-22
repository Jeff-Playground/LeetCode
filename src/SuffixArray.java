import java.util.*;

public class SuffixArray {

    public static void main(String[] args){
        String input="abcabcdabc";
        Integer[] suffixArray=buildSuffixArray(input);
        for(int idx: suffixArray){
            System.out.println(input.substring(idx));
        }

        Integer[][] lcpArray=buildLCPArray(input);
        for(Integer[] e: lcpArray){
            System.out.println(e[1]+" - "+input.substring(e[0]));
        }

        // Calculate number of unique substrings:
        //      number of all substrings - number of repeated substrings
        //      (1+n)*n/2-(1...n-1)lcpArray[i][1]
        // (1...n-1)lcpArray[i][1] is equal to the number of repeated substrings because each entry denotes the length of
        // longest prefix for the give 2 suffixes, note because the iteration will cover all possible suffixes, for each
        // comparison, the length of longest prefix is equal to the number of repeated substrings starting from the first
        // character of both suffixes

        // Find the longest repeated substring:
        //      max=(1...n-1)max(lcpArray[i][1]), i
        //      result=input.substring(i+max)
        // this will compute repeated substring starting from the first character of both suffixes, and the iteration will
        // finally find the longest one

        // Find the longest common substrings among multiple strings(appearing in k different strings):
        // Note this is just a simple example to show the idea, when we have too many strings in the input, a few sentinels
        // might not be enough, so instead, we can map the string characters to integers and then ensure we use smaller
        // integers to play as the unique lexicographically smaller sentinels.
        String s1="abca", s2="bcad", s3="daca";
        List<String> lcs2=findLongestCommonSubstrings(s1, s2, s3, 2);
        System.out.println("Longest common substring appearing in at least 2 strings:");
        lcs2.forEach(System.out::println);
        List<String> lcs3=findLongestCommonSubstrings(s1, s2, s3, 3);
        System.out.println("Longest common substring appearing in at least 3 strings:");
        lcs3.forEach(System.out::println);
    }

    private static List<String> findLongestCommonSubstrings(String s1, String s2, String s3, int k) {
        String t=s1+"#"+s2+"$"+s3+"%";
        int l=t.length();
        Integer[][] sa=new Integer[l][3];
        for(int i=0; i<l; i++){
            sa[i][0]=i;
            if(i<=s1.length()){
                sa[i][1]=1;
            } else if(i<=s1.length()+1+s2.length()){
                sa[i][1]=2;
            } else{
                sa[i][1]=3;
            }
        }
        Arrays.sort(sa, Comparator.comparing(a->t.substring(a[0])));
        for(int i=1; i<l; i++){
            int i1=sa[i-1][0], i2=sa[i][0], count=0;
            while(i1<l && i2<l && t.charAt(i1)==t.charAt(i2)){
                i1++;
                i2++;
                count++;
            }
            sa[i][2]=count;
        }
//        // Check built suffix array
//        for(Integer[] e: sa){
//            System.out.println("string"+e[1]+" - "+e[2]+" - "+t.substring(e[0]));
//        }

        // Use sliding window to ensure at least k strings
        List<Integer> maxIdx=new ArrayList<>();
        int max=0;
        int start=0, end=0, count=1;
        Map<Integer, Set<Integer>> stringIdx=new HashMap<>();
        stringIdx.put(1, new HashSet<>());
        stringIdx.put(2, new HashSet<>());
        stringIdx.put(3, new HashSet<>());
        stringIdx.get(sa[0][1]).add(0);
        while(end<l){
            if(count<k){
                end++;
                if(end<l){
                    if(stringIdx.get(sa[end][1]).isEmpty()){
                        count++;
                    }
                    stringIdx.get(sa[end][1]).add(end);
                }
            } else{
                while(stringIdx.get(sa[start][1]).size()>1){
                    stringIdx.get(sa[start][1]).remove(start);
                    start++;
                }
                int cur=Integer.MAX_VALUE;
                for(int i=start+1; i<=end; i++){
                    cur=Math.min(cur, sa[i][2]);
                }
                if(cur>max){
                    maxIdx=new ArrayList<>();
                    maxIdx.add(sa[end][0]);
                    max=cur;
                } else if(cur==max && cur>0){
                    maxIdx.add(end);
                }
                stringIdx.get(sa[start][1]).remove(start);
                start++;
                count--;
            }
        }
        Set<String> rSet=new HashSet<>();
        if(max>0){
            int length=max;
            maxIdx.forEach(i->rSet.add(t.substring(i, i+length)));
        }
        List<String> result=new ArrayList<>(rSet);
        return result;
    }

    private static Integer[][] buildLCPArray(String input) {
        int l=input.length();
        Integer[][] result=new Integer[l][2];
        for(int i=0; i<l; i++){
            result[i][0]=i;
        }
//        Arrays.sort(result, (a, b)->input.substring(a[0]).compareTo(input.substring(b[0])));
        Arrays.sort(result, Comparator.comparing(a -> input.substring(a[0])));
        for(int i=1; i<l; i++){
            int i1=result[i-1][0], i2=result[i][0];
            int count=0;
            while(i1<l && i2<l && input.charAt(i1)==input.charAt(i2)){
                i1++;
                i2++;
                count++;
            }
            result[i][1]=count;
        }
        return result;
    }

    private static Integer[] buildSuffixArray(String input){
        int l=input.length();
        Integer[] result=new Integer[l];
        for(int i=0; i<l; i++){
            result[i]=i;
        }
//        Arrays.sort(result, (a, b)->input.substring(a).compareTo(input.substring(b)));
        Arrays.sort(result, Comparator.comparing(input::substring));
        return result;
    }
}
