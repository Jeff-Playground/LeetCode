package com.wen.TwelfthFifty;

/*

Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical,
diagonal or anti-diagonal.

Example:

Input:
[[0,1,1,0],
 [0,1,1,0],
 [0,0,0,1]]
Output: 3


Hint: The number of elements in the given matrix will not exceed 10,000.

 */

public class LQLongestLineOfConsecutiveOneInMatrix {
    // DP
    public int longestLine(int[][] M) {
        if(M==null || M.length==0 || M[0].length==0){
            return 0;
        }
        int m=M.length, n=M[0].length;
        String[][] length=new String[m][n];
        int result=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(M[i][j]==1){
                    if(i>0 && length[i-1][j]!=null){
                        int last=Integer.valueOf(length[i-1][j].split(" ")[0]);
                        length[i][j]=String.valueOf(last+1)+" ";
                        result=Math.max(result, last+1);
                    } else{
                        length[i][j]="1 ";
                        result=Math.max(result, 1);
                    }
                    if(j>0 && length[i][j-1]!=null){
                        int last=Integer.valueOf(length[i][j-1].split(" ")[1]);
                        length[i][j]+=String.valueOf(last+1)+" ";
                        result=Math.max(result, last+1);
                    } else{
                        length[i][j]+="1 ";
                    }
                    if(i>0 && j>0 && length[i-1][j-1]!=null){
                        int last=Integer.valueOf(length[i-1][j-1].split(" ")[2]);
                        length[i][j]+=String.valueOf(last+1)+" ";
                        result=Math.max(result, last+1);
                    } else{
                        length[i][j]+="1 ";
                    }
                    if(i>0 && j+1<n && length[i-1][j+1]!=null){
                        int last=Integer.valueOf(length[i-1][j+1].split(" ")[3]);
                        length[i][j]+=String.valueOf(last+1);
                        result=Math.max(result, last+1);
                    } else{
                        length[i][j]+="1";
                    }
                }
            }
        }
        return result;
    }

//    // DFS without cache array
//    public int longestLine(int[][] M) {
//        if(M==null || M.length==0 || M[0].length==0){
//            return 0;
//        }
//        int m=M.length, n=M[0].length;
//        int[][] dirs=new int[][]{{-1, 0}, {0, -1}, {-1, -1}, {-1, 1}};
//        int result=0;
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(M[i][j]==1){
//                    for(int[] dir: dirs){
//                        int x=i+dir[0], y=j+dir[1];
//                        int cur=1;
//                        while(x>=0 && y>=0 && y<n && M[x][y]==1){
//                            cur++;
//                            x+=dir[0];
//                            y+=dir[1];
//                        }
//                        result=Math.max(result, cur);
//                    }
//                }
//            }
//        }
//        return result;
//    }
}
