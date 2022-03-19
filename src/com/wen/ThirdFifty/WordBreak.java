package com.wen.ThirdFifty;

import java.util.*;

public class WordBreak {
//    // BFS
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> dict=new HashSet<>(wordDict);
//        boolean[] visited=new boolean[s.length()];
//        Queue<Integer> queue=new LinkedList<>();
//        queue.offer(0);
//        while(!queue.isEmpty()){
//            int start=queue.poll();
//            if(!visited[start]){
//                for(int i=start+1; i<=s.length(); i++){
//                    if(dict.contains(s.substring(start, i))){
//                        queue.offer(i);
//                        if(i==s.length()){
//                            return true;
//                        }
//                    }
//                }
//                visited[start]=true;
//            }
//        }
//        return false;
//    }

//    // DP, top down
//    public boolean wordBreak(String s, List<String> wordDict) {
//        int l=s.length();
//        Set<String> dict=new HashSet<>(wordDict);
//        int[] memo=new int[l];
//        return dp(s, dict, l-1, memo);
//    }
//
//    private boolean dp(String s, Set<String> dict, int idx, int[] memo){
//        if(memo[idx]==0){
//            for(int i=0; i<=idx; i++){
//                if((i==0 || dp(s, dict, i-1, memo)) && dict.contains(s.substring(i, idx+1))){
//                    memo[idx]=1;
//                    break;
//                }
//            }
//            if(memo[idx]==0){
//                memo[idx]=-1;
//            }
//        }
//        return memo[idx]==1;
//    }

//    // DP, bottom up, dp[i] stands for whether s.substring(0, i+1) can be broken properly
//    public boolean wordBreak(String s, List<String> wordDict) {
//        int l=s.length();
//        boolean[] dp=new boolean[l];
//        Set<String> dict=new HashSet<>(wordDict);
//        for(int i=0; i<l; i++){
//            for(int j=0; j<=i; j++){
//                if((j==0 || dp[j-1]) && dict.contains(s.substring(j, i+1))){
//                    dp[i]=true;
//                    break;
//                }
//            }
//        }
//        return dp[l-1];
//    }

//    // DFS, memo values 0 means not visited, 1 means matching, -1 means not matching
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

    // Works better when wordDict size is relatively small
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.isEmpty()) {
            return true;
        }
        for(String word: wordDict) {
            if(s.contains(word)) {
                String[] parts=s.split(word);
                if(parts.length==0) {
                    return true;
                }
                boolean result=wordBreak(parts[0], wordDict);
                for(int i=1; i<parts.length; i++) {
                    if(!result){
                        break;
                    }
                    result=result && wordBreak(parts[i], wordDict);
                }
                if(result) {
                    return true;
                }
            }
        }
        return false;
    }
}
