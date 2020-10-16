package com.wen.TwelfthFifty;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> kinds=new HashSet<>();
        int l=candies.length;
        for(int c: candies){
            kinds.add(c);
        }
        return Math.min(l/2, kinds.size());
    }
}
