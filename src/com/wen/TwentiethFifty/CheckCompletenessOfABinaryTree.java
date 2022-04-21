package com.wen.TwentiethFifty;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree {
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

//    // Level order traversal, found last node with child, then if there's another node with child after it, it's incomplete
//    public boolean isCompleteTree(TreeNode root) {
//        Queue<TreeNode> q=new LinkedList<>();
//        q.offer(root);
//        boolean visitedLastNodeWithChild=false;
//        while(!q.isEmpty()){
//            int size=q.size();
//            while(size-->0){
//                TreeNode cur=q.poll();
//                if(!visitedLastNodeWithChild){
//                    if(cur.left!=null && cur.right!=null){
//                        q.offer(cur.left);
//                        q.offer(cur.right);
//                    } else{
//                        visitedLastNodeWithChild=true;
//                        if(cur.left==null && cur.right!=null){
//                            return false;
//                        }
//                        if(cur.left!=null){
//                            q.offer(cur.left);
//                        }
//                    }
//                } else{
//                    if(cur.left!=null || cur.right!=null){
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }

    // Level order traversal, in the end only null should be in the Queue, otherwise it's incomplete
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(q.peek()!=null){
            TreeNode cur=q.poll();
            if(cur!=null){
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        while(!q.isEmpty() && q.peek()==null){
            TreeNode cur=q.poll();
        }
        return q.isEmpty();
    }
}
