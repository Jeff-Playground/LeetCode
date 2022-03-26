package com.wen.SixteenthFifty;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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

//    // Convert the problem to finding Eulerian path in a graph
//    // The idea is each possible combination of length n is an edge in the graph, and each vertex in the graph would be
//    // of length n-1, for example, 0010->0101 will produce edge 00101, so this becomes to find the Eulerian path/circuit
//    // of the graph
//    public String crackSafe(int n, int k) {
//        StringBuilder start=new StringBuilder();
//        for(int i=0; i<n-1; i++){
//            start.append('0');
//        }
//        StringBuilder sb=new StringBuilder();
//        Set<String> visitedEdges=new HashSet<>();
//        csHelper(k, start.toString(), visitedEdges, sb);
//        sb.append(start);
//        return sb.toString();
//    }
//
//    private void csHelper(int k, String cur, Set<String> visitedEdges, StringBuilder sb){
//        for(int i=0; i<k; i++){
//            String edge=cur+i;
//            if(!visitedEdges.contains(edge)){
//                visitedEdges.add(edge);
//                csHelper(k, edge.substring(1), visitedEdges, sb);
//                sb.append(i);
//            }
//        }
//    }

    // Eulerian path with a Stack
    public String crackSafe(int n, int k) {
        StringBuilder sb=new StringBuilder();
        if(n==1){
            for(int i=0; i<k; i++){
                sb.append(i);
            }
        } else{
            StringBuilder start=new StringBuilder();
            for(int i=0; i<n-1; i++){
                start.append('0');
            }
            Set<String> visitedEdges=new HashSet<>();
            Stack<String> stack=new Stack<>();
            stack.push(start.toString());
            while(!stack.isEmpty()){
                String cur=stack.peek();
                boolean found=false;
                for(int i=0; i<k; i++){
                    String edge=cur+i;
                    if(!visitedEdges.contains(edge)){
                        stack.push(edge.substring(1));
                        visitedEdges.add(edge);
                        found=true;
                        break;
                    }
                }
                if(!found){
                    stack.pop();
                    sb.append(cur.charAt(cur.length()-1));
                }
            }
            sb.append(start.substring(0, start.length()-1));
        }
        return sb.toString();
    }
}
