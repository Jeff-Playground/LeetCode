package com.wen.Airbnb;

import java.util.ArrayList;
import java.util.List;

public class BoggleGame {
    public List<String> words=new ArrayList<>();
    public Trie root;
    public int[][] dirs=new int[][]{{0,-1},{0,1},{-1,0},{1,0}};

    public class Trie{
        public Trie[] nodes;
        public String word;
        public Trie(){
            nodes=new Trie[26];
            word=null;
        }

        public void insert(String word){
            int l=word.length();
            Trie node=this;
            for(int i=0; i<l; i++){
                char c=word.charAt(i);
                if(node.nodes[c-'a']==null){
                    node.nodes[c-'a']=new Trie();
                }
                node=node.nodes[c-'a'];
            }
            node.word=word;
        }
    }

    public int boggleGame(char[][] board, String[] words) {
        int result=0;
        if(board==null || board.length==0 || board[0].length==0){
            return result;
        }
        int m=board.length, n=board[0].length;
        root=new Trie();
        for(String word: words){
            root.insert(word);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                search(board, i, j, new ArrayList<>(), new boolean[m][n], root);
            }
        }
        return this.words.size();
    }

    public void search(char[][] board, int x, int y, List<String> path, boolean[][] visited, Trie node){
        if(!visited[x][y] && node.nodes[board[x][y]-'a']!=null){
            visited[x][y]=true;
            node=node.nodes[board[x][y]-'a'];
            int m=board.length, n=board[0].length;
            if(node.word!=null){
                path.add(node.word);
                if(path.size()>words.size()){
                    words=new ArrayList<>(path);
                }
                for(int i=0; i<m; i++) {
                    for (int j = 0; j < n; j++) {
                        search(board, i, j, path, visited, root);
                    }
                }
                path.remove(path.size()-1);
            } else{
                for(int[] dir: dirs){
                    int xN=x+dir[0], yN=y+dir[1];
                    if(xN>=0 && xN<m && yN>=0 && yN<n){
                        search(board, xN, yN, path, visited, node);
                    }
                }
                visited[x][y]=false;
            }
        }
    }
}
