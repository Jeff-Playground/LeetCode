package com.wen.SixthFifty;

public class LQFlipGameII {
    public boolean canWin(String s){
        int l=s.length();
        boolean result=true;
        for(int i=0; i<l-1; i++){
            if(s.charAt(i)=='+' && s.charAt(i+1)=='+' && !canWin(s.substring(0, i)+"--"+s.substring(i+2))){
                return true;
            }
        }
        return false;
    }
}
