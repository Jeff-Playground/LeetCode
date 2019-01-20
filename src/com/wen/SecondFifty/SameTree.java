package com.wen.SecondFifty;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SameTree {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

//    // Levelorder
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        Queue<TreeNode> queueP=new LinkedList<>();
//        Queue<TreeNode> queueQ=new LinkedList<>();
//        queueP.add(p);
//        queueQ.add(q);
//        while(!queueP.isEmpty() && !queueQ.isEmpty()){
//            TreeNode tP=queueP.poll();
//            TreeNode tQ=queueQ.poll();
//            if(tP!=null && tQ!=null) {
//                if(tP.val!=tQ.val || queueP.size()!=queueQ.size()){
//                    return false;
//                } else{
//                    ((LinkedList<TreeNode>) queueP).push(tP.left);
//                    ((LinkedList<TreeNode>) queueP).push(tP.right);
//                    ((LinkedList<TreeNode>) queueQ).push(tQ.left);
//                    ((LinkedList<TreeNode>) queueQ).push(tQ.right);
//                }
//            } else if(tP==null && tQ==null){
//                continue;
//            } else{
//                return false;
//            }
//        }
//        return true;
//    }

    // Inorder
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p==null && q!=null) || (p!=null && q==null)){
            return false;
        }
        Stack<TreeNode> stackP=new Stack<>();
        Stack<TreeNode> stackQ=new Stack<>();
        while((p!=null || !stackP.isEmpty()) && (q!=null || !stackQ.isEmpty())){
            while(p!=null){
                stackP.push(p);
                p= p.left;
            }
            while(q!=null){
                stackQ.push(q);
                q= q.left;
            }
            TreeNode tP=stackP.pop();
            TreeNode tQ=stackQ.pop();
            if(tP.val!= tQ.val){
                return false;
            }
            if(stackP.size()!= stackQ.size()){
                return false;
            }
            p=tP.right;
            q=tQ.right;
        }
        return stackP.size()==stackQ.size() && ((p==null && q==null) || (p!=null && q!=null && p.val==q.val));
    }

//    // Preorder
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        Stack<TreeNode> stackP=new Stack<>();
//        Stack<TreeNode> stackQ=new Stack<>();
//        if(p!=null){
//            stackP.push(p);
//        }
//        if(q!=null){
//            stackQ.push(q);
//        }
//        while(!stackP.isEmpty() && !stackQ.isEmpty()){
//            TreeNode tP=stackP.pop();
//            TreeNode tQ=stackQ.pop();
//            if(tP.val!= tQ.val){
//                return false;
//            }
//            if(tP.left!=null){
//                stackP.push(tP.left);
//            }
//            if(tQ.left!=null){
//                stackQ.push(tQ.left);
//            }
//            if(stackP.size()!= stackQ.size()){
//                return false;
//            }
//            if(tP.right!=null){
//                stackP.push(tP.right);
//            }
//            if(tQ.right!=null){
//                stackQ.push(tQ.right);
//            }
//            if(stackP.size()!= stackQ.size()){
//                return false;
//            }
//        }
//        return stackP.size()==stackQ.size();
//    }

//    // DFS
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if(p==null && q==null){
//            return true;
//        }
//        if((p==null && q!=null) || (p!=null && q==null) || p.val!=q.val){
//            return false;
//        }
//        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//    }
}
