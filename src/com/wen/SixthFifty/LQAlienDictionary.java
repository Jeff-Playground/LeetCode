package com.wen.SixthFifty;

/*
There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.

You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted
lexicographically by the rules of this new language.

Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new
language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.

A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s comes
before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same, then s is smaller
if and only if s.length < t.length.


Example 1:
Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"


Example 2:
Input: words = ["z","x"]
Output: "zx"


Example 3:
Input: words = ["z","x","z"]
Output: ""
Explanation: The order is invalid, so return "".


Constraints:
1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of only lowercase English letters.

 */

import java.util.*;

public class LQAlienDictionary {
    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph=new HashMap<>();
        int l=words.length;
        int[] inDegree=new int[26];
        Set<Character> visited=new HashSet<>();
        // Handle when there's only 1 word in the input
        if(l==1){
            for(char c: words[0].toCharArray()){
                visited.add(c);
            }
        }
        for(int i=0; i<l-1; i++){
            String w1=words[i], w2=words[i+1];
            int j=0;
            boolean hasDiff=false;
            for(; j<w1.length() && j<w2.length(); j++){
                char c1=w1.charAt(j), c2=w2.charAt(j);
                visited.add(c1);
                visited.add(c2);
                if(c1!=c2){
                    hasDiff=true;
                    graph.putIfAbsent(c1, new HashSet<>());
                    // To ensure we don't add the same edge more than once
                    if(!graph.get(c1).contains(c2)){
                        graph.get(c1).add(c2);
                        inDegree[c2-'a']++;
                    }
                    j++;
                    break;
                }
            }
            // To handle when the input is not by rule
            if(!hasDiff && w1.length()>w2.length()){
                return "";
            }
            for(int k=j; k<w1.length(); k++){
                visited.add(w1.charAt(k));
            }
            for(int k=j; k<w2.length(); k++){
                visited.add(w2.charAt(k));
            }
        }
        Queue<Character> q=new LinkedList<>();
        for(char c: visited){
            if(inDegree[c-'a']==0){
                q.offer(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty()){
            char c=q.poll();
            sb.append(c);
            for(char in: graph.getOrDefault(c, new HashSet<>())){
                if(--inDegree[in-'a']==0){
                    q.offer(in);
                }
            }
        }
        return sb.length()==visited.size()?sb.toString():"";
    }
}
