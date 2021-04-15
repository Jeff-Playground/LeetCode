package com.wen.ThirteenthFifty;

import java.util.Arrays;

public class ValidTriangleNumber {
//    // Binary search
//    // Sort the array and ensure the sum of the 2 shorter edges is larger than the longest edge
//    public int triangleNumber(int[] nums) {
//        int result=0;
//        if (nums != null && nums.length >= 3) {
//            Arrays.sort(nums);
//            int l = nums.length;
//            for (int i = 0; i < l - 2; i++) {
//                for (int j = i + 1; j < l - 1; j++) {
//                    int left = j + 1, right = l;
//                    while (left < right) {
//                        int mid = left + (right - left) / 2;
//                        if (nums[mid] >= nums[i] + nums[j]) {
//                            right = mid;
//                        } else {
//                            left = mid + 1;
//                        }
//                    }
//                    result += left - 1 - j;
//                }
//            }
//        }
//        return result;
//    }

    // Two pointers, O(n^2)
    public int triangleNumber(int[] nums) {
        int result=0;
        if (nums != null && nums.length >= 3) {
            Arrays.sort(nums);
            int l = nums.length;
            for(int i=l-1; i>1; i--){
                int left=0, right=i-1;
                while(left<right){
                    if(nums[left]+nums[right]>nums[i]){
                        result+=right-left;
                        right--;
                    } else{
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
