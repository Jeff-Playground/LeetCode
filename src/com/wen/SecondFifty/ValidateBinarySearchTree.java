package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidateBinarySearchTree {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

//    // Morris Traversal, space complexity is O(1) since it doesn't require a Stack
//    public boolean isValidBST(TreeNode root) {
//        if(root==null){
//            return true;
//        }
//        TreeNode cur=root, pre=null;
//        while(cur!=null){
//            if(cur.left!=null){
//                TreeNode tmp=cur.left;
//                while(tmp.right!=null && tmp.right!=cur){
//                    tmp=tmp.right;
//                }
//                if(tmp.right==null){
//                    tmp.right=cur;
//                    cur=cur.left;
//                } else{
//                    tmp.right=null;
//                    if(pre.val>=cur.val){
//                        return false;
//                    } else{
//                        pre=cur;
//                        cur=cur.right;
//                    }
//                }
//            } else{
//                if(pre!=null && pre.val>=cur.val){
//                    return false;
//                } else{
//                    pre=cur;
//                    cur=cur.right;
//                }
//            }
//        }
//        return true;
//    }

//    // Inorder traversal with Stack
//    public boolean isValidBST(TreeNode root) {
//        Stack<TreeNode> stack=new Stack<>();
//        TreeNode cur=root, pre=null;
//        while(cur!=null || !stack.isEmpty()){
//            if(cur!=null){
//                stack.push(cur);
//                cur=cur.left;
//            } else{
//                cur=stack.pop();
//                if(pre!=null && pre.val>=cur.val){
//                    return false;
//                }
//                pre=cur;
//                cur=cur.right;
//            }
//        }
//        return true;
//    }

    // Inorder traversal recursively, note the passed down value is using long to cover the case for a tree with single
    // node of value Integer.MIN_VALUE or Integer.MAX_VALUE
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode root, long low, long high) {
        if(root==null){
            return true;
        }
        if(root.val<=low || root.val>=high){
            return false;
        }
        return isValidBSTHelper(root.left, low, root.val) && isValidBSTHelper(root.right, root.val, high);
    }
}
