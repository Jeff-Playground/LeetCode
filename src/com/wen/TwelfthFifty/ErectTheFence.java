package com.wen.TwelfthFifty;

import java.util.*;

public class ErectTheFence {
    // Jarvis march
    public static int[][] outerTrees(int[][] trees) {
        int l=trees.length;
        // Note here we can also use a fence with type LinkedHashSet to replace both fence and visited
        List<Integer> fence=new ArrayList<>();
        Set<Integer> visited=new HashSet<>();
        // Find the point in the left lower corner to be the starting point, this is to avoid from starting from a point
        // on a edge
        int x=trees[0][0], y=trees[0][1], startIdx=0;
        for(int i=1; i<l; i++){
            if(trees[i][0]<x ||(trees[i][0]==x && trees[i][1]<y)){
                x=trees[i][0];
                y=trees[i][1];
                startIdx=i;
            }
        }
        fence.add(startIdx);
        visited.add(startIdx);
        // This can also handle when there's only one point
        int lastIdx=startIdx, curIdx=(startIdx+1)%l;
        while(curIdx!=startIdx){
            // Note here we have to define a effectively final temp variable which is required for the PriorityQueue
            // comparator function
            int finalLastIdx = lastIdx;
            // The PriorityQueue is to store all the collinear points on the current edge, the minimum size here will be 1
            PriorityQueue<Integer> collinearPoints=new PriorityQueue<>((a, b)-> Math.abs(trees[a][1]-trees[finalLastIdx][1])-Math.abs(trees[b][1]-trees[finalLastIdx][1]));
            for(int i=0; i<l; i++){
                if(i!=lastIdx){
                    int dx1=trees[curIdx][0]-trees[lastIdx][0], dy1=trees[curIdx][1]-trees[lastIdx][1];
                    int dx2=trees[i][0]-trees[lastIdx][0], dy2=trees[i][1]-trees[lastIdx][1];
                    if(curIdx==lastIdx || dx1*dy2==dy1*dx2){
                        collinearPoints.add(i);
                        // This is to ensure we end up with the point NOT in the line(vertex）, note we compare both dx
                        // and dy to handle cases when the line is parallel with the x-axis or y-axis
                        if(Math.abs(dy2)>Math.abs(dy1) || Math.abs(dx2)>Math.abs(dx1)){
                            curIdx=i;
                        }
                    } else if(dx1*dy2<dy1*dx2){
                        collinearPoints.clear();
                        collinearPoints.add(i);
                        curIdx=i;
                    }
                }
            }
            while(!collinearPoints.isEmpty()){
                int cur=collinearPoints.poll();
                if(!visited.contains(cur)){
                    visited.add(cur);
                    fence.add(cur);
                }
            }
            lastIdx=curIdx;
        }
        int size=fence.size();
        int[][] result=new int[size][2];
        for(int i=0; i<size; i++){
            int idx=fence.get(i);
            result[i][0]=trees[idx][0];
            result[i][1]=trees[idx][1];
        }
        return result;
    }
}
