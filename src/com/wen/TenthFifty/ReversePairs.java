package com.wen.TenthFifty;

import java.util.*;

public class ReversePairs {
//    // Divide and conquer with merge sort
//    public int reversePairs(int[] nums) {
//        if(nums==null || nums.length<2){
//            return 0;
//        }
//        return rpHelper(nums, 0, nums.length-1);
//    }
//
//    private int rpHelper(int[] nums, int start, int end){
//        if(start>=end){
//            return 0;
//        }
//        int mid=start+(end-start)/2;
//        int result=rpHelper(nums, start, mid)+rpHelper(nums, mid+1, end);
//        int[] newNums=new int[end-start+1];
//        int firstIdx=start, secondIdx=mid+1;
//        while(firstIdx<=mid && secondIdx<=end){
//            if(nums[firstIdx]>(long)2*nums[secondIdx]){
//                result+=mid-firstIdx+1;
//                secondIdx++;
//            } else{
//                firstIdx++;
//            }
//        }
//        firstIdx=start;
//        secondIdx=mid+1;
//        for(int i=start; i<=end; i++){
//            int num1=firstIdx<=mid?nums[firstIdx]:Integer.MAX_VALUE;
//            int num2=secondIdx<=end?nums[secondIdx]:Integer.MAX_VALUE;
//            newNums[i-start]=num1<=num2?nums[firstIdx++]:nums[secondIdx++];
//        }
//        for(int i=start; i<=end; i++){
//            nums[i]=newNums[i-start];
//        }
//        return result;
//    }

    // Binary indexed tree
    public int reversePairs(int[] nums) {
        TreeSet<Integer> sorted=new TreeSet<>();
        for(int num: nums){
            sorted.add(num);
        }
        List<Integer> idx=new ArrayList<>(sorted);
        BITree t=new BITree(idx);
        int result=0;
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i]>=0){
                result+=t.queryCount((nums[i]+1)/2);
            } else{
                result+=t.queryCount(nums[i]/2);
            }
            t.updateCount(nums[i]);
        }
        return result;
    }

    private class BITree{
        List<Integer> idx;
        int[] count;

        public BITree(List<Integer> idx){
            this.idx=idx;
            count=new int[idx.size()+1];
        }

        public void updateCount(int num){
            int left=0, right=idx.size()-1;
            while(left<right){
                int mid=left+(right-left)/2;
                if(idx.get(mid)<num){
                    left=mid+1;
                } else{
                    right=mid;
                }
            }
            int numIdx=left+1;
            for(int i=numIdx; i<count.length; i+=i&(-i)){
                count[i]+=1;
            }
        }

        public int queryCount(int num){
            int left=0, right=idx.size()-1;
            while(left<right){
                int mid=left+(right-left)/2;
                if(idx.get(mid)<num){
                    left=mid+1;
                } else{
                    right=mid;
                }
            }
            int numIdx=idx.get(left)<num?left+1:left;
            int result=0;
            for(int i=numIdx; i>0; i-=i&(-i)){
                result+=count[i];
            }
            return result;
        }
    }

//    // Segment tree
//    private class SegmentTree{
//        SegmentTree left, right;
//        int low, up;
//        int count;
//
//        public SegmentTree(int low, int up){
//            this.low=low;
//            this.up=up;
//            this.count=0;
//        }
//
//        public void update(int num){
//            if(num>=low && num<=up){
//                count++;
//                if(low!=up){
//                    getLeft().update(num);
//                    getRight().update(num);
//                }
//            }
//        }
//
//        public int query(int num){
//            if(num>=up){
//                return count;
//            } else if(num>=low && num<up){
//                return getLeft().query(num)+getRight().query(num);
//            } else{
//                return 0;
//            }
//        }
//
//        private SegmentTree getLeft(){
//            if(left==null){
//                left=new SegmentTree(low, getMid());
//            }
//            return left;
//        }
//
//        private SegmentTree getRight(){
//            if(right==null){
//                right=new SegmentTree(getMid()+1, up);
//            }
//            return right;
//        }
//
//        // Note here use long to avoid overflow
//        private int getMid(){
//            long mid=(long)low+((long)up-(long)low)/2;
//            return (int)mid;
//        }
//    }
//
//    public int reversePairs(int[] nums) {
//        int l=nums.length, result=0, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
//        for(int num: nums){
//            min=Math.min(min, num);
//            max=Math.max(max, num);
//        }
//        SegmentTree root=new SegmentTree(min, max);
//        for(int i=l-1; i>=0; i--){
//            // Note here when num<=0, num/2*2>=num, so it should be num/2-1
//            result+=nums[i]%2==0||nums[i]<=0?root.query(nums[i]/2-1):root.query(nums[i]/2);
//            root.update(nums[i]);
//        }
//        return result;
//    }
}
