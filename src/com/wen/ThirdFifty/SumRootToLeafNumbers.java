package com.wen.ThirdFifty;

import java.util.Stack;

public class SumRootToLeafNumbers {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // Iterative
    public int sumNumbers(TreeNode root) {
        int result=0;
        if(root==null){
            return result;
        }
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp=stack.pop();
            if(temp.left==null && temp.right==null){
                result+=temp.val;
            }
            if(temp.left!=null){
                temp.left.val+=temp.val*10;
                stack.push(temp.left);
            }
            if(temp.right!=null){
                temp.right.val+=temp.val*10;
                stack.push(temp.right);
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
