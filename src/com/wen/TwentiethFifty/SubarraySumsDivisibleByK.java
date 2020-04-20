package com.wen.TwentiethFifty;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {
//    public int subarraysDivByK(int[] A, int K) {
//        int result=0;
//        if(A==null || A.length==0){
//            return 0;
//        }
//        int l=A.length, sum=0, mod=0;
//        Map<Integer, Integer> count=new HashMap<>();
//        count.put(mod, 1);
//        for(int i=0; i<l; i++){
//            sum+=A[i];
//            mod=(sum%K+K)%K;
//            int exist=count.getOrDefault(mod, 0);
//            result+=exist;
//            count.put(mod, exist+1);
//        }
//        return result;
//    }

    // Optimized to use array instead of Map
    public int subarraysDivByK(int[] A, int K) {
        int result=0;
        if(A==null || A.length==0){
            return 0;
        }
        int l=A.length, sum=0, mod=0;
        int[] count=new int[K];
        count[mod]=1;
        for(int i=0; i<l; i++){
            sum+=A[i];
            mod=(sum%K+K)%K;
            count[mod]++;
        }
        for(int i=0; i<K; i++){
            if(count[i]>1){
                result+=count[i]*(count[i]-1)/2;
            }
        }
        return result;
    }
}
