package com.wen.Airbnb;

import java.util.ArrayList;
import java.util.List;

public class KEditDistance {
    public static void main(String[] args){
        kDistance(new String[]{"as","ab","cf","da","ee","e","adee","eeda"}, "eefab", 3);
    }

    public static List<String> kDistance(String[] words, String target, int k) {
        List<String> result=new ArrayList<>();
        if(words==null || words.length==0){
            return result;
        }
        Trie root=new Trie();
        for(String word: words){
            root.insert(word);
        }
        int[] dp=new int[target.length()+1];
        for(int i=0; i<dp.length; i++){
            dp[i]=i;
        }
        search(dp, target, k, root, result);
        return result;
    }

    private static void search(int[] dp, String target, int k, Trie node, List<String> result){
        if(node.word!=null){
            if(dp[target.length()]<=k){
                result.add(node.word);
            }
        }
        for(char c='a'; c<='z'; c++){
            if(node.nodes[c-'a']!=null){
                int[] cur=new int[dp.length];
                cur[0]=dp[0]+1;
                for(int i=1; i<target.length()+1; i++){
                    if(c==target.charAt(i-1)){
                        cur[i]=dp[i-1];
                    } else{
                        cur[i]=Math.min(Math.min(dp[i-1], dp[i]), cur[i-1])+1;
                    }
                }
                search(cur, target, k, node.nodes[c-'a'], result);
            }
        }
    }

    public static class Trie{
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
}
