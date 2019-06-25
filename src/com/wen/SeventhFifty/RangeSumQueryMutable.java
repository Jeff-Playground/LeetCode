package com.wen.SeventhFifty;

public class RangeSumQueryMutable {
    // Binary indexed tree
    class NumArray {
        int[] nums=null;
        int[] biTree=null;

        public NumArray(int[] nums) {
            this.nums=new int[nums.length];
            this.biTree=new int[nums.length+1];
            for(int i=0; i<nums.length; i++){
                update(i, nums[i]);
            }
        }

        public void update(int i, int val) {
            if(i<0 || i>nums.length-1){
                return;
            }
            int diff=val-nums[i];
            nums[i]=val;
            for(int j=i+1; j<biTree.length; j+=(j&(-j))){
                biTree[j]+=diff;
            }
        }

        public int getSum(int i){
            if(i+1>biTree.length-1){
                i=biTree.length-2;
            }
            int result=0;
            for(int j=i+1; j>0; j-=(j&(-j))){
                result+=biTree[j];
            }
            return result;
        }

        public int sumRange(int i, int j) {
            return getSum(j)-getSum(i-1);
        }
    }
}
