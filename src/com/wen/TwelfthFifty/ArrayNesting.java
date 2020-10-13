package com.wen.TwelfthFifty;

public class ArrayNesting {
    // Set idx to nums[idx] to server as visited
    public int arrayNesting(int[] nums) {
        int result=1;
        int l=nums.length;
        for(int i=0; i<l; i++){
            if(nums[i]!=i){
                int count=0, idx=i;
                while(nums[idx]!=idx){
                    int temp=nums[idx];
                    nums[idx]=idx;
                    idx=temp;
                    count++;
                }
                result=Math.max(result, count);
            }
        }
        return result;
    }

//    // Mark visited as -1
//    public int arrayNesting(int[] nums) {
//        int result=1;
//        int l=nums.length;
//        for(int i=0; i<l; i++){
//            if(nums[i]!=-1){
//                int count=0, idx=i;
//                while(nums[idx]!=-1){
//                    int temp=nums[idx];
//                    nums[idx]=-1;
//                    idx=temp;
//                    count++;
//                }
//                result=Math.max(result, count);
//            }
//        }
//        return result;
//    }
}
