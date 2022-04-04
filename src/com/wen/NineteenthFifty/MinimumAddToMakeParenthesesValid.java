package com.wen.NineteenthFifty;

public class MinimumAddToMakeParenthesesValid {
//    // Greedy, left stands for the number of left parentheses need to be added and right vice versa
//    public int minAddToMakeValid(String S) {
//        int left=0, right=0;
//        for(char c: S.toCharArray()){
//            if(c=='('){
//                right++;
//            } else{
//                if(right==0){
//                    left++;
//                } else{
//                    right--;
//                }
//            }
//        }
//        return left+right;
//    }

    public int minAddToMakeValid(String S) {
        if(S==null || S.length()==0){
            return 0;
        }
        int result=0, l=S.length(), count=0;
        for(int i=0; i<l; i++){
            char c=S.charAt(i);
            if(c=='('){
                count++;
            } else{
                if(count>0){
                    count--;
                } else{
                    result++;
                }
            }
        }
        result+=count;
        return result;
    }
}
