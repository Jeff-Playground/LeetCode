package com.wen.FourthFifty;

public class LQBinaryTreeUpsideDown {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // Iterative
    public static TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur=root, pre=null, next=null, temp=null;
        while(cur!=null){
            next=cur.left;
            cur.left=temp;
            temp=cur.right;
            cur.right=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

//    // Recursive
//    public static TreeNode upsideDownBinaryTree(TreeNode root) {
//        if(root==null || root.left==null){
//            return root;
//        }
//        TreeNode left=root.left, right=root.right;
//        TreeNode result=upsideDownBinaryTree(left);
//        left.left=right;
//        left.right=root;
//        root.left=null;
//        root.right=null;
//        return result;
//    }
}
