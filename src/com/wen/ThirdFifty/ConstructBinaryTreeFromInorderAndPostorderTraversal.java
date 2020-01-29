package com.wen.ThirdFifty;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if(postLeft>postRight || inLeft>inRight){
            return null;
        }
        int i=inLeft;
        for(i=inLeft; i<=inRight; i++){
            if(inorder[i]==postorder[postRight]){
                break;
            }
        }
        TreeNode cur=new TreeNode(postorder[postRight]);
        cur.left=buildTree(inorder, inLeft, i-1, postorder, postLeft, postLeft+i-inLeft-1);
        cur.right=buildTree(inorder, i+1, inRight, postorder, postLeft+i-inLeft, postRight-1);
        return cur;
    }
}
