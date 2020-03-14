package com.wen.TwentiethFifty;

import java.util.*;

public class PrisonCellsAfterNDays {
    public static int[] prisonAfterNDays(int[] cells, int N) {
        List<int[]> visited=new ArrayList<>();
        for(int i=1; i<=N; i++){
            int[] next=new int[8];
            for(int j=1; j<7; j++){
                next[j]=cells[j-1]^cells[j+1]^1;
            }
            if(visited.size()>0 && Arrays.equals(visited.get(0), next)){
                break;
            }
            visited.add(next);
            cells=next.clone();
        }
        int actual=N%visited.size()==0?visited.size()-1:N%visited.size()-1;
        return visited.get(actual);
    }
}
