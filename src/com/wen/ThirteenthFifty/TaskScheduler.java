package com.wen.ThirteenthFifty;

import java.util.Arrays;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] count=new int[26];
        int total=tasks.length;
        for(char task: tasks){
            count[task-'A']++;
        }
        Arrays.sort(count);
        int max=count[25];
        int maxCount=0;
        for(int i=25; i>=0; i--){
            if(count[i]==max){
                maxCount++;
            } else{
                break;
            }
        }
        if(maxCount>=n+1){
            return total;
        } else{
            return Math.max(total, (max-1)*(n+1)+maxCount);
        }
    }
}
