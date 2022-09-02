package com.wen.FifteenthFifty;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    // Iterative
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result=new ArrayList<>();
        for(int i=left; i<=right; i++){
            boolean selfDivisible=true;
            for(int j=i; j>0; j/=10){
                int cur=j%10;
                if(cur==0 || i%cur!=0){
                    selfDivisible=false;
                    break;
                }
            }
            if(selfDivisible){
                result.add(i);
            }
        }
        return result;
    }

//    // Recursive
//    public List<Integer> selfDividingNumbers(int left, int right) {
//        List<Integer> result=new ArrayList<>();
//        for(int i=left; i<=right; i++){
//            if(selfDivisible(i)){
//                result.add(i);
//            }
//        }
//        return result;
//    }
//
//    private boolean selfDivisible(int num){
//        int tmp=num, cur=tmp%10;
//        while(tmp!=0){
//            if(cur==0 || num%cur!=0){
//                return false;
//            } else{
//                tmp/=10;
//                cur=tmp%10;
//            }
//        }
//        return true;
//    }
}
