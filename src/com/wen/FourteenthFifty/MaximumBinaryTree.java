package com.wen.FourteenthFifty;

import java.util.Stack;

public class MaximumBinaryTree {
    public class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

//    // Divide and conquer
//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        int l=nums.length;
//        return cmbtHelper(nums, 0, l-1);
//    }
//
//    private TreeNode cmbtHelper(int[] nums, int start, int end){
//        if(start>end){
//            return null;
//        } else if(start==end){
//            TreeNode result=new TreeNode(nums[start]);
//            return result;
//        } else{
//            int max=Integer.MIN_VALUE, index=-1;
//            for(int i=start; i<=end; i++){
//                if(nums[i]>max){
//                    max=nums[i];
//                    index=i;
//                }
//            }
//            TreeNode result=new TreeNode(nums[index]);
//            result.left=cmbtHelper(nums, start, index-1);
//            result.right=cmbtHelper(nums, index+1, end);
//            return result;
//        }
//    }

    // Monotonic stack
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> stack=new Stack<>();
        for(int num: nums){
            TreeNode cur=new TreeNode(num);
            while(!stack.isEmpty() && stack.peek().val<cur.val){
                cur.left=stack.pop();
            }
            if(!stack.isEmpty()){
                stack.peek().right=cur;
            }
            stack.push(cur);
        }
        while(stack.size()>1){
            stack.pop();
        }
        return stack.peek();
    }
}
