package com.wen.FirstFifty;

public class LongestPalindromicSubstring {
//    // Dynamic Programming O(n^2)
//    // isPalindrome[i][j] stands for whether s.substring(i, j+1) is palindromic
//    public static String longestPalindrome(String s) {
//        if(s.length()<=1){
//            return s;
//        }
//        int[][] isPalindrome=new int[s.length()][s.length()];
//        int left=0, right=0, len=0;
//        // Note because dp[i][j] depends on dp[i+1][j-1], so the loop is like below
//        for(int j=0; j<s.length(); j++){
//            for(int i=0; i<=j; i++){
//                if(i==j){
//                    isPalindrome[i][j]=1;
//                } else if(i==j-1){
//                    isPalindrome[i][j]=s.charAt(i)==s.charAt(j)?1:0;
//                } else{
//                    isPalindrome[i][j]=(isPalindrome[i+1][j-1]==1)&&s.charAt(i)==s.charAt(j)?1:0;
//                }
//                if(isPalindrome[i][j]==1 && j-i+1>len){
//                    len=j-i+1;
//                    left=i;
//                    right=j;
//                }
//            }
//        }
//        return s.substring(left, right+1);
//    }


    // Manacher's algorithm
    public static String longestPalindrome(String s) {
        if(s==null || s.isEmpty()){
            return "";
        } else{
            int l=s.length();
            StringBuilder sb=new StringBuilder("$#");
            for(int i=0; i<l; i++){
                sb.append(s.charAt(i)+"#");
            }
            int[] r=new int[2*l+2];
            r[0]=1;
            int maxReachIdx=0, maxReach=0, maxIdx=0, maxR=1;
            for(int i=1; i<2*l+2 && 2*l+1-i+1>maxR; i++){
                r[i]=1;
                if(i<=maxReach){
                    r[i]=Math.min(r[2*maxReachIdx-i], maxReach-i+1);
                }
                while(i-r[i]>=0 && i+r[i]<2*l+2 && sb.charAt(i+r[i])==sb.charAt(i-r[i])){
                    r[i]++;
                }
                if(i+r[i]-1>maxReach){
                    maxReachIdx=i;
                    maxReach=i+r[i]-1;
                }
                if(r[i]>maxR){
                    maxIdx=i;
                    maxR=r[i];
                }
            }
            return s.substring((maxIdx-maxR+1)/2, (maxIdx+maxR-1)/2);
        }
    }
}
