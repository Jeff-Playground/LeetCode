package com.wen.TenthFifty;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int l=A.length, result=0;
        if(l==0){
            return result;
        }
        Map<Integer, Integer> count1=getSumCount(A, B);
        Map<Integer, Integer> count2=getSumCount(C, D);
        for(int key: count1.keySet()){
            if(count2.containsKey(-key)){
                result+=count1.get(key)*count2.get(-key);
            }
        }
        return result;
    }

    private Map<Integer, Integer> getSumCount(int[] A, int[] B){
        Map<Integer, Integer> result=new HashMap<>();
        int l=A.length;
        for(int i=0; i<l; i++){
            for(int j=0; j<l; j++){
                int cur=A[i]+B[j];
                result.put(cur, result.getOrDefault(cur, 0)+1);
            }
        }
        return result;
    }
}
