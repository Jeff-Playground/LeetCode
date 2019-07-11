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

    public boolean countUnivalSubtreesDFS(TreeNode node, int[] result) {
        boolean left=node.left!=null?countUnivalSubtreesDFS(node.left, result):true;
        boolean right=node.right!=null?countUnivalSubtreesDFS(node.right, result):true;
        if(node.left==null && node.right==null) {
            result[0]++;
            return true;
        } else if(node.left!=null && node.right==null) {
            if(left && node.left.val==node.val) {
                result[0]++;
                return true;
            }
        } else if(node.left==null && node.right!=null) {
            if(right && node.right.val==node.val) {
                result[0]++;
                return true;
            }
        } else {
            if(left && right && node.left.val==node.val && node.left.val==node.right.val) {
                result[0]++;
                return true;
            }
        }
        return false;
    }
}
