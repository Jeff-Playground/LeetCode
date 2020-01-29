package com.wen.FifthFifty;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new ArrayList<>();
        if(k<=0){
            return result;
        }
        combinationSum3DFS(k, n, result, 1, new ArrayList<>());
        return result;
    }

    public void combinationSum3DFS(int k, int n, List<List<Integer>> result, int start, List<Integer> out){
        if(k==0 && n==0){
            List<Integer> outCopy=new ArrayList<>(out);
            result.add(outCopy);
        } else if(k!=0 && n!=0){
            if(start<=n){
                for(int i=start; i<=n && i<=9; i++){
                    out.add(i);
                    combinationSum3DFS(k-1, n-i, result, i+1, out);
                    out.remove(out.size()-1);
                }
            }
        }
    }
}
