package com.wen.EleventhFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Iterative
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result=new ArrayList();
        if(root==null){
            return result;
        }
        TreeNode left=root.left, right=root.right, cur=root;
        // If root is not a leaf node
        if(left!=null || right!=null){
            result.add(root.val);
        }
        // For left boundary
        while(left!=null && (left.left!=null || left.right!=null)){
            result.add(left.val);
            if(left.left!=null){
                left=left.left;
            } else{
                left=left.right;
            }
        }
        // For leaf nodes
        Stack<TreeNode> stack=new Stack<>();
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                if(cur.left==null && cur.right==null){
                    result.add(cur.val);
                }
                cur=cur.left;
            } else{
                cur=stack.pop();
                cur=cur.right;
            }
        }
        // For right nodes
        int index=result.size();
        while(right!=null && (right.left!=null || right.right!=null)){
            result.add(index, right.val);
            if(right.right!=null){
                right=right.right;
            } else{
                right=right.left;
            }
        }
        return result;
    }

//    // One recursion fits all
//    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
//        List<Integer> result=new ArrayList();
//        if(root==null){
//            return result;
//        }
//        result.add(root.val);
//        boundaryOfBinaryTreeDFS(root.left, result, true, false);
//        boundaryOfBinaryTreeDFS(root.right, result, false, true);
//        return result;
//    }
//
//    public void boundaryOfBinaryTreeDFS(TreeNode node, List<Integer> result, boolean leftbd, boolean rightbd){
//        if(node==null){
//            return;
//        }
//        if(node.left==null && node.right==null){
//            result.add(node.val);
//        } else{
//            if(leftbd){
//                result.add(node.val);
//            }
//            boundaryOfBinaryTreeDFS(node.left, result, leftbd&&node.left!=null, rightbd&&node.right==null);
//            boundaryOfBinaryTreeDFS(node.right, result, leftbd&&node.left==null, rightbd&&node.right!=null);
//            if(rightbd){
//                result.add(node.val);
//            }
//        }
//    }

//    // Three recursions for left boundary, leaf nodes and right boundary
//    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
//        List<Integer> result=new ArrayList();
//        if(root==null){
//            return result;
//        }
//        if(root.left!=null || root.right!=null){
//            result.add(root.val);
//        }
//        leftBoundaryOfBinaryTree(root.left, result);
//        leafBoundaryOfBinaryTree(root, result);
//        rightBoundaryOfBinaryTree(root.right, result);
//        return result;
//    }
//
//    public void leftBoundaryOfBinaryTree(TreeNode node, List<Integer> result){
//        if(node==null || (node.left==null && node.right==null)){
//            return;
//        }
//        result.add(node.val);
//        if(node.left!=null){
//            leftBoundaryOfBinaryTree(node.left, result);
//        } else{
//            leftBoundaryOfBinaryTree(node.right, result);
//        }
//    }
//
//    public void leafBoundaryOfBinaryTree(TreeNode node, List<Integer> result){
//        if(node==null){
//            return;
//        }
//        if(node.left==null && node.right==null){
//            result.add(node.val);
//        } else{
//            leafBoundaryOfBinaryTree(node.left, result);
//            leafBoundaryOfBinaryTree(node.right, result);
//        }
//    }
//
//    public void rightBoundaryOfBinaryTree(TreeNode node, List<Integer> result){
//        if(node==null || (node.left==null && node.right==null)){
//            return;
//        }
//        if(node.right!=null){
//            rightBoundaryOfBinaryTree(node.right, result);
//        } else{
//            rightBoundaryOfBinaryTree(node.left, result);
//        }
//        result.add(node.val);
//    }
}
