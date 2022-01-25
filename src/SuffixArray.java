import java.util.*;

public class SuffixArray {

    public static void main(String[] args){
        String input="abcabcdabc";
        Integer[] suffixArray=buildSuffixArray(input);
        System.out.println("Suffix array stored suffices:");
        for(int idx: suffixArray){
            System.out.println(input.substring(idx));
        }
        System.out.println();

        Integer[][] lcpArray=buildLCPArray(input);
        System.out.println("LCP array stored values:");
        System.out.println("Length of longest common prefix - Suffix");
        for(int i=0; i<lcpArray[0].length; i++){
            System.out.println(lcpArray[1][i]+" - "+input.substring(lcpArray[0][i]));
        }

        // Calculate number of distinct substrings:
        //      number of all substrings - number of repeated substrings
        //      (1+n)*n/2-(1...n-1)lcpArray[1][i]
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
        Integer[][] lcpArray=new Integer[3][l];

        TrieNode root=new TrieNode();
        for(int i=0; i<l; i++){
            root.addSuffix(t.substring(i), i);
        }
        putSortedStartingIndices(lcpArray[0], new int[]{0}, root);


        for(int i=0; i<l; i++){
            if(lcpArray[0][i]<=s1.length()){
                lcpArray[1][i]=1;
            } else if(lcpArray[0][i]<=s1.length()+1+s2.length()){
                lcpArray[1][i]=2;
            } else{
                lcpArray[1][i]=3;
            }
        }

        for(int i=1; i<l; i++){
            int i1=lcpArray[0][i-1], i2=lcpArray[0][i], count=0;
            while(i1<l && i2<l && t.charAt(i1)==t.charAt(i2)){
                i1++;
                i2++;
                count++;
            }
            lcpArray[2][i]=count;
        }
//        // Check built suffix array
//        for(int i=0; i<l; i++){
//            System.out.println("string"+lcpArray[1][i]+" - "+lcpArray[2][i]+" - "+t.substring(lcpArray[0][i]));
//        }

        // Use sliding window to ensure at least k strings
        List<Integer> maxIdx=new ArrayList<>();
        int max=0;
        int start=0, end=0, count=1;
        Map<Integer, Set<Integer>> stringIdx=new HashMap<>();
        stringIdx.put(1, new HashSet<>());
        stringIdx.put(2, new HashSet<>());
        stringIdx.put(3, new HashSet<>());
        stringIdx.get(lcpArray[1][0]).add(0);
        while(end<l){
            if(count<k){
                end++;
                if(end<l){
                    if(stringIdx.get(lcpArray[1][end]).isEmpty()){
                        count++;
                    }
                    stringIdx.get(lcpArray[1][end]).add(end);
                }
            } else{
                while(stringIdx.get(lcpArray[1][start]).size()>1){
                    stringIdx.get(lcpArray[1][start]).remove(start);
                    start++;
                }
                int cur=Integer.MAX_VALUE;
                for(int i=start+1; i<=end; i++){
                    cur=Math.min(cur, lcpArray[2][i]);
                }
                if(cur>max){
                    maxIdx=new ArrayList<>();
                    maxIdx.add(lcpArray[0][end]);
                    max=cur;
                } else if(cur==max && cur>0){
                    maxIdx.add(end);
                }
                stringIdx.get(lcpArray[1][start]).remove(start);
                start++;
                count--;
            }
        }
        Set<String> rSet=new HashSet<>();
        if(max>0){
            int length=max;
            maxIdx.forEach(i->rSet.add(t.substring(i, i+length)));
        }
        return new ArrayList<>(rSet);
    }

    private static Integer[][] buildLCPArray(String input) {
        int l=input.length();
        Integer[][] lcpArray=new Integer[2][l];

//        // Using a suffix trie instead for sorting
//        for(int i=0; i<l; i++){
//            lcpArray[0][i]=i;
//        }
////        Arrays.sort(lcpArray[0], (a, b)->input.substring(a).compareTo(input.substring(b)));
//        Arrays.sort(lcpArray[0], Comparator.comparing(a -> input.substring(a)));

        TrieNode root=new TrieNode();
        for(int i=0; i<l; i++){
            root.addSuffix(input.substring(i), i);
        }
        putSortedStartingIndices(lcpArray[0], new int[]{0}, root);
        for(int i=1; i<l; i++){
            int i1=lcpArray[0][i-1], i2=lcpArray[0][i];
            int count=0;
            while(i1<l && i2<l && input.charAt(i1)==input.charAt(i2)){
                i1++;
                i2++;
                count++;
            }
            lcpArray[1][i]=count;
        }
        return lcpArray;
    }

    private static Integer[] buildSuffixArray(String input){
        int l=input.length();
        Integer[] suffixArray=new Integer[l];

//        // Using a suffix trie instead for sorting
//        for(int i=0; i<l; i++){
//            suffixArray[i]=i;
//        }
////        Arrays.sort(suffixArray, (a, b)->input.substring(a).compareTo(input.substring(b)));
//        Arrays.sort(suffixArray, Comparator.comparing(input::substring));

        TrieNode root=new TrieNode();
        for(int i=0; i<l; i++){
            root.addSuffix(input.substring(i), i);
        }
        putSortedStartingIndices(suffixArray, new int[]{0}, root);
        return suffixArray;
    }

    private static void putSortedStartingIndices(Integer[] suffixArray, int[] index, TrieNode curSuffixTrieNode){
        if(curSuffixTrieNode.startIndex!=-1){
            suffixArray[index[0]++]=curSuffixTrieNode.startIndex;
        }
        for(TrieNode c: curSuffixTrieNode.children){
            if(c!=null){
                putSortedStartingIndices(suffixArray, index, c);
            }
        }
    }

    private static class TrieNode{
        TrieNode[] children;
        int startIndex;

        public TrieNode(){
            children=new TrieNode[256];
            startIndex =-1;
        }

        public void addSuffix(String suffix, int startIndex){
            TrieNode cur=this;
            for(char c: suffix.toCharArray()){
                if(cur.children[c]==null){
                    cur.children[c]=new TrieNode();
                }
                cur=cur.children[c];
            }
            cur.startIndex =startIndex;
        }
    }
}
