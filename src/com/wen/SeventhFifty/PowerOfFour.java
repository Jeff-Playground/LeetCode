package com.wen.SeventhFifty;

public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
//        return num>0 && (num&(num-1))==0 && (num&0b1010101010101010101010101010101)==0;
        return num>0 && (num&(num-1))==0 && (num&0x55555555)==num;
    }

//    public boolean isPowerOfFour(int num) {
//        return num>0 && (num&(num-1))==0 && (num-1)%3==0;
//    }
}
