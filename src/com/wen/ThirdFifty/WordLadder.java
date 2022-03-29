package com.wen.ThirdFifty;

import java.util.*;

public class WordLadder {
    // BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict=new HashSet<>(wordList);
        if(beginWord.equals(endWord) || !dict.contains(endWord)){
            return 0;
        }
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        Set<String> visited=new HashSet<>();
        int step=1;
        while(!q.isEmpty()){
            int size=q.size();
            step++;
            while(size-->0){
                String cur=q.poll();
                for(int i=0; i<cur.length(); i++){
                    for(char c='a'; c<='z'; c++){
                        String newWord=cur.substring(0, i)+c+cur.substring(i+1);
                        if(dict.contains(newWord) && !visited.contains(newWord)){
                            if(newWord.equals(endWord)){
                                return step;
                            }
                            visited.add(newWord);
                            q.offer(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
