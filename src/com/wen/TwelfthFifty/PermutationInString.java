package com.wen.TwelfthFifty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    // Sliding window with two arrays
    public boolean checkInclusion(String s1, String s2) {
        int l1=s1.length(), l2=s2.length();
        if(l1>l2){
            return false;
        }
        int[] count1=new int[256], count2=new int[256];
        for(int i=0; i<l1; i++){
            count1[s1.charAt(i)]++;
            count2[s2.charAt(i)]++;
        }
        if(Arrays.equals(count1, count2)){
            return true;
        }
        for(int i=l1; i<l2; i++){
            count2[s2.charAt(i)]++;
            count2[s2.charAt(i-l1)]--;
            if(Arrays.equals(count1, count2)){
                return true;
            }
        }
        return false;
    }

//    // Sliding window with one Map
//    public static boolean checkInclusion(String s1, String s2) {
//        int l1=s1.length(), l2=s2.length();
//        if(l1>l2){
//            return false;
//        }
//        Map<Character, Integer> count=new HashMap<>();
//        for(char c: s1.toCharArray()){
//            count.put(c, count.getOrDefault(c, 0)+1);
//        }
//        int left=0;
//        for(int right=0; right<l2; right++){
//            char cr=s2.charAt(right);
//            count.put(cr, count.getOrDefault(cr, 0)-1);
//            if(count.get(cr)<0){
//                do{
//                    char cl=s2.charAt(left);
//                    count.put(cl, count.get(cl)+1);
//                } while(count.get(s2.charAt(left++))!=0);
//            } else if(right-left+1==l1){
//                return true;
//            }
//        }
//        return false;
//    }
}
