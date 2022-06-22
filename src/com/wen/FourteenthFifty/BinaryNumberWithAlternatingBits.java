package com.wen.FourteenthFifty;

public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        return ((n^=n>>2)&(n-1))==0;
    }

//    public boolean hasAlternatingBits(int n) {
//        return ((n+(n>>1))&(n+(n>>1)+1))==0;
//    }

//    public boolean hasAlternatingBits(int n) {
//        int last=-1;
//        while(n>0){
//            int cur=n&1;
//            if(last==-1 || (last^cur)==1){
//                last=cur;
//                n>>=1;
//            } else{
//                return false;
//            }
//        }
//        return true;
//    }
}
