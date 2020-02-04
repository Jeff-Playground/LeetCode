package com.wen.SixthFifty;

public class FindTheDuplicateNumber {
    // The duplicated number can appear more than once, so can't use sum-(1+n)*n/2 to find it

//    // Estimate a mid and verify it, if the estimation is too small(count<=mid), means duplicates on the right,
//    // otherwise on the left
//    public int findDuplicate(int[] nums) {
//        int min=1, max=nums.length-1;
//        while(min<max){
//            int mid=min+(max-min)/2;
//            int count=0;
//            for(int num: nums){
//                if(num<=mid){
//                    count++;
//                }
//            }
//            if(count<=mid){
//                min=mid+1;
//            } else{
//                max=mid;
//            }
//        }
//        return max;
//    }

    // Bit manipulation
    public int findDuplicate(int[] nums) {
        int result=0, n=nums.length-1;
        for(int i=0; i<32; i++){
            int bit=1<<i, count1=0, count2=0;
            for(int j=0; j<nums.length; j++){
                if(j>0 && (j&bit)>0){
                    count1++;
                }
                if((nums[j]&bit)>0){
                    count2++;
                }
            }
            if(count2>count1){
                result|=bit;
            }
        }
        return result;
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
