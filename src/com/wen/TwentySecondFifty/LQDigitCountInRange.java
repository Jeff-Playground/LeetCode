package com.wen.TwentySecondFifty;

/*

Given an integer d between 0 and 9, and two positive integers low and high as lower and upper bounds, respectively. Return
the number of times that d occurs as a digit in all integers between low and high, including the bounds low and high.


Example 1:

Input: d = 1, low = 1, high = 13
Output: 6
Explanation:
The digit d=1 occurs 6 times in 1,10,11,12,13. Note that the digit d=1 occurs twice in the number 11.
Example 2:

Input: d = 3, low = 100, high = 250
Output: 35
Explanation:
The digit d=3 occurs 35 times in 103,113,123,130,131,...,238,239,243.

 */

import java.util.HashMap;
import java.util.Map;

public class LQDigitCountInRange {
    public static int digitsCount(int d, int low, int high) {
        Map<Integer, Integer> cache=new HashMap<>();
        int result=dcHelper(d, high, cache)-dcHelper(d, low-1, cache);
        return result;
    }

    private static int dcHelper(int d, int num, Map<Integer, Integer> cache){
        if(cache.containsKey(num)){
            return cache.get(num);
        } else{
            int result=0;
            if(num<=9){
                if(d>0 && num>=d){
                    result=1;
                }
            } else{
                // Every 10 numbers(x1...x0) it appears once in the lowest bit
                result+=num/10;
                // Check in remainder for the lowest bit
                result+=dcHelper(d, num%10, cache);
                // Find all appearances in non-lowest bits
                int nonLowest=dcHelper(d, num/10, cache);
                if(nonLowest>0){
                    result+=nonLowest*10;
                    // Here the every 10 numbers becomes (x0...x9), as num doesn't necessarily ends with '9', will need
                    // to get rid of the extra counts for (xk...x9)
                    String prefix=String.valueOf(num/10);
                    int preCount=0;
                    for(char c: prefix.toCharArray()){
                        if(c==(char)('0'+d)){
                            preCount++;
                        }
                    }
                    result-=preCount*(9-num%10);
                }
            }
            cache.put(num, result);
            return result;
        }
    }
}
