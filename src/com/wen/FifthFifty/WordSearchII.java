package com.wen.FifthFifty;

import java.util.*;

public class WordSearchII {
//    // DFS
//    public static List<String> findWords(char[][] board, String[] words) {
//        if(board==null || board.length==0 || board[0].length==0 || words==null){
//            throw new IllegalArgumentException("Invalid input!");
//        }
//        Set<String> visited=new HashSet<>();
//        int m=board.length, n=board[0].length;
//        Map<Character, Set<String>> wordsMap=new HashMap<>();
//        for(String word: words){
//            char c=word.charAt(0);
//            wordsMap.putIfAbsent(c, new HashSet<>());
//            wordsMap.get(c).add(word);
//        }
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                char c=board[i][j];
//                if(wordsMap.containsKey(c)){
//                    for(String word: wordsMap.get(c)){
//                        if(!visited.contains(word) & findWord(board, i, j, word)){
//                            visited.add(word);
//                        }
//                    }
//                }
//            }
//        }
//        List<String> result=new ArrayList<>();
//        visited.stream().forEach(e->result.add(e));
//        return result;
//    }
//
//    private static boolean findWord(char[][] board, int x, int y, String word){
//        int m=board.length, n=board[0].length;
//        int[][] visited=new int[m][n];
//        int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
//        return findWordDFS(board, x, y, word, 0, visited, dirs);
//    }
//
//    private static boolean findWordDFS(char[][] board, int x, int y, String word, int cur, int[][] visited, int[][] dirs){
//        if(cur==word.length()-1){
//            return true;
//        } else{
//            int m=board.length, n=board[0].length;
//            visited[x][y]=1;
//            boolean result=false;
//            for(int[] dir: dirs){
//                int newX=x+dir[0], newY=y+dir[1];
//                if(newX>=0 && newX<m && newY>=0 && newY<n && visited[newX][newY]==0 && board[newX][newY]==word.charAt(cur+1)){
//                    if(findWordDFS(board, newX, newY, word, cur+1, visited, dirs)){
//                        result=true;
//                        break;
//                    }
//                }
//            }
//            visited[x][y]=0;
//            return result;
//        }
//    }

//    // Trie with DFS
//    public static class Trie{
//        String word;
//        Trie[] next;
//
//        public Trie(){
//            word="";
//            next=new Trie[26];
//        }
//
//        private void add(String word){
//            if(word==null || word.isEmpty()){
//                throw new IllegalArgumentException("Word can't be null or empty!");
//            }
//            Trie cur=this;
//            for(int i=0; i<word.length(); i++){
//                int index=word.charAt(i)-'a';
//                if(cur.next[index]==null){
//                    cur.next[index]=new Trie();
//                }
//                cur=cur.next[index];
//            }
//            cur.word=word;
//        }
//    }
//
//    public static List<String> findWords(char[][] board, String[] words) {
//        List<String> result=new ArrayList<>();
//        if(board==null || board.length==0 || board[0]==null || board[0].length==0){
//            throw new IllegalArgumentException("Invalid board!");
//        }
//        if(words==null || words.length==0){
//            return result;
//        }
//        Trie t=new Trie();
//        for(String word: words){
//            t.add(word);
//        }
//        int m=board.length, n=board[0].length;
//        int[][] visited=new int[m][n];
//        for(int i=0; i<m; i++){
//            for(int j=0; j<n; j++){
//                if(t.next[board[i][j]-'a']!=null){
//                    findWordsDFS(board, i, j, t.next[board[i][j]-'a'], visited, result);
//                }
//            }
//        }
//        return result;
//    }
//
//    private static void findWordsDFS(char[][] board, int x, int y, Trie t, int[][] visited, List<String> result) {
//        if(!t.word.isEmpty()){
//            result.add(t.word);
//            // This is to ensure no duplicates added to result, duplicates may be added when there are multiple valid
//            // words on the different location of the board
//            t.word="";
//        }
//        int m=board.length, n=board[0].length;
//        int[][] dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
//        visited[x][y]=1;
//        for(int[] dir: dirs){
//            int xn=x+dir[0], yn=y+dir[1];
//            if(xn>=0 && xn<m && yn>=0 && yn<n && visited[xn][yn]==0 && t.next[board[xn][yn]-'a']!=null){
//                findWordsDFS(board, xn, yn, t.next[board[xn][yn]-'a'], visited, result);
//            }
//        }
//        visited[x][y]=0;
//    }

    // Trie and DFS without visited
    private class TrieNode{
        TrieNode[] children;
        String word;

        public TrieNode(){
            children=new TrieNode[26];
        }

        public void addWord(String word){
            TrieNode cur=this;
            for(char c: word.toCharArray()){
                if(cur.children[c-'a']==null){
                    cur.children[c-'a']=new TrieNode();
                }
                cur=cur.children[c-'a'];
            }
            cur.word=word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root=new TrieNode();
        for(String word: words){
            root.addWord(word);
        }
        List<String> result=new ArrayList<>();
        int m=board.length, n=board[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(root.children[board[i][j]-'a']!=null){
                    char c=board[i][j];
                    board[i][j]='#';
                    findWordInTrie(board, root.children[c-'a'], i, j, result);
                    board[i][j]=c;
                }
            }
        }
        return result;
    }

    private void findWordInTrie(char[][] board, TrieNode cur, int x, int y, List<String> result){
        if(cur.word!=null){
            result.add(cur.word);
            cur.word=null;
        }
        int[][] dirs=new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int[] dir: dirs){
            int nextX=x+dir[0], nextY=y+dir[1];
            if(nextX>=0 && nextX<board.length && nextY>=0 && nextY<board[0].length){
                char c=board[nextX][nextY];
                if(c-'a'>=0 && c-'a'<26 && cur.children[c-'a']!=null){
                    board[nextX][nextY]='#';
                    findWordInTrie(board, cur.children[c-'a'], nextX, nextY, result);
                }
                board[nextX][nextY]=c;
            }
        }
    }
}
