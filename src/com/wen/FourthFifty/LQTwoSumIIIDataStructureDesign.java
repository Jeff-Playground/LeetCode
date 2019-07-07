package com.wen.FourthFifty;

import java.util.*;

public class LQTwoSumIIIDataStructureDesign {
    // HashMap
    Map<Integer, Integer> nums=new HashMap<>();

    /**
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        nums.put(number, nums.getOrDefault(number, 0)+1);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for(int num: nums.keySet()){
            int target=value-num;
            if((target==num && nums.getOrDefault(target, 0)>1) || (target!=num && nums.getOrDefault(target, 0)>0)){
                return true;
            }
        }
        return false;
    }
}
