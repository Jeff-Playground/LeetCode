package com.wen.SixthFifty;

public class LQBinaryTreeLongestConsecutiveSequence {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    // Postorder traversal
//    public int longestConsecutive(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        int[] result=new int[]{1};
//        longestConsecutiveDFS(root, result);
//        return result[0];
//    }
//
//    public int longestConsecutiveDFS(TreeNode node, int[] result) {
//        if(node==null){
//            return 0;
//        } else{
//            int max=1;
//            int left=longestConsecutiveDFS(node.left, result);
//            int right=longestConsecutiveDFS(node.right, result);
//            if(node.left!=null && node.left.val==node.val+1){
//                max=left+1;
//            }
//            if(node.right!=null && node.right.val==node.val+1){
//                max=Math.max(max, right+1);
//            }
//            result[0]=Math.max(result[0], max);
//            return max;
//        }
//    }

    // Preorder traversal
    public int longestConsecutive(TreeNode root) {
        if(root==null){
            return 0;
        } else{
            int[] result=new int[]{0};
            longestConsecutiveHelper(root, result, 1);
            return result[0];
        }
    }

    public void longestConsecutiveHelper(TreeNode node, int[] max, int count){
        if((node.left==null || node.left.val!=node.val+1) && (node.right==null || node.right.val!=node.val+1)){
            max[0]=Math.max(max[0], count);
            if(node.left!=null){
                longestConsecutiveHelper(node.left, max, 1);
            }
            if(node.right!=null){
                longestConsecutiveHelper(node.right, max, 1);
            }
        } else{
            if(node.left!=null && node.left.val==node.val+1){
                longestConsecutiveHelper(node.left, max, count+1);
            }
            if(node.right!=null && node.right.val==node.val+1){
                longestConsecutiveHelper(node.right, max, count+1);
            }
        }
    }
}
