package com.wen.NineteenthFifty;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeInserter {
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

    // 1 Queue
    class CBTInserter {
        Queue<TreeNode> q;
        TreeNode root;

        public CBTInserter(TreeNode root) {
            this.root=root;
            q=new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                TreeNode cur=q.peek();
                if(cur.left!=null && cur.right!=null){
                    q.offer(cur.left);
                    q.offer(cur.right);
                    q.poll();
                } else{
                    break;
                }
            }
        }

        public int insert(int val) {
            TreeNode parent=q.peek();
            if(parent.left==null){
                parent.left=new TreeNode(val);
            } else{
                parent.right=new TreeNode(val);
                q.offer(parent.left);
                q.offer(parent.right);
                q.poll();
            }
            return parent.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

//    // Actually no need to use 2 Queues, 1 should be sufficient
//    class CBTInserter {
//        TreeNode root;
//        Queue<TreeNode> completeParent;
//        Queue<TreeNode> incompleteParent;
//
//        public CBTInserter(TreeNode root) {
//            this.root=root;
//            completeParent=new LinkedList<>();
//            incompleteParent=new LinkedList<>();
//            incompleteParent.offer(root);
//            organize();
//        }
//
//        private void organize(){
//            boolean ready=false;
//            while(!ready){
//                while(!incompleteParent.isEmpty()){
//                    TreeNode cur=incompleteParent.peek();
//                    if(cur.left!=null && cur.right!=null){
//                        completeParent.offer(incompleteParent.poll());
//                    } else{
//                        break;
//                    }
//                }
//                if(incompleteParent.isEmpty()){
//                    while(!completeParent.isEmpty()){
//                        TreeNode cur=completeParent.poll();
//                        incompleteParent.offer(cur.left);
//                        incompleteParent.offer(cur.right);
//                    }
//                } else{
//                    ready=true;
//                }
//            }
//        }
//
//        public int insert(int val) {
//            TreeNode parent=incompleteParent.peek();
//            if(parent.left==null){
//                parent.left=new TreeNode(val);
//            } else{
//                parent.right=new TreeNode(val);
//                organize();
//            }
//            return parent.val;
//        }
//
//        public TreeNode get_root() {
//            return root;
//        }
//    }
}
