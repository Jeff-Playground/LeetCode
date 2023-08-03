package com.wen.SecondFifty;

import java.util.*;

public class GrayCode {
    // Gray code is a series of code which the consecutive codes only have one digit that differs
    // Brute force iterative, basically just try to alter every bit from the lowest until worked
    public static List<Integer> grayCode(int n) {
        List<Integer> result=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        int priorValue=0;
        set.add(0);
        result.add(0);
        while(priorValue!=-1){
            int index=0;
            while(index<n){
                int temp=priorValue;
                if((temp & (1<<index))==0){
                    temp|=(1<<index);
                }else{
                    temp&=~(1<<index);
                }
                if(set.contains(temp)){
                    index++;
                    continue;
                }
                set.add(temp);
                priorValue=temp;
                result.add(temp);
                break;
            }
            if(index==n){
                priorValue=-1;
            }
        }
        return result;
    }

//    // Brute force recursive
//    public List<Integer> grayCode(int n) {
//        List<Integer> result=new ArrayList<>();
//        Set<Integer> set=new HashSet<>();
//        helper(n, set, 0, result);
//        return result;
//    }
//
//    private void helper(int n, Set<Integer> set, int out, List<Integer> result) {
//        if(!set.contains(out)){
//            set.add(out);
//            result.add(out);
//        }
//        for(int i=0; i<n; i++){
//            int temp=out;
//            if((temp & (1<<i))==0){
//                temp|=(1<<i);
//            }else{
//                temp&=~(1<<i);
//            }
//            if(set.contains(temp)){
//                continue;
//            }
//            helper(n, set, temp, result);
//            break;
//        }
//    }

//    // Mirror arrangement
//    public List<Integer> grayCode(int n) {
//        List<Integer> result=new ArrayList<>();
//        result.add(0);
//        result.add(1);
//        for(int i=1; i<n; i++){
//            int highBit=1<<i;
//            for(int j=result.size()-1; j>=0; j--){
//                result.add(result.get(j)|highBit);
//            }
//        }
//        return result;
//    }

//    // Binary to gray code
//    public List<Integer> grayCode(int n) {
//        List<Integer> result=new ArrayList<>();
//        for(int i=0; i<Math.pow(2,n); i++){
//            result.add((i>>1)^i);
//        }
//        return result;
//    }
}
