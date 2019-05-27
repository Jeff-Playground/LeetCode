package com.wen.EighthFifty;

public class FirstUniqueCharacterInAString {
    // Sliding window, worst case O(2*N)
    public int firstUniqChar(String s) {
        int[] occurrence=new int[26];
        int left=0, right=0;
        while(right<s.length()){
            occurrence[s.charAt(right)-'a']++;
            while(left<=right && occurrence[s.charAt(left)-'a']>1){
                left++;
            }
            right++;
        }
        return left==s.length()?-1:left;
    }
}
