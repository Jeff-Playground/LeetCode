package com.wen.ThirteenthFifty;

public class CanPlaceFlowers {
//    // Modify the input array
//    public boolean canPlaceFlowers(int[] flowerbed, int n) {
//        int l=flowerbed.length;
//        for(int i=0; i<l; i++){
//            if(flowerbed[i]==0){
//                if((i-1<0 || flowerbed[i-1]==0) && (i+1>l-1 || flowerbed[i+1]==0)){
//                    flowerbed[i]=1;
//                    if(--n<=0){
//                        return true;
//                    }
//                }
//            }
//        }
//        return n<=0;
//    }

    // Don't modify the input array
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l=flowerbed.length, count=0;
        boolean canPlace=true;
        for(int i=0; i<l; i++){
            if(flowerbed[i]==0){
                if(canPlace && (i==l-1 || flowerbed[i+1]==0)){
                    canPlace=false;
                    count++;
                    if(count>=n){
                        return true;
                    }
                } else{
                    canPlace=true;
                }
            } else{
                canPlace=false;
            }
        }
        return count>=n;
    }
}
