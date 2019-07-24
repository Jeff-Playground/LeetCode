package com.wen.SixthFifty;

import java.util.ArrayList;
import java.util.List;

public class LQFlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result=new ArrayList<>();
        int l=s.length();
        for(int i=0; i<l-1; i++){
            if(s.charAt(i)=='+' && s.charAt(i+1)=='+'){
                result.add(s.substring(0, i)+"--"+s.substring(i+2));
            }
        }
        return result;
    }
}
