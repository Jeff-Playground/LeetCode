package com.wen.NinthFifty;

import java.util.*;

public class MinimumGeneticMutation {
    // BFS
    public int minMutation(String start, String end, String[] bank) {
        int l=bank.length;
        int[][] dist=new int[l][l];
        for(int i=0; i<l; i++){
            for(int j=i+1; j<l; j++){
                dist[i][j]=getDiff(bank[i], bank[j]);
                dist[j][i]=getDiff(bank[i], bank[j]);
            }
        }
        int result=0;
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> visited=new HashSet<>();
        for(int i=0; i<l; i++){
            if(getDiff(start, bank[i])==1){
                q.offer(i);
                visited.add(i);
            }
        }
        while(!q.isEmpty()){
            result++;
            int size=q.size();
            while(size-->0){
                int cur=q.poll();
                if(bank[cur].equals(end)){
                    return result;
                }
                for(int j=0; j<l; j++){
                    if(dist[cur][j]==1 && !visited.contains(j)){
                        visited.add(j);
                        q.offer(j);
                    }
                }
            }
        }
        return -1;
    }

//    // DFS
//    public static int minMutation(String start, String end, String[] bank) {
//        Set<String> bankSet=new HashSet<>(Arrays.asList(bank));
//        if(bankSet.contains(end)){
//            int[] result=new int[]{-1};
//            Set<String> visited=new HashSet<>();
//            mmHelper(start, 0, end, visited, bankSet, result);
//            return result[0];
//        } else{
//            return -1;
//        }
//    }
//
//    private static void mmHelper(String cur, int count, String end, Set<String> visited, Set<String> bank, int[] result) {
//        if(cur.equals(end)){
//            result[0]=result[0]==-1?count:Math.min(result[0], count);
//        } else{
//            visited.add(cur);
//            for(String e: bank){
//                if(!visited.contains(e) && getDiff(cur, e)==1){
//                    mmHelper(e, count+1, end, visited, bank, result);
//                }
//            }
//            visited.remove(cur);
//        }
//    }

    private static int getDiff(String s1, String s2){
        int result=0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                result++;
            }
        }
        return result;
    }
}
