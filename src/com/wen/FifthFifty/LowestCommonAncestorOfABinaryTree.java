package com.wen.FifthFifty;

public class LowestCommonAncestorOfABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p || root==q){
            return root;
        } else{
            TreeNode leftResult=lowestCommonAncestor(root.left, p, q);
            TreeNode rightResult=lowestCommonAncestor(root.right, p, q);
            if(leftResult==null && rightResult==null){
                return null;
            } else if(leftResult==null){
                return rightResult;
            } else if(rightResult==null){
                return leftResult;
            } else{
                return root;
            }
        }
    }
}
