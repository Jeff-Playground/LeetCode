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
        if(x<=1){
            return x;
        } else{
            int left=2, right=x;
            while(left<right){
                int mid=left+(right-left)/2;
                if(x/mid>mid){
                    left=mid+1;
                } else{
                    right=mid;
                }
            }
            return x/left<left?left-1:left;
        }
    }
}
