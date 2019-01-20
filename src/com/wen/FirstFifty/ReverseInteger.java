package com.wen.FirstFifty;

public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        while(x != 0) {
            int remainder = x % 10;
            int temp = result * 10 + remainder;
            if(temp / 10 != result) return 0;
            result = temp;
            x /= 10;
        }
        return result;
    }
}
