package com.wen.NinthFifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructOriginalDigitsFromEnglish {
//    // Greedy1
//    public String originalDigits(String s) {
//        String[] nums=new String[]{"zero", "two", "four", "five", "six", "seven", "eight", "nine", "one", "three"};
//        Character[] numsChar=new Character[]{'0', '2', '4', '5', '6', '7', '8', '9', '1', '3'};
//        List<List<Integer>> patterns=new ArrayList<>();
//        for(String num: nums){
//            List<Integer> pattern=new ArrayList<>();
//            for(char c: num.toCharArray()){
//                pattern.add(c-'a');
//            }
//            patterns.add(pattern);
//        }
//        Map<Integer, Integer> count=new HashMap<>();
//        for(char c: s.toCharArray()){
//            int orig=count.getOrDefault(c-'a', 0);
//            count.put(c-'a', orig+1);
//        }
//        StringBuilder sb=new StringBuilder();
//        for(int i=0; i<10; i++){
//            List<Integer> pattern=patterns.get(i);
//            Integer min=null;
//            for(int c: pattern){
//                if(!count.containsKey(c)){
//                    min=null;
//                    break;
//                } else{
//                    if(min==null){
//                        min=count.get(c);
//                    } else{
//                        min=Math.min(min, count.get(c));
//                    }
//                }
//            }
//            if(min==null){
//                continue;
//            } else{
//                for(int c: pattern){
//                    int orig=count.get(c);
//                    count.put(c, orig-min);
//                }
//                int start=sb.length();
//                if(i==8){
//                    start=sb.lastIndexOf("0")+1;
//                } else if(i==9){
//                    int max=sb.lastIndexOf("0");
//                    max=Math.max(max, sb.lastIndexOf("1"));
//                    max=Math.max(max, sb.lastIndexOf("2"));
//                    start=max+1;
//                }
//                while(min-->0){
//                    sb.insert(start, numsChar[i]);
//                }
//            }
//        }
//        return sb.toString();
//    }

    // Greedy2
    public String originalDigits(String s) {
        String[] nums=new String[]{"zero", "two", "four", "five", "six", "seven", "eight", "nine", "one", "three"};
        int[] charCount=new int[26];
        int[] count=new int[10];
        for(char c: s.toCharArray()){
            charCount[c-'a']++;
        }
        count[0]=charCount['z'-'a'];
        count[2]=charCount['w'-'a'];
        count[4]=charCount['u'-'a'];
        count[5]=charCount['f'-'a']-count[4];
        count[6]=charCount['x'-'a'];
        count[7]=charCount['v'-'a']-count[5];
        count[8]=charCount['g'-'a'];
        count[9]=charCount['i'-'a']-count[5]-count[6]-count[8];
        count[1]=charCount['o'-'a']-count[0]-count[2]-count[4];
        count[3]=charCount['h'-'a']-count[8];
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<10; i++){
            while(count[i]-->0){
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
