package com.wen.FifteenthFifty;

import java.util.ArrayList;
import java.util.List;

public class LQNumberOfCornerRectangles {
    // For any two rows, find the number of vertical lines, and the total for these two row would be count*(count-1)/2

    public static int countCornerRectangles(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }
        int m=grid.length, n=grid[0].length;
        int result=0;
        for(int i=0; i<m-1; i++){
            for(int j=i+1; j<m; j++){
                int count=0;
                for(int k=0; k<n; k++){
                    if(grid[i][k]==1 && grid[j][k]==1){
                        count++;
                    }
                }
                result+=count*(count-1)/2;
            }
        }
        return result;
    }

//    public int countCornerRectangles(int[][] grid) {
//        if(grid==null || grid.length==0 || grid[0].length==0){
//            return 0;
//        }
//        int m=grid.length, n=grid[0].length;
//        int result=0;
//        for(int i=0; i<m-1; i++){
//            List<Integer> ones=new ArrayList<>();
//            for(int k=0; k<n; k++){
//                if(grid[i][k]==1){
//                    ones.add(k);
//                }
//            }
//            for(int j=i+1; j<m; j++){
//                int count=0;
//                for(int k: ones){
//                    if(grid[j][k]==1){
//                        count++;
//                    }
//                }
//                result+=count*(count-1)/2;
//            }
//        }
//        return result;
//    }
}
