package com.wen.SeventeenthFifty;

import java.util.HashSet;
import java.util.Set;

public class CardFlippingGame {
    public int flipgame(int[] fronts, int[] backs) {
        int result=Integer.MAX_VALUE, l=fronts.length;
        Set<Integer> dup=new HashSet<>();
        for(int i=0; i<l; i++){
            if(fronts[i]==backs[i]){
                dup.add(fronts[i]);
            }
        }
        for(int f: fronts){
            if(!dup.contains(f)){
                result=Math.min(result, f);
            }
        }
        for(int b: backs){
            if(!dup.contains(b)){
                result=Math.min(result, b);
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }
}
