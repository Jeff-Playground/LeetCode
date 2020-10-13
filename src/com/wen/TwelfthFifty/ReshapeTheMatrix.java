package com.wen.TwelfthFifty;

public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m=nums.length, n=nums[0].length;
        if(m*n!=r*c){
            return nums;
        } else{
            int[][] result=new int[r][c];
            for(int i=0; i<m*n; i++){
                result[i/c][i%c]=nums[i/n][i%n];
            }
            return result;
        }
    }
}
