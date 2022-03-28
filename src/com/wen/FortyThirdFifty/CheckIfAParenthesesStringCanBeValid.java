package com.wen.FortyThirdFifty;

public class CheckIfAParenthesesStringCanBeValid {
    // Greedy, check the string twice, once left to right, once right to left, each check we ensure ( is no less than )
    public boolean canBeValid(String s, String locked) {
        int l=s.length();
        if(l%2==1){
            return false;
        }
        StringBuilder sb=new StringBuilder(locked);
        return leftNoLessThanRight(s, locked) && leftNoLessThanRight(reverseString(s), sb.reverse().toString());
    }

    private String reverseString(String s){
        int l=s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=l-1; i>=0; i--){
            char c=s.charAt(i);
            sb.append(c==')'?'(':')');
        }
        return sb.toString();
    }

    private boolean leftNoLessThanRight(String s, String locked){
        int l=s.length();
        int left=0, right=0, lc=0, rc=0;
        for(int i=0; i<l; i++){
            char c=s.charAt(i), lock=locked.charAt(i);
            if(c=='('){
                left++;
                if(lock=='0'){
                    lc++;
                }
            } else{
                right++;
                if(lock=='0'){
                    rc++;
                }
                while(left<right && rc>0){
                    rc--;
                    left++;
                    right--;
                }
                if(left<right){
                    return false;
                }
            }
        }
        if(left>right){
            return lc>=(left-right)/2;
        }
        return true;
    }
}
