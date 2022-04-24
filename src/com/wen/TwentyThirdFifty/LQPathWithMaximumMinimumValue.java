package com.wen.TwentyThirdFifty;

/*
Given an m x n integer matrix grid, return the maximum score of a path starting at (0, 0) and ending at (m - 1, n - 1)
moving in the 4 cardinal directions.

The score of a path is the minimum value in that path.

For example, the score of the path 8 → 4 → 5 → 9 is 4.


Example 1:
Input: grid = [[5,4,5],[1,2,6],[7,4,6]]
Output: 4
Explanation: The path with the maximum score is highlighted in yellow.


Example 2:
Input: grid = [[2,2,1,2,2,2],[1,2,2,2,1,2]]
Output: 2


Example 3:
Input: grid = [[3,4,6,3,4],[0,2,1,1,7],[8,8,3,2,7],[3,2,4,9,8],[4,1,2,0,0],[4,6,5,4,3]]
Output: 3


Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 100
0 <= grid[i][j] <= 109
 */

import java.util.*;

public class LQPathWithMaximumMinimumValue {
//    // Plain BFS or even optimized BFS to prune some paths would TLE
//    public int maximumMinimumPath(int[][] grid) {
//        int m=grid.length, n=grid[0].length;
//        if(m==1 && n==1){
//            return grid[0][0];
//        }
//        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
//        Queue<int[]> q=new LinkedList<>();
//        q.offer(new int[]{0,grid[0][0]});
//        Map<Integer, Integer> visited=new HashMap<>();
//        visited.put(0, grid[0][0]);
//        while(!q.isEmpty()){
//            int[] cur=q.poll();
//            int curPos=cur[0], curMin=cur[1];
//            for(int[] d: dirs){
//                int x=curPos/n+d[0], y=curPos%n+d[1];
//                if(x>=0 && x<m && y>=0 && y<n){
//                    int newPos=x*n+y, newMin=Math.min(curMin, grid[x][y]);
//                    if(x==m-1 && y==n-1){
//                        visited.put(newPos,Math.max(visited.getOrDefault(newPos,Integer.MIN_VALUE), Math.min(curMin, grid[x][y])));
//                    } else{
//                        if(!visited.containsKey(newPos) || visited.get(newPos)<newMin){
//                            q.offer(new int[]{newPos, newMin});
//                            visited.put(newPos,newMin);
//                        }
//                    }
//                }
//            }
//        }
//        return visited.get(((m-1)*n)+n-1);
//    }

    // Similar to Dijkstra, if we need to know the path, then we can make a Map last to store the last node reaching a node
    public int maximumMinimumPath(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->b[1]-a[1]);
        pq.offer(new int[]{0,grid[0][0]});
        Map<Integer, Integer> visited=new HashMap<>();
        visited.put(0, grid[0][0]);
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int curPos=cur[0], curMin=cur[1];
            if(curPos/n==m-1 && curPos%n==n-1){
                return Math.min(curMin, grid[m-1][n-1]);
            } else{
                for(int[] d: dirs){
                    int x=curPos/n+d[0], y=curPos%n+d[1];
                    if(x>=0 && x<m && y>=0 && y<n){
                        int newPos=x*n+y, newMin=Math.min(curMin, grid[x][y]);
                        if(visited.getOrDefault(newPos, Integer.MIN_VALUE)<newMin){
                            visited.put(newPos, newMin);
                            pq.offer(new int[]{newPos, newMin});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
