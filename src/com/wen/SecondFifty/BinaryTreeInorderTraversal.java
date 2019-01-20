package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // Morris Traversal(my way without changing the tree structure)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        TreeNode cur=root;
        TreeNode pre;
        while(cur!=null){
            if(cur.left==null){
                result.add(cur.val);
                cur=cur.right;
            } else{
                pre=cur.left;
                while(pre.right!=null && pre.right!=cur){
                    pre=pre.right;
                }
                if(pre.right==null){
                    pre.right=cur;
                    cur=cur.left;
                } else{
                    pre.right=null;
                    result.add(cur.val);
                    cur=cur.right;
                }
            }
        }
        return result;
    }

//    // Morris Traversal(non-recursive and no stack)
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result=new ArrayList<>();
//        TreeNode cur=root;
//        TreeNode pre;
//        while(cur!=null){
//            if(cur.left==null){
//                result.add(cur.val);
//                cur=cur.right;
//            } else{
//                pre=cur.left;
//                while(pre.right!=null){
//                    pre=pre.right;
//                }
//                pre.right=cur;
//                // This part changes the structure of the tree
//                TreeNode temp=cur;
//                cur=cur.left;
//                temp.left=null;
//            }
//        }
//        return result;
//    }

//    // Iterative with Stack 2
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result=new ArrayList<>();
//        Stack<TreeNode> stack=new Stack<>();
//        TreeNode p=root;
//        while(p!=null || !stack.isEmpty()){
//            if(p!=null){
//                stack.push(p);
//                p=p.left;
//            } else{
//                TreeNode t=stack.pop();
//                result.add(t.val);
//                p=t.right;
//            }
//        }
//        return result;
//    }

//    // Iterative with Stack
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result=new ArrayList<>();
//        Stack<TreeNode> stack=new Stack<>();
//        TreeNode p=root;
//        while(p!=null || !stack.isEmpty()){
//            while(p!=null){
//                stack.push(p);
//                p=p.left;
//            }
//            p=stack.pop();
//            result.add(p.val);
//            p=p.right;
//        }
//        return result;
//    }

//    // Recursive
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result=new ArrayList<>();
//        inorder(root, result);
//        return result;
//    }
//
//    private void inorder(TreeNode root, List<Integer> result) {
//        if(root!=null){
//            if(root.left!=null){
//                inorder(root.left, result);
//            }
//            result.add(root.val);
//            if(root.right!=null){
//                inorder(root.right, result);
//            }
//        }
//    }
}
