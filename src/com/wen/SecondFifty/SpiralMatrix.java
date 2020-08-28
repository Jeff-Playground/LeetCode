package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<>();
        if(matrix==null || matrix.length==0){
            return result;
        }
        int up=0, down=matrix.length-1, left=0, right=matrix[0].length-1;
        while(up<=down && left<=right){
            for(int i=left; i<=right; i++){
                result.add(matrix[up][i]);
            }
            up++;
            if(up>down){
                break;
            }
            for(int i=up; i<=down; i++){
                result.add(matrix[i][right]);
            }
            right--;
            if(left>right){
                break;
            }
            for(int i=right; i>=left; i--){
                result.add(matrix[down][i]);
            }
            down--;
            if(up>down){
                break;
            }
            for(int i=down; i>=up; i--){
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}
