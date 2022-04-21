package com.wen.FifthFifty;

/*
Given a string num which represents an integer, return true if num is a strobogrammatic number.

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).



Example 1:
Input: num = "69"
Output: true

Example 2:
Input: num = "88"
Output: true

Example 3:
Input: num = "962"
Output: false


Constraints:
1 <= num.length <= 50
num consists of only digits.
num does not contain any leading zeros except for zero itself.
 */

import java.util.*;

public class LQStrobogrammaticNumber {
//    public boolean isStrobogrammatic(String num) {
//        Map<Character,Character> map=new HashMap<>();
//        map.put('0','0');
//        map.put('1','1');
//        map.put('6','9');
//        map.put('8','8');
//        map.put('9','6');
//        int l=num.length();
//        int left=0, right=l-1;
//        while(left<=right){
//            if(!map.containsKey(num.charAt(left)) || map.get(num.charAt(left))!=num.charAt(right)){
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }

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
