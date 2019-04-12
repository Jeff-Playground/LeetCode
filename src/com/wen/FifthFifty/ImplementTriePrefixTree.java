package com.wen.FifthFifty;

public class ImplementTriePrefixTree {
    // Functions are implemented iteratively
    class Trie {
        boolean isEnd;
        Trie[] chars;

        /** Initialize your data structure here. */
        public Trie() {
            isEnd=false;
            chars=new Trie[26];
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            int l=word.length();
            Trie cur=this;
            for(int i=0; i<l; i++){
                Trie temp=null;
                if(cur.chars[word.charAt(i)-'a']!=null) {
                    temp=cur.chars[word.charAt(i)-'a'];
                } else {
                    temp=new Trie();
                    cur.chars[word.charAt(i)-'a']=temp;
                }
                cur=temp;
            }
            cur.isEnd=true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            int l=word.length();
            Trie cur=this;
            for(int i=0; i<l; i++){
                if(cur.chars[word.charAt(i)-'a']==null) {
                    return false;
                } else {
                    cur=cur.chars[word.charAt(i)-'a'];
                }
            }
            return cur.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            int l=prefix.length();
            Trie cur=this;
            for(int i=0; i<l; i++){
                if(cur.chars[prefix.charAt(i)-'a']==null) {
                    return false;
                } else {
                    cur=cur.chars[prefix.charAt(i)-'a'];
                }
            }
            return true;
        }
    }

//    // Functions are implemented recursively
//    class Trie {
//        boolean isEnd;
//        Trie[] chars;
//
//        /** Initialize your data structure here. */
//        public Trie() {
//            isEnd=false;
//            chars=new Trie[26];
//        }
//
//        /** Inserts a word into the trie. */
//        public void insert(String word) {
//            char current=word.charAt(0);
//            if(chars[current-'a']==null){
//                Trie newTrie=new Trie();
//                chars[current-'a']=newTrie;
//            }
//            Trie cur=chars[current-'a'];
//            if(word.length()>1){
//                cur.insert(word.substring(1));
//            } else {
//                cur.isEnd=true;
//            }
//        }
//
//        /** Returns if the word is in the trie. */
//        public boolean search(String word) {
//            if(chars[word.charAt(0)-'a']!=null) {
//                if(word.length()==1){
//                    return chars[word.charAt(0)-'a'].isEnd;
//                } else {
//                    return chars[word.charAt(0)-'a'].search(word.substring(1));
//                }
//            } else {
//                return false;
//            }
//        }
//
//        /** Returns if there is any word in the trie that starts with the given prefix. */
//        public boolean startsWith(String prefix) {
//            if(chars[prefix.charAt(0)-'a']!=null) {
//                if(prefix.length()==1){
//                    return true;
//                } else {
//                    return chars[prefix.charAt(0)-'a'].startsWith(prefix.substring(1));
//                }
//            } else {
//                return false;
//            }
//        }
//    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
