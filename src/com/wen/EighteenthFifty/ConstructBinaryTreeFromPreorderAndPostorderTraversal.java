package com.wen.EighteenthFifty;

import java.util.Stack;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Using a stack
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Stack<TreeNode> stack=new Stack<>();
        stack.push(new TreeNode(preorder[0]));
        for(int i=1, j=0; i<preorder.length; i++){
            TreeNode cur=new TreeNode(preorder[i]);
            while(stack.peek().val==postorder[j]){
                stack.pop();
                j++;
            }
            if(stack.peek().left==null){
                stack.peek().left=cur;
            } else{
                stack.peek().right=cur;
            }
            stack.push(cur);
        }
        while(stack.size()>1){
            stack.pop();
        }
        return stack.peek();
    }

//    // Specifically checks whether there's a left/right child tree exists
//    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
//        return buildTree(preorder, 0, preorder.length-1, postorder, 0, postorder.length-1);
//    }
//
//    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
//        if(preStart>preEnd || preStart<0 || preEnd>preorder.length-1){
//            return null;
//        } else if(preStart==preEnd){
//            return new TreeNode(preorder[preStart]);
//        } else{
//            TreeNode result=new TreeNode(preorder[preStart]);
//            int leftPreStart=preStart+1, rightPostEnd=postEnd-1;
//            int rightPreStart=preEnd+1, leftPostEnd=postStart-1;
//            for(int i=leftPreStart+1; i<=preEnd; i++){
//                if(preorder[i]==postorder[rightPostEnd]){
//                    rightPreStart=i;
//                    break;
//                }
//            }
//            for(int i=rightPostEnd-1; i>=postStart; i--){
//                if(postorder[i]==preorder[leftPreStart]){
//                    leftPostEnd=i;
//                    break;
//                }
//            }
//            if(rightPreStart==preEnd+1){
//                result.left=buildTree(preorder, preStart+1, preEnd, postorder, postStart, postEnd-1);
//            } else if(leftPostEnd==postStart-1){
//                result.right=buildTree(preorder, preStart+1, preEnd, postorder, postStart, postEnd-1);
//            } else{
//                result.left=buildTree(preorder, leftPreStart, rightPreStart-1, postorder, postStart, leftPostEnd);
//                result.right=buildTree(preorder, rightPreStart, preEnd, postorder, leftPostEnd+1, rightPostEnd);
//            }
//            return result;
//        }
//    }

//    // Without specifically checking whether there's a left/right child tree exists
//    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
//        return buildTree(preorder, 0, preorder.length-1, postorder, 0, postorder.length-1);
//    }
//
//    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd){
//        if(preStart>preEnd){
//            return null;
//        } else if(preStart==preEnd){
//            return new TreeNode(preorder[preStart]);
//        } else{
//            TreeNode result=new TreeNode(preorder[preStart]);
//            int i=-1;
//            for(i=postStart; i<=postEnd; i++){
//                if(postorder[i]==preorder[preStart+1]){
//                    break;
//                }
//            }
//            result.left=buildTree(preorder, preStart+1, preStart+1+i-postStart, postorder, postStart, i);
//            result.right=buildTree(preorder, preStart+1+i-postStart+1, preEnd, postorder, i+1, postEnd-1);
//            return result;
//        }
//    }
}
