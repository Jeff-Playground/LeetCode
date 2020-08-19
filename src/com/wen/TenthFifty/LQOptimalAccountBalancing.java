package com.wen.TenthFifty;

/*
A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for 10.
Then later Chris Gave Alice 5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x
gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the
transactions can be represented as [[0, 1, 10], [2, 0, 5]].

Given a list of transactions between a group of people, return the minimum number of transactions required to settle the
debt.

Note:

A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.


Example 1:

Input:
[[0,1,10], [2,0,5]]

Output:
2

Explanation:
Person #0 gave person #1 $10.
Person #2 gave person #0 $5.

Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.


Example 2:

Input:
[[0,1,10], [1,0,1], [1,2,5], [2,0,5]]

Output:
1

Explanation:
Person #0 gave person #1 $10.
Person #1 gave person #0 $1.
Person #1 gave person #2 $5.
Person #2 gave person #0 $5.

Therefore, person #1 only need to give person #0 $4, and all debt is settled.
 */

import java.util.*;

public class LQOptimalAccountBalancing {
    // DFS with backtrackinng, will TLE in lintcode
    public static int balanceGraph(int[][] edges) {
        int result=0;
        Map<Integer, Integer> graph=new HashMap<>();
        for(int[] edge: edges){
            int x=edge[0], y=edge[1], v=edge[2];
            graph.put(x, graph.getOrDefault(x, 0)+v);
            graph.put(y, graph.getOrDefault(y, 0)-v);
        }
        List<Integer> balance=new ArrayList<>();
        for(int key: graph.keySet()){
            if(graph.get(key)!=0){
                balance.add(graph.get(key));
            }
        }
        int[] cache=new int[]{Integer.MAX_VALUE};
        bgHelper(balance, 0, 0, cache);
        return result+cache[0];
    }

    private static void bgHelper(List<Integer> bal, int idx, int cur, int[] cache){
        int l=bal.size();
        while(idx<l && bal.get(idx)==0){
            idx++;
        }
        if(idx==l){
            cache[0]=Math.min(cache[0], cur);
        } else{
            for(int i=idx+1; i<l; i++){
                if((bal.get(i)<0 && bal.get(idx)>0) || (bal.get(i)>0 && bal.get(idx)<0)){
                    bal.set(i, bal.get(i)+bal.get(idx));
                    bgHelper(bal, idx+1, cur+1, cache);
                    bal.set(i, bal.get(i)-bal.get(idx));
                }
            }
        }
    }

//    // Shuffle 100000 times to make result closer to optimal solution
//    public int balanceGraph(int[][] edges) {
//        Map<Integer, Integer> graph = new HashMap<>();
//        for(int[] tran: edges) {
//            graph.put(tran[0], graph.getOrDefault(tran[0], 0) - tran[2]);
//            graph.put(tran[1], graph.getOrDefault(tran[1], 0) + tran[2]);
//        }
//        List<Integer> poss = new ArrayList<>();
//        List<Integer> negs = new ArrayList<>();
//        for(Map.Entry<Integer, Integer> balance : graph.entrySet()) {
//            int val = balance.getValue();
//            if (val > 0) poss.add(val);
//            else if (val < 0) negs.add(-val);
//        }
//        int min = Integer.MAX_VALUE;
//        Stack<Integer> ps = new Stack<>();
//        Stack<Integer> ns = new Stack<>();
//        for(int i = 0; i < 100000; i++) {
//            for(int pos: poss) {
//                ps.push(pos);
//            }
//            for(int neg: negs) {
//                ns.push(neg);
//            }
//            int count = 0;
//            while (!ps.isEmpty()) {
//                int p = ps.pop();
//                int n = ns.pop();
//                if (p > n) {
//                    ps.push(p - n);
//                } else if (p < n) {
//                    ns.push(n - p);
//                }
//                count++;
//            }
//            min = Math.min(min, count);
//            Collections.shuffle(poss);
//            Collections.shuffle(negs);
//        }
//        return min;
//    }
}
