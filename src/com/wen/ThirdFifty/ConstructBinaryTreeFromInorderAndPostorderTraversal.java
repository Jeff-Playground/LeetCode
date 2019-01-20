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

    private TreeNode buildTree(int[] inorder, int iLeft, int iRight, int[] postorder, int pLeft, int pRight) {
        if(pLeft>pRight || iLeft>iRight){
            return null;
        }
        int i=iLeft;
        for(i=iLeft; i<=iRight; i++){
            if(inorder[i]==postorder[pRight]){
                break;
            }
        }
        TreeNode cur=new TreeNode(postorder[pRight]);
        cur.left=buildTree(inorder, iLeft, i-1, postorder, pLeft, pLeft+i-iLeft-1);
        cur.right=buildTree(inorder, i+1, iRight, postorder, pLeft+i-iLeft, pRight-1);
        return cur;
    }
}
