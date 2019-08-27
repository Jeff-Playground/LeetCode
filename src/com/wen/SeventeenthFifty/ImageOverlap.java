package com.wen.SeventeenthFifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        List<Integer> aList=new ArrayList<>(), bList=new ArrayList<>();
        Map<Integer, Integer> count=new HashMap<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(A[i][j]==1) {
                    aList.add(i*100+j);
                }
                if(B[i][j]==1) {
                    bList.add(i*100+j);
                }
            }
        }
        for(int a: aList) {
            for(int b: bList) {
                count.put(a-b, count.getOrDefault(a-b, 0)+1);
            }
        }
        int result=0;
        for(int cnt: count.values()) {
            result=Math.max(result, cnt);
        }
        return result;
    }
}
