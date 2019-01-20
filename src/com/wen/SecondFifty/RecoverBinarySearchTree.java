package com.wen.SecondFifty;

import java.util.Stack;

public class RecoverBinarySearchTree {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // Stack
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root, pre=null, first=null, second=null;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode t=stack.pop();
            if(pre!=null && t.val<=pre.val){
                if(first==null){
                    first=pre;
                }
                second=t;
            }
            pre=t;
            cur=t.right;
        }
        if(first!=null && second!=null){
            int temp=first.val;
            first.val=second.val;
            second.val=temp;
        }
    }

//    // This works for any nodes out of order because it sorts values of all nodes
//    public void recoverTree(TreeNode root) {
//        List<TreeNode> nodes=new ArrayList<>();
//        List<Integer> values=new ArrayList<>();
//        treeTraverse(root, nodes, values);
//        values.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer n1, Integer n2) {
//                if(n1<n2){
//                    return -1;
//                } else if(n1>n2){
//                    return 1;
//                } else{
//                    return 0;
//                }
//            }
//        });
//        for(int i=0; i<nodes.size(); i++){
//            nodes.get(i).val=values.get(i);
//        }
//    }
//
//    private void treeTraverse(TreeNode root, List<TreeNode> nodes, List<Integer> values) {
//        if(root==null){
//            return;
//        }
//        treeTraverse(root.left, nodes, values);
//        nodes.add(root);
//        values.add(root.val);
//        treeTraverse(root.right, nodes, values);
//    }

//    // Morris traversal
//    public void recoverTree(TreeNode root) {
//        TreeNode pre=null, last=null, cur=root, first=null, second=null;
//        while(cur!=null){
//            if(cur.left==null){
//                if(last!=null){
//                    if(last.val>=cur.val){
//                        if(first==null){
//                            first=last;
//                        }
//                        second=cur;
//                    }
//                }
//                last=cur;
//                cur=cur.right;
//            } else{
//                pre=cur.left;
//                while(pre.right!=null && pre.right!=cur){
//                    pre=pre.right;
//                }
//                if(pre.right==null){
//                    pre.right=cur;
//                    cur=cur.left;
//                } else{
//                    pre.right=null;
//                    if(last.val>=cur.val){
//                        if(first==null){
//                            first=last;
//                        }
//                        second=cur;
//                    }
//                    last=cur;
//                    cur=cur.right;
//                }
//            }
//        }
//        if(first!=null && second!=null){
//            int temp=first.val;
//            first.val=second.val;
//            second.val=temp;
//        }
//    }
}
