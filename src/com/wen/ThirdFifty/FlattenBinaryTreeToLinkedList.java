package com.wen.ThirdFifty;

public class FlattenBinaryTreeToLinkedList {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // Iterative
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode cur=root;
        while(cur!=null){
            if(cur.left!=null){
                TreeNode temp=cur.left;
                while(temp.right!=null){
                    temp=temp.right;
                }
                temp.right=cur.right;
                cur.right=cur.left;
                cur.left=null;
            }
            cur=cur.right;
        }
    }

//    // Recursive
//    public void flatten(TreeNode root) {
//        if(root==null){
//            return;
//        }
//        if(root.left!=null){
//            flatten(root.left);
//        }
//        if(root.right!=null){
//            flatten(root.right);
//        }
//        TreeNode temp=root.right;
//        root.right=root.left;
//        root.left=null;
//        while(root.right!=null){
//            root=root.right;
//        }
//        root.right=temp;
//    }
}
