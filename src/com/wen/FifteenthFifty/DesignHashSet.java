package com.wen.FifteenthFifty;

public class DesignHashSet {
//    class MyHashSet {
//        int[] nums;
//
//        public MyHashSet() {
//            nums=new int[1000001];
//        }
//
//        public void add(int key) {
//            nums[key]=1;
//        }
//
//        public void remove(int key) {
//            nums[key]=0;
//        }
//
//        public boolean contains(int key) {
//            return nums[key]==1;
//        }
//    }

    class MyHashSet {
        int[][] nums;
        int[] count;

        public MyHashSet() {
            nums=new int[1001][];
            count=new int[1001];
        }

        public void add(int key) {
            int idx=key/1000;
            if(nums[idx]==null){
                nums[idx]=new int[1000];
            }
            if(nums[idx][key%1000]==0){
                nums[idx][key%1000]=1;
                count[idx]++;
            }
        }

        public void remove(int key) {
            int idx=key/1000;
            if(nums[idx]!=null && nums[idx][key%1000]==1){
                nums[idx][key%1000]=0;
                if(count[idx]--==1){
                    nums[idx]=null;
                }
            }
        }

        public boolean contains(int key) {
            int idx=key/1000;
            return nums[idx]!=null && nums[idx][key%1000]==1;
        }
    }
}
