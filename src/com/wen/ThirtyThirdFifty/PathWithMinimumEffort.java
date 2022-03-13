package com.wen.ThirtyThirdFifty;

import java.util.*;

public class PathWithMinimumEffort {
//    // Binary search
//    public int minimumEffortPath(int[][] heights) {
//        int left=0, right=Integer.MAX_VALUE;
//        while(left<right){
//            int mid=left+(right-left)/2;
//            if(reachable(heights, mid)){
//                right=mid;
//            } else{
//                left=mid+1;
//            }
//        }
//        return left;
//    }
//
//    private boolean reachable(int[][] heights, int effort){
//        int m=heights.length, n=heights[0].length;
//        if(m==1 && n==1){
//            return true;
//        }
//        int[][] visited=new int[m][n];
//        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
//        Queue<int[]> q=new LinkedList<>();
//        q.offer(new int[]{0,0});
//        while(!q.isEmpty()){
//            int[] last=q.poll();
//            int x=last[0], y=last[1];
//            for(int[] d: dirs){
//                int nx=x+d[0], ny=y+d[1];
//                if(nx>=0 && nx<m && ny>=0 && ny<n){
//                    if(visited[nx][ny]==0 && Math.abs(heights[x][y]-heights[nx][ny])<=effort){
//                        if(nx==m-1 && ny==n-1){
//                            return true;
//                        } else{
//                            visited[nx][ny]=1;
//                            q.offer(new int[]{nx, ny});
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }

    // SPFA
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length, n=heights[0].length, l=m*n;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int[] effort=new int[l];
        Arrays.fill(effort, Integer.MAX_VALUE);
        effort[0]=0;
        pq.offer(0);
        while(!pq.isEmpty()){
            int last=pq.poll();
            int x=last/n, y=last%n;
            for(int[] d: dirs){
                int nx=x+d[0], ny=y+d[1];
                if(nx>=0 && nx<m && ny>=0 && ny<n){
                    int cur=nx*n+ny;
                    int curEffort=Math.max(effort[last], Math.abs(heights[x][y]-heights[nx][ny]));
                    if(curEffort<effort[cur]){
                        effort[cur]=curEffort;
                        pq.offer(cur);
                    }
                }
            }
        }
        return effort[l-1];
    }

//    // Dijkstra
//    public int minimumEffortPath(int[][] heights) {
//        int m=heights.length, n=heights[0].length;
//        int l=m*n;
//        Map<Integer, Map<Integer, Integer>> graph=new HashMap<>();
//        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                int v1=i*n+j;
//                for(int[] d: dirs){
//                    int x=i+d[0], y=j+d[1];
//                    if(x>=0 && x<m && y>=0 && y<n){
//                        int v2=x*n+y;
//                        int e=Math.abs(heights[i][j]-heights[x][y]);
//                        graph.putIfAbsent(v1, new HashMap<>());
//                        graph.putIfAbsent(v2, new HashMap<>());
//                        graph.get(v1).put(v2, e);
//                        graph.get(v2).put(v1, e);
//                    }
//                }
//            }
//        }
//        int start=0;
//        Map<Integer, Integer> reached=new HashMap<>();
//        reached.put(start, 0);
//        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Math.max(reached.get(a[0]),graph.get(a[0]).get(a[1]))-Math.max(reached.get(b[0]),graph.get(b[0]).get(b[1])));
//        for(int v: graph.getOrDefault(0, new HashMap<>()).keySet()){
//            pq.offer(new int[]{0, v});
//        }
//        while(!pq.isEmpty() && !reached.containsKey(l-1)){
//            int[] cur=pq.poll();
//            if(!reached.containsKey(cur[1])){
//                reached.put(cur[1], Math.max(reached.get(cur[0]),graph.get(cur[0]).get(cur[1])));
//                for(int v: graph.get(cur[1]).keySet()){
//                    if(!reached.containsKey(v)){
//                        pq.offer(new int[]{cur[1], v});
//                    }
//                }
//            }
//        }
//        return reached.get(l-1);
//    }
}
