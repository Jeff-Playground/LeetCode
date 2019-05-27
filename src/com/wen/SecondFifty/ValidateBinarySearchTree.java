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

    // Morris Traversal
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        TreeNode cur=root, pre=null, parent=null;
        boolean result=true;
        while(cur!=null){
            if(cur.left==null){
                if(parent!=null && parent.val>=cur.val){
                    result=false;
                }
                parent=cur;
                cur=cur.right;
            } else{
                pre=cur.left;
                while(pre.right!=null && pre.right!=cur){
                    pre=pre.right;
                }
                if(pre.right==null){
                    pre.right=cur;
                    cur=cur.left;
                } else{
                    pre.right=null;
                    if(parent.val>=cur.val){
                        result=false;
                    }
                    parent=cur;
                    cur=cur.right;
                }
            }
        }
        return result;
    }

//    // Stack
//    public boolean isValidBST(TreeNode root) {
//        Stack<TreeNode> stack=new Stack<>();
//        TreeNode cur=root, pre=null;
//        while(cur!=null || !stack.isEmpty()){
//            while(cur!=null){
//                stack.push(cur);
//                cur=cur.left;
//            }
//            TreeNode t=stack.pop();
//            if(pre!=null && t.val<=pre.val){
//                return false;
//            }
//            pre=t;
//            cur=t.right;
//        }
//        return true;
//    }

//    // Put tree nodes in a list in order and check, this only works with left<root<right instead of left<=root<right
//    public boolean isValidBST(TreeNode root) {
//        if(root==null){
//            return true;
//        }
//        List<Integer> list=new ArrayList<>();
//        inorder(root, list);
//        for(int i=0; i<list.size()-1; i++){
//            if(list.get(i)>=list.get(i+1)){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private void inorder(TreeNode root, List<Integer> list) {
//        if(root==null){
//            return;
//        }
//        inorder(root.left, list);
//        list.add(root.val);
//        inorder(root.right, list);
//    }

//    // DFS
//    public boolean isValidBST(TreeNode root) {
//        if(root==null){
//            return true;
//        }
//        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    private boolean isValidBSTHelper(TreeNode root, long low, long high) {
//        if(root==null){
//            return true;
//        }
//        if(root.val<=low || root.val>=high){
//            return false;
//        }
//        return isValidBSTHelper(root.left, low, root.val) && isValidBSTHelper(root.right, root.val, high);
//    }
}
