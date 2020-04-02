package com.wen.TwentySeventhFifty;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        int l=arr.length;
        Set<Integer> visited=new HashSet<>();
        visited.add(start);
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int cur=q.poll();
            if(arr[cur]==0){
                return true;
            }
            int i1=cur+arr[cur], i2=cur-arr[cur];
            if(i1>=0 && i1<l && !visited.contains(i1)){
                q.offer(i1);
                visited.add(i1);
            }
            if(i2>=0 && i2<l && !visited.contains(i2)){
                q.offer(i2);
                visited.add(i2);
            }
        }
        return false;
    }
}
