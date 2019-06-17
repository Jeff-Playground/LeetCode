package com.wen.FifthFifty;

public class LowestCommonAncestorOfABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        } else{
            TreeNode left=lowestCommonAncestor(root.left, p, q);
            TreeNode right=lowestCommonAncestor(root.right, p, q);
            if(left!=null && right!=null){
                return root;
            } else if(left==null && right!=null){
                return right;
            } else if(left!=null && right==null){
                return left;
            } else{
                return null;
            }
        }
    }
}
