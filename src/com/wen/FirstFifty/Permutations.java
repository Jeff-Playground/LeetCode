package com.wen.FirstFifty;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());

        for(int i=0; i<nums.length; i++){
            List<List<Integer>> current=new ArrayList<List<Integer>>();
            for(List<Integer> list: result){
                for(int j=0; j< list.size()+1; j++){
                    list.add(j, nums[i]);
                    ArrayList<Integer> temp = new ArrayList<Integer>(list);
                    current.add(temp);
                    list.remove(j);
                }
            }
            result = new ArrayList<List<Integer>>(current);
        }
        return result;
    }

//    // Recursive 2: swapping two elements each time
//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> result=new ArrayList<List<Integer>>();
//        if(nums==null || nums.length==0){
//            return result;
//        }
//        permute(nums, 0, result);
//        return result;
//    }
//
//    private static void permute(int[] nums, int start, List<List<Integer>> result) {
//        if(start>=nums.length-1){
//            result.add(convertArrayToList(nums));
//        } else{
//            for(int i=start; i<nums.length; i++){
//                swap(nums, start, i);
//                permute(nums, start+1, result);
//                swap(nums, start, i);
//            }
//        }
//    }
//
//    private static void swap(int[] nums, int start, int i) {
//        int temp=nums[start];
//        nums[start]=nums[i];
//        nums[i]=temp;
//    }
//
//    private static List<Integer> convertArrayToList(int[] nums) {
//        List<Integer> result=new ArrayList<Integer>();
//        for(int i=0; i<nums.length; i++){
//            result.add(nums[i]);
//        }
//        return result;
//    }

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
