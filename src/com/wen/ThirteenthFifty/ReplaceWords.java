package com.wen.ThirteenthFifty;

import java.util.List;

public class ReplaceWords {
//    // Trie functions implemented in a iterative way
//    private class TrieNode{
//        TrieNode[] nodes;
//        boolean isEnd;
//
//        public TrieNode(){
//            nodes=new TrieNode[26];
//            isEnd=false;
//        }
//
//        public void addPrefix(String word){
//            int l=word.length();
//            TrieNode cur=this;
//            for(int i=0; i<l; i++){
//                char c=word.charAt(i);
//                if(cur.nodes[c-'a']==null){
//                    cur.nodes[c-'a']=new TrieNode();
//                }
//                cur=cur.nodes[c-'a'];
//                if(cur.isEnd){
//                    break;
//                }
//                if(i==l-1){
//                    cur.isEnd=true;
//                }
//            }
//        }
//
//        public String searchPrefix(String word){
//            int l=word.length();
//            TrieNode cur=this;
//            for(int i=0; i<l; i++){
//                char c=word.charAt(i);
//                cur=cur.nodes[c-'a'];
//                if(cur==null){
//                    return word;
//                }
//                if(cur.isEnd){
//                    return word.substring(0, i+1);
//                }
//            }
//            return word;
//        }
//    }

    private class TrieNode{
        TrieNode[] nodes;
        boolean isEnd;

        public TrieNode(){
            nodes=new TrieNode[26];
            isEnd=false;
        }

        public void addPrefix(String word){
            TrieNode cur=this;
            if(cur.isEnd){
                return;
            }
            char c=word.charAt(0);
            if(cur.nodes[c-'a']==null){
                cur.nodes[c-'a']=new TrieNode();
            }
            cur=cur.nodes[c-'a'];
            if(word.length()==1){
                cur.isEnd=true;
            } else{
                cur.addPrefix(word.substring(1));
            }
        }

        public String searchPrefix(String word){
            if(word.length()==1){
                return word;
            }
            TrieNode cur=this;
            char c=word.charAt(0);
            if(cur.nodes[c-'a']==null){
                return word;
            } else{
                if(cur.nodes[c-'a'].isEnd){
                    return ""+c;
                } else{
                    return c+cur.nodes[c-'a'].searchPrefix(word.substring(1));
                }
            }
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root=new TrieNode();
        for(String word: dictionary){
            root.addPrefix(word);
        }
        StringBuilder sb=new StringBuilder();
        String[] splitSentence=sentence.split("\\s");
        for(String word: splitSentence){
            sb.append(root.searchPrefix(word));
            sb.append(" ");
        }
        return sb.substring(0, sb.length()-1);
    }
}
