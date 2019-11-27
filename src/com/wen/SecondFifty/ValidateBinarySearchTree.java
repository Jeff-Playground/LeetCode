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

//    // Morris Traversal
//    public boolean isValidBST(TreeNode root) {
//        if(root==null){
//            return true;
//        }
//        TreeNode cur=root, pre=null, last=null;
//        boolean result=true;
//        while(cur!=null){
//            if(cur.left!=null){
//                pre=cur.left;
//                while(pre.right!=null && pre.right!=cur){
//                    pre=pre.right;
//                }
//                if(pre.right==null){
//                    pre.right=cur;
//                    cur=cur.left;
//                } else{
//                    pre.right=null;
//                    if(last.val>=cur.val){
//                        result=false;
//                    }
//                    last=cur;
//                    cur=cur.right;
//                }
//            } else{
//                if(last!=null && last.val>=cur.val){
//                    result=false;
//                }
//                last=cur;
//                cur=cur.right;
//            }
//        }
//        return result;
//    }

    // Stack
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root, last=null;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            } else{
                cur=stack.pop();
                if(last!=null && cur.val<=last.val){
                    return false;
                }
                last=cur;
                cur=cur.right;
            }
        }
        return true;
    }

//    // Put tree nodes in a list in order and check, this only works with left<root<right instead of left<=root<right,
//    // for example, it can't distinguish
//    //       20       against     20
//    //      /                       \
//    //    20                         20
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

//    // DFS, this can be used to solve case left<=root<right
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
