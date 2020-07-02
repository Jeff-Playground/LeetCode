package com.wen.EighthFifty;

public class SuperPow {
    public int superPow(int a, int[] b) {
        int result=1;
        for(int i=0; i<b.length; i++){
            result=pow(result, 10)*pow(a, b[i])%1337;
        }
        return result;
    }

    private int pow(int num, int n){
        if(n==0){
            return 1;
        } else if(n==1){
            return num%1337;
        } else{
            return pow(num%1337, n/2)*pow(num%1337, n-n/2)%1337;
        }
    }
}
