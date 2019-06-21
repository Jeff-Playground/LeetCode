package com.wen.FifthFifty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LQStrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        Set<Character> set=new HashSet<>();
        set.addAll(Arrays.asList('0','1','6','8','9'));
        String reversed="";
        for(int i=0; i<num.length();i++){
            if(!set.contains(num.charAt(i))){
                return false;
            }
            char c=num.charAt(i);
            if(num.charAt(i)=='6'){
                c='9';
            } else if(num.charAt(i)=='9'){
                c='6';
            }
            reversed=c+reversed;
        }
        return reversed.equals(num);
    }
}
