package com.wen.FifteenthFifty;

import java.util.*;

public class LQNumberOfDistinctIslandsII {
    public int numDistinctIslands2(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0){
            throw new IllegalArgumentException("Input grid can't be null or empty!");
        }
        int m=grid.length, n=grid[0].length;
        Set<String> result=new HashSet<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    List<Integer> island=new ArrayList();
                    numberofDistinctIslandsDFS(grid, i, j, island);
                    result.add(normalize(island, Math.max(m,n)));
                }
            }
        }
        return result.size();
    }

    public String normalize(List<Integer> island, int maxEdge){
        String result="";
        int size=island.size();
        int[][] rotate=new int[][]{{1,1}, {1,-1}, {-1,1}, {-1,-1}};
        for(int k=0; k<8; k++){
            int[] xs=new int[size], ys=new int[size], out=new int[size];
            int minX=Integer.MAX_VALUE, minY=Integer.MAX_VALUE;
            for(int i=0; i<size; i++){
                int num=island.get(i);
                xs[i]=num/maxEdge*rotate[k%4][0];
                ys[i]=num%maxEdge*rotate[k%4][1];
                minX=Math.min(minX, xs[i]);
                minY=Math.min(minY, ys[i]);
            }
            for(int i=0; i<size; i++){
                if(k<4){
                    out[i]=(xs[i]-minX)*maxEdge+ys[i]-minY;
                } else{
                    out[i]=(ys[i]-minY)*maxEdge+xs[i]-minX;
                }
            }
            Arrays.sort(out);
            String normalized=Arrays.toString(out);
            if(result.compareTo(normalized)<0){
                result=normalized;
            }
        }
        return result;
    }

    public void numberofDistinctIslandsDFS(int[][] grid, int x, int y, List<Integer> island) {
        int m=grid.length, n=grid[0].length;
        int[][] dirs=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
            grid[x][y]=-1;
            island.add(x*Math.max(m,n)+y);
            for(int[] dir: dirs){
                numberofDistinctIslandsDFS(grid, x+dir[0], y+dir[1], island);
            }
        }
    }
}
