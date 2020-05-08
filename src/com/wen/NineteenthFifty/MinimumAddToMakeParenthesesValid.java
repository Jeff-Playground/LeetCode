package com.wen.NineteenthFifty;

public class MinimumAddToMakeParenthesesValid {
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
