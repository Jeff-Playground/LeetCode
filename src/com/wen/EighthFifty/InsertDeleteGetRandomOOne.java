package com.wen.EighthFifty;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class InsertDeleteGetRandomOOne {

    class RandomizedSet {
        List<Integer> nums=null;
        Map<Integer, Integer> map=null;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            nums=new ArrayList<>();
            map=new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey(val)){
                return false;
            } else{
                int index=nums.size();
                nums.add(index, val);
                map.put(val, index);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!map.containsKey(val)){
                return false;
            } else{
                int index=map.get(val);
                if(index==nums.size()-1){
                    nums.remove(index);
                    map.remove(val);
                } else{
                    int lastVal=nums.get(nums.size()-1);
                    nums.set(index, lastVal);
                    map.remove(val);
                    map.put(lastVal, index);
                }
                return true;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(new Random().nextInt(nums.size()));
        }
    }
}
