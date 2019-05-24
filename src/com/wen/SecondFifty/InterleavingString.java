package com.wen.SecondFifty;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class InterleavingString {
//    // BFS
//    public static boolean isInterleave(String s1, String s2, String s3) {
//        int n1=s1.length(), n2=s2.length(), n3=s3.length(), k=0;
//        if(n1+n2!=n3){
//            return false;
//        }
//        Set<Integer> set=new HashSet<>();
//        // PriorityQueue is sorted, while ConcurrentLinkedQueue is not, but LeetCode doesn't support ConcurrentLinkedQueue, so use LinkedList instead
//        Queue<Integer> queue=new LinkedList<>();
//        queue.add(0);
//        while(!queue.isEmpty() && k<n3){
//            int len= queue.size();
//            for(int t=0; t<len; t++){
//                int i= queue.peek()/n3, j=queue.peek()%n3;
//                queue.poll();
//                if(i<n1 && s1.charAt(i)==s3.charAt(k)){
//                    int key=(i+1)*n3+j;
//                    if(!set.contains(key)){
//                        set.add(key);
//                        queue.add(key);
//                    }
//                }
//                if(j<n2 && s2.charAt(j)==s3.charAt(k)){
//                    int key=i*n3+j+1;
//                    if(!set.contains(key)){
//                        set.add(key);
//                        queue.add(key);
//                    }
//                }
//            }
//            k++;
//        }
//        return !queue.isEmpty() && k==n3;
//    }

    // DFS
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        Set<Integer> set=new HashSet<>();
        return isInterleaveDFS(s1, 0, s2, 0, s3, 0, set);
    }

    private static boolean isInterleaveDFS(String s1, int i1, String s2, int i2, String s3, int i3, Set<Integer> set) {
        int key=i1*s3.length()+i2;
        if(set.contains(key)){
            return false;
        }
        if(i1==s1.length()){
            return s2.substring(i2).equals(s3.substring(i3));
        }
        if(i2==s2.length()){
            return s1.substring(i1).equals(s3.substring(i3));
        }
        if(s1.charAt(i1)==s3.charAt(i3) && isInterleaveDFS(s1, i1+1, s2, i2, s3, i3+1, set) ||
                s2.charAt(i2)==s3.charAt(i3) && isInterleaveDFS(s1, i1, s2, i2+1, s3, i3+1, set)){
            return true;
        }
        set.add(key);
        return false;
    }

//    // Dynamic Programming
//    public static boolean isInterleave(String s1, String s2, String s3) {
//        int m=s1.length(), n=s2.length();
//        if(m+n!=s3.length()){
//            return false;
//        }
//        boolean[][] dp=new boolean[m+1][n+1];
//        dp[0][0]=true;
//        for(int i=1; i<m+1; i++){
//            if(s1.charAt(i-1)==s3.charAt(i-1) && dp[i-1][0]){
//                dp[i][0]=true;
//            }
//        }
//        for(int i=1; i<n+1; i++){
//            if(s2.charAt(i-1)==s3.charAt(i-1) && dp[0][i-1]){
//                dp[0][i]=true;
//            }
//        }
//        for(int i=1; i<m+1; i++){
//            for(int j=1; j<n+1; j++){
//                if(dp[i-1][j]){
//                    if(s1.charAt(i-1)==s3.charAt(i+j-1)){
//                        dp[i][j]=true;
//                    }
//                } else if(dp[i][j-1]){
//                    if(s2.charAt(j-1)==s3.charAt(i+j-1)){
//                        dp[i][j]=true;
//                    }
//                }
//            }
//        }
//        return dp[m][n];
//    }
}
