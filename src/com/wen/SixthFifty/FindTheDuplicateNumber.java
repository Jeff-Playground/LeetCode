package com.wen.SixthFifty;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int n=nums.length-1;
        int min=1, max=n;
        while(min<max){
            int mid=min+(max-min)/2;
            int count=0;
            for(int num: nums){
                if(num<=mid){
                    count++;
                }
            }
            if(count<=mid){
                min=mid+1;
            } else{
                max=mid;
            }
        }
        return max;
    }

//    // This is like how to find the cycle on a linked list
//    public int findDuplicate(int[] nums) {
//        int slow=0, fast=0;
//        do{
//            slow=nums[slow];
//            fast=nums[nums[fast]];
//        } while(fast!=slow);
//        slow=0;
//        while(slow!=fast){
//            slow=nums[slow];
//            fast=nums[fast];
//        }
//        return slow;
//    }
}
