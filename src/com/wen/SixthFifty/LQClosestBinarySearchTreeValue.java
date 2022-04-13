package com.wen.SixthFifty;

/*
Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.



Example 1:
Input: root = [4,2,5,1,3], target = 3.714286
Output: 4


Example 2:
Input: root = [1], target = 4.428571
Output: 1


Constraints:
The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 109
-109 <= target <= 109
 */

public class LQClosestBinarySearchTreeValue {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Iterative
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

//    // Recursive
//    public int closestValue(TreeNode root, double target) {
//        int result=root.val;
//        TreeNode next=root.val>target?root.left:root.right;
//        if(next!=null){
//            int nextResult=closestValue(next, target);
//            if(Math.abs(result-target)>Math.abs(nextResult-target)){
//                result=nextResult;
//            }
//        }
//        return result;
//    }
}
