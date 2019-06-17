package com.wen.FifthFifty;

public class LowestCommonAncestorOfABinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int max=Math.max(p.val, q.val);
        int min=Math.min(p.val, q.val);
        while(root.val<min || root.val>max){
            if(root.val<min){
                root=root.right;
            } else{
                root=root.left;
            }
        }
        return root;
    }
}
