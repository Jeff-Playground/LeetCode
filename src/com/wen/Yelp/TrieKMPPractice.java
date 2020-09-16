package com.wen.Yelp;

import java.util.*;

public class TrieKMPPractice {
    public static void main(String[] args){
        List<String> input= Arrays.asList("Burgers", "Super Burgers", "Super Duper Burgers");
        String prefix="bur";
        List<String> result=findByPrefix(input, prefix);
        result.forEach(System.out::println);


        List<String> result2=findBySubstring(input, prefix);
        result2.forEach(System.out::println);
    }

    private static List<String> findBySubstring(List<String> input, String sub) {
        List<String> result=new ArrayList<>();
        int l=sub.length();
        int[] next=new int[l];
        next[0]=-1;
        int i=-1, j=0;
        while(j<l-1){
            if(i==-1 || (sub.charAt(i)-'A')%32==(sub.charAt(j)-'A')%32){
                i++;
                j++;
                if((sub.charAt(i)-'A')%32!=(sub.charAt(j)-'A')%32){
                    next[j]=i;
                } else{
                    next[j]=next[i];
                }
            } else{
                i=next[i];
            }
        }
        for(String phrase: input){
            i=0;
            j=0;
            while(i<phrase.length()){
                if(j==-1 || (phrase.charAt(i)-'A')%32==(sub.charAt(j)-'A')%32){
                    i++;
                    j++;
                    if(j==l){
                        result.add(phrase);
                        break;
                    }
                } else{
                    j=next[j];
                }
            }
        }
        return result;
    }

    private static List<String> findByPrefix(List<String> input, String prefix) {
        Trie trie=new Trie();
        for(String phrase: input){
            String[] split=phrase.split("\\s");
            for(String word: split){
                trie.addEntryByWord(word, phrase);
            }
        }
        List<String> result=new ArrayList<>();
        trie.searchByPrefix(prefix).forEach(e->result.add(e));
        return result;
    }

    private static class Trie{
        private Trie[] children;
        private Set<String> entries;
        private int DELTA='a'-'A';

        public Trie(){
            children=new Trie[26];
            entries=new HashSet<>();
        }

        public void addEntryByWord(String word, String entry){
            Trie cur=this;
            for(char c: word.toCharArray()){
                if(cur.children[(c-'A')%DELTA]==null){
                    cur.children[(c-'A')%DELTA]=new Trie();
                }
                cur.children[(c-'A')%DELTA].entries.add(entry);
                cur=cur.children[(c-'A')%DELTA];
            }
        }

        public Set<String> searchByPrefix(String prefix){
            Trie cur=this;
            for(char c: prefix.toCharArray()){
                Trie next=cur.children[(c-'A')%DELTA];
                if(next==null){
                    return null;
                } else{
                    cur=next;
                }
            }
            return cur.entries;
        }
    }
}
