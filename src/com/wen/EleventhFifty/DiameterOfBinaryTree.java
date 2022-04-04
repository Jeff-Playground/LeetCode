package com.wen.EleventhFifty;

public class DiameterOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // DFS
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max=new int[]{0};
        dobtHelper(root, max);
        return max[0];
    }

    private int dobtHelper(TreeNode node, int[] max){
        if(node==null){
            return -1;
        } else{
            int left=dobtHelper(node.left, max), right=dobtHelper(node.right, max);
            if(left==-1 && right==-1){
                return 0;
            } else{
                max[0]=Math.max(max[0], left+1+right+1);
                return Math.max(left+1, right+1);
            }
        }
    }
}
