package com.wen.FourthFifty;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    // Cast numerator and denominator to Long to prevent overflow when denominator is Integer.MIN_VALUE
    public static String fractionToDecimal(int numerator, int denominator) {
        int sign1=numerator>=0?1:-1;
        int sign2=denominator>=0?1:-1;
        String sign=sign1*sign2>0?"":"-";
        long num=Math.abs((long)numerator);
        long den=Math.abs((long)denominator);
        long cur=num/den;
        long remainder= num%den;
        String result="";
        result+=String.valueOf(cur);
        if(remainder==0){
            return result.equals("0")?result:sign+result;
        } else{
            result+=".";
            Map<Long, Integer> remainders=new HashMap<>();
            int offset=0;
            remainders.put(remainder, offset++);
            while(remainder!=0){
                // If remainder is int, cur will become negative at some point when remainder*10>Integer.MAX_VALUE, because there's overflow before cast to Long
                cur=remainder*10;
                remainder=cur%den;
                result+=String.valueOf(cur/den);
                if(remainders.containsKey(remainder)){
                    break;
                }
                remainders.put(remainder,offset++);
            }
            if(remainder==0){
                return sign+result;
            } else{
                int idx=result.indexOf('.')+remainders.get(remainder);
                result=result.substring(0,idx+1)+"("+result.substring(idx+1)+")";
                return sign+result;
            }
        }
    }
}
