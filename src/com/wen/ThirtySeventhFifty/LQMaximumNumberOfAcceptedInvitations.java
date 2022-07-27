package com.wen.ThirtySeventhFifty;

/*
There are m boys and n girls in a class attending an upcoming party.

You are given an m x n integer matrix grid, where grid[i][j] equals 0 or 1. If grid[i][j] == 1, then that means the ith
boy can invite the jth girl to the party. A boy can invite at most one girl, and a girl can accept at most one invitation
from a boy.

Return the maximum possible number of accepted invitations.



Example 1:
Input: grid = [[1,1,1],
               [1,0,1],
               [0,0,1]]
Output: 3
Explanation: The invitations are sent as follows:
- The 1st boy invites the 2nd girl.
- The 2nd boy invites the 1st girl.
- The 3rd boy invites the 3rd girl.


Example 2:
Input: grid = [[1,0,1,0],
               [1,0,0,0],
               [0,0,1,0],
               [1,1,1,0]]
Output: 3
Explanation: The invitations are sent as follows:
-The 1st boy invites the 3rd girl.
-The 2nd boy invites the 1st girl.
-The 3rd boy invites no one.
-The 4th boy invites the 2nd girl.


Constraints:
grid.length == m
grid[i].length == n
1 <= m, n <= 200
grid[i][j] is either 0 or 1.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LQMaximumNumberOfAcceptedInvitations {
//    // Hungarian algorithm, DFS, with bMatch added for helping to understand
//    public int maximumInvitations(int[][] grid) {
//        int m=grid.length, n=grid[0].length, result=0;
//        int[] bMatch=new int[m], gMatch=new int[n];
//        Arrays.fill(gMatch,-1);
//        for(int i=0; i<m; i++){
//            int[] gVisited=new int[n];
//            if(match(i, grid, bMatch, gMatch, gVisited)){
//                result++;
//            }
//        }
//        return result;
//    }
//
//    private boolean match(int b, int[][] grid, int[] bMatch, int[] gMatch, int[] gVisited){
//        int n=grid[0].length;
//        for(int g=0; g<n; g++){
//            if(grid[b][g]==1 && gVisited[g]==0){
//                gVisited[g]=1;
//                if(gMatch[g]==-1 || match(gMatch[g], grid, bMatch, gMatch, gVisited)){
//                    bMatch[b]=g;
//                    gMatch[g]=b;
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

//    // Hungarian algorithm, DFS
//    public int maximumInvitations(int[][] grid) {
//        int m=grid.length, n=grid[0].length, result=0;
//        int[] gMatch=new int[n];
//        Arrays.fill(gMatch,-1);
//        for(int i=0; i<m; i++){
//            int[] gVisited=new int[n];
//            if(match(i, grid, gMatch, gVisited)){
//                result++;
//            }
//        }
//        return result;
//    }
//
//    private boolean match(int b, int[][] grid, int[] gMatch, int[] gVisited){
//        int n=grid[0].length;
//        for(int g=0; g<n; g++){
//            if(grid[b][g]==1 && gVisited[g]==0){
//                gVisited[g]=1;
//                if(gMatch[g]==-1 || match(gMatch[g], grid, gMatch, gVisited)){
//                    gMatch[g]=b;
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    // Hungarian algorithm, BFS
    public int maximumInvitations(int[][] grid) {
        int m=grid.length, n=grid[0].length, result=0;
        int[] bMatch=new int[m], gMatch=new int[n];
        Arrays.fill(bMatch,-1);
        Arrays.fill(gMatch,-1);
        for(int i=0; i<m; i++){
            Queue<Integer> q=new LinkedList<>();
            int[] bPrev=new int[m];
            int[] gVisited=new int[n];
            bPrev[i]=-1;
            q.offer(i);
            boolean foundPath=false;
            while(!q.isEmpty() && !foundPath){
                int cur=q.poll();
                for(int j=0; j<n; j++){
                    if(grid[cur][j]==1 && gVisited[j]==0){
                        gVisited[j]=1;
                        if(gMatch[j]==-1){
                            int b=cur, g=j;
                            while(b!=-1){
                                int pg=bMatch[b];
                                bMatch[b]=g;
                                gMatch[g]=b;
                                b=bPrev[b];
                                g=pg;
                            }
                            foundPath=true;
                            break;
                        } else{
                            q.offer(gMatch[j]);
                            bPrev[gMatch[j]]=cur;
                        }
                    }
                }
            }
            if(bMatch[i]!=-1){
                result++;
            }
        }
        return result;
    }
}
