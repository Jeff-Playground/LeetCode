package com.wen.SixteenthFifty;

import java.util.HashSet;
import java.util.Set;

public class CrackingTheSafe {
//    public String crackSafe(int n, int k) {
//        StringBuilder result=new StringBuilder();
//        for(int i=0; i<n-1; i++){
//            result.append("0");
//        }
//        Set<String> visited=new HashSet<>();
//        crackSafeHelper(result, visited, (int)Math.pow(k, n), n, k);
//        return result.toString();
//    }
//
//    public void crackSafeHelper(StringBuilder result, Set<String> visited, int count, int n, int k){
//        if(visited.size()==count){
//            return;
//        }
//        String cur=result.substring(result.length()-n+1);
//        // Note here uses reverse traversal
//        for(int i=k-1; i>=0; i--){
//            if(!visited.contains(cur+i)){
//                visited.add(cur+i);
//                result.append(i);
//                crackSafeHelper(result, visited, count, n, k);
//                break;
//            }
//        }
//    }

//    public String crackSafe(int n, int k) {
//        StringBuilder result=new StringBuilder();
//        for(int i=0; i<n-1; i++){
//            result.append("0");
//        }
//        Set<String> visited=new HashSet<>();
//        for(int i=0; i<Math.pow(k, n); i++){
//            String cur=result.substring(result.length()-n+1);
//            // Note here uses reverse traversal
//            for(int j=k-1; j>=0; j--){
//                if(!visited.contains(cur+j)){
//                    visited.add(cur+j);
//                    result.append(j);
//                    break;
//                }
//            }
//        }
//        return result.toString();
//    }

    // Convert the problem to finding euler path in a graph
    public String crackSafe(int n, int k) {
        if(n==1 && k==1){
            return "0";
        }
        Set<String> seen=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        StringBuilder result=new StringBuilder();
        for(int i=0; i<n-1; i++){
            sb.append("0");
        }
        String start=sb.toString();
        crackSafeDFS(start, k, seen, result);
        result.append(start);
        return result.toString();
    }

    public void crackSafeDFS(String node, int k, Set<String> seen, StringBuilder result){
        for(int i=0; i<k; i++){
            String next=node+i;
            if(!seen.contains(next)){
                seen.add(next);
                crackSafeDFS(next.substring(1), k, seen, result);
                result.append(i);
            }
        }
    }
}
