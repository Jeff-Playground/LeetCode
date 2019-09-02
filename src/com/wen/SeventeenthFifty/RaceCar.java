package com.wen.SeventeenthFifty;

import java.util.*;

public class RaceCar {
    // Recursive dp
    public int racecar(int target) {
        int[] dp=new int[target+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        return racecarHelper(dp, target);
    }

    private int racecarHelper(int[] dp, int t) {
        if(dp[t]<Integer.MAX_VALUE){
            return dp[t];
        }
        int n=32-Integer.numberOfLeadingZeros(t);
        if(t==(1<<n)-1){
            dp[t]=n;
        } else{
            for(int j=0; j<n-1; j++){
                // (n-1) ops reach the first point before target, then reverse(1) and j ops, then reverse again travel k distance and reach t
                // t==1<<((n-1))-1)-((1<<j)-1)+dp[k]
                dp[t]=Math.min(dp[t], n-1+2+j+racecarHelper(dp, t-(1<<(n-1))+(1<<j)));
            }
            if((1<<n)-1-t<t){
                // n ops reach the first point beyond target, then reverse(1) and travel distance k distance
                // t==(1<<n)-1-k
                dp[t]=Math.min(dp[t], n+1+racecarHelper(dp, (1<<n)-1-t));
            }
        }
        return dp[t];
    }

//    // Iterative dp
//    public int racecar(int target) {
//        int[] dp=new int[target+1];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0]=0;
//        for(int t=1; t<=target; t++){
//            int n=32-Integer.numberOfLeadingZeros(t);
//            if(t==(1<<n)-1){
//                dp[t]=n;
//                continue;
//            }
//            for(int j=0; j<n-1; j++){
//                dp[t]=Math.min(dp[t], n-1+2+j+dp[t-(1<<(n-1))+(1<<j)]);
//            }
//            if((1<<n)-1-t<t){
//                dp[t]=Math.min(dp[t], n+1+dp[(1<<n)-1-t]);
//            }
//        }
//        return dp[target];
//    }

//    // BFS
//    public int racecar(int target) {
//        int result=0;
//        Queue<int[]> q=new LinkedList<>();
//        Set<String> visited=new HashSet<>();
//        q.offer(new int[]{0,1});
//        visited.add("0,1");
//        while(!q.isEmpty()){
//            int size=q.size();
//            while(size-->0){
//                int[] cur=q.poll();
//                int pos=cur[0], speed=cur[1];
//                if(pos==target){
//                    return result;
//                }
//                // Note the pruning condition: newPos>0 && newPos<target*2
//                // Keep going in same direction
//                int newPos=pos+speed, newSpeed=speed*2;
//                String newKey=newPos+","+newSpeed;
//                if(!visited.contains(newKey) && newPos>0 && newPos<target*2){
//                    visited.add(newKey);
//                    q.offer(new int[]{newPos, newSpeed});
//                }
//                // Reverse
//                newPos=pos;
//                newSpeed=speed>0?-1:1;
//                newKey=newPos+","+newSpeed;
//                if(!visited.contains(newKey) && newPos>0 && newPos<target*2){
//                    visited.add(newKey);
//                    q.offer(new int[]{newPos, newSpeed});
//                }
//            }
//            result++;
//        }
//        return -1;
//    }
}
