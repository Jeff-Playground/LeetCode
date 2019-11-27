package com.wen.FifthFifty;

public class LQCountUnivalueSubtrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    // Postorder traversal dfs2
//    public int countUnivalSubtrees(TreeNode root) {
//        int[] result=new int[] {0};
//        countUnivalSubtreesDFS(root, -1, result);
//        return result[0];
//    }
//
//    public boolean countUnivalSubtreesDFS(TreeNode node, int parentVal, int[] result) {
//        if(node==null) {
//            return true;
//        }
//        if(!countUnivalSubtreesDFS(node.left, node.val, result) | !countUnivalSubtreesDFS(node.right, node.val, result)) {
//            return false;
//        }
//        result[0]++;
//        return node.val==parentVal;
//    }

    // Postorder traversal dfs
    public int countUnivalSubtrees(TreeNode root) {
        if(root==null) {
            return 0;
        } else {
            int[] result=new int[] {0};
            countUnivalSubtreesDFS(root, result);
            return result[0];
        }
    }

    public boolean countUnivalSubtreesDFS(TreeNode node, int[] count){
        if(node==null){
            return true;
        } else if(countUnivalSubtreesDFS(node.left, count) & countUnivalSubtreesDFS(node.right, count)){
            if((node.left!=null && node.val==node.left.val || node.left==null) && (node.right!=null && node.val==node.right.val || node.right==null)){
                count[0]++;
                return true;
            } else{
                return false;
            }
        } else{
            return false;
        }
    }
}
