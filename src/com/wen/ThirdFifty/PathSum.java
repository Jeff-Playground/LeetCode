package com.wen.ThirdFifty;

public class PathSum {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null && root.val==sum){
            return true;
        } else{
            return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
        }
    }
}
