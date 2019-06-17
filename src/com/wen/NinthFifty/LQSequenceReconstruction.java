package com.wen.NinthFifty;

import java.util.*;

public class LQSequenceReconstruction {
    public static boolean sequenceReconstruction(int[] org, int[][] seqs) {
        if(org.length==0 && seqs[0].length==0) {
            return true;
        }
        if(org==null || seqs==null || seqs.length==0 || seqs[0].length==0) {
            return false;
        }
        Map<Integer, Set<Integer>> graph=new HashMap<>();
        Map<Integer, Integer> inDegree=new HashMap<>();
        for(int[] seq: seqs){
            for(int i=0; i<seq.length; i++){
                if(i==0){
                    if(!graph.containsKey(seq[i])){
                        graph.put(seq[i], new HashSet<>());
                    }
                    if(!inDegree.containsKey(seq[i])){
                        inDegree.put(seq[i], 0);
                    }
                }
                if(i+1<seq.length){
                    Set<Integer> neighbours=graph.get(seq[i]);
                    if(neighbours==null){
                        neighbours=new HashSet<>();
                    }
                    if(!neighbours.contains(seq[i+1])){
                        inDegree.put(seq[i+1], inDegree.getOrDefault(seq[i+1], 0)+1);
                    }
                    neighbours.add(seq[i+1]);
                    graph.put(seq[i], neighbours);
                }
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        for(Map.Entry<Integer, Integer> e: inDegree.entrySet()){
            if(e.getValue()==0){
                queue.offer(e.getKey());
            }
        }
        int index=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            if(size>1){
                return false;
            }
            int cur=queue.poll();
            if(index>=org.length || cur!=org[index++]){
                return false;
            }
            if(graph.get(cur)!=null){
                for(int neighbour: graph.get(cur)){
                    inDegree.put(neighbour, inDegree.get(neighbour)-1);
                    if(inDegree.get(neighbour)==0){
                        queue.offer(neighbour);
                    }
                }
            }
        }
        return index==org.length && index==inDegree.size();
    }

//    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
//        if(org.length==0 && seqs[0].length==0) {
//            return true;
//        }
//        if(org==null || seqs==null || seqs.length==0 || seqs[0].length==0) {
//            return false;
//        }
//        int n=org.length;
//        Map<Integer, Integer> pos=new HashMap<>();
//        Map<Integer, Integer> pre=new HashMap<>();
//        for(int i=0; i<n; i++) {
//            pos.put(org[i], i);
//        }
//        for(int[] seq: seqs) {
//            for(int i=0; i<seq.length; i++) {
//                if(!pos.containsKey(seq[i])) {
//                    return false;
//                }
//                if(i>0 && pos.get(seq[i-1])>=pos.get(seq[i])) {
//                    return false;
//                }
//                if(i>0) {
//                    if(!pre.containsKey(seq[i])) {
//                        pre.put(seq[i], seq[i-1]);
//                    } else {
//                        pre.put(seq[i], Math.max(seq[i-1], pre.get(seq[i])));
//                    }
//                }
//            }
//        }
//        for(int i=1; i<n; i++) {
//            if(!pre.containsKey(org[i]) || (i>0 && pre.get(org[i])!=org[i-1])) {
//                return false;
//            }
//        }
//        return true;
//    }
}
