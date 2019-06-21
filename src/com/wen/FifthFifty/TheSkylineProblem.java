package com.wen.FifthFifty;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TheSkylineProblem {
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings==null || buildings.length == 0){
            return new LinkedList<>();
        } else{
            return getSkylineDivideAndConquer(buildings, 0, buildings.length-1);
        }
    }

    private static LinkedList<List<Integer>> getSkylineDivideAndConquer(int[][] buildings, int start, int end) {
        if(start<end){
            int mid=start+(end-start)/2;
            return merge(getSkylineDivideAndConquer(buildings, start, mid), getSkylineDivideAndConquer(buildings, mid+1, end));
        } else{
            LinkedList<List<Integer>> result=new LinkedList<>();
            result.add(Arrays.asList(buildings[start][0], buildings[start][2]));
            result.add(Arrays.asList(buildings[start][1], 0));
            return result;
        }
    }

    private static LinkedList<List<Integer>> merge(LinkedList<List<Integer>> l1, LinkedList<List<Integer>> l2) {
        LinkedList<List<Integer>> result=new LinkedList<>();
        int h1=0, h2=0;
        while(!l1.isEmpty() && !l2.isEmpty()){
            int x=0, h=0;
            if(l1.getFirst().get(0)<l2.getFirst().get(0)){
                x=l1.getFirst().get(0);
                h1=l1.getFirst().get(1);
                h=Math.max(h1, h2);
                l1.removeFirst();
            } else if(l1.getFirst().get(0)>l2.getFirst().get(0)){
                x=l2.getFirst().get(0);
                h2=l2.getFirst().get(1);
                h=Math.max(h1, h2);
                l2.removeFirst();
            } else{
                x=l1.getFirst().get(0);
                h1=l1.getFirst().get(1);
                h2=l2.getFirst().get(1);
                h=Math.max(h1, h2);
                l1.removeFirst();
                l2.removeFirst();
            }
            if(result.isEmpty() || result.getLast().get(1)!=h){
                result.add(Arrays.asList(x, h));
            }
        }
        if(!l1.isEmpty()){
            result.addAll(l1);
        }
        if(!l2.isEmpty()){
            result.addAll(l2);
        }
        return result;
    }
}
