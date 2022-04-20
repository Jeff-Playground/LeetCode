package com.wen.TwentyEighthFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BalanceABinarySearchTree {
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

    // Tree inorder traversal recursively to construct a sorted list of nodes, then reconstruct the tree from the sorted list
    public TreeNode balanceBST(TreeNode root) {
        if(root==null){
            return null;
        } else{
            List<TreeNode> sorted=new ArrayList<>();
            inorderTraverse(root, sorted);
            return balanceBSTHelper(sorted, 0, sorted.size()-1);
        }
    }

    private void inorderTraverse(TreeNode node, List<TreeNode> sorted){
        if(node!=null){
            inorderTraverse(node.left, sorted);
            sorted.add(node);
            inorderTraverse(node.right, sorted);
        }
    }

//    // Tree inorder traversal iteratively to construct a sorted list of nodes, then reconstruct the tree from the sorted list
//    public TreeNode balanceBST(TreeNode root) {
//        if(root==null){
//            return null;
//        } else{
//            List<TreeNode> sorted=new ArrayList<>();
//            Stack<TreeNode> stack=new Stack<>();
//            TreeNode cur=root;
//            while(cur!=null || !stack.isEmpty()){
//                if(cur!=null){
//                    stack.push(cur);
//                    cur=cur.left;
//                } else{
//                    cur=stack.pop();
//                    sorted.add(cur);
//                    cur=cur.right;
//                }
//            }
//            return balanceBSTHelper(sorted, 0, sorted.size()-1);
//        }
//    }

    private TreeNode balanceBSTHelper(List<TreeNode> sorted, int start, int end){
        if(start>end){
            return null;
        } else{
            int rootIdx=start+(end-start)/2;
            TreeNode root=sorted.get(rootIdx);
            root.left=balanceBSTHelper(sorted, start, rootIdx-1);
            root.right=balanceBSTHelper(sorted, rootIdx+1, end);
            return root;
        }
    }
}
