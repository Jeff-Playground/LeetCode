package com.wen.ThirdFifty;

public class ConvertSortedArrayToBinarySearchTree {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return satbHelper(nums, 0, nums.length-1);
    }

    private TreeNode satbHelper(int[] nums, int min, int max){
        if(min==max){
            return new TreeNode(nums[min]);
        } else if(min>max){
            return null;
        } else{
            int mid=min+(max-min)/2;
            TreeNode root=new TreeNode(nums[mid]);
            root.left=satbHelper(nums, min, mid-1);
            root.right=satbHelper(nums, mid+1, max);
            return root;
        }
    }
}
