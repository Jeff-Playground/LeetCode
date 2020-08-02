package com.wen.NinthFifty;

import java.util.*;

public class PacificAtlanticWaterFlow {
    // DFS
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result=new ArrayList<>();
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return result;
        }
        int m=matrix.length, n=matrix[0].length;
        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int[][] reach=new int[m][n];
        for(int i=0; i<m; i++){
            reach[i][0]|=1;
        }
        for(int j=1; j<n; j++){
            reach[0][j]|=1;
        }
        for(int i=0; i<m; i++){
            reach[i][n-1]|=2;
        }
        for(int j=0; j<n-1; j++){
            reach[m-1][j]|=2;
        }
        for(int i=0; i<m; i++){
            updateReach(matrix, dirs, reach, i, 0, 1);
        }
        for(int j=1; j<n; j++){
            updateReach(matrix, dirs, reach, 0, j, 1);
        }
        for(int i=0; i<m; i++){
            updateReach(matrix, dirs, reach, i, n-1, 2);
        }
        for(int j=0; j<n-1; j++){
            updateReach(matrix, dirs, reach, m-1, j, 2);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(reach[i][j]==3){
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void updateReach(int[][] matrix, int[][] dirs, int[][] reach, int lastX, int lastY, int flag){
        for(int[] dir: dirs){
            int x=lastX+dir[0], y=lastY+dir[1];
            if(x>=0 && x<matrix.length && y>=0 && y<matrix[0].length && matrix[x][y]>=matrix[lastX][lastY] && (reach[x][y]&flag)==0){
                reach[x][y]|=flag;
                updateReach(matrix, dirs, reach, x, y, flag);
            }
        }
    }

//    // BFS
//    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
//        List<List<Integer>> result=new ArrayList<>();
//        if(matrix==null || matrix.length==0 || matrix[0].length==0){
//            return result;
//        }
//        int m=matrix.length, n=matrix[0].length;
//        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
//        int[][] reach=new int[m][n];
//        Queue<int[]> pq=new LinkedList<>(), aq=new LinkedList<>();
//        for(int i=0; i<m; i++){
//            pq.offer(new int[]{i, 0});
//            reach[i][0]|=1;
//        }
//        for(int j=1; j<n; j++){
//            pq.offer(new int[]{0, j});
//            reach[0][j]|=1;
//        }
//        for(int i=0; i<m; i++){
//            aq.offer(new int[]{i, n-1});
//            reach[i][n-1]|=2;
//        }
//        for(int j=0; j<n-1; j++){
//            aq.offer(new int[]{m-1, j});
//            reach[m-1][j]|=2;
//        }
//        updateReach(matrix, dirs, reach, pq, 1);
//        updateReach(matrix, dirs, reach, aq, 2);
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(reach[i][j]==3){
//                    result.add(Arrays.asList(i, j));
//                }
//            }
//        }
//        return result;
//    }
//
//    private void updateReach(int[][] matrix, int[][] dirs, int[][] reach, Queue<int[]> q, int flag){
//        while(!q.isEmpty()){
//            int[] cur=q.poll();
//            for(int[] dir: dirs){
//                int x=cur[0]+dir[0], y=cur[1]+dir[1];
//                if(x>=0 && x<matrix.length && y>=0 && y<matrix[0].length && matrix[x][y]>=matrix[cur[0]][cur[1]] && (reach[x][y]&flag)==0){
//                    reach[x][y]|=flag;
//                    q.offer(new int[]{x, y});
//                }
//            }
//        }
//    }
}
