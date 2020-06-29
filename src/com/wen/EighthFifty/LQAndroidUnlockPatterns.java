package com.wen.EighthFifty;

/*
Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock
patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

Rules for a valid pattern:

Each pattern must connect at least m keys and at most n keys.
All the keys must be distinct.
If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have
previously selected in the pattern. No jumps through non selected key is allowed.
The order of keys used matters.


Explanation:

| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
Invalid move: 4 - 1 - 3 - 6
Line 1 - 3 passes through key 2 which had not been selected in the pattern.

Invalid move: 4 - 1 - 9 - 2
Line 1 - 9 passes through key 5 which had not been selected in the pattern.

Valid move: 2 - 4 - 1 - 3 - 6
Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

Valid move: 6 - 5 - 4 - 1 - 9 - 2
Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.


Example1:
Input: m = 1, n = 1
Output: 9

Example2:
Input: m = 1, n = 2
Output: 65
 */

public class LQAndroidUnlockPatterns {
//    // DFS1
//    public static int numberOfPatterns(int m, int n) {
//        int[][] jump=new int[10][10];
//        jump[1][3]=jump[3][1]=2;
//        jump[4][6]=jump[6][4]=5;
//        jump[7][9]=jump[9][7]=8;
//        jump[1][7]=jump[7][1]=4;
//        jump[2][8]=jump[8][2]=5;
//        jump[3][9]=jump[9][3]=6;
//        jump[1][9]=jump[9][1]=jump[3][7]=jump[7][3]=5;
//        int[] visited=new int[10];
//        int result=0;
//        int[] cache=new int[]{0};
//        nopHelper(1, 1, m, n, visited, jump, cache);
//        result+=cache[0]*4;
//        cache[0]=0;
//        nopHelper(2, 1, m, n, visited, jump, cache);
//        result+=cache[0]*4;
//        cache[0]=0;
//        nopHelper(5, 1, m, n, visited, jump, cache);
//        result+=cache[0];
//        return result;
//    }
//
//    private static void nopHelper(int cur, int curLength, int min, int max, int[] visited, int[][] jump, int[] cache){
//        if(curLength>=min){
//            cache[0]++;
//        }
//        if(++curLength>max){
//            return;
//        }
//        visited[cur]=1;
//        for(int i=1; i<=9; i++){
//            if(visited[i]==0 && (jump[cur][i]==0 || visited[jump[cur][i]]==1)){
//                nopHelper(i, curLength, min, max, visited, jump, cache);
//            }
//        }
//        visited[cur]=0;
//    }

//    // DFS1, note curCount is used to simplify the usage like cache above
//    public int numberOfPatterns(int m, int n) {
//        int[][] jump=new int[10][10];
//        jump[1][3]=jump[3][1]=2;
//        jump[4][6]=jump[6][4]=5;
//        jump[7][9]=jump[9][7]=8;
//        jump[1][7]=jump[7][1]=4;
//        jump[2][8]=jump[8][2]=5;
//        jump[3][9]=jump[9][3]=6;
//        jump[1][9]=jump[9][1]=jump[3][7]=jump[7][3]=5;
//        int[] visited=new int[10];
//        int result=0;
//        result+=nopHelper(1, 1, m, n, visited, jump, 0)*4;
//        result+=nopHelper(2, 1, m, n, visited, jump, 0)*4;
//        result+=nopHelper(5, 1, m, n, visited, jump, 0);
//        return result;
//    }
//
//    private int nopHelper(int cur, int curLength, int min, int max, int[] visited, int[][] jump, int curCount){
//        if(curLength>=min){
//            curCount++;
//        }
//        if(++curLength>max){
//            return curCount;
//        }
//        visited[cur]=1;
//        for(int i=1; i<=9; i++){
//            if(visited[i]==0 && (jump[cur][i]==0 || visited[jump[cur][i]]==1)){
//                curCount=nopHelper(i, curLength, min, max, visited, jump, curCount);
//            }
//        }
//        visited[cur]=0;
//        return curCount;
//    }

//    // DFS2
//    public int numberOfPatterns(int m, int n) {
//        int result=0;
//        result+=4*nopHelper(m, n, 1, 0, 0);
//        result+=4*nopHelper(m, n, 2, 0, 1);
//        result+=nopHelper(m, n, 16, 1, 1);
//        return result;
//    }
//
//    private int nopHelper(int m, int n, int visited, int x, int y){
//        if(n==0){
//            return 0;
//        }
//        int result=0;
//        if(m<=1){
//            result++;
//        }
//        for(int i=0; i<3; i++){
//            for(int j=0; j<3; j++){
//                int newVisited=visited | 1<<(3*i+j);
//                if(newVisited>visited){
//                    int sumX=x+i, sumY=y+j;
//                    if(sumX%2==1 || sumY%2==1 || (visited | (1<<(sumX/2*3+sumY/2)))==visited){
//                        result+=nopHelper(m-1, n-1, newVisited, i, j);
//                    }
//                }
//            }
//        }
//        return result;
//    }

    // DFS2, note start from (1,1) with visited==0, also use newVisited to determine whether next node is reachable to
    // include (1,1) in the first move
    public int numberOfPatterns(int m, int n) {
        return nopHelper(m, n, 0, 1, 1);
    }

    private int nopHelper(int m, int n, int visited, int x, int y){
        int result=m<=0?1:0;
        if(n==0){
            return result;
        }
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                int newVisited=visited | 1<<(3*i+j);
                if(newVisited>visited){
                    int sumX=x+i, sumY=y+j;
                    if(sumX%2==1 || sumY%2==1 || (newVisited | (1<<(sumX/2*3+sumY/2)))==newVisited){
                        result+=nopHelper(m-1, n-1, newVisited, i, j);
                    }
                }
            }
        }
        return result;
    }
}
