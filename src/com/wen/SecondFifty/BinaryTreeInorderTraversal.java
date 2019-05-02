package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // Morris Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            } else{
                cur=stack.pop();
                result.add(cur.val);
                cur=cur.right;
            }
        }
        return  result;
    }

//    // Iterative with Stack
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result=new ArrayList<>();
//        Stack<TreeNode> stack=new Stack<>();
//        TreeNode cur=root;
//        while(cur!=null || !stack.isEmpty()){
//            while(cur!=null){
//                stack.push(cur);
//                cur=cur.left;
//            }
//            cur=stack.pop();
//            result.add(cur.val);
//            cur=cur.right;
//        }
//        return  result;
//    }

//    // Recursive
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result=new ArrayList<>();
//        inorder(root, result);
//        return result;
//    }
//
//    private void inorder(TreeNode root, List<Integer> result) {
//        if(root!=null){
//            if(root.left!=null){
//                inorder(root.left, result);
//            }
//            result.add(root.val);
//            if(root.right!=null){
//                inorder(root.right, result);
//            }
//        }
//    }
}
