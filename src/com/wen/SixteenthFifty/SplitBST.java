package com.wen.SixteenthFifty;

public class SplitBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode[] splitBST(TreeNode root, int V){
        TreeNode[] result=new TreeNode[2];
        if(root==null){
            return result;
        }
        if(root.val==V){
            result[0]=root;
            result[1]=root.right;
            root.right=null;
        } else if(root.val<V){
            result[0]=root;
            TreeNode[] rightResult=splitBST(root.right, V);
            result[1]=rightResult[1];
            root.right=rightResult[0];
        } else{
            result[1]=root;
            TreeNode[] leftResult=splitBST(root.left, V);
            result[0]=leftResult[0];
            root.left=leftResult[1];
        }
        return result;
    }
}
