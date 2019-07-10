package com.wen.FifthFifty;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // DFS
    public TreeNode invertTree(TreeNode root) {
        if(root==null) {
            return root;
        } else {
            TreeNode newLeft=invertTree(root.right);
            TreeNode newRight=invertTree(root.left);
            root.left=newLeft;
            root.right=newRight;
            return root;
        }
    }

//    // Level order traversal
//    public TreeNode invertTree(TreeNode root) {
//        if(root==null) {
//            return root;
//        }
//        Queue<TreeNode> q=new LinkedList<>();
//        q.offer(root);
//        while(!q.isEmpty()) {
//            TreeNode cur=q.poll();
//            TreeNode oldLeft=cur.left;
//            cur.left=cur.right;
//            cur.right=oldLeft;
//            if(cur.left!=null) {
//                q.offer(cur.left);
//            }
//            if(cur.right!=null) {
//                q.offer(cur.right);
//            }
//        }
//        return root;
//    }
}
