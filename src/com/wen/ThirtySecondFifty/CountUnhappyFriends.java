package com.wen.ThirtySecondFifty;

import java.util.HashSet;
import java.util.Set;

public class CountUnhappyFriends {
    public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] rank=new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n-1; j++){
                int cur=preferences[i][j];
                rank[i][cur]=j;
            }
        }
        Set<Integer> unhappy=new HashSet<>();
        int l=pairs.length;
        for(int i=0; i<l; i++){
            for(int j=i+1; j<l; j++){
                int[] p1=pairs[i], p2=pairs[j];
                int x=p1[0], y=p1[1], u=p2[0], v=p2[1];
                if(rank[x][u]<rank[x][y] && rank[u][x]<rank[u][v]){
                    unhappy.add(x);
                    unhappy.add(u);
                }
                if(rank[x][v]<rank[x][y] && rank[v][x]<rank[v][u]){
                    unhappy.add(x);
                    unhappy.add(v);
                }
                if(rank[y][u]<rank[y][x] && rank[u][y]<rank[u][v]){
                    unhappy.add(y);
                    unhappy.add(u);
                }
                if(rank[y][v]<rank[y][x] && rank[v][y]<rank[v][u]){
                    unhappy.add(y);
                    unhappy.add(v);
                }
            }
        }
        return unhappy.size();
    }
}
