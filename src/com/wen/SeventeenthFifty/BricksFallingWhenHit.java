package com.wen.SeventeenthFifty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BricksFallingWhenHit {
    // Union find
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m=grid.length, n=grid[0].length, l=hits.length;
        int[] result=new int[l];
        int[] root=new int[m*n], count=new int[m*n], connectedToTop=new int[m*n];
        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        Arrays.fill(root, -1);
        Arrays.fill(count, 1);
        for(int i=0; i<n; i++){
            connectedToTop[i]=1;
        }
        for(int[] hit: hits){
            grid[hit[0]][hit[1]]--;
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    if(i+1<m && grid[i+1][j]==1){
                        int r1=findRoot(root, i*n+j), r2=findRoot(root, (i+1)*n+j);
                        if(r1!=r2){
                            union(root, count, r1, r2);
                            connectedToTop[r1]=connectedToTop[r2]=(connectedToTop[r1]|connectedToTop[r2]);
                        }
                    }
                    if(j+1<n && grid[i][j+1]==1){
                        int r1=findRoot(root, i*n+j), r2=findRoot(root, i*n+j+1);
                        if(r1!=r2){
                            union(root, count, r1, r2);
                            connectedToTop[r1]=connectedToTop[r2]=(connectedToTop[r1]|connectedToTop[r2]);
                        }
                    }
                }
            }
        }
        for(int i=l-1; i>=0; i--){
            int[] hit=hits[i];
            int x=hit[0], y=hit[1], r1=findRoot(root, x*n+y), cnt=0;
            if(++grid[x][y]==1){
                for(int[] dir: dirs){
                    int xN=x+dir[0], yN=y+dir[1];
                    if(xN>=0 && xN<m && yN>=0 && yN<n && grid[xN][yN]==1){
                        int r2=findRoot(root, xN*n+yN);
                        if(r1!=r2){
                            if(connectedToTop[r2]==0){
                                cnt+=count[r2];
                            }
                            union(root, count, r1, r2);
                            connectedToTop[r1]=connectedToTop[r2]=(connectedToTop[r1]|connectedToTop[r2]);
                        }
                    }
                }
            }
            if(connectedToTop[r1]==1){
                result[i]=cnt;
            }
        }
        return result;
    }

    private int findRoot(int[] root, int key){
        return root[key]==-1?key:findRoot(root, root[key]);
    }

    private void union(int[] root, int[] count, int x, int y){
        root[y]=x;
        count[x]+=count[y];
    }
    
//    // DFS
//    public static int[] hitBricks(int[][] grid, int[][] hits) {
//        int m=grid.length, n=grid[0].length, l=hits.length;
//        int[] result=new int[l];
//        int[][] dirs=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
//        Set<Integer> notDropped=new HashSet<>();
//        for(int[] hit: hits){
//            grid[hit[0]][hit[1]]--;
//        }
//        for(int j=0; j<n; j++){
//            if(grid[0][j]==1){
//                getNotDropped(grid, 0, j, notDropped, dirs);
//            }
//        }
//        for(int i=l-1; i>=0; i--){
//            int[] hit=hits[i];
//            int beforeSize=notDropped.size(), x=hit[0], y=hit[1];
//            if(++grid[x][y]==1){
//                boolean add=(x==0);
//                if(!add) {
//                    for (int[] dir : dirs) {
//                        int a = x + dir[0], b = y + dir[1];
//                        if (a >= 0 && a < m && b >= 0 && b < n && notDropped.contains(a * n + b)) {
//                            add = true;
//                            break;
//                        }
//                    }
//                }
//                if(add){
//                    getNotDropped(grid, x, y, notDropped, dirs);
//                    result[i]=notDropped.size()-1-beforeSize;
//                }
//            }
//        }
//        return result;
//    }
//
//    private static void getNotDropped(int[][] grid, int x, int y, Set<Integer> notDropped, int[][] dirs){
//        int m=grid.length, n=grid[0].length;
//        notDropped.add(x*n+y);
//        for(int[] dir: dirs){
//            int a=x+dir[0], b=y+dir[1];
//            if(a>=0 && a<m && b>=0 && b<n && grid[a][b]==1 && !notDropped.contains(a*n+b)){
//                getNotDropped(grid, a, b, notDropped, dirs);
//            }
//        }
//    }

//    // DFS, will TLE because there're too many duplicated checks
//    public static int[] hitBricks(int[][] grid, int[][] hits) {
//        int m=grid.length, n=grid[0].length;
//        int l=hits.length;
//        int[] result=new int[l];
//        int[][] dirs=new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
//        for(int i=0; i<l; i++){
//            int[] hit=hits[i];
//            int x=hit[0], y=hit[1];
//            if(x>=0 && x<m && y>=0 && y<n){
//                if(grid[x][y]!=0){
//                    grid[x][y]=0;
//                    for(int[] dir: dirs){
//                        int a=x+dir[0], b=y+dir[1];
//                        if(a>0 && a<m && b>=0 && b<n && grid[a][b]==1){
//                            Set<Integer> visited=new HashSet<>();
//                            visited.add(a*n+b);
//                            if(hitBricksDFS(grid, a, b, visited, dirs)){
//                                result[i]+=visited.size();
//                                for(int key: visited){
//                                    grid[key/n][key%n]=0;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    private static boolean hitBricksDFS(int[][] grid, int x, int y, Set<Integer> visited, int[][] dirs){
//        int m=grid.length, n=grid[0].length;
//        for(int[] dir: dirs){
//            int a=x+dir[0], b=y+dir[1];
//            if(a>=0 && a<m && b>=0 && b<n && grid[a][b]==1 && !visited.contains(a*n+b)){
//                if(a==0){
//                    visited.clear();
//                    return false;
//                } else{
//                    visited.add(a*n+b);
//                    if(!hitBricksDFS(grid, a, b, visited, dirs)){
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }
}
