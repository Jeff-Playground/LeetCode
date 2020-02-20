package com.wen.FourthFifty;

public class MaximumProductSubarray {
//    public int maxProduct(int[] nums) {
//        int result=nums[0], n=nums.length, prod=1;
//        for(int i=1; i<n; i++){
//            result=Math.max(result, prod*=nums[i]);
//            if(nums[i]==0){
//                prod=1;
//            }
//        }
//        prod=1;
//        for(int i=n-1; i>=0; i--){
//            result=Math.max(result, prod*=nums[i]);
//            if(nums[i]==0){
//                prod=1;
//            }
//        }
//        return result;
//    }

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
//        int greatest=nums[0], smallest=nums[0];
//        for(int i=1; i<n; i++){
//            int preG=greatest, preS=smallest;
//            greatest=Math.max(Math.max(preG*nums[i], preS*nums[i]), nums[i]);
//            smallest=Math.min(Math.min(preG*nums[i], preS*nums[i]), nums[i]);
//            result=Math.max(result, greatest);
//        }
//        return result;
//    }

    // DP
    // dpGrestest[i] stores the maximum product till nums[i], dpSmallest[i] stores the minimum product till nums[i],
    // note here minimum is because of the negative sign, the absolute value is not necessarily small
    public int maxProduct(int[] nums) {
        int result=nums[0], n=nums.length;
        int[] dpGreatest=new int[n], dpSmallest=new int[n];
        dpGreatest[0]=nums[0];
        dpSmallest[0]=nums[0];
        for(int i=1; i<n; i++){
            dpGreatest[i]=Math.max(Math.max(dpGreatest[i-1]*nums[i], dpSmallest[i-1]*nums[i]), nums[i]);
            dpSmallest[i]=Math.min(Math.min(dpGreatest[i-1]*nums[i], dpSmallest[i-1]*nums[i]), nums[i]);
            result=Math.max(result, dpGreatest[i]);
        }
        return result;
    }
}
