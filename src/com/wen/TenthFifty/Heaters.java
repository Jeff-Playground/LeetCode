package com.wen.TenthFifty;

import java.util.Arrays;
import java.util.TreeSet;

public class Heaters {
    // Binary search
    public int findRadius(int[] houses, int[] heaters) {
        if(houses.length==0 || heaters.length==0){
            return 0;
        }
        int result=Integer.MIN_VALUE;
        Arrays.sort(heaters);
        int l1=houses.length, l2=heaters.length;
        for(int i=0; i<l1; i++){
            int cur=houses[i];
            int left=0, right=l2-1;
            while(left<right){
                int mid=left+(right-left)/2;
                if(heaters[mid]<cur){
                    left=mid+1;
                } else{
                    right=mid;
                }
            }
            if(right>0){
                result=Math.max(result, Math.min(Math.abs(cur-heaters[right]), Math.abs(cur-heaters[right-1])));
            } else{
                result=Math.max(result, Math.abs(cur-heaters[right]));
            }
        }
        return result;
    }

//    // Greedy
//    public int findRadius(int[] houses, int[] heaters) {
//        if(houses.length==0 || heaters.length==0){
//            return 0;
//        }
//        int result=Integer.MIN_VALUE;
//        Arrays.sort(houses);
//        Arrays.sort(heaters);
//        int l1=houses.length, l2=heaters.length, j=0;
//        for(int i=0; i<l1; i++){
//            int cur=houses[i];
//            while(j<l2-1 && Math.abs(cur-heaters[j+1])<=Math.abs(cur-heaters[j])){
//                j++;
//            }
//            result=Math.max(result, Math.abs(cur-heaters[j]));
//        }
//        return result;
//    }

//    // TreeSet with binary search
//    public int findRadius(int[] houses, int[] heaters) {
//        if(houses.length==0 || heaters.length==0){
//            return 0;
//        }
//        int result=Integer.MIN_VALUE;
//        TreeSet<Integer> heaterSet=new TreeSet<>();
//        for(int heater: heaters){
//            heaterSet.add(heater);
//        }
//        for(int house: houses){
//            Integer left=heaterSet.floor(house);
//            Integer right=heaterSet.ceiling(house);
//            int cur=Integer.MAX_VALUE;
//            if(left!=null && right!=null){
//                cur=Math.min(house-left, right-house);
//            } else{
//                cur=left!=null?house-left:right-house;
//            }
//            result=Math.max(result, cur);
//        }
//        return result;
//    }
}
