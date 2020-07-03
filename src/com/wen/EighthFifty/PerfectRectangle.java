package com.wen.EighthFifty;

import java.util.*;

public class PerfectRectangle {
    // Similar to below nodes pattern, the result should only have 4 nodes as vertices, and the totalArea need to match
    // the aggregated sums of each rectangle to void overlap
    public boolean isRectangleCover(int[][] rectangles) {
        Set<List<Integer>> nodes=new HashSet<>();
        int totalArea=0, minX=Integer.MAX_VALUE, minY=Integer.MAX_VALUE, maxX=Integer.MIN_VALUE, maxY=Integer.MIN_VALUE;
        for(int[] rec: rectangles){
            minX=Math.min(minX, rec[0]);
            minY=Math.min(minY, rec[1]);
            maxX=Math.max(maxX, rec[2]);
            maxY=Math.max(maxY, rec[3]);
            totalArea+=(rec[2]-rec[0])*(rec[3]-rec[1]);
            List<Integer> leftDown=Arrays.asList(rec[0], rec[1]);
            List<Integer> leftUp=Arrays.asList(rec[0], rec[3]);
            List<Integer> rightUp=Arrays.asList(rec[2], rec[3]);
            List<Integer> rightDown=Arrays.asList(rec[2], rec[1]);
            updateNodes(nodes, leftDown);
            updateNodes(nodes, leftUp);
            updateNodes(nodes, rightUp);
            updateNodes(nodes, rightDown);
        }
        List<Integer> leftDown=Arrays.asList(minX, minY);
        List<Integer> leftUp=Arrays.asList(minX, maxY);
        List<Integer> rightUp=Arrays.asList(maxX, maxY);
        List<Integer> rightDown=Arrays.asList(maxX, minY);
        return nodes.contains(leftDown) && nodes.contains(leftUp) && nodes.contains(rightUp) && nodes.contains(rightDown)
                && nodes.size()==4 && totalArea==(maxX-minX)*(maxY-minY);
    }

    private void updateNodes(Set<List<Integer>> nodes, List<Integer> node){
        if(nodes.contains(node)){
            nodes.remove(node);
        } else{
            nodes.add(node);
        }
    }

//    // Define each vertex to be represented by one bit:
//    //      leftDown:   0001  1
//    //      leftUp:     0010  2
//    //      rightUp:    0100  4
//    //      rightDown:  1000  8
//    // For final result, the nodes must be a vertex or a internal node
//    // For vertices, it can only be single node with above values
//    // For internal nodes, it can only be two nodes or four nodes at the same place: 3,6,12,9,15
//    // Note here not necessary to check area as it won't produce any overlaps
//    public boolean isRectangleCover(int[][] rectangles) {
//        int N=rectangles.length;
//        Map<List<Integer>, Integer> nodes=new HashMap<>();
//        for(int[] rec: rectangles){
//            List<Integer> leftDown=Arrays.asList(rec[0], rec[1]);
//            List<Integer> leftUp=Arrays.asList(rec[0], rec[3]);
//            List<Integer> rightUp=Arrays.asList(rec[2], rec[3]);
//            List<Integer> rightDown=Arrays.asList(rec[2], rec[1]);
//            if(!checkNode(nodes, leftDown, 1)){
//                return false;
//            }
//            if(!checkNode(nodes, leftUp, 2)){
//                return false;
//            }
//            if(!checkNode(nodes, rightUp, 4)){
//                return false;
//            }
//            if(!checkNode(nodes, rightDown, 8)){
//                return false;
//            }
//        }
//        int vertex=0;
//        Set<Integer> vertices=new HashSet<>(Arrays.asList(1,2,4,8));
//        Set<Integer> internal=new HashSet<>(Arrays.asList(3,6,12,9,15));
//        for(int v: nodes.values()){
//            if(vertices.contains(v)){
//                if((vertex&v)==0){
//                    vertex|=v;
//                } else{
//                    return false;
//                }
//            } else if(!internal.contains(v)){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private boolean checkNode(Map<List<Integer>, Integer> nodes, List<Integer> node, int type){
//        int exist=nodes.getOrDefault(node, 0);
//        if((exist&type)!=0){
//            return false;
//        } else{
//            nodes.put(node, exist|type);
//            return true;
//        }
//    }
}
