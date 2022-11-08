package com.wen.FifthFifty;

public class LowestCommonAncestorOfABinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    // Iterative
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        int max=Math.max(p.val, q.val);
//        int min=Math.min(p.val, q.val);
//        while(root.val<min || root.val>max){
//            if(root.val<min){
//                root=root.right;
//            } else{
//                root=root.left;
//            }
//        }
//        return root;
//    }

    // Recursive
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int minValue=Math.min(p.val, q.val), maxValue=Math.max(p.val, q.val);
        if(root.val<minValue){
            return lowestCommonAncestor(root.right, p, q);
        } else if(root.val>maxValue){
            return lowestCommonAncestor(root.left, p, q);
        } else{
            return root;
        }
    }
}
