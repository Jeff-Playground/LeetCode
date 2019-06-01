package com.wen.EleventhFifty;

public class ConvertBSTToGreaterTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Recursive
    public TreeNode convertBST(TreeNode root) {
        if(root==null) {
            return root;
        } else {
            int[] sum=new int[] {0};
            convertBSTDFS(root, sum);
            return root;
        }
    }

    private void convertBSTDFS(TreeNode node, int[] sum) {
        if(node==null) {
            return;
        } else {
            convertBSTDFS(node.right, sum);
            node.val+=sum[0];
            sum[0]=node.val;
            convertBSTDFS(node.left, sum);
        }
    }

//    // Morris traversal
//    public TreeNode convertBST(TreeNode root) {
//        TreeNode cur=root, pre=null;
//        int sum=0;
//        while(cur!=null) {
//            if(cur.right!=null) {
//                pre=cur.right;
//                while(pre.left!=null && pre.left!=cur) {
//                    pre=pre.left;
//                }
//                if(pre.left==null) {
//                    pre.left=cur;
//                    cur=cur.right;
//                } else {
//                    pre.left=null;
//                    cur.val+=sum;
//                    sum=cur.val;
//                    cur=cur.left;
//                }
//            } else {
//                cur.val+=sum;
//                sum=cur.val;
//                cur=cur.left;
//            }
//        }
//        return root;
//    }

//    // Iterative with Stack
//    public TreeNode convertBST(TreeNode root) {
//        Stack<TreeNode> stack=new Stack<>();
//        TreeNode cur=root;
//        int sum=0;
//        while(cur!=null || !stack.isEmpty()) {
//            if(cur!=null) {
//                stack.push(cur);
//                cur=cur.right;
//            } else {
//                cur=stack.pop();
//                cur.val+=sum;
//                sum=cur.val;
//                cur=cur.left;
//            }
//        }
//        return root;
//    }
}
