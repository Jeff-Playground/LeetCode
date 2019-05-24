package com.wen.ThirdFifty;

public class BalancedBinaryTree {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // Recursive, optimized by stopping at any point when depth diff is greater than 1
    public boolean isBalanced(TreeNode root) {
        if(checkDepth(root)==-1){
            return false;
        } else{
            return true;
        }
    }

    private int checkDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=checkDepth(root.left);
        if(left==-1){
            return -1;
        }
        int right=checkDepth(root.right);
        if(right==-1){
            return -1;
        }
        int diff=Math.abs(left-right);
        if(diff>1){
            return -1;
        } else{
            return 1+Math.max(left, right);
        }
    }

//    // Recursive, get depth for all nodes
//    public boolean isBalanced(TreeNode root) {
//        if(root==null){
//            return true;
//        }
//        if(Math.abs(getDepth(root.left)-getDepth(root.right))>1){
//            return false;
//        }
//        return isBalanced(root.left) && isBalanced(root.right);
//    }
//
//    private int getDepth(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        return Math.max(getDepth(root.left), getDepth(root.right))+1;
//    }
}
