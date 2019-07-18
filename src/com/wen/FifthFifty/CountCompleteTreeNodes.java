package com.wen.FifthFifty;

public class CountCompleteTreeNodes {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // A Complete Binary Tree is a binary tree in which every level, except possibly 
    // the last, is completely filled, and all nodes are as far left as possible.
    // A Full Binary Tree is a tree in which every node other than the leaves has two children.
    // A Perfect Binary Tree is a tree with all leaf nodes at the same depth. All internal nodes have degree 2.
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
