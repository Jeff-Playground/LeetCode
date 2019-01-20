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

    private static TreeNode buildTree(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight) {
        if(pLeft>pRight || iLeft>iRight){
            return null;
        }
        int i=0;
        for(i=iLeft; i<=iRight; i++){
            if(preorder[pLeft]==inorder[i]){
                break;
            }
        }
        TreeNode cur=new TreeNode(preorder[pLeft]);
        // pLeft+i-iLeft is the value for the left tree in preorder, which contains the left root node
        cur.left=buildTree(preorder, pLeft+1, pLeft+i-iLeft, inorder, iLeft, i-1);
        cur.right=buildTree(preorder, pLeft+i-iLeft+1, pRight, inorder, i+1, iRight);
        return cur;
    }
}
