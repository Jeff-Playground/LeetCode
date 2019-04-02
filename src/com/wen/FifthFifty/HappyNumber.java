package com.wen.FifthFifty;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        int sum=n;
        set.add(sum);
        while(sum!=1) {
            n=sum;
            sum=0;
            while(n!=0) {
                sum+=(n%10)*(n%10);
                n=n/10;
            }
            if(set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }
        }
        return true;
    }
}
