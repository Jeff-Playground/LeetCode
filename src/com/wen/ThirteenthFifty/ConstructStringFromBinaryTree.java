package com.wen.ThirteenthFifty;

public class ConstructStringFromBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public String tree2str(TreeNode t) {
        if(t==null){
            return "";
        } else{
            String right=t.right!=null?"("+tree2str(t.right)+")":"";
            String left=t.left!=null?"("+tree2str(t.left)+")":(right.isEmpty()?"":"()");
            return t.val+left+right;
        }
    }
}
