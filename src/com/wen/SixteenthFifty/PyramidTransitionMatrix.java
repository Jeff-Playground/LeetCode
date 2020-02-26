package com.wen.SixteenthFifty;

import java.util.*;

public class PyramidTransitionMatrix {
    // DP
    // dp[i][j][k] stands for the letter at location (i, j) can be (char)('A'+k)
    public static boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<Character, Set<String>> triples=new HashMap<>();
        for(String triple: allowed) {
            triples.putIfAbsent(triple.charAt(2), new HashSet<>());
            triples.get(triple.charAt(2)).add(triple.substring(0,2));
        }
        int l=bottom.length();
        boolean[][][] dp=new boolean[l][l][7];
        for(int i=0; i<l; i++) {
            dp[l-1][i][bottom.charAt(i)-'A']=true;
        }
        for(int i=l-2; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                for(char c='A'; c<='G'; c++) {
                    if(triples.containsKey(c)) {
                        for(String pair: triples.get(c)) {
                            if(dp[i+1][j][pair.charAt(0)-'A'] && dp[i+1][j+1][pair.charAt(1)-'A']) {
                                dp[i][j][c-'A']=true;
                                if(i==0) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

//    // DFS
//    public boolean pyramidTransition(String bottom, List<String> allowed) {
//        Map<String, Set<Character>> triples=new HashMap<>();
//        for(String triple: allowed) {
//            triples.putIfAbsent(triple.substring(0,2), new HashSet<>());
//            triples.get(triple.substring(0,2)).add(triple.charAt(2));
//        }
//        return pyramidTransitionDFS(bottom, "", triples);
//    }
//
//    private boolean pyramidTransitionDFS(String last, String cur, Map<String, Set<Character>> triples) {
//        int l=last.length(), cl=cur.length();
//        if(l==1) {
//            return true;
//        } else if(l==cl+1) {
//            return pyramidTransitionDFS(cur, "", triples);
//        } else {
//            StringBuilder sb=new StringBuilder(cur);
//            String key=last.substring(cl, cl+2);
//            if(triples.containsKey(key)) {
//                Set<Character> possible=triples.get(key);
//                for(Character option: possible) {
//                    sb.append(option);
//                    if(pyramidTransitionDFS(last, sb.toString(), triples)) {
//                        return true;
//                    }
//                    sb.setLength(sb.length()-1);
//                }
//            } else {
//                return false;
//            }
//            return false;
//        }
//    }
}
