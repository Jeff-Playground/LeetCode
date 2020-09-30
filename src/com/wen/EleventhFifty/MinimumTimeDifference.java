package com.wen.EleventhFifty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference {
    // Time complexity O(n)
    public int findMinDifference(List<String> timePoints) {
        int[] min=new int[24*60];
        int start=Integer.MAX_VALUE, end=Integer.MIN_VALUE;
        for(String tp: timePoints){
            String[] split=tp.split(":");
            int cur=Integer.parseInt(split[1])+60*Integer.parseInt(split[0]);
            start=Math.min(start, cur);
            end=Math.max(end, cur);
            if(min[cur]++==1){
                return 0;
            }
        }
        int result=start+24*60-end, pre=-1;
        for(int i=0; i<24*60; i++){
            if(min[i]==1){
                if(pre!=-1){
                    result=Math.min(result, i-pre);
                }
                pre=i;
            }
        }
        return result;
    }

//    // Time complexity O(n*logn)
//    public int findMinDifference(List<String> timePoints) {
//        List<Integer> tp=new ArrayList<>();
//        for(String t: timePoints){
//            String[] split=t.split(":");
//            int cur=Integer.parseInt(split[1])+60*Integer.parseInt(split[0]);
//            tp.add(cur);
//        }
//        Collections.sort(tp);
//        int result=tp.get(0)+24*60-tp.get(tp.size()-1);
//        for(int i=1; i<tp.size(); i++){
//            result=Math.min(result, tp.get(i)-tp.get(i-1));
//        }
//        return result;
//    }
}
