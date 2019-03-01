package com.wen.FourthFifty;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int result=nums[0], n=nums.length, prod=1;
        for(int i=1; i<n; i++){
            result=Math.max(result, prod*=nums[i]);
            if(nums[i]==0){
                prod=1;
            }
        }
        prod=1;
        for(int i=n-1; i>=0; i--){
            result=Math.max(result, prod*=nums[i]);
            if(nums[i]==0){
                prod=1;
            }
        }
        return result;
    }

//    // Algorithm optimized DP(simplify code)
//    public int maxProduct(int[] nums) {
//        int result=nums[0], n=nums.length;
//        int great=nums[0], small=nums[0];
//        for(int i=1; i<n; i++){
//            int preG=great, preS=small;
//            if(nums[i]<0){
//                int temp=great;
//                great=small;
//                small=temp;
//            }
//            great=Math.max(preG*nums[i], nums[i]);
//            small=Math.min(preS*nums[i], nums[i]);
//            result=Math.max(result, great);
//        }
//        return result;
//    }

//    // Algorithm optimized DP(show detailed logic)
//    public int maxProduct(int[] nums) {
//        int result=nums[0], n=nums.length;
//        int great=nums[0], small=nums[0];
//        for(int i=1; i<n; i++){
//            int preG=great, preS=small;
//            if(nums[i]>0){
//                great=Math.max(preG*nums[i], nums[i]);
//                small=Math.min(preS*nums[i], nums[i]);
//            } else if(nums[i]<0){
//                great=Math.max(preS*nums[i], nums[i]);
//                small=Math.min(preG*nums[i], nums[i]);
//            } else{
//                great=0;
//                small=0;
//            }
//            result=Math.max(result, great);
//        }
//        return result;
//    }

//    // Space optimized DP
//    public int maxProduct(int[] nums) {
//        int result=nums[0], n=nums.length;
//        int great=nums[0], small=nums[0];
//        for(int i=1; i<n; i++){
//            int preG=great, preS=small;
//            great=Math.max(Math.max(preG*nums[i], preS*nums[i]), nums[i]);
//            small=Math.min(Math.min(preG*nums[i], preS*nums[i]), nums[i]);
//            result=Math.max(result, great);
//        }
//        return result;
//    }

//    // DP
//    public int maxProduct(int[] nums) {
//        int result=nums[0], n=nums.length;
//        int[] dpG=new int[n], dpS=new int[n];
//        dpG[0]=nums[0];
//        dpS[0]=nums[0];
//        for(int i=1; i<n; i++){
//            dpG[i]=Math.max(Math.max(dpG[i-1]*nums[i], dpS[i-1]*nums[i]), nums[i]);
//            dpS[i]=Math.min(Math.min(dpG[i-1]*nums[i], dpS[i-1]*nums[i]), nums[i]);
//            result=Math.max(result, dpG[i]);
//        }
//        return result;
//    }
}
