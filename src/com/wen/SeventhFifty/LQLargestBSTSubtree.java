package com.wen.SeventhFifty;

/*
Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.

Example:
Input: [10,5,15,1,8,null,7]
10
/ \
5  15
/ \   \
1   8   7
Output: 3
Explanation: The Largest BST Subtree in this case is the highlighted one.
The return value is the subtree's size, which is 3.

Follow up:
Can you figure out ways to solve it with O(n) time complexity?

Hint:
You can recursively use algorithm similar to 98. Validate Binary Search Tree at each node of the tree, which will result in O(nlogn) time complexity.
*/

public class LQLargestBSTSubtree {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public static int largestBSTSubtree(TreeNode root) {
        if(root==null){
            return 0;
        } else{
            int[] result=new int[]{0};
            lbsHelper(root, result);
            return result[0];
        }
    }

    private static int[] lbsHelper(TreeNode cur, int[] result){
        int[] leftResult=null, rightResult=null;
        if(cur.left!=null){
            leftResult=lbsHelper(cur.left, result);
        }
        if(cur.right!=null){
            rightResult=lbsHelper(cur.right, result);
        }
        if(leftResult==null && rightResult==null){
            result[0]=Math.max(result[0],1);
            return new int[]{1, cur.val, cur.val};
        } else if(leftResult==null){
            if(rightResult[0]>0 && cur.val<rightResult[1]){
                result[0]=Math.max(result[0], rightResult[0]+1);
                return new int[]{rightResult[0]+1, cur.val, rightResult[2]};
            } else{
                return new int[3];
            }
        } else if(rightResult==null){
            if(leftResult[0]>0 && cur.val>leftResult[2]){
                result[0]=Math.max(result[0], leftResult[0]+1);
                return new int[]{leftResult[0]+1, leftResult[1], cur.val};
            } else{
                return new int[3];
            }
        } else{
            if(leftResult[0]>0 && rightResult[0]>0 && cur.val>leftResult[2] && cur.val<rightResult[1]){
                result[0]=Math.max(result[0], leftResult[0]+1+rightResult[0]);
                return new int[]{leftResult[0]+1+rightResult[0], leftResult[1], rightResult[2]};
            } else{
                return new int[3];
            }
        }
    }
}
