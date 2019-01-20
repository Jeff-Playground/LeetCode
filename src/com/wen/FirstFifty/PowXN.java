package com.wen.FirstFifty;

public class PowXN {
    // Iterative
    public double myPow(double x, int n) {
        double result=1;
        for(int i=n; i!=0; i/=2) {
            if(i%2!=0) {
                result*=x;
            }
            x*=x;
        }
        return n<0? 1/result: result;
    }

//    // Recursive1
//    public double myPow(double x, int n) {
//        if(n<0) {
//            return 1/power(x, -n);
//        }
//        return power(x, n);
//    }
//
//    private double power(double x, int n) {
//        if(n==0) {
//            return 1;
//        }
//        double half=power(x, n/2);
//        if(n%2==0) {
//            return half*half;
//        } else {
//            return x*half*half;
//        }
//    }

//    // Recursive2
//    public double myPow(double x, int n) {
//        if(n==0) {
//            return 1;
//        }
//        double half=myPow(x, n/2);
//        if(n%2==0) {
//            return half*half;
//        } else if(n>0) {
//            return x*half*half;
//        } else {
//            return half*half/x;
//        }
//    }
}
