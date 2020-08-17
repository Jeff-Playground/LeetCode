package com.wen.TenthFifty;

import java.util.HashMap;
import java.util.Map;

public class CanIWin {
    // Use a Map to cache intermediate results to avoid TLE
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger>=desiredTotal){
            return true;
        }
        if((1+maxChoosableInteger)*maxChoosableInteger/2<desiredTotal){
            return false;
        }
        return canIWinMinimax(maxChoosableInteger, 0, desiredTotal, new HashMap<>());
    }

    private boolean canIWinMinimax(int length, int cur, int desiredTotal, Map<Integer, Boolean> cache){
        if(cache.containsKey(cur)){
            return cache.get(cur);
        } else{
            for(int i=length-1; i>=0; i--){
                int temp=1<<i;
                if((temp&cur)==0){
                    if(i+1>=desiredTotal || !canIWinMinimax(length, cur|temp, desiredTotal-i-1, cache)){
                        cache.put(cur, true);
                        return true;
                    }
                }
            }
            cache.put(cur, false);
            return false;
        }
    }
}
