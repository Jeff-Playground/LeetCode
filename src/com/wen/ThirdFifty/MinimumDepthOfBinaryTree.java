package com.wen.ThirdFifty;

public class MinimumDepthOfBinaryTree {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        if(root.left==null){
            return 1+minDepth(root.right);
        } else if(root.right==null){
            return 1+minDepth(root.left);
        } else{
            return 1+Math.min(minDepth(root.left), minDepth(root.right));
        }
    }
}
