package com.wen.SeventhFifty;

/*
Given the root of a binary tree, find the largest subtree, which is also a Binary Search Tree (BST), where the largest
means subtree has the largest number of nodes.

A Binary Search Tree (BST) is a tree in which all the nodes follow the below-mentioned properties:
The left subtree values are less than the value of their parent (root) node's value.
The right subtree values are greater than the value of their parent (root) node's value.


Note: A subtree must include all of its descendants.


Example 1:
Input: root = [10,5,15,1,8,null,7]
Output: 3



Example 2:
Input: root = [4,2,7,2,3,5,null,2,null,null,null,null,null,1]
Output: 2


Constraints:
The number of nodes in the tree is in the range [0, 104].
-104 <= Node.val <= 104
*/

public class LQLargestBSTSubtree {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public int largestBSTSubtree(TreeNode root) {
        if(root==null){
            return 0;
        } else{
            int[] result=new int[]{0};
            lbsHelper(root, result);
            return result[0];
        }
    }

    private int[] lbsHelper(TreeNode cur, int[] result){
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
