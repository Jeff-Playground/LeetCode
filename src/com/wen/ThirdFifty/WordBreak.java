package com.wen.ThirdFifty;

import java.util.*;

public class WordBreak {
    // BFS
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict=new HashSet<>(wordDict);
        boolean[] visited=new boolean[s.length()];
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int start=queue.poll();
            if(!visited[start]){
                for(int i=start+1; i<=s.length(); i++){
                    if(dict.contains(s.substring(start, i))){
                        queue.offer(i);
                        if(i==s.length()){
                            return true;
                        }
                    }
                }
                visited[start]=true;
            }
        }
        return false;
    }

//    // Dynamic Programming
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> dict=new HashSet<>(wordDict);
//        boolean[] dp=new boolean[s.length()+1];
//        dp[0]=true;
//        for(int i=0; i<s.length()+1; i++){
//            for(int j=0; j<i; j++){
//                if(dp[j] && dict.contains(s.substring(j, i))){
//                    dp[i]=true;
//                    break;
//                }
//            }
//        }
//        return dp[s.length()];
//    }

//    // DFS
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> dict=new HashSet<>(wordDict);
//        int[] memo=new int[s.length()];
//        return check(s, dict, 0, memo);
//    }
//
//    private boolean check(String s, Set<String> dict, int start, int[] memo) {
//        if(start>=s.length()) {
//            return true;
//        }
//        if(memo[start]!=0) {
//            return memo[start]==1;
//        }
//        for(int i=start+1; i<=s.length(); i++) {
//            if(dict.contains(s.substring(start, i)) && check(s, dict, i, memo)) {
//                memo[start]=1;
//                return true;
//            }
//        }
//        memo[start]=-1;
//        return false;
//    }

//    // My way
//    public boolean wordBreak(String s, List<String> wordDict) {
//        if(s.isEmpty()) {
//            return true;
//        }
//        for(String word: wordDict) {
//            if(s.contains(word)) {
//                String[] parts=s.split(word);
//                if(parts.length==0) {
//                    return true;
//                }
//                boolean result=wordBreak(parts[0], wordDict);
//                for(int i=0; i<parts.length; i++) {
//                    result=result && wordBreak(parts[i], wordDict);
//                }
//                if(result) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
