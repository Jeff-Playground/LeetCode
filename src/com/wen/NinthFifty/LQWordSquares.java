package com.wen.NinthFifty;

import java.util.*;

public class LQWordSquares {
    // Trie
    private class TrieNode{
        public TrieNode[] children;
        public Set<String> words;

        public TrieNode(){
            children=new TrieNode[26];
            words=new HashSet<>();
        }

        public void buildTrie(List<String> words){
            for(String word: words){
                TrieNode cur=this;
                cur.words.add(word);
                for(int i=0; i<word.length(); i++){
                    char c=word.charAt(i);
                    if(cur.children[c-'a']==null){
                        cur.children[c-'a']=new TrieNode();
                    }
                    cur=cur.children[c-'a'];
                    cur.words.add(word);
                }
            }
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        Map<Integer, List<String>> lengthMap=new HashMap<>();
        for(String word: words){
            int length=word.length();
            List<String> group=lengthMap.getOrDefault(length, new ArrayList<>());
            group.add(word);
            lengthMap.put(length, group);
        }
        List<List<String>> result=new ArrayList<>();
        for(List<String> group: lengthMap.values()){
            result.addAll(wordSquares(group));
        }
        return result;
    }

    private List<List<String>> wordSquares(List<String> words){
        List<List<String>> result=new ArrayList<>();
        if(words==null || words.size()==0 || words.get(0).length()>words.size()){
            return result;
        }
        int l=words.get(0).length();
        TrieNode root=new TrieNode();
        root.buildTrie(words);
        for(String word: words){
            List<String> cur=new ArrayList<>();
            cur.add(word);
            wsHelper(root, l, cur, result);
        }
        return result;
    }

    private void wsHelper(TrieNode root, int l, List<String> cur, List<List<String>> result){
        if(cur.size()==l){
            List<String> temp=new ArrayList<>(cur);
            result.add(temp);
        } else{
            int idx=cur.size();
            TrieNode curNode=root;
            int i=0, j=idx;
            while(i<idx){
                curNode=curNode.children[cur.get(i).charAt(j)-'a'];
                if(curNode==null){
                    break;
                }
                i++;
            }
            if(i==idx){
                for(String word: curNode.words){
                    cur.add(word);
                    wsHelper(root, l, cur, result);
                    cur.remove(cur.size()-1);
                }
            }
        }
    }

//    // DFS
//    public static List<List<String>> wordSquares(String[] words) {
//        List<List<String>> result=new ArrayList<>();
//        Map<Integer, List<String>> lengthGroup=new HashMap<>();
//        for(String word: words){
//            int l=word.length();
//            List<String> group=lengthGroup.getOrDefault(l, new ArrayList<>());
//            group.add(word);
//            lengthGroup.put(l, group);
//        }
//        for(List<String> group: lengthGroup.values()){
//            result.addAll(wordSquares(group));
//        }
//        return result;
//    }
//
//    private static List<List<String>> wordSquares(List<String> words){
//        List<List<String>> result=new ArrayList<>();
//        if(words==null || words.size()==0 || words.get(0).length()>words.size()){
//            return result;
//        }
//        Map<String, Set<String>> prefixMap=new HashMap<>();
//        int l=words.get(0).length();
//        for(String word: words){
//            for(int i=0; i<l; i++){
//                String key=word.substring(0, i);
//                Set<String> wordsSet=prefixMap.getOrDefault(key, new HashSet<>());
//                wordsSet.add(word);
//                prefixMap.put(key, wordsSet);
//            }
//        }
//        wsHelper(0, l, new char[l][l], prefixMap, result);
//        return result;
//    }
//
//    private static void wsHelper(int i, int l, char[][] cur, Map<String, Set<String>> prefixMap, List<List<String>> result){
//        if(i==l){
//            List<String> temp=new ArrayList<>();
//            for(int j=0; j<l; j++){
//                temp.add(new String(cur[j]));
//            }
//            result.add(temp);
//        } else{
//            String key=new String(cur[i], 0, i);
//            for(String word: prefixMap.get(key)){
//                cur[i][i]=word.charAt(i);
//                int j=i+1;
//                while(j<l){
//                    cur[i][j]=word.charAt(j);
//                    cur[j][i]=word.charAt(j);
//                    if(!prefixMap.containsKey(new String(cur[j], 0, i+1))){
//                        break;
//                    }
//                    j++;
//                }
//                if(j==l){
//                    wsHelper(i+1, l, cur, prefixMap, result);
//                }
//            }
//        }
//    }
}
