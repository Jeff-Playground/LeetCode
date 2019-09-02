package com.wen.FirstFifty;

import java.util.*;

public class PermutationsII {
//    // Recursive 2: swapping two elements each time
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> result=new ArrayList<List<Integer>>();
//        // No need to sort
////        Arrays.sort(nums);
//        permuteUnique(nums, 0, result);
//        return result;
//    }
//
//    private void permuteUnique(int[] nums, int start, List<List<Integer>> result) {
//        if(start==nums.length-1){
//            result.add(convertArrayToList(nums));
//        }else{
//            for(int i=start; i<nums.length; i++){
//                if(!swapAlreadyDoneForDuplicates(nums, start, i)){
//                    swap(nums, start, i);
//                    permuteUnique(nums, start+1, result);
//                    swap(nums, start, i);
//                }
//            }
//        }
//    }
//
//    private boolean swapAlreadyDoneForDuplicates(int[] nums, int first, int second) {
//        for(int i=first; i<second; i++){
//            if(nums[i]==nums[second]){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private void swap(int[] nums, int start, int i) {
//        int temp=nums[start];
//        nums[start]=nums[i];
//        nums[i]=temp;
//    }
//
//    private List<Integer> convertArrayToList(int[] nums) {
//        List<Integer> result=new ArrayList<Integer>();
//        for(int i=0; i<nums.length; i++){
//            result.add(nums[i]);
//        }
//        return result;
//    }

    // Recursive 1: generating each entry
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> out=new ArrayList<Integer>();
        int[] visited=new int[nums.length];
        Arrays.sort(nums);
        permuteUniqueDFS(nums, 0, visited, out, result);
        return result;
    }

    private static void permuteUniqueDFS(int[] nums, int level, int[] visited, List<Integer> out, List<List<Integer>> result) {
        if(level==nums.length){
            List<Integer> temp=new ArrayList<Integer>(out);
            result.add(temp);
        } else{
            for(int i=0; i<nums.length; i++){
                if(visited[i]!=1){
                    if(i>0 && visited[i-1]!=1 && nums[i]==nums[i-1]){
                        continue;
                    } else{
                        visited[i]=1;
                        out.add(out.size(), nums[i]);
                        permuteUniqueDFS(nums, level+1, visited, out, result);
                        out.remove(out.size()-1);
                        visited[i]=0;
                    }
                }
            }
        }
    }

//    // Use hashset to maintain uniqueness
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> result=new ArrayList<List<Integer>>();
//        result.add(new ArrayList<Integer>());
//
//        for(int i=0; i<nums.length; i++){
//            Set<List<Integer>> current=new HashSet<List<Integer>>();
//            for(List<Integer> list: result){
//                for(int j=0; j<list.size()+1; j++){
//                    list.add(j, nums[i]);
//                    List<Integer> temp=new ArrayList<Integer>(list);
//                    current.add(temp);
//                    list.remove(j);
//                }
//            }
//            result=new ArrayList<List<Integer>>(current);
//        }
//        return result;
//    }
}
