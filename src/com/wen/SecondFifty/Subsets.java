package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    // Using an increasing binary array
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        int max=1<<nums.length;
        for(int i=0; i<max; i++){
            List<Integer> out=convertIntToList(nums, i);
            result.add(out);
        }
        return result;
    }

    private static List<Integer> convertIntToList(int[] nums, int i) {
        List<Integer> out=new ArrayList<>();
        int idx=0;
        for(int j=i; j>0; j>>=1){
            if((j&1)==1) {
                out.add(nums[idx]);
            }
            idx++;
        }
        return out;
    }

//    // Non-recursive
//    public static List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result=new ArrayList<>();
//        result.add(new ArrayList<>());
//        for(int i=0; i<nums.length; i++){
//            int size=result.size();
//            for(int j=0; j<size; j++){
//                List<Integer> temp=new ArrayList<>(result.get(j));
//                result.add(temp);
//                result.get(j).add(nums[i]);
//            }
//        }
//        return result;
//    }

//    // DFS
//    public static List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> result=new ArrayList<>();
//        List<Integer> out=new ArrayList<>();
//        result.add(new ArrayList<>());
//        if(nums==null || nums.length==0){
//            return result;
//        }
//        subsetsDFS(nums, 0, out, result);
//        return result;
//    }
//
//    private static void subsetsDFS(int[] nums, int startIdx, List<Integer> out, List<List<Integer>> result) {
//        if(startIdx==nums.length){
//            return;
//        } else{
//            for(int i=startIdx; i<nums.length; i++){
//                out.add(nums[i]);
//                List<Integer> outCopy=new ArrayList<>(out);
//                result.add(outCopy);
//                subsetsDFS(nums, i+1, out, result);
//                out.remove(out.size()-1);
//            }
//        }
//    }
}
