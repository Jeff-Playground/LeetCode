package com.wen.ThirdFifty;

import java.util.*;

public class WordLadderII {
    // BFS
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result=new ArrayList<>();
        Set<String> dict=new HashSet<>(wordList);
        if(!dict.contains(endWord)){
            return result;
        }
        List<String> initPath=new ArrayList<>();
        initPath.add(beginWord);
        Queue<List<String>> paths=new LinkedList<>();
        paths.offer(initPath);
        boolean reachedEnd=false;
        while(!paths.isEmpty() && !reachedEnd){
            int size=paths.size();
            Set<String> visitedInLevel=new HashSet<>();
            for(int i=0; i<size; i++){
                List<String> cur=paths.poll();
                String lastWord=cur.get(cur.size()-1);
                for(int j=0; j<lastWord.length(); j++){
                    for(char c='a'; c<='z'; c++){
                        String newWord=lastWord.substring(0,j)+c+lastWord.substring(j+1);
                        if(dict.contains(newWord)){
                            List<String> curCopy=new ArrayList<>(cur);
                            curCopy.add(newWord);
                            visitedInLevel.add(newWord);
                            if(newWord.equals(endWord)){
                                result.add(curCopy);
                                reachedEnd=true;
                            } else{
                                paths.offer(curCopy);
                            }
                        }
                    }

                }
            }
            dict.removeAll(visitedInLevel);
        }
        return result;
    }
}
