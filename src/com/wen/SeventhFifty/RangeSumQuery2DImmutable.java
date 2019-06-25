package com.wen.SeventhFifty;

public class RangeSumQuery2DImmutable {
    // Segment Tree
    class NumArray {
        int[]  segTree=null;
        int length=-1;

        public NumArray(int[] nums) {
            length=nums.length;
            segTree=new int[4*length];
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
            buildTree(segTree, 2*treeIndex+1, nums, low, mid);
            buildTree(segTree, 2*treeIndex+2, nums, mid+1, high);
            segTree[treeIndex]=segTree[2*treeIndex+1]+segTree[2*treeIndex+2];
        }

        public int queryTree(int[] segTree, int treeIndex, int low, int high, int i, int j){
            if(i>high || j<low){
                return 0;
            }
            if(i<=low && j>=high){
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

        public void updateTree(int[] segTree, int treeIndex, int low, int high, int i, int val){
            if(i>high || i<low){
                return;
            }
            if(low==high){
                segTree[treeIndex]=val;
                return;
            }
            int mid=low+(high-low)/2;
            if(i<=mid){
                updateTree(segTree, 2*treeIndex+1, low, mid, i, val);
            } else{
                updateTree(segTree, 2*treeIndex+2, mid+1, high, i, val);
            }
            segTree[treeIndex]=segTree[2*treeIndex+1]+segTree[2*treeIndex+2];
        }

        public void update(int i, int val) {
            updateTree(segTree, 0, 0, length-1, i, val);
        }

        public int sumRange(int i, int j) {
            return queryTree(segTree, 0, 0, length-1, i, j);
        }
    }
}
