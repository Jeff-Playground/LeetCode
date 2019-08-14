package com.wen.SixteenthFifty;

import java.util.ArrayList;
import java.util.List;

public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        if(arr==null || arr.length<2){
            return 1;
        }
        int max=-1, result=0;
        for(int i=0; i<arr.length; i++){
            max=Math.max(max, arr[i]);
            if(i==max) {
                max=-1;
                result++;
            }
        }
        return result;
    }

//    public int maxChunksToSorted(int[] arr) {
//        if(arr==null || arr.length<2){
//            return 1;
//        }
//        List<Integer> ends=new ArrayList<>();
//        for(int i=0; i<arr.length; i++){
//            int end=arr[i];
//            if(ends.size()==0){
//                ends.add(arr[i]);
//            } else {
//                int last=ends.get(ends.size()-1);
//                if(i<=last && arr[i]>last){
//                    ends.set(ends.size()-1, arr[i]);
//                } else if(i>last){
//                    ends.add(arr[i]);
//                }
//            }
//        }
//        return ends.size();
//    }
}
