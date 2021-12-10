package com.wen.FourteenthFifty;

public class TrimABinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Iterative
    public TreeNode trimBST(TreeNode root, int low, int high) {
        while(root!=null && (root.val<low || root.val>high)){
            root=root.val<low?root.right:root.left;
        }
        if(root!=null){
            TreeNode cur=root;
            while(cur!=null){
                while(cur.left!=null && cur.left.val<low){
                    cur.left=cur.left.right;
                }
                cur=cur.left;
            }
            cur=root;
            while(cur!=null){
                while(cur.right!=null && cur.right.val>high){
                    cur.right=cur.right.left;
                }
                cur=cur.right;
            }
        }
        return root;
    }

//    // Recursive
//    public TreeNode trimBST(TreeNode root, int low, int high) {
//        if(root==null){
//            return null;
//        } else{
//            if(root.val>high){
//                return trimBST(root.left, low, high);
//            } else if(root.val<low){
//                return trimBST(root.right, low, high);
//            } else{
//                root.left=trimBST(root.left, low, high);
//                root.right=trimBST(root.right, low, high);
//                return root;
//            }
//        }
//    }
}
