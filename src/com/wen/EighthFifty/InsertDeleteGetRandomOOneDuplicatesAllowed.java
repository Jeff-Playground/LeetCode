package com.wen.EighthFifty;

import java.util.*;

public class InsertDeleteGetRandomOOneDuplicatesAllowed {class RandomizedCollection {
    Map<Integer, Set<Integer>> map;
    List<Integer> nums;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map=new HashMap<>();
        nums=new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        int index=nums.size();
        nums.add(val);
        Set<Integer> indices=map.getOrDefault(val, new HashSet<>());
        indices.add(index);
        map.put(val, indices);
        return indices.size()==1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val) && map.get(val).size()>0){
            int index=map.get(val).iterator().next();
            int lastIdx=nums.size()-1;
            map.get(val).remove(index);
            if(index==lastIdx){
                nums.remove(index);
            } else{
                int lastVal=nums.get(lastIdx);
                nums.remove(lastIdx);
                map.get(lastVal).remove(lastIdx);
                nums.set(index, lastVal);
                map.get(lastVal).add(index);
            }
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(new Random().nextInt(nums.size()));
    }
}
}
