package com.wen.TenthFifty;

import java.util.*;

public class LQOptimalAccountBalancing {
    // Shuffle 100000 times to make result closer to optimal solution
    public int balanceGraph(int[][] edges) {
        Map<Integer, Integer> graph = new HashMap<>();
        for(int[] tran: edges) {
            graph.put(tran[0], graph.getOrDefault(tran[0], 0) - tran[2]);
            graph.put(tran[1], graph.getOrDefault(tran[1], 0) + tran[2]);
        }
        List<Integer> poss = new ArrayList<>();
        List<Integer> negs = new ArrayList<>();
        for(Map.Entry<Integer, Integer> balance : graph.entrySet()) {
            int val = balance.getValue();
            if (val > 0) poss.add(val);
            else if (val < 0) negs.add(-val);
        }
        int min = Integer.MAX_VALUE;
        Stack<Integer> ps = new Stack<>();
        Stack<Integer> ns = new Stack<>();
        for(int i = 0; i < 100000; i++) {
            for(int pos: poss) {
                ps.push(pos);
            }
            for(int neg: negs) {
                ns.push(neg);
            }
            int count = 0;
            while (!ps.isEmpty()) {
                int p = ps.pop();
                int n = ns.pop();
                if (p > n) {
                    ps.push(p - n);
                } else if (p < n) {
                    ns.push(n - p);
                }
                count++;
            }
            min = Math.min(min, count);
            Collections.shuffle(poss);
            Collections.shuffle(negs);
        }
        return min;
    }
}
