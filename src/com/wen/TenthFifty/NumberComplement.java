package com.wen.TenthFifty;

public class NumberComplement {
    public int findComplement(int num) {
        return 1-(num%2)+2*(num<=1?0:findComplement(num/2));
    }

//    // Use a mask to filter out higher bits
//    public int findComplement(int num) {
//        int result=0, mask=Integer.MAX_VALUE;
//        while((mask&num)!=0){
//            mask<<=1;
//        }
//        return ~mask&~num;
//    }

//    // From right to left
//    public int findComplement(int num) {
//        int result=0;
//        boolean start=false;
//        for(int i=30; i>=0; i--){
//            if(!start){
//                if(((1<<i)&num)!=0){
//                    start=true;
//                }
//            } else{
//                if(((1<<i)&num)==0){
//                    result|=(1<<i);
//                }
//            }
//        }
//        return result;
//    }

//    // From left to right
//    public int findComplement(int num) {
//        long mask=1, result=0;
//        while(mask<=num){
//            if((mask&num)==0){
//                result|=mask;
//            }
//            mask<<=1;
//        }
//        return (int)result;
//    }
}
