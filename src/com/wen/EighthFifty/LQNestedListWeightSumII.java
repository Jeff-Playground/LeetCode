package com.wen.EighthFifty;

/*
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

Example 1:
Input: [[1,1],2,[1,1]]
Output: 8
Explanation: Four 1's at depth 1, one 2 at depth 2.

Example 2:
Input: [1,[4,[6]]]
Output: 17
Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LQNestedListWeightSumII {
    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer,
        // rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds,
        // if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds,
        // if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int result=0, temp=0;
        while(nestedList.size()>0){
            List<NestedInteger> nextLevelList=new ArrayList<>();
            for(NestedInteger e: nestedList){
                if(e.isInteger()){
                    temp+=e.getInteger();
                } else{
                    e.getList().forEach(cur->nextLevelList.add(cur));
                }
            }
            result+=temp;
            nestedList=nextLevelList;
        }
        return result;
    }

//    public int depthSumInverse(List<NestedInteger> nestedList) {
//        int result=0;
//        Map<Integer, Integer> sums=new HashMap<>();
//        dsiHelper(nestedList, 1, sums);
//        int total=sums.keySet().size();
//        for(int key: sums.keySet()){
//            result+=sums.get(key)*(total+1-key);
//        }
//        return result;
//    }
//
//    private void dsiHelper(List<NestedInteger> nestedList, int lvl, Map<Integer, Integer> sums){
//        int sum=sums.getOrDefault(lvl, 0);
//        for(NestedInteger e: nestedList){
//            if(e.isInteger()){
//                sum+=e.getInteger();
//            } else{
//                dsiHelper(e.getList(), lvl+1, sums);
//            }
//        }
//        sums.put(lvl, sum);
//    }
}
