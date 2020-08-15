package com.wen.TenthFifty;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        if((x^y)==0){
            return 0;
        }
        return (x^y)%2+hammingDistance(x>>1, y>>1);
    }

//    public int hammingDistance(int x, int y) {
//        int result=0, xor=x^y;
//        while(xor>0){
//            result+=xor&1;
//            xor>>=1;
//        }
//        return result;
//    }
}
