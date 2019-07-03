package com.wen.ThirdFifty;

import java.util.*;

public class WordLadder {
    // BFS
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict=new HashSet<>(wordList);
        if(!dict.contains(endWord) || beginWord.equals(endWord)){
            return 0;
        }
        Queue<String> reachedWords=new LinkedList<>();
        reachedWords.offer(beginWord);
        int level=1;
        while(!reachedWords.isEmpty()){
            Set<String> visitedInLevel=new HashSet<>();
            for(int i=reachedWords.size(); i>0; i--){
                String word=reachedWords.poll();
                for(int j=0; j<word.length(); j++){
                    for(char c='a'; c<='z'; c++){
                        String newWord=word.substring(0,j)+c+word.substring(j+1);
                        if(dict.contains(newWord)){
                            if(newWord.equals(endWord)){
                                return level+1;
                            } else{
                                reachedWords.offer(newWord);
                                visitedInLevel.add(newWord);
                            }
                        }
                    }
                }
            }
            level++;
            dict.removeAll(visitedInLevel);
        }
        return 0;
    }
}
