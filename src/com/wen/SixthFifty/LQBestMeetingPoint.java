package com.wen.SixthFifty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LQBestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        int result=0;
        int m=grid.length, n=grid[0].length;
        List<Integer> rows=new ArrayList<>();
        List<Integer> columns=new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        Collections.sort(rows);
        Collections.sort(columns);
        int left=0, right=rows.size()-1;
        while(left<right){
            result+=rows.get(right)-rows.get(left)+columns.get(right--)-columns.get(left++);
        }
        return result;
    }
}
