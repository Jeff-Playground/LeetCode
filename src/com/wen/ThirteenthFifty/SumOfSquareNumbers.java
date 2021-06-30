package com.wen.ThirteenthFifty;

import java.util.HashSet;
import java.util.Set;

public class SumOfSquareNumbers {
    // Fermat's theorem on sums of two squares
    public boolean judgeSquareSum(int c) {
        for(int i=2; i<=Math.sqrt(c); i++){
            if(i>c){
                break;
            }
            if(c%i==0){
                int count=0;
                while(c%i==0){
                    c/=i;
                    count++;
                }
                if(i%4==3 && count%2==1){
                    return false;
                }
            }
        }
        return c%4!=3;
    }

//    public boolean judgeSquareSum(int c) {
//        int a=0, b=(int)Math.sqrt(c);
//        while(a<=b){
//            if(a*a+b*b==c){
//                return true;
//            } else if(a*a+b*b<c){
//                a++;
//            } else{
//                b--;
//            }
//        }
//        return false;
//    }

//    public boolean judgeSquareSum(int c) {
//        Set<Integer> sqNums=new HashSet<>();
//        for(int i=0; i<=Math.sqrt(c); i++){
//            sqNums.add(i*i);
//            int remain = c-i*i;
//            if(sqNums.contains(remain)){
//                return true;
//            }
//        }
//        return false;
//    }

//    public boolean judgeSquareSum(int c) {
//        for(int i=0; i<=Math.sqrt(c); i++){
//            int remain = c-i*i;
//            int sqrt=(int)Math.sqrt(c-i*i);
//            if(sqrt*sqrt==remain){
//                return true;
//            }
//        }
//        return false;
//    }
}
