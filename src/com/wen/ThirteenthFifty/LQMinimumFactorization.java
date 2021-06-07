package com.wen.ThirteenthFifty;

/*
Given a positive integer a, find the smallest positive integer b whose multiplication of each digit equals to a.

If there is no answer or the answer is not fit in 32-bit signed integer, then return 0.

Example 1
Input:
48
Output:
68


Example 2
Input:
15
Output:
35
 */

public class LQMinimumFactorization {
    // Use base to add to result
    public int smallestFactorization(int a) {
        int n=9, base=1;
        long result=0;
        while(n>1){
            while(a%n==0){
                a/=n;
                result+=base*n;
                if(result>Integer.MAX_VALUE){
                    return 0;
                }
                base*=10;
            }
            n--;
        }
        return a>1?0:(int)result;
    }

//    // Use digit to add to result
//    public int smallestFactorization(int a) {
//        int n=9, digit=0;
//        long result=0;
//        while(n>1){
//            while(a%n==0){
//                a/=n;
//                int temp=digit++, cur=n;
//                while(temp-->0){
//                    cur*=10;
//                }
//                result+=cur;
//                if(result>Integer.MAX_VALUE){
//                    return 0;
//                }
//            }
//            n--;
//        }
//        return a>1?0:(int)result;
//    }
}
