package com.wen.ThirdFifty;

import java.util.*;

public class WordLadderII {
    // BFS
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result=new ArrayList<>();
        Set<String> dict=new HashSet<>(wordList);
        List<String> path=new ArrayList<>();
        path.add(beginWord);
        Queue<List<String>> paths=new LinkedList<>();
        paths.offer(path);
        int level=1, minLevel=Integer.MAX_VALUE;
        Set<String> visitedInLevel=new HashSet<>();
        while(!paths.isEmpty()){
            List<String> temp=paths.poll();
            if(temp.size()>level){
                // Only remove words from the dict when reaching another level, otherwise different branches from same source would be excluded wrongly
                for(String w: visitedInLevel){
                    dict.remove(w);
                }
                visitedInLevel.clear();
                level= temp.size();
                if(level>minLevel){
                    break;
                }
            }
            String last=temp.get(temp.size()-1);
            for(int i=0; i<last.length(); i++){
                String newLast=last;
                for(char ch='a'; ch<='z'; ch++){
                    newLast=newLast.substring(0, i)+ch+newLast.substring(i+1);
                    if(!dict.contains(newLast)){
                        continue;
                    }
                    visitedInLevel.add(newLast);
                    List<String> nextPath=new ArrayList<>(temp);
                    nextPath.add(newLast);
                    if(newLast.equals(endWord)){
                        result.add(nextPath);
                        minLevel=level;
                    } else{
                        paths.offer(nextPath);
                    }
                }
            }
        }
        return result;
    }
}
