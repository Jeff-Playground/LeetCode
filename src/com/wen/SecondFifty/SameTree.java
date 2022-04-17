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
//                    queueP.offer(tP.left);
//                    queueP.offer(tP.right);
//                    queueQ.offer(tQ.left);
//                    queueQ.offer(tQ.right);
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
            if(p!=null && q!=null){
                stackP.push(p);
                p=p.left;
                stackQ.push(q);
                q=q.left;
            } else if(p==null && q==null){
                p=stackP.pop();
                q=stackQ.pop();
                if(p.val!=q.val){
                    return false;
                }
                p=p.right;
                q=q.right;
            } else{
                return false;
            }
        }
        return true;
    }

//    // Preorder
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if(p!=null && q!=null){
//            Stack<TreeNode> stackP=new Stack<>();
//            Stack<TreeNode> stackQ=new Stack<>();
//            while((!stackP.isEmpty() || p!=null) && (!stackQ.isEmpty() || q!=null)){
//                if(p!=null && q!=null){
//                    if(p.val!=q.val){
//                        return false;
//                    }
//                    stackP.push(p);
//                    p=p.left;
//                    stackQ.push(q);
//                    q=q.left;
//                } else if(p==null && q==null){
//                    p=stackP.pop();
//                    p=p.right;
//                    q=stackQ.pop();
//                    q=q.right;
//                } else{
//                    return false;
//                }
//            }
//            return true;
//        } else{
//            return p==null && q==null;
//        }
//    }

//    // Postorder
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if((p==null && q!=null) || (p!=null && q==null)){
//            return false;
//        }
//        Stack<TreeNode> stackP=new Stack<>();
//        Stack<TreeNode> stackQ=new Stack<>();
//        TreeNode preP=null, preQ=null;
//        while((p!=null || !stackP.isEmpty()) && (q!=null || !stackQ.isEmpty())){
//            while(p!=null || q!=null){
//                if(p==null || q==null){
//                    return false;
//                }
//                stackP.push(p);
//                p= p.left;
//                stackQ.push(q);
//                q= q.left;
//            }
//            p=stackP.peek();
//            q=stackQ.peek();
//            if((p.right==null || p.right==preP) && (q.right==null || q.right==preQ)){
//                stackP.pop();
//                stackQ.pop();
//                if(p.val!=q.val){
//                    return false;
//                }
//                preP=p;
//                preQ=q;
//                p=null;
//                q=null;
//            } else{
//                p=p.right;
//                q=q.right;
//            }
//        }
//        return stackP.size()==stackQ.size();
//    }

//    // DFS
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if(p==null && q==null){
//            return true;
//        } else if(p==null){
//            return false;
//        } else if(q==null){
//            return false;
//        } else{
//            if(p.val==q.val){
//                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//            } else{
//                return false;
//            }
//        }
//    }
}
