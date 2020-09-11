package com.wen.TwelfthFifty;

import java.util.HashSet;
import java.util.Set;

public class ErectTheFence {
    // Jarvis march
    public int[][] outerTrees(int[][] points) {
        Set<Integer> idx=new HashSet<>();
        int l=points.length, firstIdx=0;
        for(int i=1; i<l; i++){
            if(points[i][0]<points[firstIdx][0]){
                firstIdx=i;
            }
        }
        idx.add(firstIdx);
        int curIdx=firstIdx;
        do{
            int nextIdx=0;
            for(int i=1; i<l; i++){
                if(i!=curIdx){
                    int cp=crossProduct(points, curIdx, nextIdx, i);
                    if(nextIdx==curIdx || cp>0 || (cp==0 && dist(points, i, curIdx)>dist(points, nextIdx, curIdx))){
                        nextIdx=i;
                    }
                }
            }
            for(int i=0; i<l; i++){
                if(i!=curIdx){
                    int cp=crossProduct(points, curIdx, nextIdx, i);
                    if(cp==0){
                        idx.add(i);
                    }
                }
            }
            curIdx=nextIdx;
        } while(curIdx!=firstIdx);
        int size=idx.size();
        int[][] result=new int[size][2];
        int i=0;
        for(int id: idx){
            result[i++]=points[id];
        }
        return result;
    }

    private int crossProduct(int[][] points, int ai, int bi, int ci){
        int[] a=points[ai], b=points[bi], c=points[ci];
        int dx1=b[0]-a[0], dx2=c[0]-a[0];
        int dy1=b[1]-a[1], dy2=c[1]-a[1];
        return dx1*dy2-dy1*dx2;
    }

    private int dist(int[][] points, int ai, int bi){
        int[] a=points[ai], b=points[bi];
        return (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
    }
}
