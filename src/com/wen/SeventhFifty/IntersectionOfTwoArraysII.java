package com.wen.SeventhFifty;

import java.util.*;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersect=new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                intersect.add(nums1[i]);
                i++;
                j++;
            } else{
                if(nums1[i]<nums2[j]){
                    i++;
                } else{
                    j++;
                }
            }
        }
        int[] result=new int[intersect.size()];
        for(i=0; i<result.length; i++){
            result[i]=intersect.get(i);
        }
        return result;
    }

//    public int[] intersect(int[] nums1, int[] nums2) {
//        List<Integer> intersect=new ArrayList<>();
//        Map<Integer, Integer> map1=new HashMap<>();
//        for(int num: nums1){
//            map1.put(num, map1.getOrDefault(num, 0)+1);
//        }
//        for(int num: nums2){
//            if(map1.containsKey(num)){
//                intersect.add(num);
//                if(map1.get(num)==1){
//                    map1.remove(num);
//                } else{
//                    map1.put(num, map1.get(num)-1);
//                }
//            }
//        }
//        int[] result=new int[intersect.size()];
//        for(int i=0; i<result.length; i++){
//            result[i]=intersect.get(i);
//        }
//        return result;
//    }
}
