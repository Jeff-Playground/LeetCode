package com.wen.FourteenthFifty;

/*
Start from integer 1, remove any integer that contains 9 such as 9, 19, 29...

Now, you will have a new integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 10, 11, ...].

Given an integer n, return the nth (1-indexed) integer in the new sequence.



Example 1:

Input: n = 9
Output: 10
Example 2:

Input: n = 10
Output: 11


Constraints:

1 <= n <= 8 * 10^8
 */

import java.util.HashMap;
import java.util.Map;

public class LQRemoveNine {
    // The problem is equivalent to convert n from 10-based to 9-based
    // Note this can be generalized to any problem removing any non-9 number, for example, if removing 3, then first do
    // the same 9-based conversion, then adjust the result by doing a mapping so
    //      0->0
    //      1->1
    //      2->2
    //      3->4
    //      4->5
    //      5->6
    //      6->7
    //      7->8
    //      8->9
    public int newInteger(int n) {
        int result=0, base=1;
        while(n>0){
            int cur=n%9;
            result+=cur*base;
            n/=9;
            base*=10;
        }
        return result;
    }

//    // This is to guess the possible next value first, then check for the next value how many numbers are skipped, if
//    // more are skipped, then adjust the original guessed value, repeat until the guess has the same skipped numbers
//    public int newInteger(int n) {
//        Map<Integer, Integer> offsets=buildOffsets(n);
//        int skipped=getSkippedCount(n, offsets);
//        int nextSkipped=getSkippedCount(n+skipped, offsets);
//        while(nextSkipped>skipped){
//            int more=nextSkipped-skipped;
//            skipped+=more;
//            nextSkipped=getSkippedCount(n+skipped, offsets);
//        }
//        return n+nextSkipped;
//    }
//
//    private Map<Integer, Integer> buildOffsets(int num){
//        int base=10;
//        Map<Integer, Integer> offsets=new HashMap<>();
//        offsets.put(10,1);
//        while(base<Integer.MAX_VALUE/10 && base*10<num){
//            offsets.put(base*10, offsets.get(base)*9+base);
//            base*=10;
//        }
//        offsets.put(base*10, offsets.get(base)*9+base);
//        return offsets;
//    }
//
//    private int getSkippedCount(int num, Map<Integer,Integer> offsets){
//        int base=10;
//        while(base*10<=num){
//            base*=10;
//        }
//        int skipped=0;
//        while(base>0){
//            skipped+=getSkippedCount(num, base, offsets);
//            int count=num/base;
//            if(count==9){
//                break;
//            }
//            num-=count*base;
//            base/=10;
//        }
//        return skipped;
//    }
//
//    private int getSkippedCount(int num, int base, Map<Integer,Integer> offsets){
//        if(base==1){
//            return num>=9?1:0;
//        } else{
//            int count=num/base;
//            if(count<=8){
//                return offsets.get(base)*count;
//            } else{
//                return offsets.get(base)*9+num-base*9+1;
//            }
//        }
//    }
}
