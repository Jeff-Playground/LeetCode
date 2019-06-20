package com.wen.SeventhFifty;

import java.util.*;

public class LQNumberOfIslandsII {
    public class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        public Point(int a, int b) { x = a; y = b; }
    }

    public class UnionFind{
        int[] pre=null;
        int[] count=null;
        int total=0;

        public UnionFind(int n){
            pre=new int[n];
            count=new int[n];
            Arrays.fill(pre,-1);
        }

        public int findPre(int x){
            int r=x;
            while(pre[r]!=r){
                r=pre[r];
            }
            int cur=x;
            while(pre[x]!=x){
                cur=pre[x];
                pre[x]=r;
                x=cur;
            }
            return r;
        }

        public void union(int x, int y){
            int px=findPre(x);
            int py=findPre(y);
            if(px!=py){
                if(count[px]<count[py]){
                    pre[px]=py;
                } else{
                    pre[py]=pre[px];
                    if(count[px]==count[py]){
                        count[py]++;
                    }
                }
                total--;
            }
        }

        public void add(int x){
            if(pre[x]>0){
                return;
            }
            pre[x]=x;
            count[x]=1;
            total++;
        }

        public boolean exists(int x){
            return pre[x]>=0;
        }
    }

    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        if(n<=0 || m<=0){
            throw new IllegalArgumentException("Input is invalid!");
        }
        List<Integer> result=new ArrayList<>();
        if(operators==null || operators.length==0){
            return result;
        }
        int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        UnionFind uf=new UnionFind(m*n);
        for(Point p: operators){
            int key=p.x*m+p.y;
            uf.add(key);
            for(int[] dir: dirs){
                int x=p.x+dir[0], y=p.y+dir[1];
                int keyN=x*m+y;
                if(x>=0 && x<n && y>=0 && y<m && uf.exists(keyN)){
                    uf.union(key, keyN);
                }
            }
            result.add(uf.total);
        }
        return result;
    }
}
