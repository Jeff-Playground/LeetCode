package com.wen.ThirdFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }


    // Morris Traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        TreeNode cur=root, pre=null;
        while(cur!=null){
            if(cur.left!=null){
                pre=cur.left;
                while(pre.right!=null && pre.right!=cur){
                    pre=pre.right;
                }
                if(pre.right==null){
                    result.add(cur.val);
                    pre.right=cur;
                    cur=cur.left;
                } else{
                    pre.right=null;
                    cur=cur.right;
                }
            } else{
                result.add(cur.val);
                cur=cur.right;
            }
        }
        return result;
    }

//    // Iterative using a stack
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> result=new ArrayList<>();
//        TreeNode cur=root;
//        Stack<TreeNode> stack=new Stack<>();
//        while(cur!=null || !stack.isEmpty()){
//            if(cur!=null){
//                result.add(cur.val);
//                stack.push(cur);
//                cur=cur.left;
//            } else{
//                cur=stack.pop();
//                cur=cur.right;
//            }
//        }
//        return result;
//    }

//    // Recursive
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> result=new ArrayList<>();
//        preorderTraversalDFS(root, result);
//        return result;
//    }
//
//    private void preorderTraversalDFS(TreeNode node, List<Integer> result) {
//        if(node==null){
//            return;
//        }
//        result.add(node.val);
//        if(node.left!=null){
//            preorderTraversalDFS(node.left, result);
//        }
//        if(node.right!=null){
//            preorderTraversalDFS(node.right, result);
//        }
//    }
}
