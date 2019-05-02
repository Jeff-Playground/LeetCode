package com.wen.FirstFifty;

public class LongestValidParentheses {
    // Dynamic Programming(Start from end of string)
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int maxLen = 0;
        for(int i = s.length()-2; i >=0; i--){
            if(s.charAt(i)=='('){
                int end = i + dp[i+1] + 1;
                if(end < s.length() && s.charAt(end)==')'){
                    dp[i] = dp[i+1] + 2;
                    if(end + 1 < s.length()){
                        dp[i] += dp[end + 1];
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

//    // Dynamic Programming(Start from beginning of string)
//    public int longestValidParentheses(String s) {
//        int result=0;
//        if(s==null || s.length()<2){
//            return result;
//        }
//        int[] dp=new int[s.length()];
//        for(int i=1; i<s.length(); i++){
//            if(s.charAt(i)==')'){
//                int start=i-1-dp[i-1];
//                if(start>=0 && s.charAt(start)=='('){
//                    dp[i]=dp[i-1]+2;
//                    if(start-1>=0){
//                        dp[i]+=dp[start-1];
//                    }
//                }
//                result=Math.max(result, dp[i]);
//            }
//        }
//        return result;
//    }

//    public int longestValidParentheses(String s) {
//        if(s==null){
//            return 0;
//        }
//        int result=0;
//        int start=0;
//        Stack<Integer> stack=new Stack<Integer>();
//        for(int i=0; i<s.length(); i++){
//            if(s.charAt(i)=='('){
//                stack.push(i);
//            }else{
//                if(stack.empty()){
//                    start=i+1;
//                }else{
//                    stack.pop();
//                    result=stack.empty()?Math.max(result,i-start+1):Math.max(result,i-stack.peek());
//                }
//            }
//        }
//        return result;
//    }
}
