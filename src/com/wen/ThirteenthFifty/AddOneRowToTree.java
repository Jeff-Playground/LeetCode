package com.wen.ThirteenthFifty;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Optimized recursive, use depth to distinguish left and right child
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1 || depth==0){
            TreeNode newRoot=new TreeNode(val);
            if(depth==1){
                newRoot.left=root;
            } else{
                newRoot.right=root;
            }
            root=newRoot;
        } else if(root!=null && depth>1) {
            root.left=addOneRow(root.left, val, depth-1>1?depth-1:1);
            root.right=addOneRow(root.right, val, depth-1>1?depth-1:0);
        }
        return root;
    }

//    // Level order traversal
//    public TreeNode addOneRow(TreeNode root, int val, int depth) {
//        if(depth==1){
//            TreeNode newRoot=new TreeNode(val);
//            newRoot.left=root;
//            return newRoot;
//        }
//        Queue<TreeNode> q=new LinkedList<>();
//        q.offer(root);
//        while(--depth>1){
//            int size=q.size();
//            while(size-->0){
//                TreeNode cur=q.poll();
//                if(cur.left!=null){
//                    q.offer(cur.left);
//                }
//                if(cur.right!=null){
//                    q.offer(cur.right);
//                }
//            }
//        }
//        while(!q.isEmpty()){
//            TreeNode cur=q.poll();
//            TreeNode left=new TreeNode(val);
//            left.left=cur.left;
//            cur.left=left;
//            TreeNode right=new TreeNode(val);
//            right.right=cur.right;
//            cur.right=right;
//        }
//        return root;
//    }

//    // Recursive
//    public TreeNode addOneRow(TreeNode root, int val, int depth) {
//        return addOneRowHelper(root, val, depth, true);
//    }
//
//    private TreeNode addOneRowHelper(TreeNode cur, int val, int depth, boolean fromLeft){
//        if(depth==1){
//            TreeNode n=new TreeNode(val);
//            if(fromLeft){
//                n.left=cur;
//            } else{
//                n.right=cur;
//            }
//            return n;
//        } else{
//            if(cur!=null){
//                cur.left=addOneRowHelper(cur.left, val, depth-1, true);
//                cur.right=addOneRowHelper(cur.right, val, depth-1, false);
//            }
//            return cur;
//        }
//    }
}
