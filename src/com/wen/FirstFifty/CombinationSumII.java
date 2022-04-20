package com.wen.FirstFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
//    // DFS1
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        List<List<Integer>> result=new ArrayList<>();
//        if(candidates==null || candidates.length==0) {
//            return result;
//        }
//        Arrays.sort(candidates);
//        combinationSum2DFS(candidates, target, 0, new ArrayList<>(), result);
//        return result;
//    }
//
//    private void combinationSum2DFS(int[] candidates, int target, int start, List<Integer> out, List<List<Integer>> result) {
//        if(target<0) {
//            return;
//        }else if(target==0) {
//            result.add(new ArrayList<>(out));
//        }else {
//            for(int i=start; i<candidates.length; i++) {
//                if(i>start && candidates[i]==candidates[i-1]){
//                    continue;
//                }
//                out.add(candidates[i]);
//                combinationSum2DFS(candidates, target-candidates[i], i+1, out, result);
//                out.remove(out.size()-1);
//            }
//        }
//    }

    // DFS2
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        combinationSum2Helper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum2Helper(int[] candidates, int target, int i, List<Integer> cur, List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(cur));
        } else{
            if(i==candidates.length || target<candidates[i]){
                return;
            } else{
                int next=i+1;
                while(next<candidates.length && candidates[next]==candidates[i]){
                    next++;
                }
                cur.add(candidates[i]);
                combinationSum2Helper(candidates, target-candidates[i], i+1, cur, result);
                cur.remove(cur.size()-1);
                combinationSum2Helper(candidates, target, next, cur, result);
            }
        }
    }
}
