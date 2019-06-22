package com.wen.SixthFifty;

import java.util.*;

public class LQAlienDictionary {
    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph=new HashMap<>();
        int[] inDegree=new int[26];
        createGraph(words, graph, inDegree);
        Queue<Character> queue=new PriorityQueue<>();
        for(Character c: graph.keySet()){
            if(inDegree[c-'a']==0){
                queue.offer(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!queue.isEmpty()){
            Character cur=queue.poll();
            sb.append(cur);
            for(Character c:graph.get(cur)){
                if(--inDegree[c-'a']==0){
                    queue.offer(c);
                }
            }
        }
        return sb.length()==graph.size()?sb.toString():"";
    }

    private static void createGraph(String[] words, Map<Character, Set<Character>> graph, int[] inDegree) {
        for(String word: words){
            for(char c: word.toCharArray()){
                graph.put(c, new HashSet<>());
            }
        }
        for(int i=1; i<words.length; i++){
            String first=words[i-1];
            String second=words[i];
            for(int j=0; j<Math.min(first.length(), second.length()); j++){
                char start=first.charAt(j);
                char end=second.charAt(j);
                if(start!=end){
                    if(!graph.get(start).contains(end)){
                        graph.get(start).add(end);
                        inDegree[end-'a']++;
                    }
                    // This is a god move!!!
                    break;
                }
            }
        }
    }
}
