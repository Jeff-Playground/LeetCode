package com.wen.ThirdFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // Iterative 2 with Stack(template)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(!stack.isEmpty() || cur!=null){
            if(cur!=null){
                stack.push(cur);
                result.add(0, cur.val);
                cur=cur.right;
            } else{
                TreeNode temp=stack.pop();
                cur=temp.left;
            }
        }
        return result;
    }

//    // Do preorder traversal and then insert the values to result in reverse order
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> result=new ArrayList<>();
//        if(root==null){
//            return result;
//        }
//        Stack<TreeNode> stack=new Stack<>();
//        stack.push(root);
//        while(!stack.isEmpty()){
//            TreeNode cur=stack.pop();
//            result.add(0, cur.val);
//            if(cur.left!=null){
//                stack.push(cur.left);
//            }
//            if(cur.right!=null){
//                stack.push(cur.right);
//            }
//        }
//        return result;
//    }

//    // Iterative using a stack
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> result=new ArrayList<>();
//        if(root==null){
//            return result;
//        }
//        Stack<TreeNode> stack=new Stack<>();
//        stack.push(root);
//        TreeNode pre=null;
//        while(!stack.isEmpty()){
//            TreeNode cur=stack.peek();
//            if(cur.left==null && cur.right==null ||(pre!=null && (cur.left==pre || cur.right==pre))){
//                pre=stack.pop();
//                result.add(cur.val);
//            } else {
//                if(cur.right!=null){
//                    stack.push(cur.right);
//                }
//                if(cur.left!=null){
//                    stack.push(cur.left);
//                }
//            }
//        }
//        return result;
//    }

//    // Recursive
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> result=new ArrayList<>();
//        postorderTraversalDFS(root, result);
//        return result;
//    }
//
//    private void postorderTraversalDFS(TreeNode node, List<Integer> result) {
//        if(node==null){
//            return;
//        }
//        if(node.left!=null){
//            postorderTraversalDFS(node.left, result);
//        }
//        if(node.right!=null){
//            postorderTraversalDFS(node.right, result);
//        }
//        result.add(node.val);
//    }
}
