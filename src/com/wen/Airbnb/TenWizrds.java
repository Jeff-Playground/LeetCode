package com.wen.Airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class TenWizrds {
    public static void main(String args[]) {
        List<List<Integer>> wizards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 0) {
                list.add(1);
                list.add(2);
            } else if (i == 1) {
                list.add(3);
            } else if (i == 2) {
                list.add(3);
                list.add(4);
            } else if (i == 3) {
                list.add(4);
            }
            wizards.add(list);
        }
        List<Integer> path = getShortestPath(wizards, 0, 4);
        for (int i = 0; i < path.size(); i++) {
            System.out.println(path.get(i));
        }
    }

    private static List<Integer> getShortestPath(List<List<Integer>> wizards, int src, int dst) {
        List<Integer> result=new ArrayList<>();
        int[] visited=new int[wizards.size()];
        int[] last=new int[wizards.size()];
        Arrays.fill(last, -1);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->a[0]-b[0]);
        for(Integer srcTo: wizards.get(src)){
            pq.offer(new int[]{(src-srcTo)*(src-srcTo), src, srcTo});
        }
        visited[src]=1;
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            if(visited[cur[2]]==0){
                visited[cur[2]]=1;
                last[cur[2]]=cur[1];
                if(cur[2]==dst){
                    result.add(dst);
                    int t=dst;
                    while(t!=src){
                        result.add(0, last[t]);
                        t=last[t];
                    }
                    return result;
                } else{

                }
            }
        }
        return null;
    }
}
