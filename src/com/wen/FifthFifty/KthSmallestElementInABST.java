package com.wen.FifthFifty;

import java.util.Stack;

public class KthSmallestElementInABST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Recreate tree with count of all nodes in both subtrees including self(note the count is not the index of current
    // node)
    class MyTreeNode{
        int val;
        int count;
        MyTreeNode left;
        MyTreeNode right;

        public MyTreeNode(int val){
            this.val=val;
            this.count=1;
            this.left=null;
            this.right=null;
        }
    }

    public MyTreeNode build(TreeNode node){
        if(node==null){
            return null;
        }
        MyTreeNode cur=new MyTreeNode(node.val);
        cur.left=build(node.left);
        cur.right=build(node.right);
        if(cur.left!=null){
            cur.count+=cur.left.count;
        }
        if(cur.right!=null){
            cur.count+=cur.right.count;
        }
        return cur;
    }

    public int kthSmallest(TreeNode root, int k) {
        MyTreeNode myRoot=build(root);
        return helper(myRoot, k);
    }

    public int helper(MyTreeNode node, int k){
        if(node.left!=null){
            int count=node.left.count;
            if(count>=k){
                return helper(node.left, k);
            } else if(count==k-1){
                return node.val;
            } else{
                return helper(node.right, k-count-1);
            }
        } else{
            if(k==1){
                return node.val;
            } else{
                return helper(node.right, k-1);
            }
        }
    }

//    // Recursive with count
//    public int kthSmallest(TreeNode root, int k) {
//        int count=count(root.left);
//        if(count>=k){
//            return kthSmallest(root.left, k);
//        } else if(count==k-1){
//            return root.val;
//        } else{
//            return kthSmallest(root.right, k-count-1);
//        }
//    }
//
//    public int count(TreeNode node) {
//        if(node==null){
//            return 0;
//        } else{
//            return 1+count(node.left)+count(node.right);
//        }
//    }

//    // Recursive for inorder traversal
//    public int kthSmallest(TreeNode root, int k) {
//        return kthSmallestDFS(root, new int[]{k});
//    }
//
//    public int kthSmallestDFS(TreeNode node, int[] count) {
//        if(node==null){
//            return -1;
//        }
//        int val=kthSmallestDFS(node.left, count);
//        if(count[0]==0){
//            return val;
//        } else if(--count[0]==0){
//            return node.val;
//        } else{
//            return kthSmallestDFS(node.right, count);
//        }
//    }

//    // Inorder traversal with stack
//    public int kthSmallest(TreeNode root, int k) {
//        int count=0;
//        Stack<TreeNode> stack=new Stack<>();
//        TreeNode cur=root;
//        while(!stack.isEmpty() || cur!=null){
//            if(cur!=null){
//                stack.push(cur);
//                cur=cur.left;
//            } else{
//                cur=stack.pop();
//                count++;
//                if(count==k){
//                    return cur.val;
//                }
//                cur=cur.right;
//            }
//        }
//        return -1;
//    }
}
