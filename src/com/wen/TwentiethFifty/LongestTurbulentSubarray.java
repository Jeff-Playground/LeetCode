package com.wen.TwentiethFifty;

public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] A) {
        if(A==null || A.length==0){
            return 0;
        }
        int l=A.length;
        int start=0, pre=0, result=1;
        for(int i=1; i<l; i++){
            if(i==1){
                result=A[i]==A[i-1]?1:2;
            } else{
                if((pre<0 && A[i]-A[i-1]>0) || (pre>0 && A[i]-A[i-1]<0)){
                    result=Math.max(result, i-start+1);
                } else{
                    start=i-1;
                }
            }
            pre=A[i]-A[i-1];
        }
        return result;
    }
}
