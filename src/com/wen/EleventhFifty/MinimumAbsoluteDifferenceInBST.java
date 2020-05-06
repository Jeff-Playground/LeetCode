package com.wen.EleventhFifty;

import java.util.Stack;

public class MinimumAbsoluteDifferenceInBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Morris inorder traversal
    public int getMinimumDifference(TreeNode root) {
        int result=Integer.MAX_VALUE, preValue=-1;
        TreeNode cur=root, pre=null;
        while(cur!=null){
            if(cur.left!=null){
                pre=cur.left;
                while(pre.right!=null && pre.right!=cur){
                    pre=pre.right;
                }
                if(pre.right==null){
                    pre.right=cur;
                    cur=cur.left;
                } else{
                    pre.right=null;
                    if(preValue>=0){
                        result=Math.min(result, Math.abs(cur.val-preValue));
                    }
                    preValue=cur.val;
                    cur=cur.right;
                }
            } else{
                if(preValue>=0){
                    result=Math.min(result, Math.abs(cur.val-preValue));
                }
                preValue=cur.val;
                cur=cur.right;
            }
        }
        return result;
    }

//    // Inorder traversal
//    public int getMinimumDifference(TreeNode root) {
//        int result=Integer.MAX_VALUE, pre=-1;
//        TreeNode cur=root;
//        Stack<TreeNode> stack=new Stack<>();
//        while(cur!=null || !stack.isEmpty()){
//            if(cur!=null){
//                stack.push(cur);
//                cur=cur.left;
//            } else{
//                cur=stack.pop();
//                if(pre>=0){
//                    result=Math.min(result, Math.abs(cur.val-pre));
//                }
//                pre=cur.val;
//                cur=cur.right;
//            }
//        }
//        return result;
//    }

//    // Inorder traversal
//    public int getMinimumDifference(TreeNode root) {
//        int[] cache=new int[]{-1, Integer.MAX_VALUE};
//        gmdHelper(root, cache);
//        return cache[1];
//    }
//
//    private void gmdHelper(TreeNode cur, int[] cache){
//        if(cur.left!=null){
//            gmdHelper(cur.left, cache);
//        }
//        if(cache[0]>=0){
//            cache[1]=Math.min(cache[1], Math.abs(cur.val-cache[0]));
//        }
//        cache[0]=cur.val;
//        if(cur.right!=null){
//            gmdHelper(cur.right, cache);
//        }
//    }
}
