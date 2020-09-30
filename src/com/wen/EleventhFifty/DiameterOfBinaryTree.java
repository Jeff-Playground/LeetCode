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
        int[] result=new int[]{1};
        dobtHelper(root, result);
        return result[0]-1;
    }

    private int[] dobtHelper(TreeNode cur, int[] cache){
        if(cur==null){
            return new int[]{0, 0};
        } else{
            int[] left=dobtHelper(cur.left, cache);
            int[] right=dobtHelper(cur.right, cache);
            int[] result=new int[]{Math.max(left[0], left[1])+1, Math.max(right[0], right[1])+1};
            cache[0]=Math.max(cache[0], result[0]+result[1]-1);
            return result;
        }
    }
}
