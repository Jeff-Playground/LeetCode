package com.wen.TwentySeventhFifty;

import java.util.Arrays;

public class MaximumStudentsTakingExam {
    // Hungarian algorithm, DFS
    // First convert the given seats into a graph, note the graph only contains edges from nodes on even columns to nodes
    // on odd columns, this is to ensure the graph is bipartite.
    // Then find the maximum match in the bipartite graph, in each match there will be 1 seat selected, and for the unmatched
    // seats, directly add to the result.
    public int maxStudents(char[][] seats) {
        int m=seats.length, n=seats[0].length;
        int[][] graph=new int[m*n][m*n];
        // Note these deltas are used to find edges for the graph
        int[][] dirs=new int[][]{{0,-1}, {-1,-1}, {1,-1}, {0,1}, {1,1}, {-1,1}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j+=2){
                if(seats[i][j]=='.'){
                    for(int[] dir: dirs){
                        int x=i+dir[0], y=j+dir[1];
                        if(x>=0 && x<m && y>=0 && y<n && seats[x][y]=='.'){
                            graph[i*n+j][x*n+y]=1;
                        }
                    }
                }
            }
        }
        return hungarianDFS(graph, seats);
    }

    private int hungarianDFS(int[][] graph, char[][] seats){
        int l=graph.length, n=seats[0].length;
        int[] match=new int[l];
        Arrays.fill(match, -1);
        for(int i=0; i<l; i++){
            int x=i/n, y=i%n;
            if(y%2==0 && seats[x][y]=='.'){
                int[] visited=new int[l];
                hungarianDFSHelper(i, graph, match, visited);
            }
        }
        int pair=0, unpair=0;
        for(int i=0; i<l; i++){
            int x=i/n, y=i%n;
            if(seats[x][y]=='.'){
                if(match[i]==-1){
                    unpair++;
                } else{
                    pair++;
                }
            }
        }
        pair/=2;
        return pair+unpair;
    }

    private boolean hungarianDFSHelper(int cur, int[][] graph, int[] match, int[] visited){
        int l=graph[0].length;
        for(int j=0; j<l; j++){
            if(graph[cur][j]==1 && visited[j]==0){
                visited[j]=1;
                if(match[j]==-1 || hungarianDFSHelper(match[j], graph, match, visited)){
                    match[j]=cur;
                    match[cur]=j;
                    return true;
                }
            }
        }
        return false;
    }
}
