package com.wen.NinthFifty;

import java.util.*;

public class LQSequenceReconstruction {
//    // Topological sort
//    public static boolean sequenceReconstruction(int[] org, int[][] seqs) {
//        if(org.length==0 && seqs[0].length==0) {
//            return true;
//        }
//        if(org==null || seqs==null || seqs.length==0 || seqs[0].length==0) {
//            return false;
//        }
//        Map<Integer, Set<Integer>> graph=new HashMap<>();
//        Map<Integer, Integer> inDegree=new HashMap<>();
//        for(int[] seq: seqs){
//            for(int i=0; i<seq.length; i++){
//                graph.putIfAbsent(seq[i], new HashSet<>());
//                inDegree.putIfAbsent(seq[i], 0);
//                if(i+1<seq.length){
//                    Set<Integer> neighbours=graph.get(seq[i]);
//                    if(!neighbours.contains(seq[i+1])){
//                        inDegree.put(seq[i+1], inDegree.getOrDefault(seq[i+1], 0)+1);
//                    }
//                    neighbours.add(seq[i+1]);
//                }
//            }
//        }
//        Queue<Integer> queue=new LinkedList<>();
//        for(Map.Entry<Integer, Integer> e: inDegree.entrySet()){
//            if(e.getValue()==0){
//                queue.offer(e.getKey());
//            }
//        }
//        int index=0;
//        while(!queue.isEmpty()){
//            int size=queue.size();
//            // At any point the size should be 1, otherwise the path is not unique
//            if(size>1){
//                return false;
//            }
//            int cur=queue.poll();
//            // If index>=org.length, it means there's a loop.
//            // If cur!=org[index], it means the order is not correct at this point.
//            if(index>=org.length || cur!=org[index++]){
//                return false;
//            }
//            if(graph.get(cur)!=null){
//                for(int neighbour: graph.get(cur)){
//                    inDegree.put(neighbour, inDegree.get(neighbour)-1);
//                    if(inDegree.get(neighbour)==0){
//                        queue.offer(neighbour);
//                    }
//                }
//            }
//        }
//        return index==org.length && index==inDegree.size();
//    }

    // Just to ensure there'll be only one unique path formed from all seqs elements
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if(org.length==0 && seqs[0].length==0) {
            return true;
        }
        if(org==null || seqs==null || seqs.length==0 || seqs[0].length==0) {
            return false;
        }
        int l=org.length;
        Map<Integer, Integer> orgIndex=new HashMap<>();
        Map<Integer, Integer> pre=new HashMap<>();
        for(int i=0; i<l; i++) {
            orgIndex.put(org[i], i);
        }
        for(int[] seq: seqs) {
            for(int i=0; i<seq.length; i++) {
                if(!orgIndex.containsKey(seq[i])) {
                    return false;
                }
                if(i>0 && orgIndex.get(seq[i-1])>orgIndex.get(seq[i])) {
                    return false;
                }
                if(i>0) {
                    if(!pre.containsKey(seq[i])) {
                        pre.put(seq[i], seq[i-1]);
                    } else {
                        if(orgIndex.get(pre.get(seq[i]))<orgIndex.get(seq[i-1])){
                            pre.put(seq[i], seq[i-1]);
                        }
                    }
                }
            }
        }
        for(int i=1; i<l; i++) {
            if(!pre.containsKey(org[i]) || (i>0 && pre.get(org[i])!=org[i-1])) {
                return false;
            }
        }
        return true;
    }
}
