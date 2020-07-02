package com.wen.EighthFifty;

public class ValidPerfectSquare {
    // Brute force
    public static boolean isPerfectSquare(int num) {
        for(int i=1; i<=num/i; i++){
            if(i*i==num){
                return true;
            }
        }
        return false;
    }

//    // Binary search, note need to handle overflow by using long for the multiplication
//    public static boolean isPerfectSquare(int num) {
//        int left=1, right=num;
//        while(left<=right){
//            int mid=left+(right-left)/2;
//            long sq=(long)mid*mid;
//            if(sq==num){
//                return true;
//            } else if(sq<num){
//                left=mid+1;
//            } else{
//                right=mid-1;
//            }
//        }
//        return false;
//    }
}
