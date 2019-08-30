package com.wen.FourteenthFifty;

import java.util.*;

public class FallingSquares {
    // Segment tree with coordinates compression
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> result=new ArrayList<>();
        Set<Integer> idxs=new TreeSet<>();
        for(int[] position: positions) {
            idxs.add(position[0]);
            idxs.add(position[0]+position[1]);
        }
        Integer[] sortedPos=idxs.toArray(new Integer[0]);
        Map<Integer, Integer> idxMap=new HashMap<>();
        for(int i=0; i<sortedPos.length; i++) {
            idxMap.put(sortedPos[i], i);
        }
        Node root=new Node(0, sortedPos.length-1, 0);
        for(int[] position: positions) {
            int left=idxMap.get(position[0]), right=idxMap.get(position[0]+position[1]), h=position[1];
            root.update(left, right, h);
            result.add(root.max);
        }
        return result;
    }

    class Node{
        int start, end;
        Node left, right;
        int max;

        public Node(int start, int end, int max){
            this.start=start;
            this.end=end;
            left=null;
            right=null;
            this.max=max;
        }

        public int getRangeMid(){
            return start+(end-start)/2;
        }

        public Node getLeft(){
            if(left==null){
                left=new Node(start, getRangeMid(), max);
            }
            return left;
        }

        public Node getRight(){
            if(right==null){
                right=new Node(getRangeMid(), end, max);
            }
            return right;
        }

        public int query(int i, int j) {
            if(i>=j) {
                return 0;
            }
            if(i==start && j==end) {
                return max;
            } else {
                int leftMax=getLeft().query(i, Math.min(j, getRangeMid()));
                int rightMax=getRight().query(Math.max(i, getRangeMid()), j);
                return Math.max(leftMax, rightMax);
            }
        }

        public void update(int i, int j, int h){
            if(i>=j){
                return;
            }
            if(i==start && j==end){
                max+=h;
                left=null;
                right=null;
            } else{
                int leftMax=getLeft().query(i, Math.min(j, getRangeMid()));
                int rightMax=getRight().query(Math.max(i, getRangeMid()), j);
                int existingMax=Math.max(leftMax, rightMax);
                getLeft().update(i, Math.min(j, getRangeMid()), existingMax+h-leftMax);
                getRight().update(Math.max(i, getRangeMid()), j, existingMax+h-rightMax);
                max=Math.max(max, existingMax+h);
            }
        }
    }

//    // Coordinates compression
//    public List<Integer> fallingSquares(int[][] positions) {
//        List<Integer> result=new ArrayList<>();
//        Set<Integer> idxs=new TreeSet<>();
//        for(int[] position: positions) {
//            idxs.add(position[0]);
//            idxs.add(position[0]+position[1]);
//        }
//        Integer[] sortedPos=idxs.toArray(new Integer[0]);
//        Map<Integer, Integer> idxMap=new HashMap<>();
//        for(int i=0; i<sortedPos.length; i++) {
//            idxMap.put(sortedPos[i], i);
//        }
//        int[] heights=new int[sortedPos.length];
//        for(int[] position: positions) {
//            int left=idxMap.get(position[0]), right=idxMap.get(position[0]+position[1]), h=position[1];
//            int maxH=0;
//            for(int i=left; i<right; i++) {
//                maxH=Math.max(maxH, heights[i]);
//            }
//            for(int i=left; i<right; i++) {
//                heights[i]=maxH+h;
//            }
//            result.add(result.size()==0?maxH+h:Math.max(maxH+h, result.get(result.size()-1)));
//        }
//        return result;
//    }
}
