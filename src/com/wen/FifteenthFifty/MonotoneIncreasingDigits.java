package com.wen.FifteenthFifty;

public class MonotoneIncreasingDigits {
    public static int monotoneIncreasingDigits(int N) {
        int result=0;
        int curDigits=0, last=-1, cur=-1;
        while(N>0){
            cur=N%10;
            curDigits++;
            if(last!=-1){
                if(cur>last){
                    result=(int)Math.pow(10, curDigits-1)-1;
                    cur--;
                }
            }
            N/=10;
            result+=cur*(int)Math.pow(10, curDigits-1);
            last=cur;
        }
        return result;
    }
}
