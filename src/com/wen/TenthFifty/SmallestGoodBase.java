package com.wen.TenthFifty;

public class SmallestGoodBase {
    public static String smallestGoodBase(String n) {
        long num=Long.parseLong(n);
        for(long i=(long)(Math.log(num+1)/Math.log(2)); i>=2; i--){
            long left=2, right=(long)(Math.pow(num, 1.0/(i-1))+1);
            while(left<right){
                long mid=left+(right-left)/2, sum=0;
                for(int j=1; j<=i; j++){
                    sum=sum*mid+1;
                }
                if(sum==num){
                    return String.valueOf(mid);
                } else if(sum<num){
                    left=mid+1;
                } else{
                    right=mid;
                }
            }
        }
        return String.valueOf(num-1);
    }
}
