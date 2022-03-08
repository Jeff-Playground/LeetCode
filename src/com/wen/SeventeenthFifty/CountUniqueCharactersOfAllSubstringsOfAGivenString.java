package com.wen.SeventeenthFifty;

public class CountUniqueCharactersOfAllSubstringsOfAGivenString {
//    // idx stores the last 2 positions of the char occurrence(note it actually stores idx+1, so we don't need to init idx
//    // values with -1)
//    //
//    // The general idea is instead of calculating the sum of all unique chars for all substrings, calculate the sum of all
//    // chars when it is a unique char in a substring.
//    //
//    // For each char, (idx[curIdx][1]-idx[curIdx][0]) is the number of distinct substrings which has only 1 occurrence of
//    // char that ends with char, (i-idx[curIdx][1]) is the number of distinct substrings which has only 1 occurrence of
//    // char that starts with char. Multiplied together, the value stands for the number of distinct substrings which has
//    // only 1 occurrence of char that has char in the middle.
//    //
//    // Note for the above calculation works for the first occurrence of chars because for the first occurrence we always
//    // have (idx[curIdx][1]-idx[curIdx][0])==0, therefore it doesn't contribute false positives to the result.
//    //
//    // Note the above calculation only calculates for char when it's in the middle of 3 consecutive occurrences, so in the
//    // end we need one additional loop, for which we assume the char at l is a third occurrence of the calculated char
//    // and make the result complete.
//    public int uniqueLetterString(String s) {
//        int l=s.length(), result=0;
//        int[][] idx=new int[26][2];
//        for(int i=1; i<=l; i++){
//            char c=s.charAt(i-1);
//            int curIdx=c-'A';
//            result+=(idx[curIdx][1]-idx[curIdx][0])*(i-idx[curIdx][1]);
//            idx[curIdx][0]=idx[curIdx][1];
//            idx[curIdx][1]=i;
//        }
//        for(int i=0; i<26; i++){
//            result+=(idx[i][1]-idx[i][0])*(l+1-idx[i][1]);
//        }
//        return result;
//    }

    // DP, dp[i] stands for the count of unique chars for all substrings ends at s.charAt(i)
    //
    // The general idea is to compute dp[i] by dp[i-1] and the contribution of the new char s.charAt(i)
    //
    // dp[i-1]=(i-2<0?0:dp[i-2])+(i-idx[curIdx][1])-(idx[curIdx][1]-idx[curIdx][0])
    // the first part dp[i-1] is the count of unique chars for all substrings ends at s.charAt(i-1)
    // the second part (i-idx[curIdx][1]) is the contribution for the current s.charAt(i), it equals to the number of
    // distinct substrings which has only 1 occurrence of char and ends at char
    // the third part (idx[curIdx][1]-idx[curIdx][0]) is the contribution of the last occurrence for the same char, this
    // is because the new char created a duplication which would cancel out the contribution of the last occurrence
//    public int uniqueLetterString(String s) {
//        int l=s.length();
//        int[] dp=new int[l];
//        int[][] idx=new int[26][2];
//        for(int i=1; i<=l; i++){
//            char c=s.charAt(i-1);
//            int curIdx=c-'A';
//            dp[i-1]=(i-2<0?0:dp[i-2])+(i-idx[curIdx][1])-(idx[curIdx][1]-idx[curIdx][0]);
//            idx[curIdx][0]=idx[curIdx][1];
//            idx[curIdx][1]=i;
//        }
//        int result=0;
//        for(int i=0; i<l; i++){
//            result+=dp[i];
//        }
//        return result;
//    }

    // Optimized DP, the idea is the same to above except the dp array is replaced by a variable to save space
    public int uniqueLetterString(String s) {
        int l=s.length();
        int cur=0, result=0;
        int[][] idx=new int[26][2];
        for(int i=1; i<=l; i++){
            char c=s.charAt(i-1);
            int curIdx=c-'A';
            cur=cur+(i-idx[curIdx][1])-(idx[curIdx][1]-idx[curIdx][0]);
            idx[curIdx][0]=idx[curIdx][1];
            idx[curIdx][1]=i;
            result+=cur;
        }
        return result;
    }
}
