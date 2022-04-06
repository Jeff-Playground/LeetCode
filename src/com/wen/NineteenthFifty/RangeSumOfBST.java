package com.wen.NineteenthFifty;

public class RangeSumOfBST {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] result=new int[]{0};
        rsbstHelper(root, low, high, result);
        return result[0];
    }

    private void rsbstHelper(TreeNode node, int low, int high, int[] cache){
        if(node!=null){
            if(node.val>=low && node.val<=high){
                cache[0]+=node.val;
                rsbstHelper(node.right, low, high, cache);
                rsbstHelper(node.left, low, high, cache);
            } else if(node.val<low){
                rsbstHelper(node.right, low, high, cache);
            } else{
                rsbstHelper(node.left, low, high, cache);
            }
        }
    }
}
