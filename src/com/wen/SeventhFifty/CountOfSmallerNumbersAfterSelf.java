package com.wen.SeventhFifty;

import java.util.*;

public class CountOfSmallerNumbersAfterSelf {
    // Merge sort
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> result=new ArrayList<>();
        if(nums==null || nums.length==0){
            return result;
        }
        int l=nums.length;
        int[] count=new int[l];
        int[] index=new int[l];
        for(int i=0; i<l; i++){
            index[i]=i;
        }
        countSmallerHelper(nums, 0, l-1, count, index);
        for(int c: count){
            result.add(c);
        }
        return result;
    }

    public static void countSmallerHelper(int[] nums, int left, int right, int[] count, int[] index){
        if(left>=right){
            return;
        }
        int mid=left+(right-left)/2;
        countSmallerHelper(nums, left, mid, count, index);
        countSmallerHelper(nums, mid+1, right, count, index);
        int i=left, j=mid+1;
        int rightCount=0;
        int[] sortedIndex=new int[nums.length];
        int k=left;
        while(i<=mid && j<=right){
            if(nums[index[i]]>nums[index[j]]){
                rightCount++;
                sortedIndex[k++]=index[j++];
            } else{
                count[index[i]]+=rightCount;
                sortedIndex[k++]=index[i++];
            }
        }
        while(i<=mid){
            count[index[i]]+=rightCount;
            sortedIndex[k++]=index[i++];
        }
        while(j<=right){
            sortedIndex[k++]=index[j++];
        }
        for(i=left; i<=right; i++){
            index[i]=sortedIndex[i];
        }
    }

//    // Segment tree
//    public List<Integer> countSmaller(int[] nums) {
//        List<Integer> result=new ArrayList<>();
//        if(nums==null || nums.length==0){
//            return result;
//        }
//        int[] numsCopy=Arrays.copyOf(nums, nums.length);
//        Arrays.sort(numsCopy);
//        Map<Integer, Integer> ranks=new HashMap<>();
//        int rank=1;
//        for(int i=0; i<numsCopy.length; i++){
//            if(i>0 && numsCopy[i]==numsCopy[i-1]){
//                continue;
//            } else{
//                ranks.put(numsCopy[i], rank++);
//            }
//        }
//        int[] freq=new int[ranks.size()*4];
//        for(int i=nums.length-1; i>=0; i--){
//            update(freq, 0, 0, ranks.size()-1, ranks.get(nums[i])-1, 1);
//            result.add(0, querySum(freq, 0, 0, ranks.size()-1, ranks.get(nums[i])-1-1));
//        }
//        return result;
//    }
//
//    public void update(int[] freq, int index, int left, int right, int valIndex, int diff){
//        if(valIndex<left || valIndex>right){
//            return;
//        } else{
//            if(left==right){
//                freq[index]+=diff;
//                return;
//            }
//            int mid=left+(right-left)/2;
//            if(mid>=valIndex){
//                update(freq, index*2+1, left, mid, valIndex, diff);
//            } else{
//                update(freq, index*2+2, mid+1, right, valIndex, diff);
//            }
//            freq[index]=freq[index*2+1]+freq[index*2+2];
//        }
//    }
//
//    public int querySum(int[] freq, int index, int left, int right, int rangeIndex){
//        if(rangeIndex<left) {
//            return 0;
//        } else if(rangeIndex>=right){
//            return freq[index];
//        } else{
//            int mid=left+(right-left)/2;
//            if(mid>=rangeIndex){
//                return querySum(freq, index*2+1, left, mid, rangeIndex);
//            } else{
//                return querySum(freq, index*2+1, left, mid, rangeIndex)+querySum(freq, index*2+2, mid+1, right, rangeIndex);
//            }
//        }
//    }

//    // Binary indexed tree
//    public static List<Integer> countSmaller(int[] nums) {
//        List<Integer> result=new ArrayList<>();
//        if(nums==null || nums.length==0){
//            return result;
//        }
//        int[] numsCopy=Arrays.copyOf(nums, nums.length);
//        Arrays.sort(numsCopy);
//        Map<Integer, Integer> ranks=new HashMap<>();
//        int rank=1;
//        for(int i=0; i<numsCopy.length; i++){
//            if(i>0 && numsCopy[i]==numsCopy[i-1]){
//                continue;
//            } else{
//                ranks.put(numsCopy[i], rank++);
//            }
//        }
//        // Note binary indexed tree starts at 1, so length is ranks.length+1
//        int[] freq=new int[rank];
//        for(int i=nums.length-1; i>=0; i--){
//            update(freq, ranks.get(nums[i]), 1);
//            result.add(0, getSum(freq, ranks.get(nums[i])-1));
//        }
//        return result;
//    }
//
//    public static void update(int[] freq, int index, int diff){
//        for(int i=index; i<freq.length; i+=i&(-i)){
//            freq[i]+=diff;
//        }
//    }
//
//    public static int getSum(int[] freq, int index){
//        int result=0;
//        for(int i=index; i>=1; i-=i&(-i)){
//            result+=freq[i];
//        }
//        return result;
//    }

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
//                    while(left<=right) {
//                        int mid=left+(right-left)/2;
//                        if(sorted[mid]<nums[i]) {
//                            left=mid+1;
//                        } else {
//                            right=mid-1;
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
