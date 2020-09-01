package com.wen.ThirdFifty;

import java.util.Stack;

public class SumRootToLeafNumbers {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // Preorder traversal, add root value to children's valus
    public static int sumNumbers(TreeNode root) {
        int result=0;
        TreeNode cur=root;
        Stack<TreeNode> stack=new Stack<>();
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                if(cur.left==null && cur.right==null){
                    result+=cur.val;
                } else if(cur.left!=null){
                    cur.left.val+=cur.val*10;
                }
                cur=cur.left;
            } else{
                cur=stack.pop();
                if(cur.right!=null){
                    cur.right.val+=cur.val*10;
                }
                cur=cur.right;
            }
        }
        return result;
    }

//    // DFS
//    public int sumNumbers(TreeNode root) {
//        int[] result={0};
//        if(root!=null){
//            sumNumbersHelper(root, 0, result);
//        }
//        return result[0];
//    }
//
//    private void sumNumbersHelper(TreeNode node, int curNum, int[] result) {
//        curNum=curNum*10+node.val;
//        if(node.left==null && node.right==null){
//            result[0]+=curNum;
//            return;
//        }
//        if(node.left!=null){
//            sumNumbersHelper(node.left, curNum, result);
//        }
//        if(node.right!=null){
//            sumNumbersHelper(node.right, curNum, result);
//        }
//    }
}
