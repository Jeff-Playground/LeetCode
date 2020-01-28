package com.wen.FourteenthFifty;

import java.util.*;

public class CutOffTreesForGolfEvent {
    // BFS
    public int cutOffTree(List<List<Integer>> forest) {
        if(forest==null || forest.size()==0 || forest.get(0).size()==0){
            throw new IllegalArgumentException("Given forest can't be null or empty!");
        }
        int m=forest.size(), n=forest.get(0).size();
        if(m==1 && n==1){
            return 0;
        }
        if(forest.get(0).get(0)==0){
            return -1;
        }
        List<int[]> heights=new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(forest.get(i).get(j)>1){
                    heights.add(new int[]{forest.get(i).get(j), i, j});
                }
            }
        }
        Collections.sort(heights, (a, b)->a[0]-b[0]);
        int steps=0, curX=0, curY=0;
        for(int[] height: heights){
            int nextX=height[1], nextY=height[2];
            int dist=dist(forest, curX, curY, nextX, nextY);
            if(dist==-1){
                return -1;
            } else{
                steps+=dist;
            }
            curX=nextX;
            curY=nextY;
        }
        return steps;
    }

    public int dist(List<List<Integer>> forest, int curX, int curY, int nextX, int nextY){
        int count=-1;
        int[][] dirs=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        int m=forest.size(), n=forest.get(0).size();
        Queue<int[]> queue=new LinkedList<>();
        int[][] visited=new int[m][n];
        visited[curX][curY]=1;
        queue.offer(new int[]{curX, curY});
        while(!queue.isEmpty()){
            int size=queue.size();
            count++;
            for(int i=0; i<size; i++){
                int[] cur=queue.poll();
                if(cur[0]==nextX && cur[1]==nextY){
                    return count;
                } else{
                    for(int[] dir: dirs){
                        if(cur[0]+dir[0]>=0 && cur[0]+dir[0]<m && cur[1]+dir[1]>=0 && cur[1]+dir[1]<n
                                && forest.get(cur[0]+dir[0]).get(cur[1]+dir[1])!=0
                                && visited[cur[0]+dir[0]][cur[1]+dir[1]]==0){
                            visited[cur[0]+dir[0]][cur[1]+dir[1]]=1;
                            queue.offer(new int[]{cur[0]+dir[0],cur[1]+dir[1]});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
