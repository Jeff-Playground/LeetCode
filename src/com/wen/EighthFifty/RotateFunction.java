package com.wen.EighthFifty;

public class RotateFunction {
    public static int maxRotateFunction(int[] A) {
        if(A==null){
            throw new IllegalArgumentException("Input array can't be null!");
        }
        if(A.length<=1){
            return 0;
        }
        int total=0, cur=0, result=0, n=A.length;
        for(int i=0; i<n; i++){
            total+=A[i];
            cur+=i*A[i];
        }
        result=cur;
        for(int i=1; i<n; i++){
            cur=cur+total-A[n-i]*n;
            result=Math.max(result, cur);
        }
        return result;
    }
}
