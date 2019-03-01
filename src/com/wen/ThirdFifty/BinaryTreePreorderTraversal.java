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

    // Iterative 2 with Stack(template)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(!stack.isEmpty() || cur!=null){
            if(cur!=null){
                stack.push(cur);
                result.add(cur.val);
                cur=cur.left;
            } else{
                TreeNode temp=stack.pop();
                cur=temp.right;
            }
        }
        return result;
    }

//    // Iterative using a stack
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> result=new ArrayList<>();
//        if(root==null){
//            return result;
//        }
//        Stack<TreeNode> stack=new Stack<>();
//        stack.push(root);
//        while(!stack.isEmpty()){
//            TreeNode cur=stack.pop();
//            result.add(cur.val);
//            if(cur.right!=null){
//                stack.push(cur.right);
//            }
//            if(cur.left!=null){
//                stack.push(cur.left);
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
