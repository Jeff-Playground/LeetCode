package com.wen.FifthFifty;

import java.util.Stack;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites==null){
            throw new IllegalArgumentException("Prerequisites can't be null");
        }
        int[] result=new int[numCourses];
        int count=0;
        int l=prerequisites.length;
        int[] depCount=new int[numCourses];
        for(int i=0; i<l; i++){
            depCount[prerequisites[i][0]]++;
        }

        Stack<Integer> stack=new Stack<>();
        int reachable=0;
        for(int i=0; i<numCourses; i++){
            if(depCount[i]==0){
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int start=stack.pop();
            reachable++;
            result[count++]=start;
            for(int i=0; i<l; i++){
                if(prerequisites[i][1]==start){
                    int cur=prerequisites[i][0];
                    if(--depCount[cur]==0){
                        stack.push(cur);
                    }
                }
            }
        }
        if(reachable==numCourses){
            return result;
        } else{
            return new int[] {};
        }
    }
}
