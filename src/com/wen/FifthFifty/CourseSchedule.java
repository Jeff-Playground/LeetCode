package com.wen.FifthFifty;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CourseSchedule {
    // DFS topological sort
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites==null){
            throw new IllegalArgumentException("Illegal Prerequisites");
        }
        int l=prerequisites.length;
        if(numCourses==0 || l==0){
            return true;
        }
        int[] pCount=new int[numCourses];
        for(int i=0; i<l; i++){
            pCount[prerequisites[i][0]]++;
        }
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<numCourses; i++){
            if(pCount[i]==0){
                stack.push(i);
            }
        }
        int reachable=stack.size();
        while(!stack.isEmpty()){
            int cur=stack.pop();
            for(int i=0; i<l; i++){
                if(prerequisites[i][1]==cur){
                    if(--pCount[prerequisites[i][0]]==0){
                        stack.push(prerequisites[i][0]);
                        reachable++;
                    }
                }
            }
        }
        return reachable==numCourses;
    }

//    // BFS topological sort
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        if(prerequisites==null) {
//            throw new IllegalArgumentException("Illegal Prerequisites");
//        }
//        int len=prerequisites.length;
//        if(numCourses==0 || len==0) {
//            return true;
//        }
//        // count of number of prerequisites for each course
//        int[] pCount = new int[numCourses];
//        for(int i=0; i<len; i++){
//            pCount[prerequisites[i][0]]++;
//        }
//
//        //store courses that have no prerequisites
//        Queue<Integer> queue = new LinkedList<Integer>();
//        for(int i=0; i<numCourses; i++){
//            if(pCount[i]==0){
//                queue.offer(i);
//            }
//        }
//
//        // number of courses that have no prerequisites
//        int numNoPre = queue.size();
//
//        while(!queue.isEmpty()){
//            int top = queue.poll();
//            for(int i=0; i<len; i++){
//                // if a course's prerequisite can be satisfied by a course in queue
//                if(prerequisites[i][1]==top){
//                    pCount[prerequisites[i][0]]--;
//                    if(pCount[prerequisites[i][0]]==0){
//                        numNoPre++;
//                        queue.add(prerequisites[i][0]);
//                    }
//                }
//            }
//        }
//
//        return numNoPre==numCourses;
//    }
}
