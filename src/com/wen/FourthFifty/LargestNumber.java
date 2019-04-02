package com.wen.FourthFifty;

import java.util.*;

public class LargestNumber {
    // ArrayList with Collections.sort with configured Comparator
    public String largestNumber(int[] nums) {
        String result="";
        if(nums==null || nums.length==0) {
            return result;
        }
        List<String> numsList=new ArrayList<>();
        for(int num: nums) {
            numsList.add(num+"");
        }
        Collections.sort(numsList,new Comparator<String>() {
            @Override
            public int compare(String num1, String num2) {
                String s1=num1+num2;;
                String s2=num2+num1;
                return s2.compareTo(s1);
            }
        });
        for(String num: numsList) {
            result+=num;
        }
        return result.startsWith("0")?"0":result;
    }

//    // PriorityQueue 2
//    public String largestNumber(int[] nums) {
//        String result="";
//        if(nums==null || nums.length==0) {
//            return result;
//        }
//        Queue<String> queue=new PriorityQueue<>(new Comparator<String>() {
//            @Override
//            public int compare(String num1, String num2) {
//                String s1=num1+num2;;
//                String s2=num2+num1;
//                return s2.compareTo(s1);
//            }
//        });
//        for(int num: nums) {
//            queue.offer(num+"");
//        }
//        while(!queue.isEmpty()) {
//            result+=queue.poll();
//        }
//        return result.startsWith("0")?"0":result;
//    }

//    // PriorityQueue 1
//    public String largestNumber(int[] nums) {
//        String result="";
//        if(nums==null || nums.length==0) {
//            return result;
//        }
//        Queue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer num1, Integer num2) {
//                Long l1=Long.parseLong(num1+""+num2);
//                Long l2=Long.parseLong(num2+""+num1);
//                return l2.compareTo(l1);
//            }
//        });
//        for(int num: nums) {
//            queue.offer(num);
//        }
//        while(!queue.isEmpty()) {
//            result+=queue.poll();
//        }
//        // This handles when nums have multiple elements of the same value 0
//        return result.startsWith("0")?"0":result;
//    }
}
