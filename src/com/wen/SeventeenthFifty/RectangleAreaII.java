package com.wen.SeventeenthFifty;

import java.util.*;

public class RectangleAreaII {
    // Segment tree with coordinates compression
    public static int rectangleArea(int[][] rectangles) {
        int l=rectangles.length;
        int OPEN=1, CLOSE=-1;
        Set<Integer> xVals=new TreeSet<>();
        int[][] events=new int[2*l][];
        int t=0;
        for(int[] rec: rectangles){
            events[t++]=new int[]{rec[1], OPEN, rec[0], rec[2]};
            events[t++]=new int[]{rec[3], CLOSE, rec[0], rec[2]};
            xVals.add(rec[0]);
            xVals.add(rec[2]);
        }
        Arrays.sort(events, (a, b)->Integer.compare(a[0], b[0]));
        Integer[] sortedX=xVals.toArray(new Integer[0]);
        Map<Integer, Integer> xIdx=new HashMap<>();
        for(int i=0; i<sortedX.length; i++){
            xIdx.put(sortedX[i], i);
        }
        long result=0, curX=0;
        int lastY=events[0][0];
        Node active=new Node(0, sortedX.length-1, sortedX);
        for(int[] event: events){
            int y=event[0], type=event[1], x1=event[2], x2=event[3];
            result+=curX*(y-lastY);
            curX=active.update(xIdx.get(x1), xIdx.get(x2), type);
            lastY=y;
        }
        result%=1_000_000_007;
        return (int)result;
    }

    static class Node{
        int start, end;
        Node left, right;
        Integer[] sortedIdx;
        int count;
        long total;

        public Node(int start, int end, Integer[] sortedIdx){
            this.sortedIdx=sortedIdx;
            this.start=start;
            this.end=end;
            left=null;
            right=null;
            count=0;
            total=0;
        }

        public int getRangeMid(){
            return start+(end-start)/2;
        }

        public Node getLeft(){
            if(left==null){
                left=new Node(start, getRangeMid(), sortedIdx);
            }
            return left;
        }

        public Node getRight() {
            if(right==null){
                right=new Node(getRangeMid(), end, sortedIdx);
            }
            return right;
        }

        public long update(int i, int j, int val){
            if(i>=j){
                return 0;
            }
            if(i==start && j==end){
                count+=val;
            } else{
                getLeft().update(i, Math.min(j, getRangeMid()), val);
                getRight().update(Math.max(i, getRangeMid()), j, val);
            }
            if(count>0){
                total=sortedIdx[end]-sortedIdx[start];
            } else{
                total=getLeft().total+getRight().total;
            }
            return total;
        }
    }

//    // Line sweep
//    public static int rectangleArea(int[][] rectangles) {
//        int l=rectangles.length;
//        int OPEN=0, CLOSE=1;
//        int[][] events=new int[2*l][];
//        int t=0;
//        for(int[] rec: rectangles){
//            events[t++]=new int[]{rec[1], OPEN, rec[0], rec[2]};
//            events[t++]=new int[]{rec[3], CLOSE, rec[0], rec[2]};
//        }
//        Arrays.sort(events, (a, b)->Integer.compare(a[0],b[0]));
//        List<int[]> active=new ArrayList<>();
//        int start=events[0][0];
//        long result=0;
//        for(int[] event: events){
//            int curY=event[0], type=event[1], x1=event[2], x2=event[3];
//            long query=0;
//            int cur=-1;
//            for(int[] xs:active){
//                cur=Math.max(cur, xs[0]);
//                query+=Math.max(xs[1]-cur, 0);
//                cur=Math.max(cur, xs[1]);
//            }
//            result+=query*(curY-start);
//            if(type==OPEN){
//                active.add(new int[]{x1, x2});
//                Collections.sort(active, (a, b)->Integer.compare(a[0], b[0]));
//            } else{
//                for(int i=0; i<active.size(); i++){
//                    if(active.get(i)[0]==x1 && active.get(i)[1]==x2){
//                        active.remove(i);
//                        break;
//                    }
//                }
//            }
//            start=curY;
//        }
//        result%=1_000_000_007;
//        return (int)result;
//    }

//    // Coordinates compression
//    public static int rectangleArea(int[][] rectangles) {
//        Set<Integer> xVals=new TreeSet<>();
//        Set<Integer> yVals=new TreeSet<>();
//        for(int[] rec: rectangles){
//            xVals.add(rec[0]);
//            yVals.add(rec[1]);
//            xVals.add(rec[2]);
//            yVals.add(rec[3]);
//        }
//        int xl=xVals.size(), yl=yVals.size();
//        Integer[] xSorted=xVals.toArray(new Integer[xl]), ySorted=yVals.toArray(new Integer[yl]);
//        Map<Integer, Integer> xMap=new HashMap<>(), yMap=new HashMap<>();
//        for(int i=0; i<xSorted.length; i++){
//            xMap.put(xSorted[i], i);
//        }
//        for(int i=0; i<ySorted.length; i++){
//            yMap.put(ySorted[i], i);
//        }
//        int[][] grid=new int[xl][yl];
//        for(int[] rec: rectangles){
//            for(int x=xMap.get(rec[0]); x<xMap.get(rec[2]); x++){
//                for(int y=yMap.get(rec[1]); y<yMap.get(rec[3]); y++){
//                    grid[x][y]=1;
//                }
//            }
//        }
//        long result=0;
//        for(int x=0; x<grid.length; x++){
//            for(int y=0; y<grid[0].length; y++){
//                if(grid[x][y]==1){
//                    result+=(long)(xSorted[x+1]-xSorted[x])*(ySorted[y+1]-ySorted[y]);
//                }
//            }
//        }
//        result%=1_000_000_007;
//        return (int)result;
//    }

//    // Principle of inclusion-exclusion(will TLE)
//    public int rectangleArea(int[][] rectangles) {
//        int n=rectangles.length;
//        long result=0;
//        for(int subset=1; subset<=((1<<n)-1); subset++){
//            int[] rec=new int[]{0,0,1_000_000_000,1_000_000_000};
//            int parity=-1;
//            for(int bit=0; bit<n; bit++){
//                if(((subset>>bit)&1)!=0){
//                    rec=intersect(rec, rectangles[bit]);
//                    parity*=-1;
//                }
//            }
//            result+=parity*area(rec);
//        }
//        long mod=1_000_000_007;
//        result%=mod;
//        if(result<0){
//            result+=mod;
//        }
//        return (int)result;
//    }
//
//    private long area(int[] rec) {
//        long dx=Math.max(0, rec[2]-rec[0]), dy=Math.max(0, rec[3]-rec[1]);
//        return dx*dy;
//    }
//
//    private int[] intersect(int[] rec1, int[] rec2) {
//        return new int[]{
//                Math.max(rec1[0], rec2[0]),
//                Math.max(rec1[1], rec2[1]),
//                Math.min(rec1[2], rec2[2]),
//                Math.min(rec1[3], rec2[3])
//        };
//    }
}
