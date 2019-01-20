package com.wen.FirstFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(candidates==null || candidates.length==0){
            return result;
        }
        List<Integer> out=new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationSumDFS(candidates, target, 0, out, result);
        return result;
    }

    public static void combinationSumDFS(int[] candidates, int target, int start, List<Integer> out, List<List<Integer>> result){
        if(target<0){
            return;
        } else if(target==0){
            List<Integer> temp=new ArrayList<Integer>(out);
            result.add(temp);
        } else{
            for(int i=start; i<candidates.length; i++){
                out.add(candidates[i]);
                combinationSumDFS(candidates, target-candidates[i], i, out, result);
                out.remove(out.size()-1);
            }
        }
    }
}
