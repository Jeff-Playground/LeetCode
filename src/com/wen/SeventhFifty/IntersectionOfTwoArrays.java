package com.wen.SeventhFifty;

import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        for(int num: nums1){
            set1.add(num);
        }
        Set<Integer> intersect=new HashSet<>();
        for(int num: nums2){
            if(set1.contains(num)){
                intersect.add(num);
            }
        }
        int[] result=new int[intersect.size()];
        Iterator<Integer> it=intersect.iterator();
        for(int i=0; i<result.length; i++){
            result[i]=it.next();
        }
        return result;
    }
}
