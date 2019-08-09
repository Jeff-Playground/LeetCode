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
    public boolean verifyPreorder(int[] preorder) {
        if(preorder==null){
            return true;
        } else{
            return verifyPreorderHelper(preorder, 0, preorder.length-1, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }

    public boolean verifyPreorderHelper(int[] preorder, int start, int end, int low, int high) {
        if(end<=start){
            return true;
        }
        int rootVal=preorder[start];
        int rightStart=-1;
        for(int i=start+1; i<=end; i++){
            if(preorder[i]<rootVal){
                if(rightStart!=-1 || preorder[i]<low){
                    return false;
                }
            } else if(preorder[i]>rootVal){
                if(rightStart==-1){
                    rightStart=i;
                }
                if(preorder[i]>high){
                    return false;
                }
            }
        }
        boolean left=verifyPreorderHelper(preorder, start+1, rightStart-1, Integer.MIN_VALUE, rootVal-1);
        // Note here need to check rightStart>end because rightStart could be out of the checking range
        boolean right=(rightStart==-1 || rightStart>end)?true:verifyPreorderHelper(preorder, rightStart, end, rootVal+1, Integer.MAX_VALUE);
        return left&&right;
    }
}
