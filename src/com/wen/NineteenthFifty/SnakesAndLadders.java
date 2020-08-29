package com.wen.NineteenthFifty;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakesAndLadders {
    public static int snakesAndLadders(int[][] board) {
        int l=board.length, result=0;
        Queue<Integer> q=new LinkedList<>();
        q.offer(1);
        Set<Integer> visited=new HashSet<>();
        visited.add(1);
        while(!q.isEmpty()){
            int size=q.size();
            result++;
            while(size-->0){
                int cur=q.poll();
                for(int i=1; i<=6; i++){
                    int next=cur+i;
                    if(next>=l*l){
                        return result;
                    }
                    int[] cd=getCoordinates(l, next);
                    int x=cd[0], y=cd[1];
                    if(board[x][y]==-1 && !visited.contains(next)){
                        q.offer(next);
                        visited.add(next);
                    } else if(board[x][y]!=-1){
                        next=board[x][y];
                        if(next==l*l){
                            return result;
                        }
                        if(!visited.contains(next)){
                            q.offer(next);
                            visited.add(next);
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static int[] getCoordinates(int l, int num){
        int x=l-1-(num-1)/l;
        int dir=x%2==(l-1)%2?1:-1;
        int y=dir==1?(num-1)%l:l-(num-1)%l-1;
        return new int[]{x, y};
    }
}
