package com.wen.FourteenthFifty;

public class SearchInABinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

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
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode result=root;
        while(result!=null){
            if(result.val==val){
                break;
            } else if(result.val>val){
                result=result.left;
            } else{
                result=result.right;
            }
        }
        return result;
    }

//    // Recursive
//    public TreeNode searchBST(TreeNode root, int val) {
//        if(root==null || root.val==val){
//            return root;
//        } else{
//            if(root.val>val){
//                return searchBST(root.left, val);
//            } else{
//                return searchBST(root.right, val);
//            }
//        }
//    }
}
