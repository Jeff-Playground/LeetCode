package com.wen.EighthFifty;

public class GuessNumberHigherOrLower {
    int guess(int num){
        return -1;
    }

    public int guessNumber(int n) {
        if(guess(n)==0){
            return n;
        } else{
            int left=1, right=n;
            while(left<right){
                int mid=left+(right-left)/2;
                if(guess(mid)==0){
                    return mid;
                } else if(guess(mid)==1){
                    left=mid+1;
                } else{
                    right=mid-1;
                }
            }
            return left;
        }
    }
}
