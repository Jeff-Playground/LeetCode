package com.wen.EighteenthFifty;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    // Create a new map contains parent info so the traverse can go from child to parent, then BFS from target
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//        List<Integer> result=new ArrayList<>();
//        Map<TreeNode, TreeNode> parent=new HashMap<>();
//        findParents(root, parent);
//        Queue<TreeNode> q=new LinkedList<>();
//        q.offer(target);
//        int dist=0;
//        Set<TreeNode> visited=new HashSet<>();
//        visited.add(target);
//        while(!q.isEmpty() && dist<=k){
//            int size=q.size();
//            while(size-->0){
//                TreeNode cur=q.poll();
//                if(dist==k){
//                    result.add(cur.val);
//                } else{
//                    if(cur.left!=null && !visited.contains(cur.left)){
//                        visited.add(cur.left);
//                        q.offer(cur.left);
//                    }
//                    if(cur.right!=null && !visited.contains(cur.right)){
//                        visited.add(cur.right);
//                        q.offer(cur.right);
//                    }
//                    if(parent.containsKey(cur) && !visited.contains(parent.get(cur))){
//                        visited.add(parent.get(cur));
//                        q.offer(parent.get(cur));
//                    }
//                }
//            }
//            dist++;
//        }
//        return result;
//    }
//
//    private void findParents(TreeNode node, Map<TreeNode, TreeNode> parent){
//        if(node.left!=null){
//            parent.put(node.left, node);
//            findParents(node.left, parent);
//        }
//        if(node.right!=null){
//            parent.put(node.right, node);
//            findParents(node.right, parent);
//        }
//    }

//    // Convert tree into a graph, then do a BFS from the target node
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//        List<Integer> result=new ArrayList<>();
//        Map<TreeNode, Set<TreeNode>> graph=new HashMap<>();
//        buildGraph(root, graph);
//        Queue<TreeNode> q=new LinkedList<>();
//        q.offer(target);
//        int dist=0;
//        Set<TreeNode> visited=new HashSet<>();
//        visited.add(target);
//        while(!q.isEmpty() && dist<=k){
//            int size=q.size();
//            while(size-->0){
//                TreeNode cur=q.poll();
//                if(dist==k){
//                    result.add(cur.val);
//                } else{
//                    for(TreeNode next: graph.get(cur)){
//                        if(!visited.contains(next)){
//                            visited.add(next);
//                            q.offer(next);
//                        }
//                    }
//                }
//            }
//            dist++;
//        }
//        return result;
//    }
//
//    private void buildGraph(TreeNode node, Map<TreeNode, Set<TreeNode>> graph){
//        if(node!=null){
//            graph.putIfAbsent(node, new HashSet<>());
//            if(node.left!=null){
//                graph.get(node).add(node.left);
//                graph.putIfAbsent(node.left, new HashSet<>());
//                graph.get(node.left).add(node);
//                buildGraph(node.left, graph);
//            }
//            if(node.right!=null){
//                graph.get(node).add(node.right);
//                graph.putIfAbsent(node.right, new HashSet<>());
//                graph.get(node.right).add(node);
//                buildGraph(node.right, graph);
//            }
//        }
//    }

//    // Recursive, use a helper function which can cover both nodes above and below target
//    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//        List<Integer> result=new ArrayList<>();
//        if(k==0){
//            result.add(target.val);
//        } else{
//            dkHelper(root, 0, target, k, result);
//        }
//        return result;
//    }
//
//    // This helper functions does 2 things:
//    //      For nodes above target, it checks the return value which contains the dist to target
//    //      For nodes under target, it checks the input value for dist which contains the dist to target
//    private int dkHelper(TreeNode node, int dist, TreeNode target, int k, List<Integer> result){
//        if(node==null){
//            return 0;
//        } else{
//            // For target node
//            if(node==target){
//                dkHelper(node.left, 1, target, k, result);
//                dkHelper(node.right, 1, target, k, result);
//                return 1;
//            }
//            // For nodes under target
//            if(dist==k){
//                result.add(node.val);
//                return 0;
//            } else if(dist>0){
//                dkHelper(node.left, dist+1, target, k, result);
//                dkHelper(node.right, dist+1, target, k, result);
//                return 0;
//            }
//            // For nodes above target
//            int left=dkHelper(node.left, 0, target, k, result);
//            if(left>0){
//                if(left==k){
//                    result.add(node.val);
//                    return 0;
//                } else{
//                    dkHelper(node.right, left+1, target, k, result);
//                    return left+1;
//                }
//            } else{
//                int right=dkHelper(node.right, 0, target, k, result);
//                if(right>0){
//                    if(right==k){
//                        result.add(node.val);
//                        return 0;
//                    } else{
//                        dkHelper(node.left, right+1, target, k, result);
//                        return right+1;
//                    }
//                } else{
//                    return 0;
//                }
//            }
//        }
//    }
}
