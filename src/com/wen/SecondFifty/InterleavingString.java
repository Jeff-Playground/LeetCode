package com.wen.SecondFifty;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class InterleavingString {
//    // BFS
//    public static boolean isInterleave(String s1, String s2, String s3) {
//        int l1=s1.length(), l2=s2.length(), l3=s3.length(), l=0;
//        if(l1+l2!=l3){
//            return false;
//        }
//        Set<Integer> set=new HashSet<>();
//        Queue<Integer> queue=new LinkedList<>();
//        queue.add(0);
//        while(!queue.isEmpty() && l<l3){
//            int len= queue.size();
//            for(int t=0; t<len; t++){
//                int key=queue.poll();
//                int i= key/l3, j=key%l3;
//                if(i<l1 && s1.charAt(i)==s3.charAt(l)){
//                    int newKey=(i+1)*l3+j;
//                    if(!set.contains(newKey)){
//                        set.add(newKey);
//                        queue.add(newKey);
//                    }
//                }
//                if(j<l2 && s2.charAt(j)==s3.charAt(l)){
//                    int newKey=i*l3+j+1;
//                    if(!set.contains(newKey)){
//                        set.add(newKey);
//                        queue.add(newKey);
//                    }
//                }
//            }
//            l++;
//        }
//        // Note here !queue.isEmpty() means the l==l3 is reachable
//        return !queue.isEmpty() && l==l3;
//    }

//    // DFS
//    public static boolean isInterleave(String s1, String s2, String s3) {
//        if(s1.length()+s2.length()!=s3.length()){
//            return false;
//        }
//        Set<Integer> set=new HashSet<>();
//        return isInterleaveDFS(s1, 0, s2, 0, s3, 0, set);
//    }
//
//    private static boolean isInterleaveDFS(String s1, int i1, String s2, int i2, String s3, int i3, Set<Integer> set) {
//        int key=i1*s3.length()+i2;
//        if(set.contains(key)){
//            return false;
//        }
//        if(i1==s1.length()){
//            return s2.substring(i2).equals(s3.substring(i3));
//        }
//        if(i2==s2.length()){
//            return s1.substring(i1).equals(s3.substring(i3));
//        }
//        if(s1.charAt(i1)==s3.charAt(i3) && isInterleaveDFS(s1, i1+1, s2, i2, s3, i3+1, set) ||
//                s2.charAt(i2)==s3.charAt(i3) && isInterleaveDFS(s1, i1, s2, i2+1, s3, i3+1, set)){
//            return true;
//        }
//        set.add(key);
//        return false;
//    }

    // Dynamic Programming
    // dp[i][j] stands for whether s3.substring(0, i+j+1) is the interleaving of s1.substring(0, i+1) and
    // s2.substring(0, j+1)
    public static boolean isInterleave(String s1, String s2, String s3) {
        int l1=s1.length(), l2=s2.length();
        if(l1+l2!=s3.length()){
            return false;
        }
        boolean[][] dp=new boolean[l1+1][l2+1];
        dp[0][0]=true;
        for(int i=1; i<l1+1; i++){
            if(s1.charAt(i-1)==s3.charAt(i-1) && dp[i-1][0]){
                dp[i][0]=true;
            }
        }
        for(int i=1; i<l2+1; i++){
            if(s2.charAt(i-1)==s3.charAt(i-1) && dp[0][i-1]){
                dp[0][i]=true;
            }
        }
        for(int i=1; i<l1+1; i++){
            for(int j=1; j<l2+1; j++){
                if(dp[i-1][j]){
                    if(s1.charAt(i-1)==s3.charAt(i+j-1)){
                        dp[i][j]=true;
                    }
                }
                if(!dp[i][j] && dp[i][j-1]){
                    if(s2.charAt(j-1)==s3.charAt(i+j-1)){
                        dp[i][j]=true;
                    }
                }
            }
        }
        return dp[l1][l2];
    }
}
