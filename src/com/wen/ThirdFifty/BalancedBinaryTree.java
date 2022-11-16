package com.wen.ThirdFifty;

// Special note for this problem:
// Leetcode's definition of height-balanced tree is interesting, the judge returns true for cases like
// [1,2,2,3,3,null,null,4,4].
//
// Below also includes another version where it would return false.
public class BalancedBinaryTree {
    // Depth here is the maximum depth of a tree
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

//    // This should be the proper function to check if a tree is height balanced, but this fails
//    // with the Leetcode definition of height-balanced tree
//    // Specifically, it would fail for case [1,2,2,3,3,null,null,4,4], although there are 2 nodes
//    // which have a depth of 2 and 4 respectively, which means it's not height balanced
//    public boolean isBalanced(TreeNode root) {
//        int[] depth=checkDepth(root);
//        return depth[0]!=-1 && depth[1]!=-1;
//    }
//
//    private int[] checkDepth(TreeNode root) {
//        if(root==null){
//            return new int[]{0,0};
//        }
//        int[] left=checkDepth(root.left);
//        if(left[0]==-1 || left[1]==-1){
//            return new int[]{-1,-1};
//        }
//        int[] right=checkDepth(root.right);
//        if(left[0]==0){
//            left[0]=right[0];
//        }
//        if(right[0]==0){
//            right[0]=left[0];
//        }
//        if(right[0]==-1 || right[1]==-1){
//            return new int[]{-1,-1};
//        }
//        if(Math.abs(left[0]-right[1])>1 || Math.abs(left[1]-right[0])>1){
//            return new int[]{-1,-1};
//        } else{
//            return new int[]{Math.min(left[0],right[0])+1, Math.max(left[1],right[1])+1};
//        }
//    }

    // Recursive, optimized by stopping at any point when depth diff is greater than 1
    public boolean isBalanced(TreeNode root) {
        if(checkDepth(root)==-1){
            return false;
        } else{
            return true;
        }
    }

    private int checkDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=checkDepth(root.left);
        if(left==-1){
            return -1;
        }
        int right=checkDepth(root.right);
        if(right==-1){
            return -1;
        }
        int diff=Math.abs(left-right);
        if(diff>1){
            return -1;
        } else{
            return 1+Math.max(left, right);
        }
    }

//    // Recursive, get depth for all nodes
//    public boolean isBalanced(TreeNode root) {
//        if(root==null){
//            return true;
//        }
//        if(Math.abs(getDepth(root.left)-getDepth(root.right))>1){
//            return false;
//        }
//        return isBalanced(root.left) && isBalanced(root.right);
//    }
//
//    private int getDepth(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        return Math.max(getDepth(root.left), getDepth(root.right))+1;
//    }
}
