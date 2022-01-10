package com.wen.ThirteenthFifty;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BulbSwitcherII {
    public static int flipLights(int n, int presses) {
        int l=n%6+(n>=6?6:0);
        int flag=0xfff00000<<(12-l);
        int init=flag;
        Queue<Integer> q=new LinkedList<>();
        q.offer(init);
        for(int i=1; i<=presses; i++){
            int size=q.size();
            Set<Integer> visited=new HashSet<>();
            for(int j=0; j<size; j++){
                int last=q.poll()&flag;
                if(!visited.contains(last)){
                    visited.add(last);
                    for(int k=1; k<=4; k++){
                        if(k==1){
                            q.offer(pressButton1(last));
                        } else if(k==2){
                            q.offer(pressButton2(last));
                        } else if(k==3){
                            q.offer(pressButton3(last));
                        } else{
                            q.offer(pressButton4(last));
                        }
                    }
                }
            }
        }
        Set<Integer> set=new HashSet<>();
        while(!q.isEmpty()){
            set.add(q.poll()&flag);
        }
        return set.size();
    }

    private static int pressButton1(int lights){
        int action=0xfff00000;
        return lights^action;
    }

    private static int pressButton2(int lights){
        int action=0x55500000;
        return lights^action;
    }

    private static int pressButton3(int lights){
        int action=0xaaa00000;
        return lights^action;
    }

    private static int pressButton4(int lights){
        int action=0x92400000;
        return lights^action;
    }
}
