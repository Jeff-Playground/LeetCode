package com.wen.EighthFifty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CombinationSumIV {
//    // DFS, will TLE
//    public static int combinationSum4(int[] nums, int target) {
//        int[] result=new int[]{0};
//        Arrays.sort(nums);
//        combinationSum4DFS(nums, target, 0, result);
//        return result[0];
//    }
//
//    private static void combinationSum4DFS(int[] nums, int target, int curSum, int[] result){
//        if(curSum>target){
//            return;
//        } else if(curSum==target){
//            result[0]++;
//        } else{
//            int l=nums.length;
//            for(int i=0; i<l; i++){
//                if(nums[i]>target-curSum){
//                    break;
//                }
//                combinationSum4DFS(nums, target, curSum+nums[i], result);
//            }
//        }
//    }

    // DP
    // dp[i] stands for the combination counts for number i
    public static int combinationSum4(int[] nums, int target) {
        int l=nums.length;
        Arrays.sort(nums);
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=1; i<=target; i++){
            for(int j=0; j<l && nums[j]<=i; j++){
                dp[i]+=dp[i-nums[j]];
            }
        }
        return dp[target];
    }

//    // DFS
//    public static int combinationSum4(int[] nums, int target) {
//        Map<Integer, Integer> counts=new HashMap<>();
//        Arrays.sort(nums);
//        combinationSum4DFS(nums, target, counts);
//        return counts.get(target);
//    }
//
//    private static int combinationSum4DFS(int[] nums, int target, Map<Integer, Integer> counts) {
//        if(target<0){
//            return 0;
//        } else if(target==0){
//            return 1;
//        } else{
//            if(!counts.containsKey(target)){
//                int count=0, l=nums.length;
//                for(int i=0; i<l && nums[i]<=target; i++){
//                    count+=combinationSum4DFS(nums, target-nums[i], counts);
//                }
//                counts.put(target, count);
//            }
//            return counts.get(target);
//        }
//    }
}
