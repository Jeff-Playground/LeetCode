package com.wen.SixthFifty;

public class LQBinaryTreeLongestConsecutiveSequence {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int longestConsecutive(TreeNode root) {
        if(root==null){
            return 0;
        }
        int[] result=new int[]{1};
        longestConsecutiveDFS(root, result);
        return result[0];
    }

    public int longestConsecutiveDFS(TreeNode node, int[] result) {
        if(node==null){
            return 0;
        } else{
            int max=1;
            int left=longestConsecutiveDFS(node.left, result);
            int right=longestConsecutiveDFS(node.right, result);
            if(node.left!=null && node.left.val==node.val+1){
                max=left+1;
            }
            if(node.right!=null && node.right.val==node.val+1){
                max=Math.max(max, right+1);
            }
            result[0]=Math.max(result[0], max);
            return max;
        }
    }
}
