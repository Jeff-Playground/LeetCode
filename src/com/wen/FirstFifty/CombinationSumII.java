package com.wen.FirstFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(candidates==null || candidates.length==0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> out = new ArrayList<Integer>();
        combinationSum2DFS(candidates, target, 0, out, result);
        return result;
    }

    private void combinationSum2DFS(int[] candidates, int target, int start, List<Integer> out, List<List<Integer>> result) {
        if(target<0) {
            return;
        }else if(target==0) {
            List<Integer> temp=new ArrayList<Integer>(out);
            result.add(temp);
        }else {
            for(int i=start; i<candidates.length; i++) {
                if(i>start && candidates[i]==candidates[i-1]){
                    continue;
                }
                out.add(candidates[i]);
                combinationSum2DFS(candidates, target-candidates[i], i+1, out, result);
                out.remove(out.size()-1);
            }
        }
    }
}
