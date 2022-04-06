package com.wen.SixthFifty;

public class AddDigits {
    public int addDigits(int num) {
        while(num/10>0){
            int temp=0;
            while(num>0){
                temp+=num%10;
                num/=10;
            }
            num=temp;
            temp=0;
        }
        return num;
    }

//    // By listing out a series of numbers, we notice every 9 numbers is a loop, and each loop has same results
//    public int addDigits(int num) {
//        return num==0?0:(num-1)%9+1;
//    }
}
