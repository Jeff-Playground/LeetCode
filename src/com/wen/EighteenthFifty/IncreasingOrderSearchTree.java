package com.wen.EighteenthFifty;

import java.util.Stack;

public class IncreasingOrderSearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Inorder traversal
    public TreeNode increasingBST(TreeNode root) {
        if(root==null){
            return null;
        } else{
            TreeNode dummy=new TreeNode(-1);
            TreeNode cur=root, pre=dummy;
            Stack<TreeNode> stack=new Stack<>();
            while(!stack.isEmpty() || cur!=null){
                if(cur!=null){
                    stack.push(cur);
                    cur=cur.left;
                } else{
                    cur=stack.pop();
                    pre.right=cur;
                    cur.left=null;
                    pre=pre.right;
                    cur=cur.right;
                }
            }
            return dummy.right;
        }
    }

//    public TreeNode increasingBST(TreeNode root) {
//        if(root==null){
//            return null;
//        } else{
//            TreeNode left=increasingBST(root.left);
//            TreeNode right=increasingBST(root.right);
//            root.left=null;
//            root.right=right;
//            if(left==null){
//                return root;
//            } else{
//                TreeNode cur=left;
//                while(cur.right!=null){
//                    cur=cur.right;
//                }
//                cur.right=root;
//                return left;
//            }
//        }
//    }
}
