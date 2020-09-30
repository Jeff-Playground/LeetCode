package com.wen.EleventhFifty;

import java.util.*;

public class ZeroOneMatrix {
    // Iteration twice, first right down, then left up, this is correct because for a certain position, it can only be
    // updated by these four directions, it's like doing BFS without all the repeated calculation
    public int[][] updateMatrix(int[][] matrix) {
        int m=matrix.length, n=matrix[0].length;
        int[][] result=new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(result[i], Integer.MAX_VALUE-1);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    result[i][j]=0;
                } else{
                    if(i>0){
                        result[i][j]=Math.min(result[i-1][j]+1, result[i][j]);
                    }
                    if(j>0){
                        result[i][j]=Math.min(result[i][j-1]+1, result[i][j]);
                    }
                }
            }
        }
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(result[i][j]!=0 && result[i][j]!=1){
                    if(i<m-1){
                        result[i][j]=Math.min(result[i+1][j]+1, result[i][j]);
                    }
                    if(j<n-1){
                        result[i][j]=Math.min(result[i][j+1]+1, result[i][j]);
                    }
                }
            }
        }
        return result;
    }

//    // BFS in-place, starting from 0s
//    public int[][] updateMatrix(int[][] matrix) {
//        int m=matrix.length, n=matrix[0].length;
//        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
//        Queue<Integer> q=new LinkedList<>();
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(matrix[i][j]==0){
//                    q.offer(i*n+j);
//                }
//            }
//        }
//        int count=0;
//        while(!q.isEmpty()){
//            int size=q.size();
//            count++;
//            while(size-->0){
//                int cur=q.poll();
//                for(int[] dir: dirs){
//                    int x=cur/n+dir[0], y=cur%n+dir[1];
//                    if(x>=0 && x<m && y>=0 && y<n && matrix[x][y]==1){
//                        matrix[x][y]+=count*10;
//                        q.offer(x*n+y);
//                    }
//                }
//            }
//        }
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                matrix[i][j]/=10;
//            }
//        }
//        return matrix;
//    }

//    // BFS in-place, starting from 1s
//    public int[][] updateMatrix(int[][] matrix) {
//        int m=matrix.length, n=matrix[0].length;
//        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(matrix[i][j]==1){
//                    Queue<Integer> q=new LinkedList<>();
//                    Set<Integer> visited=new HashSet<>();
//                    q.offer(i*n+j);
//                    visited.add(i*n+j);
//                    int count=0;
//                    while(!q.isEmpty()){
//                        int size=q.size();
//                        count++;
//                        while(size-->0){
//                            int cur=q.poll();
//                            for(int[] dir: dirs){
//                                int x=cur/n+dir[0], y=cur%n+dir[1];
//                                if(x>=0 && x<m && y>=0 && y<n && !visited.contains(x*n+y)){
//                                    if(matrix[x][y]==0){
//                                        matrix[i][j]+=count*10;
//                                        break;
//                                    } else{
//                                        visited.add(x*n+y);
//                                        q.offer(x*n+y);
//                                    }
//                                }
//                            }
//                            if(matrix[i][j]>1){
//                                break;
//                            }
//                        }
//                        if(matrix[i][j]>1){
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                matrix[i][j]/=10;
//            }
//        }
//        return matrix;
//    }
}
