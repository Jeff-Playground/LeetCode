package com.wen.SeventhFifty;

public class RangeSumQueryImmutable {
    // Segment Tree
    public static class NumArray {
        int[] segTree=null;
        int length=-1;

        public NumArray(int[] nums) {
            length=nums.length;
            segTree=new int[4*nums.length];
            buildTree(segTree, 0, nums, 0, nums.length-1);
        }

        public void buildTree(int[] segTree, int treeIndex, int[] nums, int low, int high){
            if(low>high){
                return;
            }
            if(low==high){
                segTree[treeIndex]=nums[low];
                return;
            }

            int mid=low+(high-low)/2;
            buildTree(segTree, treeIndex*2+1, nums, low, mid);
            buildTree(segTree, treeIndex*2+2, nums, mid+1, high);

            segTree[treeIndex]=segTree[treeIndex*2+1]+segTree[treeIndex*2+2];
        }

        public int queryTree(int[] segTree, int treeIndex, int low, int high, int i, int j){
            if(low>j || high<i){
                return 0;
            }
            if(i<=low && high<=j){
                return segTree[treeIndex];
            }

            int mid=low+(high-low)/2;
            if(mid>=j){
                return queryTree(segTree, treeIndex*2+1, low, mid, i, j);
            } else if(mid<i){
                return queryTree(segTree, treeIndex*2+2, mid+1, high, i, j);
            } else{
                int left=queryTree(segTree, treeIndex*2+1, low, mid, i, mid);
                int right=queryTree(segTree, treeIndex*2+2, mid+1, high, mid+1, j);
                return left+right;
            }
        }

        public int sumRange(int i, int j) {
            return queryTree(segTree, 0, 0, length-1, i, j);
        }
    }

//    // DP
//    // dp[i] stands for the sum of numbers before nums[i] inclusively
//    class NumArray {
//        private int[] dp=null;
//
//        public NumArray(int[] nums) {
//            dp=new int[nums.length+1];
//            for(int i=0; i<nums.length; i++){
//                dp[i+1]=dp[i]+nums[i];
//            }
//        }
//
//        public int sumRange(int i, int j) {
//            return dp[j+1]-dp[i];
//        }
//    }
}
