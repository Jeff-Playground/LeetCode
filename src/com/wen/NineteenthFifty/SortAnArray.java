package com.wen.NineteenthFifty;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SortAnArray {
    // Count sort
    public int[] sortArray(int[] nums) {
        int[] count=new int[100_001];
        for(int num: nums){
            count[num+50_000]++;
        }
        int[] result=new int[nums.length];
        int j=0;
        for(int i=0; i<count.length; i++){
            while(count[i]-->0){
                result[j++]=i-50_000;
            }
        }
        return result;
    }

//    // Merge sort
//    public int[] sortArray(int[] nums) {
//        mergeSort(nums, 0, nums.length-1);
//        return nums;
//    }
//
//    private void mergeSort(int[] nums, int start, int end){
//        if(start<end){
//            int mid=start+(end-start)/2;
//            mergeSort(nums, start, mid);
//            mergeSort(nums, mid+1, end);
//            int[] left=Arrays.copyOfRange(nums, start, mid+1);
//            int[] right= Arrays.copyOfRange(nums, mid+1, end+1);
//            int il=0, ir=0, ll=mid-start+1, lr=end-mid, i=start;
//            while(il<ll || ir<lr){
//                if(il<ll && ir<lr){
//                    nums[i++]=left[il]<=right[ir]?left[il++]:right[ir++];
//                } else if(il<ll){
//                    nums[i++]=left[il++];
//                } else{
//                    nums[i++]=right[ir++];
//                }
//            }
//        }
//    }

//    // Recursive quick sort
//    public int[] sortArray(int[] nums) {
//        quickSort(nums, 0, nums.length-1);
//        return nums;
//    }
//
//    private void quickSort(int[] nums, int start, int end){
//        if(start<end){
//            int left=start, right=end;
//            int tmp=nums[left];
//            while(left<right){
//                while(left<right && nums[right]>=tmp){
//                    right--;
//                }
//                nums[left]=nums[right];
//                while(left<right && nums[left]<=tmp){
//                    left++;
//                }
//                nums[right]=nums[left];
//            }
//            nums[left]=tmp;
//            quickSort(nums, start, left-1);
//            quickSort(nums, left+1, end);
//        }
//    }

//    // Iterative quick sort
//    public static int[] sortArray(int[] nums) {
//        int l=nums.length;
//        Queue<Integer> q=new LinkedList<>();
//        q.offer(0);
//        q.offer(l-1);
//        while(!q.isEmpty()){
//            int start=q.poll(), end=q.poll();
//            int left=start, right=end;
//            if(left<right){
//                int tmp=nums[left];
//                while(left<right){
//                    while(left<right && nums[right]>=tmp){
//                        right--;
//                    }
//                    nums[left]=nums[right];
//                    while(left<right && nums[left]<=tmp){
//                        left++;
//                    }
//                    nums[right]=nums[left];
//                }
//                nums[left]=tmp;
//                q.offer(start);
//                q.offer(left-1);
//                q.offer(left+1);
//                q.offer(end);
//            }
//        }
//        return nums;
//    }
}
