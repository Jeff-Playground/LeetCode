package com.wen.FirstFifty;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result=new ArrayList<>();
//        List<Integer> init=new ArrayList<>();
//        result.add(init);
//        for(int i=0; i<nums.length; i++){
//            List<List<Integer>> current=new ArrayList<>();
//            for(List<Integer> element: result){
//                for(int j=0; j<element.size()+1; j++){
//                    element.add(j, nums[i]);
//                    current.add(new ArrayList<Integer>(element));
//                    element.remove(j);
//                }
//            }
//            result=current;
//        }
//        return result;
//    }

    // Recursive 2: swapping two elements each time
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        if(nums==null || nums.length==0){
            return result;
        }
        permute(nums, 0, result);
        return result;
    }

    private static void permute(int[] nums, int start, List<List<Integer>> result) {
        if(start>=nums.length-1){
            result.add(convertArrayToList(nums));
        } else{
            for(int i=start; i<nums.length; i++){
                swap(nums, start, i);
                permute(nums, start+1, result);
                swap(nums, start, i);
            }
        }
    }

    private static void swap(int[] nums, int first, int second) {
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }

    private static List<Integer> convertArrayToList(int[] nums) {
        List<Integer> result=new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            result.add(nums[i]);
        }
        return result;
    }

//    // Recursive 1: generating each entry
//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result=new ArrayList<List<Integer>>();
//        if(nums==null || nums.length==0){
//            return result;
//        }
//        int[] visited=new int[nums.length];
//        List<Integer> out=new ArrayList<Integer>();
//        permuteDFS(nums, 0, visited, out, result);
//        return result;
//    }
//
//    private static void permuteDFS(int[] nums, int level, int[] visited, List<Integer> out, List<List<Integer>> result) {
//        if(level==nums.length){
//            List<Integer> outCopy=new ArrayList<Integer>(out);
//            result.add(outCopy);
//        } else{
//            for(int i=0; i<nums.length; i++){
//                if(visited[i]==0){
//                    visited[i]=1;
//                    out.add(nums[i]);
//                    permuteDFS(nums, level+1, visited, out, result);
//                    out.remove(out.size()-1);
//                    visited[i]=0;
//                }
//            }
//        }
//    }
}
