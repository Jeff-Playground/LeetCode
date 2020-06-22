package com.wen.SeventhFifty;

public class PowerOfThree {
    // Without using any loop / recursion
    public boolean isPowerOfThree(int n) {
        int max=(int) Math.pow(3,19);
        return n>0 && max%n==0;
    }

//    // Iterative
//    public boolean isPowerOfThree(int n) {
//        while(n>0 && n%3==0){
//            n/=3;
//        }
//        return n==1;
//    }

//    // Recursive
//    public boolean isPowerOfThree(int n) {
//        if(n<3){
//            return n==1;
//        } else{
//            return n%3==0?isPowerOfThree(n/3):false;
//        }
//    }
}
