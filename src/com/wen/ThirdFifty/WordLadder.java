package com.wen.ThirdFifty;

import java.util.*;

public class WordLadder {
    // BFS
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict=new HashSet<>(wordList);
        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord);
        int level=0;
        while(!queue.isEmpty()){
            for(int i=queue.size(); i>0; i--){
                String last=queue.poll();
                if(last.equals(endWord)){
                    return level+1;
                }
                for(int j=0; j<last.length(); j++){
                    for(char ch='a'; ch<='z'; ch++){
                        String newWord=last.substring(0, j)+ch+last.substring(j+1);
                        // Note this condition is different from WordLadderII because the place to remove visited words is different
                        if(!newWord.equals(last) && dict.contains(newWord)){
                            dict.remove(newWord);
                            queue.offer(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
