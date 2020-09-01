package com.wen.FourteenthFifty;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TwoSumIVInputIsABST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Inorder traversal iteratively
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        } else{
            Set<Integer> visited=new HashSet<>();
            TreeNode cur=root;
            Stack<TreeNode> stack=new Stack<>();
            while(!stack.isEmpty() || cur!=null){
                if(cur!=null){
                    stack.push(cur);
                    cur=cur.left;
                } else{
                    cur=stack.pop();
                    if(visited.contains(k-cur.val)){
                        return true;
                    }
                    visited.add(cur.val);
                    cur=cur.right;
                }
            }
            return false;
        }
    }

//    // Pre-order traversal recursively
//    public boolean findTarget(TreeNode root, int k) {
//        Set<Integer> visited=new HashSet<>();
//        return findTarget(root, k, visited);
//    }
//
//    private boolean findTarget(TreeNode cur, int k, Set<Integer> visited){
//        if(cur==null){
//            return false;
//        }
//        if(visited.contains(k-cur.val)){
//            return true;
//        } else{
//            visited.add(cur.val);
//            return findTarget(cur.left, k, visited) || findTarget(cur.right, k, visited);
//        }
//    }
}
