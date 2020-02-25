package com.wen.SixthFifty;

public class UglyNumberII {
    // Get the sequence by multiply the existing ugly numbers to get the new ones
    // The index array stores the next index of the ugly number which will be multiplied by the corresponding factor
    public int nthUglyNumber(int n) {
        int[] factors={2,3,5};
        int fl=factors.length;
        int[] index=new int[fl];
        int[] ugly=new int[n];
        ugly[0]=1;
        int cur=1;
        while(cur<n){
            int min=Integer.MAX_VALUE, fIndex=-1;
            for(int i=0; i<fl; i++){
                if(min>factors[i]*ugly[index[i]]){
                    min=factors[i]*ugly[index[i]];
                    fIndex=i;
                }
            }
            if(min!=ugly[cur-1]){
                ugly[cur]=min;
                cur++;
            }
            index[fIndex]++;
        }
        return ugly[n-1];
    }
}
