package com.wen.EighteenthFifty;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestPathToGetAllKeys {
    public static int shortestPathAllKeys(String[] grid) {
        int m=grid.length, n=grid[0].length();
        char[][] g=new char[m][n];
        int[] start=new int[]{-1,-1, 0};
        int allKeys=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                g[i][j]=grid[i].charAt(j);
                if(g[i][j]=='@'){
                    start[0]=i;
                    start[1]=j;
                } else if(isKey(g[i][j])){
                    allKeys|=1<<(g[i][j]-'a');
                }
            }
        }
        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        Set<String> visited=new HashSet<>();
        Queue<int[]> q=new LinkedList<>();
        q.offer(start);
        visited.add(start[0]+"_"+start[1]+"_"+0);
        int result=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                int[] cur=q.poll();
                int keys=cur[2];
                for(int[] dir: dirs){
                    int x=cur[0]+dir[0], y=cur[1]+dir[1];
                    if(x>=0 && x<m && y>=0 && y<n && g[x][y]!='#'){
                        int newKeys=keys;
                        if(isKey(g[x][y])){
                            newKeys |= 1 << (g[x][y] - 'a');
                            if (newKeys == allKeys) {
                                return result + 1;
                            }
                        }
                        if(!visited.contains(x+"_"+y+"_"+newKeys)){
                            if(!isLock(g[x][y]) || (isLock(g[x][y]) && (1<<(g[x][y]-'A')&keys)>0)){
                                visited.add(x+"_"+y+"_"+newKeys);
                                q.offer(new int[]{x, y, newKeys});
                            }
                        }
                    }
                }
            }
            result++;
        }
        return -1;
    }

    private static boolean isKey(char c){
        return c>='a' && c<='z';
    }

    private static boolean isLock(char c){
        return c>='A' && c<='Z';
    }
}
