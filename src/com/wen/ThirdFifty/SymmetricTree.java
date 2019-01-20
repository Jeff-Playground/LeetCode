package com.wen.ThirdFifty;

import java.util.Stack;

public class SymmetricTree {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // Iterative-Inorder
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        } else if(root.left!=null && root.right!=null){
            Stack<TreeNode> stackL=new Stack<>();
            Stack<TreeNode> stackR=new Stack<>();
            TreeNode left=root.left, right=root.right;
            while((left!=null || !stackL.isEmpty()) && (right!=null || !stackR.isEmpty())){
                while (left!=null){
                    stackL.push(left);
                    left=left.left;
                }
                while (right!=null){
                    stackR.push(right);
                    right=right.right;
                }
                left=stackL.pop();
                right=stackR.pop();
                if(left.val!=right.val){
                    return false;
                }
                if(stackL.size()!=stackR.size()){
                    return false;
                }
                left=left.right;
                right=right.left;
            }
            return stackL.size()==stackR.size() && ((left==null && right==null) || (left!=null && right!=null && left.val==right.val));
        } else if(root.left==null && root.right==null){
            return true;
        } else{
            return false;
        }
    }

//    // Recursive-Inorder
//    public boolean isSymmetric(TreeNode root) {
//        if(root==null){
//            return true;
//        } else{
//            return isSymmetricDFS(root.left, root.right);
//        }
//    }
//
//    private boolean isSymmetricDFS(TreeNode left, TreeNode right) {
//        if(left!=null && right!=null){
//            if(left.val==right.val){
//                return isSymmetricDFS(left.left, right.right) && isSymmetricDFS(left.right, right.left);
//            } else{
//                return false;
//            }
//        } else if(left==null && right==null){
//            return true;
//        } else{
//            return false;
//        }
//    }
}
