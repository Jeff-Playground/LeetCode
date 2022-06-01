package com.wen.FourteenthFifty;

public class BeautifulArrangementII {
    public int[] constructArray(int n, int k) {
        int left=1, right=n;
        int[] result=new int[n];
        for(int i=0; i<n; i++){
            if(k>1){
                if(k%2==0){
                    result[i]=right--;
                } else{
                    result[i]=left++;
                }
                k--;
            } else{
                result[i]=left++;
            }
        }
        return result;
    }
}
