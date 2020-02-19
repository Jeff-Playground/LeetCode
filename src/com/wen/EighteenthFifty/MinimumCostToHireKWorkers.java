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
        // Sort workers by wage/quality increasing ly(better workers first)
        Collections.sort(workers, (a, b)->Double.compare((double)a[1]/a[0], (double)b[1]/b[0]));
        int totalQuality=0;
        // Pop out the workers with highest quality(the ones need to be paid more when paid by ratio according to quality)
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->Integer.compare(b[0], a[0]));
        for(int i=0; i<l; i++) {
            int[] worker=workers.get(i);
            totalQuality+=worker[0];
            pq.offer(worker);
            if(pq.size()==K) {
                // Pay by the last worker because it's the most expensive one per quality, and the previous workers
                // can't make less than him
                result=Math.min(result, (double)totalQuality*worker[1]/worker[0]);
                totalQuality-=pq.poll()[0];
            }
        }
        return result;
    }
}
