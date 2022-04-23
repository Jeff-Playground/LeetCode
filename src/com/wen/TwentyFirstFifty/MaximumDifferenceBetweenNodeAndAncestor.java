package com.wen.TwentyFirstFifty;

public class MaximumDifferenceBetweenNodeAndAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // With cache
    public int maxAncestorDiff(TreeNode root) {
        int[] cache=new int[1];
        maxAncestorDiffHelper(root, root.val, root.val, cache);
        return cache[0];
    }

    private void maxAncestorDiffHelper(TreeNode node, int min, int max, int[] cache){
        if(node!=null){
            cache[0]=Math.max(cache[0], Math.max(Math.abs(node.val-min), Math.abs(node.val-max)));
            maxAncestorDiffHelper(node.left, Math.min(min, node.val), Math.max(max, node.val), cache);
            maxAncestorDiffHelper(node.right, Math.min(min, node.val), Math.max(max, node.val), cache);
        }
    }

//    // Without cache
//    public int maxAncestorDiff(TreeNode root) {
//        return maxAncestorDiffHelper(root, root.val, root.val);
//    }
//
//    private int maxAncestorDiffHelper(TreeNode node, int min, int max){
//        int result=Math.max(Math.abs(node.val-min), Math.abs(node.val-max));
//        if(node.left!=null){
//            result=Math.max(result, maxAncestorDiffHelper(node.left, Math.min(node.val, min), Math.max(node.val, max)));
//        }
//        if(node.right!=null){
//            result=Math.max(result, maxAncestorDiffHelper(node.right, Math.min(node.val, min), Math.max(node.val, max)));
//        }
//        return result;
//    }
}
