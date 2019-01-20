package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        String result="";
        List<Integer> numbers=new ArrayList<Integer>();
        for(int i=1; i<=n; i++) {
            numbers.add(i);
        }
        int i=n-1;
        k=k-1;
        while(i>=0) {
            int f=factorial(i);
            int index=k/f;
            k=k%f;
            result+=numbers.get(index);
            numbers.remove(index);
            i--;
        }
        return result;
    }

    private int factorial(int i) {
        return (i==0 || i==1)?1:i*factorial(i-1);
    }
}
