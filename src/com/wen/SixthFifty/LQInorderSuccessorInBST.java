package com.wen.SixthFifty;

public class LQInorderSuccessorInBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null){
            return null;
        } else{
            if(root.val<=p.val){
                return inorderSuccessor(root.right, p);
            } else{
                TreeNode left=inorderSuccessor(root.left, p);
                return left==null?root:left;
            }
        }
    }

//    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        TreeNode result=null;
//        while(root!=null){
//            if(root.val>p.val){
//                result=root;
//                root=root.left;
//            } else{
//                root=root.right;
//            }
//        }
//        return result;
//    }
}
