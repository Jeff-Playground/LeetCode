package com.wen.TwentyFourthFifty;

/*
In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then
one square in an orthogonal direction.

Return the minimum number of steps needed to move the knight to the square [x, y]. It is guaranteed the answer exists.



Example 1:
Input: x = 2, y = 1
Output: 1
Explanation: [0, 0] → [2, 1]


Example 2:
Input: x = 5, y = 5
Output: 4
Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]


Constraints:
-300 <= x, y <= 300
0 <= |x| + |y| <= 300
 */

import java.util.LinkedList;
import java.util.Queue;

public class LQMinimumKnightMoves {
    // Note for visited use a 2d array instead of Map<Integer, Set<Integer>> for efficiency as HashSet is slow
    public int minKnightMoves(int x, int y) {
        int result=0;
        if(x==0 && y==0){
            return result;
        }
        int[][] dirs=new int[][]{{-2, 1}, {-2, -1}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {1, 2}, {1, -2}};
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0});
        int[][] visited=new int[607][607];
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int[] cur=q.poll();
                int cx=cur[0], cy=cur[1];
                if(visited[cx+302][cy+302]==0){
                    visited[cx+302][cy+302]=1;
                    if(cx==x && cy==y){
                        return result;
                    }
                    for(int[] d: dirs){
                        int nx=cx+d[0], ny=cy+d[1];
                        if(visited[nx+302][ny+302]==0){
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
            result++;
        }
        return -1;
    }
}
