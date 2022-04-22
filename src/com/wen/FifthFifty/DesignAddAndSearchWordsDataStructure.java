package com.wen.FifthFifty;

public class DesignAddAndSearchWordsDataStructure {
    class WordDictionary {
        TrieNode root;

        public WordDictionary() {
            root=new TrieNode();
        }

        public void addWord(String word) {
            root.addWord(word);
        }

        public boolean search(String word) {
            return root.search(word);
        }
    }

    public class TrieNode{
        TrieNode[] chars;
        boolean isEnd;

        public TrieNode(){
            chars=new TrieNode[26];
            isEnd=false;
        }

        public void addWord(String word){
            TrieNode cur=this;
            for(char c: word.toCharArray()){
                if(cur.chars[c-'a']==null){
                    cur.chars[c-'a']=new TrieNode();
                }
                cur=cur.chars[c-'a'];
            }
            cur.isEnd=true;
        }

        public boolean search(String word){
            TrieNode cur=this;
            for(int i=0; i<word.length(); i++){
                char c=word.charAt(i);
                if(c=='.'){
                    for(TrieNode node: cur.chars){
                        if(node!=null && node.search(word.substring(i+1))){
                            return true;
                        }
                    }
                    return false;
                } else{
                    if(cur.chars[c-'a']==null){
                        return false;
                    } else{
                        cur=cur.chars[c-'a'];
                    }
                }
            }
            return cur.isEnd;
        }
    }
}
