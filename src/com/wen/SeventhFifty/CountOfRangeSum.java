package com.wen.SeventhFifty;

import java.util.*;

public class CountOfRangeSum {
    // Divide and conquer
    public int countRangeSum(int[] nums, int lower, int upper) {
        int l=nums.length;
        long[] sums=new long[l+1];
        for(int i=1; i<=l; i++){
            sums[i]=sums[i-1]+nums[i-1];
        }
        return crsHelper(sums, 0, l, lower, upper);
    }

    private int crsHelper(long[] sums, int left, int right, int lower, int upper){
        if(left>=right){
            return 0;
        }
        int mid=left+(right-left)/2;
        int result=crsHelper(sums, left, mid, lower, upper)+crsHelper(sums, mid+1, right, lower, upper);
        int i=mid+1, j=mid+1;
        for(int k=left; k<=mid; k++){
            while(i<=right && sums[i]-sums[k]<lower){
                i++;
            }
            while(j<=right && sums[j]-sums[k]<=upper){
                j++;
            }
            result+=j-i;
        }
        i=left;
        j=mid+1;
        long[] sorted=new long[right-left+1];
        for(int k=left; k<=right; k++){
            long num1=i<=mid?sums[i]:Long.MAX_VALUE;
            long num2=j<=right?sums[j]:Long.MAX_VALUE;
            sorted[k-left]=num1<num2?sums[i++]:sums[j++];
        }
        for(int k=left; k<=right; k++){
            sums[k]=sorted[k-left];
        }
        return result;
    }

//    // Segment tree
//    public static int countRangeSum(int[] nums, int lower, int upper) {
//        int result=0;
//        long sum=0, min=Long.MAX_VALUE, max=Long.MIN_VALUE;
//        for(int num: nums){
//            min=Math.min(min, sum);
//            max=Math.max(max, sum);
//            sum+=num;
//        }
//        SegmentTreeNode root=new SegmentTreeNode(min, max);
//        sum=0;
//        root.update(0,1);
//        for(int num: nums){
//            sum+=num;
//            result+=root.query(sum-upper, sum-lower);
//            root.update(sum, 1);
//        }
//        return result;
//    }
//
//    private static class SegmentTreeNode{
//        SegmentTreeNode left, right;
//        long min, max;
//        int count;
//        public SegmentTreeNode(long min, long max){
//            this.min=min;
//            this.max=max;
//            this.count=0;
//        }
//
//        public void update(long sum, int diff){
//            if(sum>=min && sum<=max){
//                count+=diff;
//                if(min<max){
//                    getLeft().update(sum, diff);
//                    getRight().update(sum, diff);
//                }
//            }
//        }
//
//        public int query(long low, long up){
//           if(low>max || up<min){
//               return 0;
//           } else if(low<=min && up>=max){
//               return count;
//           } else{
//               return getLeft().query(low, up)+getRight().query(low, up);
//           }
//        }
//
//        private SegmentTreeNode getLeft(){
//            if(this.left==null){
//                this.left=new SegmentTreeNode(min, getMid());
//            }
//            return this.left;
//        }
//
//        private SegmentTreeNode getRight(){
//            if(this.right==null){
//                this.right=new SegmentTreeNode(this.getMid()+1, max);
//            }
//            return this.right;
//        }
//
//        private long getMid(){
//            return this.min+(this.max-this.min)/2;
//        }
//    }

//    // Binary indexed tree1, got rid of rank mapping by using Collections.binarySearch
//    public static int countRangeSum(int[] nums, int lower, int upper) {
//        int result=0;
//        long sum=0;
//        TreeSet<Long> sortedSum=new TreeSet<>();
//        sortedSum.add(Long.MIN_VALUE);
//        sortedSum.add(0L);
//        for(int num: nums){
//            sum+=num;
//            sortedSum.add(sum);
//            sortedSum.add(sum-lower);
//            sortedSum.add(sum-upper-1);
//        }
//        List<Long> sortedSumList=new ArrayList<>(sortedSum);
//        int[] count=new int[sortedSumList.size()];
//        sum=0;
//        updateCount(count, Collections.binarySearch(sortedSumList, sum));
//        for(int num: nums){
//            sum+=num;
//            result+=getCount(count, Collections.binarySearch(sortedSumList, sum-lower))-getCount(count, Collections.binarySearch(sortedSumList, sum-upper-1));
//            updateCount(count, Collections.binarySearch(sortedSumList, sum));
//        }
//        return result;
//    }
//
////    // Binary indexed tree2
////    public static int countRangeSum(int[] nums, int lower, int upper) {
////        int result=0;
////        long sum=0;
////        TreeSet<Long> sortedSum=new TreeSet<>();
////        sortedSum.add(0L);
////        for(int num: nums){
////            sum+=num;
////            sortedSum.add(sum);
////        }
////        Map<Long, Integer> ranks=new HashMap<>();
////        int rank=1;
////        for(long key: sortedSum){
////            ranks.put(key, rank++);
////        }
////        int[] count=new int[rank];
////        sum=0;
////        updateCount(count, ranks.get(sum));
////        for(int num: nums){
////            sum+=num;
////            int upIdx=sortedSum.floor(sum-lower)!=null?ranks.get(sortedSum.floor(sum-lower)):0;
////            int lowIdx=sortedSum.floor(sum-upper-1)!=null?ranks.get(sortedSum.floor(sum-upper-1)):0;
////            result+=getCount(count, upIdx)-getCount(count, lowIdx);
////            updateCount(count, ranks.get(sum));
////        }
////        return result;
////    }
//
//    private static void updateCount(int[] count, int idx) {
//        int l=count.length;
//        for(int i=idx; i<l; i+=i&(-i)){
//            count[i]++;
//        }
//    }
//
//    private static int getCount(int[] count, int idx) {
//        int result=0;
//        for(int i=idx; i>=1; i-=i&(-i)){
//            result+=count[i];
//        }
//        return result;
//    }
}
