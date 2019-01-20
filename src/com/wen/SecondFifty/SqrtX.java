package com.wen.SecondFifty;

public class SqrtX {
    // Newton's method
    public int mySqrt(int x) {
        long result=x;
        while(result*result>x){
            result=(result+x/result)/2;
        }
        return (int)result;
    }

//    // Binary search
//    public int mySqrt(int x) {
//        if(x<=1) {
//            return x;
//        }
//        int left=1, right=x;
//        while(left<right) {
//            int mid=left+(right+1-left)/2;
//            if(x/mid<mid) {
//                right=mid-1;
//            } else {
//                left=mid;
//            }
//        }
//        return left;
//    }
}
