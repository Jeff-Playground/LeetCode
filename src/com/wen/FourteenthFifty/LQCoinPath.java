package com.wen.FourteenthFifty;

/*
You are given an integer array coins (1-indexed) of length n and an integer maxJump. You can jump to any index i of the
array coins if coins[i]!=-1 and you have to pay coins[i] when you visit index i. In addition to that, if you are
currently at index i, you can only jump to any index i + k where i + k <= n and k is a value in the range [1, maxJump].

You are initially positioned at index 1 (coins[1] is not -1). You want to find the path that reaches index n with the
minimum cost.

Return an integer array of the indices that you will visit in order so that you can reach index n with the minimum cost.
If there are multiple paths with the same cost, return the lexicographically smallest such path. If it is not possible
to reach index n, return an empty array.

A path p1 = [Pa1, Pa2, ..., Pax] of length x is lexicographically smaller than p2 = [Pb1, Pb2, ..., Pbx] of length y, if
and only if at the first j where Paj and Pbj differ, Paj < Pbj; when no such j exists, then x < y.



Example 1:
Input: coins = [1,2,4,-1,2], maxJump = 2
Output: [1,3,5]


Example 2:
Input: coins = [1,2,4,-1,2], maxJump = 1
Output: []


Constraints:
1 <= coins.length <= 1000
-1 <= coins[i] <= 100
coins[1] != -1
1 <= maxJump <= 100
 */

import java.util.*;

public class LQCoinPath {
    // DP, dp[i] stands for the minimum cost to get to i, use a Map to store the corresponding path
    public List<Integer> cheapestJump(int[] coins, int maxJump) {
        int l=coins.length;
        int[] dp=new int[l+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Map<Integer, List<Integer>> path=new HashMap<>();
        path.put(1, Arrays.asList(1));
        dp[1]=coins[0];
        for(int i=1; i<l; i++){
            if(dp[i]!=-1 && dp[i]<Integer.MAX_VALUE){
                for(int j=1; j<=maxJump && i+j<l+1; j++){
                    if(coins[i+j-1]!=-1){
                        if(dp[i+j]>dp[i]+coins[i+j-1]){
                            dp[i+j]=dp[i]+coins[i+j-1];
                            path.put(i+j, new ArrayList<>(path.get(i)));
                            path.get(i+j).add(i+j);
                        } else if(dp[i+j]==dp[i]+coins[i+j-1]){
                            List<Integer> cur=new ArrayList<>(path.get(i));
                            cur.add(i+j);
                            path.put(i+j, getSmaller(path.get(i+j), cur));
                        }
                    } else{
                        dp[i+j]=-1;
                    }
                }
            }
        }
        return (dp[l]!=-1 && dp[l]<Integer.MAX_VALUE)?path.get(l):new ArrayList<>();
    }

    private List<Integer> getSmaller(List<Integer> l1, List<Integer> l2){
        for(int i=0; i<l1.size() && i<l2.size(); i++){
            int x1=l1.get(i), x2=l2.get(i);
            if(x1<x2){
                return l1;
            } else if(x1>x2){
                return l2;
            }
        }
        return l1.size()<l2.size()?l1:l2;
    }
}
