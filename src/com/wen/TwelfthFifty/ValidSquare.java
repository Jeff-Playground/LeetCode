package com.wen.TwelfthFifty;

import java.util.*;

public class ValidSquare {
    // Given 4 points, they only case they can form a square is when they can form 2 kinds of edges with 2 kinds of lengths
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> dists=new HashSet<>();
        List<int[]> points=Arrays.asList(p1, p2, p3, p4);
        for(int i=0; i<4; i++){
            for(int j=i+1; j<4; j++){
                int x1=points.get(i)[0], x2=points.get(j)[0];
                int y1=points.get(i)[1], y2=points.get(j)[1];
                int dist=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
                if(dist==0){
                    return false;
                } else{
                    dists.add(dist);
                }
            }
        }
        return dists.size()==2;
    }

//    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
//        Map<Integer, Integer> distCount=new HashMap<>();
//        List<int[]> points= Arrays.asList(p1, p2, p3, p4);
//        for(int i=0; i<4; i++){
//            for(int j=i+1; j<4; j++){
//                int x1=points.get(i)[0], x2=points.get(j)[0];
//                int y1=points.get(i)[1], y2=points.get(j)[1];
//                int dist=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
//                if(dist==0){
//                    return false;
//                } else{
//                    distCount.put(dist, distCount.getOrDefault(dist, 0)+1);
//                }
//            }
//        }
//        return distCount.size()==2;
//    }
}
