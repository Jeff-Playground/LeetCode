package com.wen.EleventhFifty;

/*

Given a picture consisting of black and white pixels, and a positive integer N, find the number of black pixels located
at some specific row R and column C that align with all the following rules:

Row R and column C both contain exactly N black pixels.
For all rows that have a black pixel at column C, they should be exactly the same as row R
The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.

Example:

Input:
[['W', 'B', 'W', 'B', 'B', 'W'],
 ['W', 'B', 'W', 'B', 'B', 'W'],
 ['W', 'B', 'W', 'B', 'B', 'W'],
 ['W', 'W', 'B', 'W', 'B', 'W']]

N = 3
Output: 6
Explanation: All the bold 'B' are the black pixels we need (all 'B's at column 1 and 3).
        0    1    2    3    4    5         column index
0    [['W', 'B', 'W', 'B', 'B', 'W'],
1     ['W', 'B', 'W', 'B', 'B', 'W'],
2     ['W', 'B', 'W', 'B', 'B', 'W'],
3     ['W', 'W', 'B', 'W', 'B', 'W']]
row index

Take 'B' at row R = 0 and column C = 1 as an example:
Rule 1, row R = 0 and column C = 1 both have exactly N = 3 black pixels.
Rule 2, the rows have black pixel at column C = 1 are row 0, row 1 and row 2. They are exactly the same as row R = 0.

Note:
The range of width and height of the input 2D array is [1,200].

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LQLonelyPixelII {
    // Use a Map to group all same rows with N 'B's together, then add for the columns which has N 'B's
    public int findBlackPixel(char[][] picture, int N) {
        int m=picture.length, n=picture[0].length, result=0;
        int[] col=new int[n];
        Map<String, Integer> rowGroup=new HashMap<>();
        for(int i=0; i<m; i++){
            int rowCount=0;
            for(int j=0; j<n; j++){
                if(picture[i][j]=='B'){
                    rowCount++;
                    col[j]++;
                }
            }
            if(rowCount==N){
                String key=new String(picture[i]);
                rowGroup.put(key, rowGroup.getOrDefault(key, 0)+1);
            }
        }
        for(String key: rowGroup.keySet()){
            if(rowGroup.get(key)==N){
                for(int i=0; i<m; i++){
                    if(key.charAt(i)=='B' && col[i]==N){
                        result+=N;
                    }
                }
            }
        }
        return result;
    }

//    public int findBlackPixel(char[][] picture, int N) {
//        int m=picture.length, n=picture[0].length, result=0;
//        int[] row=new int[m], col=new int[n];
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(picture[i][j]=='B'){
//                    row[i]++;
//                    col[j]++;
//                }
//            }
//        }
//        for(int i=0; i<m; i++){
//            if(row[i]==N){
//                for(int j=0; j<n; j++){
//                    if(col[j]==N){
//                        // Use occur to check if the rows same
//                        Map<List<Integer>, Integer> occur=new HashMap<>();
//                        for(int p=0; p<m; p++){
//                            if(picture[p][j]=='B' && row[p]==N){
//                                List<Integer> idx=new ArrayList<>();
//                                for(int q=0; q<n; q++){
//                                    if(picture[p][q]=='B'){
//                                        idx.add(q);
//                                    }
//                                }
//                                occur.put(idx, occur.getOrDefault(idx, 0)+1);
//                            }
//                        }
//                        if(occur.size()==1){
//                            result+=occur.values().iterator().next();
//                        }
//                        col[j]=-1;
//                    }
//                }
//            }
//        }
//        return result;
//    }
}
