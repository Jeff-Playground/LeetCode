package com.wen.FifthFifty;

public class CountCompleteTreeNodes {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public static int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        } else{
            int hLeft=heightLeft(root);
            if(hLeft==heightRight(root)){
                return (int)Math.pow(2,hLeft)-1;
            } else{
                return 1+countNodes(root.left)+countNodes(root.right);
            }
        }
    }

    private static int heightLeft(TreeNode node) {
        if(node==null){
            return 0;
        } else{
            return 1+heightLeft(node.left);
        }
    }

    private static int heightRight(TreeNode node) {
        if(node==null){
            return 0;
        } else{
            return 1+heightRight(node.right);
        }
    }
}
