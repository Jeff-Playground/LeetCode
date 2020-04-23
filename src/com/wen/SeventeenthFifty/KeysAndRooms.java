package com.wen.SeventeenthFifty;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int N=rooms.size(), count=0;
        int[] roomStatus=new int[N];
        roomStatus[0]=1;
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        while(!q.isEmpty()){
            int cur=q.poll();
            if(roomStatus[cur]==1){
                roomStatus[cur]=-1;
                count++;
                List<Integer> keys=rooms.get(cur);
                for(int key: keys){
                    if(roomStatus[key]==0){
                        roomStatus[key]=1;
                        q.offer(key);
                    }
                }
            }
        }
        return count==N;
    }
}
