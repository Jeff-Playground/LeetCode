package com.wen.Airbnb;

public class FindingOcean {
    public static void main(String args[]) {
        char[][] graph = {
                {'W','W','W','L','L','L','W'},
                {'W','W','L','L','L','W','W'},
                {'W','L','L','L','L','W','W'},
        };
        markOcean(graph, 0, 1, 'W', 'O');
        for (int i = 0; i < graph.length; i++) {
            System.out.println();
            for (int j = 0; j < graph[0].length; j++) {
                System.out.print(graph[i][j]);
                System.out.print(",");
            }
        }
    }

    private static void markOcean(char[][] graph, int x, int y, char water, char ocean) {
        if(graph[x][y]==water){
            graph[x][y]=ocean;
            int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
            int m=graph.length, n=graph[0].length;
            for(int[] dir: dirs){
                int xn=x+dir[0], yn=y+dir[1];
                if(xn>=0 && xn<m && yn>=0 && yn<n && graph[xn][yn]==water){
                    markOcean(graph, xn, yn, water, ocean);
                }
            }
        }
    }
}
