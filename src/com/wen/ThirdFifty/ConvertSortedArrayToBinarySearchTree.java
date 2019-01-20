package com.wen.ThirdFifty;

public class ConvertSortedArrayToBinarySearchTree {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if(left>right){
            return null;
        }
        int mid=left+(right-left)/2;
        TreeNode cur=new TreeNode(nums[mid]);
        cur.left=sortedArrayToBST(nums, left, mid-1);
        cur.right=sortedArrayToBST(nums, mid+1, right);
        return cur;
    }
}
