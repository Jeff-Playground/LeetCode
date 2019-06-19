package com.wen.FifthFifty;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    // This can be solved by normal DFS, except for the words list, one additional level of loop need to be added for iteration

    // Trie
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result=new ArrayList<>();
        if(board==null || board.length==0 || board[0]==null || board[0].length==0){
            throw new IllegalArgumentException("Invalid board!");
        }
        if(words==null || words.length==0){
            return result;
        }
        Trie t=new Trie();
        for(String word: words){
            t.add(word);
        }
        int m=board.length, n=board[0].length;
        int[][] visited=new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(t.next[board[i][j]-'a']!=null){
                    findWordsDFS(board, i, j, t.next[board[i][j]-'a'], visited, result);
                }
            }
        }
        return result;
    }

    private static void findWordsDFS(char[][] board, int x, int y, Trie t, int[][] visited, List<String> result) {
        if(!t.word.isEmpty()){
            result.add(t.word);
            // This is to ensure no duplicates added to result
            t.word="";
        }
        int m=board.length, n=board[0].length;
        int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        visited[x][y]=1;
        for(int[] dir: dirs){
            int xn=x+dir[0], yn=y+dir[1];
            if(xn>=0 && xn<m && yn>=0 && yn<n && visited[xn][yn]==0 && t.next[board[xn][yn]-'a']!=null){
                findWordsDFS(board, xn, yn, t.next[board[xn][yn]-'a'], visited, result);
                visited[xn][yn]=0;
            }
        }
        visited[x][y]=0;
    }

    public static class Trie{
        String word="";
        Trie[] next=new Trie[26];

        public Trie(){

        }

        private void add(String word){
            if(word==null || word.isEmpty()){
                throw new IllegalArgumentException("Word can't be null or empty!");
            }
            Trie cur=this;
            for(int i=0; i<word.length(); i++){
                int index=word.charAt(i)-'a';
                if(cur.next[index]==null){
                    cur.next[index]=new Trie();
                }
                cur=cur.next[index];
            }
            cur.word=word;
        }
    }
}
