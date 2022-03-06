package com.wen.FourteenthFifty;

import java.util.HashMap;
import java.util.Map;

public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        if(moves.length()%2!=0){
            return false;
        }
        int c1=0, c2=0;
        for(char c: moves.toCharArray()){
            if(c=='L'){
                c1++;
            } else if(c=='R'){
                c1--;
            } else if(c=='U'){
                c2++;
            } else{
                c2--;
            }
        }
        return c1==0 && c2==0;
    }

//    public boolean judgeCircle(String moves) {
//        if(moves.length()%2!=0){
//            return false;
//        }
//        Map<Character, Integer> count=new HashMap<>();
//        for(char c: moves.toCharArray()){
//            count.put(c, count.getOrDefault(c, 0)+1);
//        }
//        boolean result=true;
//        if(count.containsKey('L') || count.containsKey('R')){
//            result=count.getOrDefault('L', 0).equals(count.getOrDefault('R', 0));
//        }
//        if(result && (count.containsKey('U') || count.containsKey('D'))){
//            result=count.getOrDefault('U', 0).equals(count.getOrDefault('D', 0));
//        }
//        return result;
//    }
}
