package com.wen.NinthFifty;

import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        if(points==null || points.length<=2){
            return 0;
        }
        int result=0, l=points.length;
        for(int i=0; i<l; i++){
            Map<Integer, Integer> distSquares=new HashMap<>();
            for(int j=0; j<l; j++){
                if(j!=i){
                    int distSquare=getDistSquare(points[i], points[j]);
                    distSquares.put(distSquare, distSquares.getOrDefault(distSquare, 0)+1);
                }
            }
            for(int count: distSquares.values()){
                if(count>1){
                    result+=count*(count-1);
                }
            }
        }
        return result;
    }

    private int getDistSquare(int[] a, int[] b){
        return (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
    }
}
