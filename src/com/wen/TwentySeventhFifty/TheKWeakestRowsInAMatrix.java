package com.wen.TwentySeventhFifty;

import java.util.PriorityQueue;

public class TheKWeakestRowsInAMatrix {
    // Heap
    public int[] kWeakestRows(int[][] mat, int k) {
        int l=mat.length;
        int[] result=new int[k];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->a[1]!=b[1]?a[1]-b[1]:a[0]-b[0]);
        for(int i=0; i<l; i++){
            int[] row=mat[i];
            int idx=0;
            while(idx<row.length && row[idx]==1){
                idx++;
            }
            pq.offer(new int[]{i, idx-1});
        }
        for(int i=0; i<k; i++){
            result[i]=pq.poll()[0];
        }
        return result;
    }
}
