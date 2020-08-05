package com.wen.NinthFifty;

import com.wen.FifthFifty.LowestCommonAncestorOfABinarySearchTree;

import java.util.Stack;

public class LQConvertBinarySearchTreeToSortedDoublyLinkedList {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

//    // Divide and conquer
//    public static TreeNode treeToDoublyList(TreeNode root) {
//        if(root==null){
//            return null;
//        }
//        TreeNode left=treeToDoublyList(root.left);
//        TreeNode right=treeToDoublyList(root.right);
//        if(left==null && right==null){
//            root.left=root;
//            root.right=root;
//            return root;
//        } else if(root.left==null){
//            root.right=right;
//            root.left=right.left;
//            right.left.right=root;
//            right.left=root;
//            return root;
//        } else if(root.right==null){
//            root.right=left;
//            root.left=left.left;
//            left.left.right=root;
//            left.left=root;
//            return left;
//        } else{
//            left.left.right=root;
//            root.left=left.left;
//            root.right=right;
//            right.left.right=left;
//            left.left=right.left;
//            right.left=root;
//            return left;
//        }
//    }

//    // In-order traversal recursively
//    public static TreeNode treeToDoublyList(TreeNode root) {
//        TreeNode head=new TreeNode(-1);
//        TreeNode[] last=new TreeNode[]{head};
//        ttdlHelper(root, last);
//        last[0].right=head.right;
//        head.right.left=last[0];
//        return head.right;
//    }
//
//    private static void ttdlHelper(TreeNode cur, TreeNode[] last){
//        if(cur.left!=null){
//            ttdlHelper(cur.left, last);
//        }
//        last[0].right=cur;
//        cur.left=last[0];
//        last[0]=last[0].right;
//        if(cur.right!=null){
//            ttdlHelper(cur.right, last);
//        }
//    }

//    // In-order traversal iteratively
//    public static TreeNode treeToDoublyList(TreeNode root) {
//        TreeNode cur=root, head=new TreeNode(-1), last=head;
//        Stack<TreeNode> stack=new Stack<>();
//        while(cur!=null || !stack.isEmpty()){
//            if(cur!=null){
//                stack.push(cur);
//                cur=cur.left;
//            } else{
//                cur=stack.pop();
//                last.right=cur;
//                cur.left=last;
//                last=last.right;
//                cur=cur.right;
//            }
//        }
//        last.right=head.right;
//        head.right.left=last;
//        return head.right;
//    }

//    // Morris traversal for in-order traversal, in-place
//    public static TreeNode treeToDoublyList(TreeNode root) {
//        TreeNode head=new TreeNode(-1), last=head;
//        TreeNode cur=root, pre=null;
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
//                    last.right=cur;
//                    cur.left=last;
//                    last=last.right;
//                    cur=cur.right;
//                }
//            } else{
//                last.right=cur;
//                cur.left=last;
//                last=last.right;
//                cur=cur.right;
//            }
//        }
//        last.right=head.right;
//        head.right.left=last;
//        return head.right;
//    }
}
