package com.wen.ThirdFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        if(numRows==0){
            return result;
        }
        int[] last=new int[numRows], cur=new int[numRows];
        Arrays.fill(cur, 1);
        for(int i=1; i<numRows+1; i++){
            for(int j=1; j<=i; j++){
                if(j==1 || j==i){
                    cur[j-1]=1;
                } else{
                    cur[j-1]=last[j-2]+last[j-1];
                }
            }
            last=Arrays.copyOf(cur, i);
            List<Integer> temp=Arrays.stream(Arrays.copyOf(cur, i)).boxed().collect(Collectors.toList());
            result.add(temp);
        }
        return result;
    }
}
