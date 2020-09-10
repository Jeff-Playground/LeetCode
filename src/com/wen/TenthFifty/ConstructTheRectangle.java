package com.wen.TenthFifty;

public class ConstructTheRectangle {
//    public int[] constructRectangle(int area) {
//        int sqrt=(int)Math.sqrt(area);
//        if(area%sqrt==0){
//            return new int[]{area/sqrt, sqrt};
//        } else{
//            for(int i=sqrt-1; i>=1; i--){
//                if(area%i==0){
//                    return new int[]{area/i, i};
//                }
//            }
//            return new int[2];
//        }
//    }

    public int[] constructRectangle(int area) {
        int temp=1;
        for(int i=1; i*i<=area; i++){
            if(area%i==0){
                temp=i;
            }
        }
        return new int[]{area/temp, temp};
    }
}
