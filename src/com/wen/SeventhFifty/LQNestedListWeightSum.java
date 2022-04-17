package com.wen.SeventhFifty;

/*
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Input: [[1,1],2,[1,1]]
Output: 10
Explanation: Four 1's at depth 2, one 2 at depth 1.

Example 2:
Input: [1,[4,[6]]]
Output: 27
Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LQNestedListWeightSum {
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

//    // BFS
//    public int depthSum(List<NestedInteger> nestedList) {
//        int result=0, level=1;
//        Queue<NestedInteger> q=new LinkedList<>();
//        nestedList.forEach(e->q.offer(e));
//        while(!q.isEmpty()){
//            int size=q.size();
//            for(int i=0; i<size; i++){
//                NestedInteger cur=q.poll();
//                if(cur.isInteger()){
//                    result+=cur.getInteger()*level;
//                } else{
//                    cur.getList().forEach(e->q.offer(e));
//                }
//            }
//            level++;
//        }
//        return result;
//    }

    // DFS
    public int depthSum(List<NestedInteger> nestedList) {
        return dsHelper(nestedList, 1);
    }

    private int dsHelper(List<NestedInteger> nestedList, int level){
        int result=0;
        for(NestedInteger e: nestedList){
            if(e.isInteger()){
                result+=level*e.getInteger();
            } else{
                result+=dsHelper(e.getList(), level+1);
            }
        }
        return result;
    }
}
