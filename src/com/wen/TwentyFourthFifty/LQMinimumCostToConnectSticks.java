package com.wen.TwentyFourthFifty;

/*
You have some sticks with positive integer lengths.

You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.  You perform this action until
there is one stick remaining.

Return the minimum cost of connecting all the given sticks into one stick in this way.

Example 1:
Input: sticks = [2,4,3]
Output: 14

Example 2:
Input: sticks = [1,8,3,5]
Output: 30

Constraints:
1 <= sticks.length <= 10^4
1 <= sticks[i] <= 10^4
 */

import java.util.PriorityQueue;

public class LQMinimumCostToConnectSticks {
    // Min heap and greedy
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int result=0;
        for(int stick: sticks){
            pq.offer(stick);
        }
        while(pq.size()>1){
            int first=pq.poll(), second=pq.poll();
            int cost=first+second;
            result+=cost;
            pq.offer(cost);
        }
        return result;
    }
}
