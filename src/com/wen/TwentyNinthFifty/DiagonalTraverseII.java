package com.wen.TwentyNinthFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class DiagonalTraverseII {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        TreeMap<Integer, List<Integer>> org=new TreeMap<>();
        for(int i=0; i<nums.size(); i++){
            for(int j=nums.get(i).size()-1; j>=0; j--){
                org.putIfAbsent(i+j, new ArrayList<>());
                org.get(i+j).add(0, nums.get(i).get(j));
            }
        }
        int total=0;
        for(int key: org.keySet()){
            total+=org.get(key).size();
        }
        System.out.println(total);
        int idx=0;
        int[] result=new int[total];
        for(int key: org.keySet()){
            for(int num: org.get(key)){
                result[idx++]=num;
            }
        }
        return result;
    }
}
