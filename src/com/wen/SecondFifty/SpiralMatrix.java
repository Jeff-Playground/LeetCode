package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result=new ArrayList<Integer>();
        if(matrix==null || matrix.length==0){
            return result;
        }
        int firstRow=0, lastRow=matrix.length-1;
        int firstColumn=0, lastColumn=matrix[0].length-1;
        while(firstRow<=lastRow && firstColumn<=lastColumn){
            int i=firstRow, j=firstColumn;
            while(j<=lastColumn){
                result.add(matrix[i][j]);
                j++;
            }
            j=lastColumn;
            i++;
            lastColumn--;
            if(i>lastRow){
                break;
            }
            while(i<=lastRow){
                result.add(matrix[i][j]);
                i++;
            }
            i=lastRow;
            j--;
            lastRow--;
            if(j<firstColumn){
                break;
            }
            while(j>=firstColumn){
                result.add(matrix[i][j]);
                j--;
            }
            j=firstColumn;
            i--;
            firstColumn++;
            if(i<firstRow){
                break;
            }
            while(i>firstRow){
                result.add(matrix[i][j]);
                i--;
            }
            i=firstRow;
            j++;
            firstRow++;
            if(j>lastColumn){
                break;
            }
        }
        return result;
    }
}
