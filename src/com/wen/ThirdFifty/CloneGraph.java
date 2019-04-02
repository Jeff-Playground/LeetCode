package com.wen.ThirdFifty;

import java.util.*;

public class CloneGraph {
    public static class UndirectedGraphNode {
        int label;
        public List<UndirectedGraphNode> neighbors;
        public UndirectedGraphNode(int x) {
            label = x; neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

//    // DFS recursive
//    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        Map<Integer, UndirectedGraphNode> visited=new HashMap<>();
//        return cloneGraphDFS(visited, node);
//    }
//
//    private UndirectedGraphNode cloneGraphDFS(Map<Integer, UndirectedGraphNode> visited, UndirectedGraphNode node) {
//        if(node==null){
//            return null;
//        }
//        if(visited.get(node.label)==null){
//            UndirectedGraphNode copy=new UndirectedGraphNode(node.label);
//            visited.put(node.label, copy);
//            for(UndirectedGraphNode n: node.neighbors){
//                copy.neighbors.add(cloneGraphDFS(visited, n));
//            }
//            return copy;
//        } else{
//            return visited.get(node.label);
//        }
//    }

//    // DFS with Stack, this can be further optimized to get rid of visited. The underlying logic is to ensure no duplicates enters the stack.
//    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        if(node==null){
//            return null;
//        }
//        Set<Integer> visited=new HashSet<>();
//        Map<Integer, UndirectedGraphNode> created=new HashMap<>();
//        Stack<UndirectedGraphNode> stack=new Stack<>();
//        stack.push(node);
//        while(!stack.isEmpty()){
//            UndirectedGraphNode cur=stack.pop();
//            if(visited.contains(cur.label)){
//                continue;
//            }
//            visited.add(cur.label);
//            UndirectedGraphNode copy=null;
//            if(created.get(cur.label)==null){
//                copy=new UndirectedGraphNode(cur.label);
//                created.put(cur.label, copy);
//            } else{
//                copy=created.get(cur.label);
//            }
//            for(UndirectedGraphNode n: cur.neighbors){
//                stack.push(n);
//                UndirectedGraphNode nCopy=null;
//                if(created.get(n.label)==null){
//                    nCopy=new UndirectedGraphNode(n.label);
//                    created.put(n.label, nCopy);
//                } else{
//                    nCopy=created.get(n.label);
//                }
//                copy.neighbors.add(nCopy);
//            }
//        }
//        return created.get(node.label);
//    }

//    // BFS, this can be further optimized to get rid of visited. The underlying logic is to ensure no duplicates enters the queue.
//    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
//        if(node==null){
//            return null;
//        }
//        Set<Integer> visited=new HashSet<>();
//        Map<Integer, UndirectedGraphNode> created=new HashMap<>();
//        Queue<UndirectedGraphNode> queue=new LinkedList<>();
//        queue.offer(node);
//        while(!queue.isEmpty()){
//            for(int i=queue.size(); i>0; i--){
//                UndirectedGraphNode cur=queue.poll();
//                if(visited.contains(cur.label)){
//                    continue;
//                }
//                visited.add(cur.label);
//                UndirectedGraphNode copy=null;
//                if(created.get(cur.label)==null){
//                    copy=new UndirectedGraphNode(cur.label);
//                    created.put(cur.label, copy);
//                } else{
//                    copy=created.get(cur.label);
//                }
//                for(UndirectedGraphNode n: cur.neighbors){
//                    queue.offer(n);
//                    UndirectedGraphNode nCopy=null;
//                    if(created.get(n.label)==null){
//                        nCopy=new UndirectedGraphNode(n.label);
//                        created.put(n.label, nCopy);
//                    } else{
//                        nCopy=created.get(n.label);
//                    }
//                    copy.neighbors.add(nCopy);
//                }
//            }
//        }
//        return created.get(node.label);
//    }

    // BFS, optimized to get rid of visited (Basically just use created as visited)
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null){
            return null;
        }
        Map<Integer, UndirectedGraphNode> created=new HashMap<>();
        Queue<UndirectedGraphNode> queue=new LinkedList<>();
        UndirectedGraphNode nodeCopy=new UndirectedGraphNode(node.label);
        created.put(node.label, nodeCopy);
        queue.offer(node);
        while(!queue.isEmpty()){
            for(int i=queue.size(); i>0; i--){
                UndirectedGraphNode cur=queue.poll();
                for(UndirectedGraphNode n: cur.neighbors){
                    if(created.get(n.label)==null){
                        queue.offer(n);
                        UndirectedGraphNode nCopy=new UndirectedGraphNode(n.label);
                    }
                    UndirectedGraphNode nCopy=null;
                    if(created.get(n.label)==null){
                        nCopy=new UndirectedGraphNode(n.label);
                        created.put(n.label, nCopy);
                    }
                    cur.neighbors.add(created.get(n.label));
                }
            }
        }
        return created.get(node.label);
    }
}
