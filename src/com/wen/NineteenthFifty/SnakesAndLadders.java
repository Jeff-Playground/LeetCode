package com.wen.NineteenthFifty;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakesAndLadders {
    public static int snakesAndLadders(int[][] board) {
        int l=board.length;
        Queue<Integer> q=new LinkedList<>();
        q.offer(1);
        Set<Integer> visited=new HashSet<>();
        visited.add(1);
        int step=0;
        while(!q.isEmpty()){
            int size=q.size();
            step++;
            while(size-->0){
                int cur=q.poll();
                for(int i=1; i<=6 && cur+i<=l*l; i++){
                    int next=cur+i;
                    int[] cor=getCoordinates(next, l);
                    int x=cor[0], y=cor[1];
                    if(board[x][y]!=-1){
                        next=board[x][y];
                    }
                    if(next==l*l){
                        return step;
                    }
                    if(!visited.contains(next)){
                        visited.add(next);
                        q.offer(next);
                    }
                }
            }
        }
        return -1;
    }

    private static int[] getCoordinates(int l, int num){
        int row=l-1-(num-1)/l;
        int col=(num-1)%l;
        // The last row' col is always increasing
        if((l-1-row)%2==0){
            return new int[]{row, col};
        } else{
            return new int[]{row, l-1-col};
        }
    }
}
