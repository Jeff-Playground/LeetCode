package com.wen.FifteenthFifty;

import java.util.*;

public class LQClosestLeafInABinaryTree {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public static int findClosestLeaf(TreeNode root, int k) {
        int[] result=new int[]{-1}, min=new int[]{Integer.MAX_VALUE};
        Map<Integer, Integer> map=new HashMap<>();
        map.put(k, 0);
        find(root, k, map);
        findClosestLeafDFS(root, map.get(root.val), map, min, result);
        return result[0];
    }

    public static void findClosestLeafDFS(TreeNode node, int cur, Map<Integer, Integer> map, int[] min, int[] result) {
        if(node==null){
            return;
        }
        // Introduce a flag to determine which branch to traverse first
        int loc=1;
        if(map.containsKey(node.val)){
            loc=map.get(node.val);
            cur=Math.abs(loc);
        }
        if(node.left==null && node.right==null){
            if(min[0]>=cur){
                min[0]=cur;
                result[0]=node.val;
            }
        }
        if(loc>=0){
            findClosestLeafDFS(node.right, cur+1, map, min, result);
            findClosestLeafDFS(node.left, cur+1, map, min, result);
        } else{
            findClosestLeafDFS(node.left, cur+1, map, min, result);
            findClosestLeafDFS(node.right, cur+1, map, min, result);
        }
    }

    // This finds the distance from all parents in different levels to k
    public static int find(TreeNode node, int k, Map<Integer, Integer> map) {
        if(node==null){
            return -1;
        }
        if(node.val==k){
            // Called from parent, so distance starts from 1
            return 1;
        }
        int r=find(node.left, k, map);
        if(r!=-1){
            map.put(node.val, r);
            return r+1;
        }
        r=find(node.right, k, map);
        if(r!=-1){
            map.put(node.val, -r);
            return r+1;
        }
        return -1;
    }

//    // Construct a graph for nodes until k, so BFS can be performed backwards to parents
//    public static int findClosestLeaf(TreeNode root, int k) {
//        Map<TreeNode, TreeNode> back=new HashMap<>();
//        TreeNode kNode=constructGraphUntilK(back, root, k);
//        Queue<TreeNode> queue=new LinkedList<>();
//        Set<TreeNode> visited=new HashSet<>();
//        queue.offer(kNode);
//        visited.add(kNode);
//        while(!queue.isEmpty()){
//            TreeNode cur=queue.poll();
//            if(cur.left==null && cur.right==null){
//                return cur.val;
//            } else{
//                // Check left child
//                if(cur.left!=null && !visited.contains(cur.left)){
//                    queue.offer(cur.left);
//                    visited.add(cur.left);
//                }
//                // Check right child
//                if(cur.right!=null && !visited.contains(cur.right)){
//                    queue.offer(cur.right);
//                    visited.add(cur.right);
//                }
//                // Check backwards to parent
//                if(back.containsKey(cur) && !visited.contains(back.get(cur))){
//                    queue.offer(back.get(cur));
//                    visited.add(back.get(cur));
//                }
//            }
//        }
//        return -1;
//    }
//
//    // This stops when k is found
//    public static TreeNode constructGraphUntilK(Map<TreeNode, TreeNode> back, TreeNode node, int k){
//        if(node.val==k){
//            return node;
//        }
//        // k is on the left side
//        if(node.left!=null){
//            back.put(node.left, node);
//            TreeNode left=constructGraphUntilK(back, node.left, k);
//            if(left!=null){
//                return left;
//            }
//        }
//        // k is one the right side
//        if(node.right!=null){
//            back.put(node.right, node);
//            TreeNode right=constructGraphUntilK(back, node.right, k);
//            if(right!=null){
//                return right;
//            }
//        }
//        return null;
//    }
}
