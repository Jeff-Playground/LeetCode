package com.wen.ThirdFifty;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private static TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if(preLeft>preRight || inLeft>inRight){
            return null;
        }
        int i=0;
        for(i=inLeft; i<=inRight; i++){
            if(preorder[preLeft]==inorder[i]){
                break;
            }
        }
        TreeNode cur=new TreeNode(preorder[preLeft]);
        // preLeft+i-inLeft is the value for the left tree in preorder, which contains the left root node
        cur.left=buildTree(preorder, preLeft+1, preLeft+i-inLeft, inorder, inLeft, i-1);
        cur.right=buildTree(preorder, preLeft+i-inLeft+1, preRight, inorder, i+1, inRight);
        return cur;
    }
}
