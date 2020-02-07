package com.wen.SixthFifty;

import java.util.Stack;

public class LQVerifyPreorderSequenceInBinarySearchTree {
//    // Monotonic stack
//    public static boolean verifyPreorder(int[] preorder) {
//        int low=Integer.MIN_VALUE;
//        Stack<Integer> stack=new Stack<>();
//        for(int cur: preorder){
//            if(cur<low){
//                return false;
//            }
//            while(!stack.isEmpty() && cur>stack.peek()){
//                low=stack.pop();
//            }
//            stack.push(cur);
//        }
//        return true;
//    }

    // Divide and conquer
    public static boolean verifyPreorder(int[] preorder) {
        return verifyPreorderHelper(preorder, 0, preorder.length-1);
    }

    private static boolean verifyPreorderHelper(int[]  preorder, int left, int right){
        if(left>=right){
            return true;
        }
        int root=preorder[left];
        int rightStart=-1;
        for(int i=left+1; i<=right; i++){
            if(preorder[i]>root){
                rightStart=i;
                break;
            }
        }
        if(rightStart!=-1){
            for(int i=rightStart+1; i<=right; i++){
                if(preorder[i]<=root){
                    return false;
                }
            }
            return verifyPreorderHelper(preorder, left+1, rightStart-1) && verifyPreorderHelper(preorder, rightStart, right);
        } else{
            return verifyPreorderHelper(preorder, left+1, right);
        }
    }
}
