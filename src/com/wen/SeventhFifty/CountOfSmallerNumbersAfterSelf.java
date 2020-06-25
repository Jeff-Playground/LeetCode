package com.wen.SeventhFifty;

import java.util.*;

public class CountOfSmallerNumbersAfterSelf {
//    // Divide and conquer with merge sort
//    public List<Integer> countSmaller(int[] nums) {
//        List<Integer> result=new ArrayList<>();
//        int l=nums.length;
//        int[] count=new int[l], index=new int[l];
//        for(int i=0; i<l; i++){
//            index[i]=i;
//        }
//        csHelper(nums, count, index, 0, l-1);
//        for(int c: count){
//            result.add(c);
//        }
//        return result;
//    }
//
//    // This function would make sure for range left to right, index would store the sorted index for the numbers in this
//    // range, and count would store the count of numbers originally located on the right but moved to the left due to
//    // sorting
//    private void csHelper(int[] nums, int[] count, int[] index, int start, int end){
//        if(start>=end){
//            return;
//        }
//        int mid=start+(end-start)/2;
//        csHelper(nums, count, index, start, mid);
//        csHelper(nums, count, index, mid+1, end);
//        int[] indexNew=new int[end-start+1];
//        int firstIdx=start, secondIdx=mid+1, moved=0;
//        for(int i=start; i<=end; i++){
//            int num1=firstIdx<=mid?nums[index[firstIdx]]:Integer.MAX_VALUE;
//            int num2=secondIdx<=end?nums[index[secondIdx]]:Integer.MAX_VALUE;
//            if(num1<=num2){
//                indexNew[i-start]=index[firstIdx];
//                count[index[firstIdx]]+=moved;
//                firstIdx++;
//            } else{
//                indexNew[i-start]=index[secondIdx];
//                moved++;
//                secondIdx++;
//            }
//        }
//        for(int i=start; i<=end; i++){
//            index[i]=indexNew[i-start];
//        }
//    }

//    // Segment tree
//    private class SegmentTree{
//        private SegmentTree left, right;
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
//            if(low<=num && up>=num){
//                count++;
//                if(low!=up){
//                    getLeft().update(num);
//                    getRight().update(num);
//                }
//            }
//        }
//
//        public int query(int num){
//            if(num>up){
//                return count;
//            } else if(num>low && num<=up){
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
//        private int getMid(){
//            return low+(up-low)/2;
//        }
//    }
//
//    public List<Integer> countSmaller(int[] nums) {
//        List<Integer> result=new ArrayList<>();
//        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
//        for(int num: nums){
//            min=Math.min(min, num);
//            max=Math.max(max, num);
//        }
//        SegmentTree root=new SegmentTree(min, max);
//        for(int i=nums.length-1; i>=0; i--){
//            result.add(0, root.query(nums[i]));
//            root.update(nums[i]);
//        }
//        return result;
//    }

    // Binary indexed tree
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result=new ArrayList<>();
        Set<Integer> sorted=new TreeSet<>();
        for(int num: nums){
            sorted.add(num);
        }
        List<Integer> sortedList=new ArrayList<>(sorted);
        int[] count=new int[sorted.size()+1];
        for(int i=nums.length-1; i>=0; i--){
            result.add(0, query(count, sortedList, nums[i]));
            update(count, sortedList, nums[i]);
        }
        return result;
    }

    private int query(int[] count, List<Integer> sortedList, int num){
        int idx=Collections.binarySearch(sortedList, num)+1;
        int result=0;
        for(int i=idx-1; i>0; i-=i&(-i)){
            result+=count[i];
        }
        return result;
    }

    private void update(int[] count, List<Integer> sortedList, int num){
        int idx=Collections.binarySearch(sortedList, num)+1;
        for(int i=idx; i<count.length; i+=i&(-i)){
            count[i]+=1;
        }
    }

//    // Binary search tree
//    public class MyTreeNode{
//        int val;
//        int leftCount=0;
//        int dupCount=1;
//        MyTreeNode left;
//        MyTreeNode right;
//
//        public MyTreeNode(int val){
//            this.val=val;
//        }
//    }
//
//    public List<Integer> countSmaller(int[] nums) {
//        List<Integer> result=new ArrayList<>();
//        if(nums==null || nums.length==0){
//            return result;
//        }
//        MyTreeNode root=new MyTreeNode(nums[nums.length-1]);
//        result.add(0, root.leftCount);
//        for(int i=nums.length-2; i>=0; i--){
//            result.add(0, addNode(root, nums[i]));
//        }
//        return result;
//    }
//
//    public int addNode(MyTreeNode root, int val){
//        MyTreeNode cur=root;
//        int result=0;
//        while(cur!=null){
//            if(val>cur.val){
//                result+=cur.leftCount+cur.dupCount;
//                if(cur.right==null){
//                    MyTreeNode temp=new MyTreeNode(val);
//                    cur.right=temp;
//                    return result;
//                } else{
//                    cur=cur.right;
//                }
//            } else if(val<cur.val){
//                cur.leftCount++;
//                if(cur.left==null){
//                    MyTreeNode temp=new MyTreeNode(val);
//                    cur.left=temp;
//                    return result;
//                } else{
//                    cur=cur.left;
//                }
//            } else if(cur.val==val){
//                cur.dupCount++;

//                return cur.leftCount+result;
//            }
//        }
//        return 0;
//    }

//    // Binary insertion sort
//    public List<Integer> countSmaller(int[] nums) {
//        List<Integer> result=new ArrayList<>();
//        int[] sorted=new int[nums.length];
//        int length=0;
//        for(int i=nums.length-1; i>=0; i--) {
//            if(length==0) {
//                sorted[length++]=nums[i];
//                result.add(0,length-1);
//            } else {
//                if(nums[i]<=sorted[length-1]) {
//                    int left=0, right=length-1;
//                    while(left<right) {
//                        int mid=left+(right-left)/2;
//                        if(sorted[mid]<nums[i]) {
//                            left=mid+1;
//                        } else {
//                            right=mid;
//                        }
//                    }
//                    for(int j=length++; j>left; j--) {
//                        sorted[j]=sorted[j-1];
//                    }
//                    sorted[left]=nums[i];
//                    result.add(0,left);
//                } else {
//                    sorted[length++]=nums[i];
//                    result.add(0,length-1);
//                }
//            }
//        }
//        return result;
//    }
}
