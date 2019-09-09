package com.wen.SixteenthFifty;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
    // BFS
    public int slidingPuzzle(int[][] board) {
        int result=0;
        int m=board.length, n=board[0].length;
        String goal="", start="";
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                start+=(char)(board[i][j]+'0');
                // Final goal starts with 1 and ends with 0
                goal+=(char)((i*n+j+1)%(m*n)+'0');
            }
        }
        if(start.equals(goal)) {
            return result;
        }
        Set<String> tried=new HashSet<>();
        tried.add(start);
        int[][] dirs=new int[][] {{-1, 0}, {1,0}, {0, -1}, {0, 1}};
        Queue<String> q=new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()) {
            result++;
            int size=q.size();
            for(int i=0; i<size; i++) {
                String cur=q.poll();
                int pos=cur.indexOf('0');
                int x=pos/n, y=pos%n;
                for(int[] dir: dirs) {
                    if(x+dir[0]>=0 && x+dir[0]<m && y+dir[1]>=0 && y+dir[1]<n) {
                        char[] curChars=cur.toCharArray();
                        int idx=(x+dir[0])*n+y+dir[1];
                        curChars[pos]=curChars[idx];
                        curChars[idx]='0';
                        String swapped=new String(curChars);
                        if(tried.contains(swapped)) {
                            continue;
                        } else {
                            tried.add(swapped);
                        }
                        if(swapped.equals(goal)) {
                            return result;
                        } else {
                            q.offer(swapped);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
