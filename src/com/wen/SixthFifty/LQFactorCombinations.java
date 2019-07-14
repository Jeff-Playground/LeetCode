package com.wen.SixthFifty;

import java.util.ArrayList;
import java.util.List;

public class LQFactorCombinations {
    // DFS
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> out=new ArrayList<>();
        getFactorsDFS(n, 0, out, result);
        return result;
    }

    public void getFactorsDFS(int n, int last, List<Integer> out, List<List<Integer>> result){
        int start=last==0?2:last;
        for(int i=start; i*i<=n; i++){
            if(n%i==0){
                out.add(i);
                getFactorsDFS(n/i, i, out, result);
                out.remove(out.size()-1);
            }
        }
        if(last!=0){
            List<Integer> outCopy=new ArrayList<>(out);
            outCopy.add(n);
            result.add(outCopy);
        }
    }
}
