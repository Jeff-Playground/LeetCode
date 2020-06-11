package com.wen.SeventhFifty;

/*
An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are
connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location
(x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black
pixels.

Example:

Input:
[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2

Output: 6
 */

public class LQSmallestRectangleEnclosingBlackPixels {
    // Binary search
    public static int minArea(char[][] image, int x, int y) {
        int m=image.length, n=image[0].length;
        int xMin=findLimit(image, 0, x, true, false);
        int xMax=findLimit(image, x+1, m, true, true);
        int yMin=findLimit(image, 0, y, false, false);
        int yMax=findLimit(image, y+1, n, false, true);
        return (xMax-xMin)*(yMax-yMin);
    }

    private static int findLimit(char[][] image, int start, int end, boolean isRow, boolean isMax){
        if(start>=end){
            return start;
        } else{
            int mid=start+(end-start)/2;
            boolean hasOne=false;
            int max=isRow?image[0].length:image.length;
            for(int i=0; i<max; i++){
                char c=isRow?image[mid][i]:image[i][mid];
                if(c=='1'){
                    hasOne=true;
                    break;
                }
            }
            if(hasOne){
                if(isMax){
                    return findLimit(image, mid+1, end, isRow, isMax);
                } else{
                    return findLimit(image, start, mid, isRow, isMax);
                }
            } else{
                if(isMax){
                    return findLimit(image, start, mid, isRow, isMax);
                } else{
                    return findLimit(image, mid+1, end, isRow, isMax);
                }
            }
        }
    }

//    // DFS, will TLE
//    public int minArea(char[][] image, int x, int y) {
//        int m=image.length, n=image[0].length;
//        int[][] visited=new int[m][n];
//        int[] result=new int[4];
//        result[0]=x;
//        result[1]=x;
//        result[2]=y;
//        result[3]=y;
//        maHelper(image, x, y, visited, result);
//        return (result[1]-result[0]+1)*(result[3]-result[2]+1);
//    }
//
//    private void maHelper(char[][] image, int x, int y, int[][] visited, int[] result){
//        int m=image.length, n=image[0].length;
//        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
//        visited[x][y]=1;
//        result[0]=Math.min(result[0], x);
//        result[1]=Math.max(result[1], x);
//        result[2]=Math.min(result[2], y);
//        result[3]=Math.max(result[3], y);
//        for(int[] dir: dirs){
//            int newX=x+dir[0], newY=y+dir[1];
//            if(newX>=0 && newX<m && newY>=0 && newY<n && image[newX][newY]=='1' && visited[newX][newY]==0){
//                maHelper(image, newX, newY, visited, result);
//            }
//        }
//    }
}
