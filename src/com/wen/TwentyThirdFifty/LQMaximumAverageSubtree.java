package com.wen.TwentyThirdFifty;

/*
Given the root of a binary tree, return the maximum average value of a subtree of that tree. Answers within 10-5 of the
actual answer will be accepted.

A subtree of a tree is any node of that tree plus all its descendants.

The average value of a tree is the sum of its values, divided by the number of nodes.



Example 1:
Input: root = [5,6,1]
Output: 6.00000
Explanation:
For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
For the node with value = 6 we have an average of 6 / 1 = 6.
For the node with value = 1 we have an average of 1 / 1 = 1.
So the answer is 6 which is the maximum.


Example 2:
Input: root = [0,null,1]
Output: 1.00000


Constraints:
The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 105
 */

public class LQMaximumAverageSubtree {
    public class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public double maximumAverageSubtree(TreeNode root) {
        double[] cache=new double[]{Double.MIN_VALUE};
        masHelper(root, cache);
        return cache[0];
    }

    private int[] masHelper(TreeNode root, double[] cache){
        int[] leftResult=new int[]{0,0}, rightResult=new int[]{0,0};
        if(root.left!=null){
            leftResult=masHelper(root.left, cache);
        }
        if(root.right!=null){
            rightResult=masHelper(root.right, cache);
        }
        int[] result=new int[]{leftResult[0]+rightResult[0]+root.val, leftResult[1]+rightResult[1]+1};
        cache[0]=Math.max(cache[0], (double)result[0]/result[1]);
        return result;
    }
}
