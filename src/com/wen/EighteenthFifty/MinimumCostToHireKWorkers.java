package com.wen.EighteenthFifty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumCostToHireKWorkers {
    // Greedy
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int l=quality.length;
        double result=Double.MAX_VALUE;
        List<int[]> workers=new ArrayList<>();
        for(int i=0; i<l; i++) {
            workers.add(new int[] {quality[i], wage[i]});
        }
        Collections.sort(workers, (a, b)->Double.compare((double)a[1]/a[0], (double)b[1]/b[0]));
        int totalQuality=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->Integer.compare(b[0], a[0]));
        for(int i=0; i<l; i++) {
            int[] worker=workers.get(i);
            totalQuality+=worker[0];
            pq.offer(worker);
            if(pq.size()==K) {
                result=Math.min(result, (double)worker[1]*totalQuality/worker[0]);
                totalQuality-=pq.poll()[0];
            }
        }
        return result;
    }
}
