package com.wen.EighteenthFifty;

import java.util.*;

public class KSimilarStrings {
    public int kSimilarity(String A, String B) {
        int l=A.length(), result=l-1;
        for(int i=0; i<l; i++) {
            if(A.charAt(i)!=B.charAt(i)) {
                List<Integer> matches=new ArrayList<>();
                for(int j=i+1; j<l; j++) {
                    if(A.charAt(j)!=B.charAt(j) && A.charAt(j)==B.charAt(i)) {
                        if(A.charAt(i)==B.charAt(j)) {
                            return 1+kSimilarity(A.substring(i+1, j)+A.charAt(i)+A.substring(j+1), B.substring(i+1));
                        }
                        matches.add(j);
                    }
                }
                for(int j: matches) {
                    StringBuilder asb=new StringBuilder(A);
                    char c1=asb.charAt(i), c2=asb.charAt(j);
                    asb.setCharAt(i, c2);
                    asb.setCharAt(j, c1);
                    result=Math.min(result, 1+kSimilarity(asb.substring(i+1), B.substring(i+1)));
                    asb.setCharAt(i, c1);
                    asb.setCharAt(j, c2);
                }
                return result;
            }
        }
        return 0;
    }

//    // DFS with backtracking
//    public int kSimilarity(String A, String B) {
//        Map<String, Integer> memo=new HashMap<>();
//        return kSimilarityDFS(A, B, 0, memo);
//    }
//
//    private int kSimilarityDFS(String A, String B, int start, Map<String, Integer> memo) {
//        if(A.equals(B)) {
//            return 0;
//        } else if(memo.containsKey(A)) {
//            return memo.get(A);
//        } else {
//            int result=Integer.MAX_VALUE;
//            int i=start, l=A.length();
//            StringBuilder asb=new StringBuilder(A);
//            while(i<l) {
//                if(asb.charAt(i)!=B.charAt(i)) {
//                    break;
//                }
//                i++;
//            }
//            for(int j=i+1; j<l; j++) {
//                if(asb.charAt(j)!=B.charAt(j) && asb.charAt(j)==B.charAt(i)) {
//                    char c1=asb.charAt(i), c2=asb.charAt(j);
//                    asb.setCharAt(i, c2);
//                    asb.setCharAt(j, c1);
//                    int next=kSimilarityDFS(asb.toString(), B, i+1, memo);
//                    result=Math.min(result, next+1);
//                    asb.setCharAt(i, c1);
//                    asb.setCharAt(j, c2);
//                }
//            }
//            memo.put(A, result);
//            return result;
//        }
//    }

//    // BFS with backtracking
//    public int kSimilarity(String A, String B) {
//        int result=0;
//        int l=A.length();
//        Set<String> visited=new HashSet<>();
//        Queue<String> q=new LinkedList<>();
//        q.offer(A);
//        while(!q.isEmpty()) {
//            int size=q.size();
//            while(size-->0) {
//                StringBuilder cur=new StringBuilder(q.poll());
//                if(cur.toString().equals(B)) {
//                    return result;
//                } else if(!visited.contains(cur.toString())) {
//                    visited.add(cur.toString());
//                    int i=0;
//                    while(i<l) {
//                        if(cur.charAt(i)!=B.charAt(i)) {
//                            break;
//                        }
//                        i++;
//                    }
//                    for(int j=i+1; j<l; j++) {
//                        if(cur.charAt(j)!=B.charAt(j) && cur.charAt(j)==B.charAt(i)) {
//                            char c1=cur.charAt(i), c2=cur.charAt(j);
//                            cur.setCharAt(i, c2);
//                            cur.setCharAt(j, c1);
//                            q.offer(cur.toString());
//                            cur.setCharAt(i, c1);
//                            cur.setCharAt(j, c2);
//                        }
//                    }
//                }
//            }
//            result++;
//        }
//        return result;
//    }
}
