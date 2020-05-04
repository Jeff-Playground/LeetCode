package com.wen.NinthFifty;

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

    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        } else{
            int left=sumOfLeftLeaves(root.left), right=sumOfLeftLeaves(root.right);
            return left+right+(root.left!=null?root.left.val:0);
        }
    }
}
