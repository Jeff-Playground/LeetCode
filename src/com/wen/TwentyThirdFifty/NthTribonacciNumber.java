package com.wen.TwentyThirdFifty;

import java.util.HashMap;
import java.util.Map;

public class NthTribonacciNumber {
    // DP, top down
    public int tribonacci(int n) {
        Map<Integer, Integer> cache=new HashMap<>();
        cache.put(0,0);
        cache.put(1,1);
        cache.put(2,1);
        return tHelper(cache, n);
    }

    private int tHelper(Map<Integer, Integer> cache, int n){
        if(!cache.containsKey(n)){
            cache.put(n, tHelper(cache, n-1)+tHelper(cache, n-2)+tHelper(cache, n-3));
        }
        return cache.get(n);
    }

//    // DP, bottom up
//    public int tribonacci(int n) {
//        int[] result=new int[n+1];
//        result[0]=0;
//        if(n>=1){
//            result[1]=1;
//        }
//        if(n>=2){
//            result[2]=1;
//        }
//        for(int i=3; i<=n; i++){
//            result[i]=result[i-1]+result[i-2]+result[i-3];
//        }
//        return result[n];
//    }
}
