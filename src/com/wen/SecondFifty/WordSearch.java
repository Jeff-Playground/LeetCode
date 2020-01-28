package com.wen.SecondFifty;

public class WordSearch {
    // DFS without visited
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || board[0].length==0){
            return false;
        }
        int m=board.length, n=board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(existDFS(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existDFS(char[][] board, String word, int idx, int i, int j) {
        if(idx==word.length()){
            return true;
        }
        int m=board.length, n=board[0].length;
        if(i<0 || j<0 || i>=m || j>=n || board[i][j]!=word.charAt(idx)){
            return false;
        }
        boolean result=false;
        char temp=board[i][j];
        board[i][j]='#';
        result=existDFS(board, word, idx+1, i-1, j) ||
                    existDFS(board, word, idx+1, i, j-1) ||
                    existDFS(board, word, idx+1, i+1, j) ||
                    existDFS(board, word, idx+1, i, j+1);
        board[i][j]=temp;
        return result;
    }

//    // DFS
//    public boolean exist(char[][] board, String word) {
//        if(board==null || board.length==0 || board[0].length==0){
//            return false;
//        }
//        int m=board.length, n=board[0].length;
//        boolean[][] visited= new boolean[m][n];
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(existDFS(board, word, 0, i, j, visited)){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private boolean existDFS(char[][] board, String word, int idx, int i, int j, boolean[][] visited) {
//        if(idx==word.length()){
//            return true;
//        }
//        int m=board.length, n=board[0].length;
//        if(i<0 || j<0 || i>=m || j>=n || visited[i][j] || board[i][j]!=word.charAt(idx)){
//            return false;
//        }
//        visited[i][j]=true;
//        boolean result=existDFS(board, word, idx+1, i-1, j, visited) ||
//                existDFS(board, word, idx+1, i+1, j, visited) ||
//                existDFS(board, word, idx+1, i, j-1, visited) ||
//                existDFS(board, word, idx+1, i, j+1, visited);
//        visited[i][j]=false;
//        return result;
//    }
}
