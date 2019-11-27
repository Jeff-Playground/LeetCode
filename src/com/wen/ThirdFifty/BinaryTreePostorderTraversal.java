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

//    // Morris Traversal 1 (new dummy node)
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> result=new ArrayList<>();
//        TreeNode dummy=new TreeNode(-1);
//        dummy.left=root;
//        TreeNode cur=dummy, pre=null;
//        while(cur!=null){
//            if(cur.left!=null){
//                pre=cur.left;
//                while(pre.right!=null && pre.right!=cur){
//                    pre=pre.right;
//                }
//                if(pre.right==null){
//                    pre.right=cur;
//                    cur=cur.left;
//                } else {
//                    pre.right=null;
//                    TreeNode temp=cur.left;
//                    int index=result.size();
//                    while(temp!=null){
//                        result.add(index, temp.val);
//                        temp=temp.right;
//                    }
//                    cur=cur.right;
//                }
//            } else{
//                cur=cur.right;
//            }
//        }
//        return result;
//    }

    // Morris Traversal 2 (modified based on preorder traversal)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        TreeNode cur=root, pre=null;
        while(cur!=null){
            if(cur.right!=null){
                pre=cur.right;
                while(pre.left!=null && pre.left!=cur){
                    pre=pre.left;
                }
                if(pre.left==null){
                    result.add(0, cur.val);
                    pre.left=cur;
                    cur=cur.right;
                } else{
                    pre.left=null;
                    cur=cur.left;
                }
            } else{
                result.add(0, cur.val);
                cur=cur.left;
            }
        }
        return result;
    }

//    // Iterative using a stack
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> result=new ArrayList<>();
//        TreeNode cur=root, pre=null;
//        Stack<TreeNode> stack=new Stack<>();
//        while(cur!=null || !stack.isEmpty()){
//            if(cur!=null){
//                result.add(0, cur.val);
//                stack.push(cur);
//                cur=cur.right;
//            } else{
//                cur=stack.pop();
//                cur=cur.left;
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
