package com.wen.FirstFifty;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        int i=0;
        for(int num: nums){
            int targetNum = target-num;
            if(indexMap.containsKey(targetNum)){
                indices[0]=indexMap.get(targetNum);
                indices[1]=i;
                return indices;
            }
            indexMap.put(num, i);
            i++;
        }
        return indices;
    }
}
