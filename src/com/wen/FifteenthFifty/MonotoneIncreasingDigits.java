package com.wen.FifteenthFifty;

public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        int result=0;
        int digits=0, last=-1, cur=-1;
        while(N>0){
            cur=N%10;
            digits++;
            if(last!=-1){
                if(cur>last){
                    result=(int)Math.pow(10, digits-1)-1;
                    cur--;
                }
            }
            N/=10;
            result+=cur*(int)Math.pow(10, digits-1);
            last=cur;
        }
        return result;
    }
}
