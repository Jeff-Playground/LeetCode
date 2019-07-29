package com.wen.EighthFifty;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int l=s.length();
        int[] occurrence=new int[26];
        for(int i=0; i<l; i++){
            occurrence[s.charAt(i)-'a']++;
        }
        for(int i=0; i<l; i++){
            if(occurrence[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }

//    // Sliding window, worst case O(2*N)
//    public int firstUniqChar(String s) {
//        int[] occurrence=new int[26];
//        int left=0, right=0;
//        while(right<s.length()){
//            occurrence[s.charAt(right)-'a']++;
//            while(left<=right && occurrence[s.charAt(left)-'a']>1){
//                left++;
//            }
//            right++;
//        }
//        return left==s.length()?-1:left;
//    }
}
