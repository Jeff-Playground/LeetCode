package com.wen.SecondFifty;

public class SqrtX {
//    // Newton's method
//    public int mySqrt(int x) {
//        long result=x;
//        while(result*result>x){
//            result=(result+x/result)/2;
//        }
//        return (int)result;
//    }

    // Binary search
    public int mySqrt(int x) {
        if(x<1){
            return 0;
        }
        int left=1, right=x;
        while(left<right-1){
            int mid=left+(right-left)/2;
            // Note use x/mid<mid instead of mid*mid>x to avoid int overflow
            if(x/mid<mid){
                right=mid-1;
            } else{
                left=mid;
            }
        }
        return x/right>=right?right:left;
    }
}
