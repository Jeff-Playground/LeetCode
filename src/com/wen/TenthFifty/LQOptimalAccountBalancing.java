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
//    // DFS with back trackinng
//    public int minTransfers(int[][] transactions) {
//        Map<Integer,Integer> accounts=new HashMap<>();
//        for(int[] t: transactions){
//            accounts.put(t[0], accounts.getOrDefault(t[0],0)-t[2]);
//            accounts.put(t[1], accounts.getOrDefault(t[1],0)+t[2]);
//        }
//        List<Integer> balance=new ArrayList<>();
//        for(int k: accounts.keySet()){
//            if(accounts.get(k)!=0){
//                balance.add(accounts.get(k));
//            }
//        }
//        int[] result=new int[]{Integer.MAX_VALUE};
//        mtHelper(balance, 0, 0, result);
//        return result[0];
//    }
//
//    private void mtHelper(List<Integer> balance, int idx, int count, int[] result){
//        int l=balance.size();
//        while(idx<l && balance.get(idx)==0){
//            idx++;
//        }
//        if(idx==l){
//            result[0]=Math.min(count, result[0]);
//        } else{
//            for(int i=idx+1; i<l; i++){
//                if((balance.get(idx)>0 && balance.get(i)<0) || (balance.get(idx)<0) && balance.get(i)>0){
//                    balance.set(i, balance.get(i)+balance.get(idx));
//                    mtHelper(balance, idx+1, count+1, result);
//                    balance.set(i, balance.get(i)-balance.get(idx));
//                }
//            }
//        }
//    }

    // Shuffle 100000 times to make result closer to optimal solution
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> accounts=new HashMap<>();
        for(int[] t: transactions){
            accounts.put(t[0], accounts.getOrDefault(t[0], 0)-t[2]);
            accounts.put(t[1], accounts.getOrDefault(t[1], 0)+t[2]);
        }
        List<Integer> pos=new ArrayList<>(), neg=new ArrayList<>();
        for(int k: accounts.keySet()){
            if(accounts.get(k)<0){
                neg.add(-accounts.get(k));
            } else if(accounts.get(k)>0){
                pos.add(accounts.get(k));
            }
        }
        int result=Integer.MAX_VALUE;
        Stack<Integer> p=new Stack<>(), n=new Stack<>();
        for(int i=1; i<=1000; i++){
            for(int e: pos){
                p.push(e);
            }
            for(int e: neg){
                n.push(e);
            }
            int count=0;
            while(!p.isEmpty()){
                int pv=p.pop(), nv=n.pop();
                if(pv<nv){
                    n.push(nv-pv);
                } else if(pv>nv){
                    p.push(pv-nv);
                }
                count++;
            }
            result=Math.min(result, count);
            Collections.shuffle(pos);
            Collections.shuffle(neg);
        }
        return result;
    }
}
