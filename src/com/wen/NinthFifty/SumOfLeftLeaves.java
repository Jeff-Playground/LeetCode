package com.wen.NinthFifty;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SumOfLeftLeaves {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Inorder traversal
    public int sumOfLeftLeaves(TreeNode root) {
        int result=0;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                if(cur.left!=null && cur.left.left==null && cur.left.right==null){
                    result+=cur.left.val;
                }
                cur=cur.left;
            } else{
                cur=stack.pop();
                cur=cur.right;
            }
        }
        return result;
    }

//    // Level order traversal
//    public int sumOfLeftLeaves(TreeNode root) {
//        if(root==null){
//            return 0;
//        } else{
//            int result=0;
//            Queue<TreeNode> q=new LinkedList<>();
//            q.offer(root);
//            while(!q.isEmpty()){
//                TreeNode cur=q.poll();
//                if(cur.left!=null && cur.left.left==null && cur.left.right==null){
//                    result+=cur.left.val;
//                }
//                if(cur.left!=null){
//                    q.offer(cur.left);
//                }
//                if(cur.right!=null){
//                    q.offer(cur.right);
//                }
//            }
//            return result;
//        }
//    }

//    // Inorder traversal recursively
//    public int sumOfLeftLeaves(TreeNode root) {
//        if(root==null){
//            return 0;
//        } else{
//            int left=sumOfLeftLeaves(root.left), right=sumOfLeftLeaves(root.right);
//            if(root.left!=null && root.left.left==null && root.left.right==null){
//                return left+right+root.left.val;
//            } else{
//                return left+right;
//            }
//        }
//    }
}
