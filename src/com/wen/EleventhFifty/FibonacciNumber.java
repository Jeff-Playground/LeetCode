package com.wen.EleventhFifty;

public class FibonacciNumber {
    public int fib(int N) {
        if(N<=1){
            return N;
        } else{
            int first=0, second=1;
            for(int i=2; i<N; i++){
                int cur=first+second;
                first=second;
                second=cur;
            }
            return first+second;
        }
    }
}
