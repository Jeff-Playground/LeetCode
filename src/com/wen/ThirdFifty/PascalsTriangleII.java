package com.wen.ThirdFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalsTriangleII {
//    public List<Integer> getRow(int rowIndex) {
//        int[] last=new int[rowIndex+1], cur=new int[rowIndex+1];
//        Arrays.fill(cur, 1);
//        for(int i=1; i<=rowIndex+1; i++){
//            for(int j=1; j<=i; j++){
//                if(j==1 || j==i){
//                    cur[j-1]=1;
//                } else{
//                    cur[j-1]=last[j-2]+last[j-1];
//                }
//            }
//            last=Arrays.copyOf(cur, i);
//        }
//        return Arrays.stream(cur).boxed().collect(Collectors.toList());
//    }

    // Optimized
    public List<Integer> getRow(int rowIndex) {
        int[] cur=new int[rowIndex+1];
        cur[0]=1;
        for(int i=1; i<=rowIndex; i++){
            for(int j=i; j>=1; j--){
                cur[j]+=cur[j-1];
            }
        }
        return Arrays.stream(cur).boxed().collect(Collectors.toList());
    }
}
