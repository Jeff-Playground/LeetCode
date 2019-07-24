package com.wen.SixthFifty;

public class LQClosestBinarySearchTreeValue {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Note here can't simply obtain a min and a max to solve, a BST can be:(note the position of 5 and 8)
    //                5
    //                / \
    //                4    9
    //                /    / \
    //                2    8  10
    public int closestValue(TreeNode root, double target) {
        int result=root.val;
        while(root!=null){
            if(Math.abs((double)result-target)>Math.abs((double)root.val-target)){
                result=root.val;
            }
            if(root.val>target){
                root=root.left;
            } else{
                root=root.right;
            }
        }
        return result;
    }
}
