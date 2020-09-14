package com.wen.TwentyFirstFifty;

import java.util.Stack;

public class BinarySearchTreeToGreaterSumTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    // In-order traversal, recursively
//    public TreeNode bstToGst(TreeNode root) {
//        if(root!=null){
//            btgHelper(root, new int[]{0});
//        }
//        return root;
//    }
//
//    private void btgHelper(TreeNode cur, int[] sum){
//        if(cur.right!=null){
//            btgHelper(cur.right, sum);
//        }
//        sum[0]+=cur.val;
//        cur.val=sum[0];
//        if(cur.left!=null){
//            btgHelper(cur.left, sum);
//        }
//    }

//    // In-order traversal with Stack
//    public TreeNode bstToGst(TreeNode root) {
//        int sum=0;
//        TreeNode cur=root;
//        Stack<TreeNode> stack=new Stack<>();
//        while(!stack.isEmpty() || cur!=null){
//            if(cur!=null){
//                stack.push(cur);
//                cur=cur.right;
//            } else{
//                cur=stack.pop();
//                sum+=cur.val;
//                cur.val=sum;
//                cur=cur.left;
//            }
//        }
//        return root;
//    }

    // In-order Morris traversal
    public TreeNode bstToGst(TreeNode root) {
        TreeNode cur=root, pre=null;
        int sum=0;
        while(cur!=null){
            if(cur.right!=null){
                pre=cur.right;
                while(pre.left!=null && pre.left!=cur){
                    pre=pre.left;
                }
                if(pre.left==null){
                    pre.left=cur;
                    cur=cur.right;
                } else{
                    pre.left=null;
                    sum+=cur.val;
                    cur.val=sum;
                    cur=cur.left;
                }
            } else{
                sum+=cur.val;
                cur.val=sum;
                cur=cur.left;
            }
        }
        return root;
    }
}
