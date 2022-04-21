package com.wen.SeventeenthFifty;

import java.util.*;

public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> xMap=new HashMap<>();
        for(int[] p: points){
            int x=p[0], y=p[1];
            xMap.putIfAbsent(x, new HashSet<>());
            xMap.get(x).add(y);
        }
        int result=Integer.MAX_VALUE;
        List<Integer> xList=new ArrayList<>(xMap.keySet());
        int l=xList.size();
        for(int i=0; i<l-1; i++){
            for(int j=i+1; j<l; j++){
                int x1=xList.get(i), x2=xList.get(j);
                if(xMap.get(x1).size()>1 && xMap.get(x2).size()>1){
                    Set<Integer> y1=xMap.get(x1), y2=xMap.get(x2);
                    TreeSet<Integer> intersection=new TreeSet<>(y1);
                    intersection.retainAll(y2);
                    if(intersection.size()>=2){
                        int min=Integer.MAX_VALUE;
                        Iterator<Integer> it=intersection.iterator();
                        int first=it.next();
                        while(it.hasNext()){
                            int second=it.next();
                            min=Math.min(min, second-first);
                            first=second;
                        }
                        result=Math.min(result, min*Math.abs(x1-x2));
                    }
                }
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }
}
