package com.wen.ThirteenthFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] count=new int[26];
        for(char task: tasks){
            count[task-'A']++;
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->(b[1]==a[1]?a[0]-b[0]:b[1]-a[1]));
        for(int i=0; i<26; i++){
            if(count[i]>0){
                pq.offer(new int[]{i, count[i]});
            }
        }
        int total=0;
        while(!pq.isEmpty()){
            List<int[]> cur=new ArrayList<>();
            int curCount=0;
            for(int i=1; i<=n+1; i++){
                cur.add(pq.poll());
                curCount++;
                if(pq.isEmpty()){
                    break;
                }
            }
            for(int[] t: cur){
                if(--t[1]>0){
                    pq.offer(t);
                }
            }
            total+=pq.isEmpty()?curCount:n+1;
        }
        return total;
    }

//    public int leastInterval(char[] tasks, int n) {
//        int[] count=new int[26];
//        int total=tasks.length;
//        for(char task: tasks){
//            count[task-'A']++;
//        }
//        Arrays.sort(count);
//        int maxCount=count[25];
//        int maxNum=0;
//        for(int i=25; i>=0; i--){
//            if(count[i]==maxCount){
//                maxNum++;
//            } else{
//                break;
//            }
//        }
//        if(maxNum<=n+1){
//            return Math.max(total, (n+1)*(maxCount-1)+maxNum);
//        } else{
//            return total;
//        }
//    }
}
