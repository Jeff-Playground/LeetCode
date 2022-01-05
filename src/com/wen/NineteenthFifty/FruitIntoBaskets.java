package com.wen.NineteenthFifty;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    // Sliding window
    public int totalFruit(int[] fruits) {
        int l=fruits.length, result=0;
        Map<Integer, Integer> counts=new HashMap<>();
        int start=0, end=0;
        while(end<l){
            int type=fruits[end];
            if(counts.size()<2 || counts.containsKey(type)){
                counts.put(type, counts.getOrDefault(type, 0)+1);
            } else{
                result=Math.max(result, end-start);
                while(counts.size()==2){
                    int removeType=fruits[start++];
                    if(counts.get(removeType)==1){
                        counts.remove(removeType);
                    } else{
                        counts.put(removeType, counts.get(removeType)-1);
                    }
                }
                counts.put(type, 1);
            }
            end++;
        }
        result=Math.max(result, end-start);
        return result;
    }

//    // Sliding window, optimized by using an array for counts as 0 <= fruits[i] < fruits.length
//    public int totalFruit(int[] fruits) {
//        int l=fruits.length, result=0;
//        int[] counts=new int[l];
//        int start=0, end=0, count=0;
//        while(end<l){
//            int type=fruits[end];
//            if(count<2 || counts[type]>0){
//                if(counts[type]==0){
//                    count++;
//                }
//                counts[type]++;
//            } else{
//                result=Math.max(result, end-start);
//                while(count==2){
//                    int removeType=fruits[start++];
//                    if(--counts[removeType]==0){
//                        count--;
//                    }
//                }
//                counts[type]++;
//                count++;
//            }
//            end++;
//        }
//        result=Math.max(result, end-start);
//        return result;
//    }
}
