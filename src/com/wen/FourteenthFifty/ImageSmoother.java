package com.wen.FourteenthFifty;

public class ImageSmoother {
    // in-place
    public int[][] imageSmoother(int[][] M) {
        if(M==null || (M.length<2 && M[0].length<2)){
            return M;
        }
        int m=M.length, n=M[0].length;
        int[][] changes=new int[][]{{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int value=M[i][j]%256;
                int count=1;
                for(int[] change: changes){
                    int x=i+change[0];
                    int y=j+change[1];
                    if(x<0 || x>=m || y<0 || y>=n){
                        continue;
                    } else{
                        value+=M[x][y]%256;
                        count++;
                    }
                }
                M[i][j]+=value/count*256;
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                M[i][j]/=256;
            }
        }
        return M;
    }
}
