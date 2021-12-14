package com.wen.FourteenthFifty;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ImplementMagicDictionary {
    // Brute force
    class MagicDictionary {
        Set<String> set;

        public MagicDictionary() {
            set=new HashSet<>();
        }

        public void buildDict(String[] dictionary) {
            for(String word: dictionary){
                set.add(word);
            }
        }

        public boolean search(String searchWord) {
            int l=searchWord.length();
            for(char c='a'; c<='z'; c++){
                for(int i=0; i<l; i++){
                    if(c!=searchWord.charAt(i)){
                        StringBuilder sb=new StringBuilder();
                        sb.append(searchWord.substring(0, i));
                        sb.append(c);
                        sb.append(searchWord.substring(i+1));
                        if(set.contains(sb.toString())){
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

//    // Found words with same length and only 1 different character
//    class MagicDictionary {
//        Map<Integer, Set<String>> dict;
//
//        public MagicDictionary() {
//            dict=new HashMap<>();
//        }
//
//        public void buildDict(String[] dictionary) {
//            for(String word: dictionary){
//                dict.putIfAbsent(word.length(), new HashSet<>());
//                dict.get(word.length()).add(word);
//            }
//        }
//
//        public boolean search(String searchWord) {
//            int l=searchWord.length();
//            for(String word: dict.getOrDefault(l, new HashSet<>())){
//                int diffCount=0;
//                for(int i=0; i<l; i++){
//                    if(word.charAt(i)!=searchWord.charAt(i)){
//                        if(++diffCount>1){
//                            break;
//                        }
//                    }
//                }
//                if(diffCount==1){
//                    return true;
//                }
//            }
//            return false;
//        }
//    }

//    // Trie
//    public static class MagicDictionary {
//        private class TrieNode{
//            TrieNode[] nodes;
//            boolean isEnd;
//
//            public TrieNode(){
//                nodes=new TrieNode[26];
//                isEnd=false;
//            }
//
//            public void addWord(String word){
//                TrieNode cur=this;
//                for(char c: word.toCharArray()){
//                    if(cur.nodes[c-'a']==null){
//                        cur.nodes[c-'a']=new TrieNode();
//                    }
//                    cur=cur.nodes[c-'a'];
//                }
//                cur.isEnd=true;
//            }
//
//            public boolean search(String word){
//                int l=word.length();
//                TrieNode cur=this;
//                for(int i=0; i<l; i++){
//                    char c=word.charAt(i);
//                    if(c<'a'){
//                        boolean found=false;
//                        for(int j=0; j<26; j++){
//                            if(j!=c-'A' && cur.nodes[j]!=null){
//                                if(i==l-1){
//                                    if(cur.nodes[j].isEnd){
//                                        found=true;
//                                        break;
//                                    }
//                                } else{
//                                    if(cur.nodes[j].search(word.substring(i+1))){
//                                        found=true;
//                                        break;
//                                    }
//                                }
//                            }
//                        }
//                        return found;
//                    } else{
//                        cur=cur.nodes[c-'a'];
//                        if(cur==null){
//                            return false;
//                        }
//                    }
//                }
//                return cur.isEnd;
//            }
//        }
//
//        TrieNode root;
//
//        public MagicDictionary() {
//            root=new TrieNode();
//        }
//
//        public void buildDict(String[] dictionary) {
//            for(String word: dictionary){
//                root.addWord(word);
//            }
//        }
//
//        public boolean search(String searchWord) {
//            for(int i=0; i<searchWord.length(); i++){
//                StringBuilder sb=new StringBuilder();
//                for(int j=0; j<searchWord.length(); j++){
//                    if(j==i){
//                        sb.append((char)('A'+searchWord.charAt(j)-'a'));
//                    } else{
//                        sb.append(searchWord.charAt(j));
//                    }
//                }
//                if(root.search(sb.toString())){
//                    return true;
//                }
//            }
//            return false;
//        }
//    }
}
