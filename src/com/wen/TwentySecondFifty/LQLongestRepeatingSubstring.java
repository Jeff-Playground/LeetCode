package com.wen.TwentySecondFifty;

/*
Given a string S, find out the length of the longest repeating substring(s). Return 0 if no repeating substring exists.

Example 1:
Input: "abcd"
Output: 0
Explanation: There is no repeating substring.

Example 2:
Input: "abbaba"
Output: 2
Explanation: The longest repeating substrings are "ab" and "ba", each of which occurs twice.

Example 3:
Input: "aabcaabdaab"
Output: 3
Explanation: The longest repeating substring is "aab", which occurs 3 times.

Example 4:
Input: "aaaaa"
Output: 4
Explanation: The longest repeating substring is "aaaa", which occurs twice.

Note:
The string S consists of only lowercase English letters from 'a' - 'z'.
1 <= S.length <= 1500
 */

import java.util.Arrays;

public class LQLongestRepeatingSubstring {
    public int longestRepeatingSubstring(String S) {
        int l=S.length();
        Integer[] sa=new Integer[l];
        for(int i=0; i<l; i++){
            sa[i]=i;
        }
        Arrays.sort(sa, (a, b)->S.substring(a).compareTo(S.substring(b)));
        int result=0;
        for(int i=1; i<l; i++){
            int len=0, i1=sa[i-1], i2=sa[i];
            while(i1<l && i2<l && S.charAt(i1)==S.charAt(i2)){
                i1++;
                i2++;
                len++;
            }
            result=Math.max(result, len);
        }
        return result;
    }
}
