package com.wen.SixthFifty;

public class LQUglyNumberII {
    public int nthUglyNumber(int n) {
        int[] factors={2,3,5};
        int fn=factors.length;
        int[] indexes=new int[fn];
        int[] ugly=new int[n];
        ugly[0]=1;
        int count=1;
        while(count<n){
            int min=Integer.MAX_VALUE, index=-1;
            for(int i=0; i<fn; i++){
                if(min>factors[i]*ugly[indexes[i]]){
                    min=factors[i]*ugly[indexes[i]];
                    index=i;
                }
            }
            if(min!=ugly[count-1]){
                ugly[count]=min;
                count++;
            }
            indexes[index]++;
        }
        return ugly[n-1];
    }
}
