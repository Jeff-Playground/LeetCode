package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    // DFS
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> out=new ArrayList<>();
        result.add(out);
        if(nums==null || nums.length==0){
            return result;
        }
        Arrays.sort(nums);
        subsetsWithDupDFS(nums, 0, out, result);
        return result;
    }

    private static void subsetsWithDupDFS(int[] nums, int startIdx, List<Integer> out, List<List<Integer>> result) {
        if(startIdx==nums.length){
            return;
        } else{
            for(int i=startIdx; i<nums.length; i++){
                out.add(nums[i]);
                List<Integer> outCopy=new ArrayList<>(out);
                result.add(outCopy);
                subsetsWithDupDFS(nums, i+1, out, result);
                out.remove(out.size()-1);
                while(i+1<nums.length && nums[i]==nums[i+1]){
                    i++;
                }
            }
        }
    }

//    // Non-recursive
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        List<List<Integer>> result=new ArrayList<>();
//        result.add(new ArrayList<>());
//        if(nums==null || nums.length==0){
//            return result;
//        }
//        Arrays.sort(nums);
//        int size=1, last=nums[0];
//        for(int i=0; i<nums.length; i++){
//            if(last!=nums[i]){
//                last=nums[i];
//                size=result.size();
//            }
//            int newSize=result.size();
//            for(int j=newSize-size; j<newSize; j++){
//                List<Integer> temp=new ArrayList<>(result.get(j));
//                result.add(temp);
//                temp.add(nums[i]);
//            }
//        }
//        return result;
//    }
}
