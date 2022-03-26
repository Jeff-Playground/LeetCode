package com.wen.SeventhFifty;

public class RangeSumQueryMutable {
//    // Blocks
//    class NumArray {
//        int[] blocks;
//        int l;
//        int[] nums;
//
//        public NumArray(int[] nums) {
//            l=(int)Math.ceil(Math.sqrt(nums.length));
//            blocks=new int[l];
//            this.nums=nums;
//            for(int i=0; i<nums.length; i++){
//                blocks[i/l]+=nums[i];
//            }
//        }
//
//        public void update(int i, int val) {
//            blocks[i/l]=blocks[i/l]-nums[i]+val;
//            nums[i]=val;
//        }
//
//        public int sumRange(int i, int j) {
//            int result=0;
//            if(i>=0 && j<nums.length && i<=j){
//                int index1=i/l, index2=j/l;
//                if(index1==index2){
//                    for(int x=i; x<=j; x++){
//                        result+=nums[x];
//                    }
//                } else{
//                    for(int x=i; x/l==index1; x++){
//                        result+=nums[x];
//                    }
//                    for(int x=index1+1; x<index2; x++){
//                        result+=blocks[x];
//                    }
//                    for(int x=index2*l; x<=j; x++){
//                        result+=nums[x];
//                    }
//                }
//                return result;
//            } else{
//                throw new IllegalArgumentException("Invalid inputs!");
//            }
//        }
//    }

//    // Segment Tree, implemented with array
//    class NumArray {
//        int[]  segTree=null;
//        int length=-1;
//
//        public NumArray(int[] nums) {
//            length=nums.length;
//            segTree=new int[4*length];
//            buildTree(segTree, 0, nums, 0, nums.length-1);
//        }
//
//        public void buildTree(int[] segTree, int treeIndex, int[] nums, int low, int high){
//            if(low>high){
//                return;
//            }
//            if(low==high){
//                segTree[treeIndex]=nums[low];
//                return;
//            }
//            int mid=low+(high-low)/2;
//            buildTree(segTree, 2*treeIndex+1, nums, low, mid);
//            buildTree(segTree, 2*treeIndex+2, nums, mid+1, high);
//            segTree[treeIndex]=segTree[2*treeIndex+1]+segTree[2*treeIndex+2];
//        }
//
//        public int queryTree(int[] segTree, int treeIndex, int low, int high, int i, int j){
//            if(i>high || j<low){
//                return 0;
//            }
//            if(i<=low && j>=high){
//                return segTree[treeIndex];
//            }
//            int mid=low+(high-low)/2;
//            if(mid>=j){
//                return queryTree(segTree, treeIndex*2+1, low, mid, i, j);
//            } else if(mid<i){
//                return queryTree(segTree, treeIndex*2+2, mid+1, high, i, j);
//            } else{
//                int left=queryTree(segTree, treeIndex*2+1, low, mid, i, mid);
//                int right=queryTree(segTree, treeIndex*2+2, mid+1, high, mid+1, j);
//                return left+right;
//            }
//        }
//
//        public void updateTree(int[] segTree, int treeIndex, int low, int high, int i, int val){
//            if(i>high || i<low){
//                return;
//            }
//            if(low==high){
//                segTree[treeIndex]=val;
//                return;
//            }
//            int mid=low+(high-low)/2;
//            if(i<=mid){
//                updateTree(segTree, 2*treeIndex+1, low, mid, i, val);
//            } else{
//                updateTree(segTree, 2*treeIndex+2, mid+1, high, i, val);
//            }
//            segTree[treeIndex]=segTree[2*treeIndex+1]+segTree[2*treeIndex+2];
//        }
//
//        public void update(int i, int val) {
//            updateTree(segTree, 0, 0, length-1, i, val);
//        }
//
//        public int sumRange(int i, int j) {
//            return queryTree(segTree, 0, 0, length-1, i, j);
//        }
//    }

//    // Binary indexed tree
//    class NumArray {
//        int[] nums=null;
//        int[] biTree=null;
//
//        public NumArray(int[] nums) {
//            this.nums=new int[nums.length];
//            this.biTree=new int[nums.length+1];
//            for(int i=0; i<nums.length; i++){
//                update(i, nums[i]);
//            }
//        }
//
//        public void update(int i, int val) {
//            if(i<0 || i>nums.length-1){
//                return;
//            }
//            int diff=val-nums[i];
//            nums[i]=val;
//            for(int j=i+1; j<biTree.length; j+=(j&(-j))){
//                biTree[j]+=diff;
//            }
//        }
//
//        public int getSum(int i){
//            if(i+1>biTree.length-1){
//                i=biTree.length-2;
//            }
//            int result=0;
//            for(int j=i+1; j>0; j-=(j&(-j))){
//                result+=biTree[j];
//            }
//            return result;
//        }
//
//        public int sumRange(int i, int j) {
//            return getSum(j)-getSum(i-1);
//        }
//    }

    // Segment Tree, implemented with Tree
    public static class NumArray {
        private class SegmentTreeNode{
            int sum, min, max;
            SegmentTreeNode left, right;

            public SegmentTreeNode(int min, int max){
                this.sum=0;
                this.min=min;
                this.max=max;

                if(min<max){
                    int mid=min+(max-min)/2;
                    this.left=new SegmentTreeNode(min, mid);
                    this.right=new SegmentTreeNode(mid+1, max);
                }
            }

            public void update(int idx, int diff){
                if(idx==min && idx==max){
                    sum+=diff;
                } else{
                    int mid=min+(max-min)/2;
                    if(idx<=mid){
                        left.update(idx, diff);
                    } else{
                        right.update(idx, diff);
                    }
                    sum=left.sum+right.sum;
                }
            }

            public int sumRange(int l, int r) {
                if(l>max || r<min){
                    return 0;
                } else if(l<min){
                    return this.sumRange(min, r);
                } else if(r>max){
                    return this.sumRange(l, max);
                } else{
                    if(l==min && r==max){
                        return sum;
                    } else{
                        int mid=min+(max-min)/2;
                        if(mid>=r){
                            return left.sumRange(l, r);
                        } else if(mid<l){
                            return right.sumRange(l, r);
                        } else{
                            return left.sumRange(l, mid)+right.sumRange(mid+1, r);
                        }
                    }
                }
            }
        }

        int[] nums;
        SegmentTreeNode root;

        public NumArray(int[] nums) {
            this.nums=nums;
            int l=nums.length;
            root=new SegmentTreeNode(0, l-1);
            for(int i=0; i<l; i++){
                root.update(i, nums[i]);
            }
        }

        public void update(int index, int val) {
            root.update(index, val-nums[index]);
            nums[index]=val;
        }

        public int sumRange(int left, int right) {
            return root.sumRange(left, right);
        }
    }
}
