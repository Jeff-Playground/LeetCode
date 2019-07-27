package com.wen.TwelfthFifty;

public class BinaryTreeTilt {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int findTilt(TreeNode root) {
        int[] result=new int[]{0};
        findTiltDFS(root, result);
        return result[0];
    }

    public int findTiltDFS(TreeNode node, int[] result){
        if(node==null){
            return 0;
        } else{
            int left=findTiltDFS(node.left, result);
            int right=findTiltDFS(node.right, result);
            result[0]+=Math.abs(left-right);
            return left+right+node.val;
        }
    }
}
