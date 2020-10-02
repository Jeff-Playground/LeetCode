package com.wen.EleventhFifty;

/*

Given an array with n integers, you need to find if there are triplets (i, j, k) which satisfies following conditions:

0 < i, i + 1 < j, j + 1 < k < n - 1
Sum of subarrays (0, i - 1), (i + 1, j - 1), (j + 1, k - 1) and (k + 1, n - 1) should be equal.
where we define that subarray (L, R) represents a slice of the original array starting from the element indexed L to the element indexed R.

Example:

Input: [1,2,1,2,1,2,1]
Output: True
Explanation:
i = 1, j = 3, k = 5.
sum(0, i - 1) = sum(0, 0) = 1
sum(i + 1, j - 1) = sum(2, 2) = 1
sum(j + 1, k - 1) = sum(4, 4) = 1
sum(k + 1, n - 1) = sum(6, 6) = 1
Note:

1 <= n <= 2000.
Elements in the given array will be in range [-1,000,000, 1,000,000].

 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LQSplitArrayWithEqualSum {
    // Brute force with pruning
    public boolean splitArray(List<Integer> nums) {
        if(nums==null || nums.size()<7){
            return false;
        } else{
            int l=nums.size(), target=0;
            int sum=0;
            for(int num: nums){
                sum+=num;
            }
            for(int i=1; i<l-5; i++){
                // Except when nums is 0 0 0 0 0 0 0, for 0 add it without checking
                if(!(i!=1 && nums.get(i)==0 && nums.get(i-1)==0)){
                    target+=nums.get(i-1);
                    if(saHelper(nums, target, sum-target-nums.get(i), i+1, 1)){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    private boolean saHelper(List<Integer> nums, int target, int remain, int start, int count){
        if(count==3){
            return remain==target;
        } else{
            int curSum=0, l=nums.size();
            for(int i=start+1; i<l-5+2*count; i++){
                curSum+=nums.get(i-1);
                if(curSum==target && saHelper(nums, target, remain-curSum-nums.get(i), i+1, count+1)){
                    return true;
                }
            }
            return false;
        }
    }

//    // Find j first, then do brute force search to try and find i and k
//    public boolean splitArray(List<Integer> nums) {
//        if(nums==null || nums.size()<7){
//            return false;
//        } else{
//            int l=nums.size();
//            List<Integer> sum=new ArrayList<>(nums);
//            for(int i=1; i<l; i++){
//                sum.set(i, sum.get(i)+sum.get(i-1));
//            }
//            for(int j=3; j<l-3; j++){
//                Set<Integer> possibleSum=new HashSet<>();
//                for(int i=1; i<j-1; i++){
//                    if(sum.get(i-1)==sum.get(j-1)-sum.get(i)){
//                        possibleSum.add(sum.get(i-1));
//                    }
//                }
//                for(int k=j+2; k<l-1; k++){
//                    if(possibleSum.contains(sum.get(k-1)-sum.get(j)) && sum.get(k-1)-sum.get(j)==sum.get(l-1)-sum.get(k)){
//                        return true;
//                    }
//                }
//            }
//            return false;
//        }
//    }
}
