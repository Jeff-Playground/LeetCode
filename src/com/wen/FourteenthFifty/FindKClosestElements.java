package com.wen.FourteenthFifty;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    // Note that when calculating distance, no need to use Math.abs, just compare (x-left) vs (right-x) is enough

//    // Binary search
//    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
//        List<Integer> result=new ArrayList<>();
//        if(arr.length<=k){
//            for(int num: arr){
//                result.add(num);
//            }
//        } else{
//            int left=0, right=arr.length-1;
//            while(left<right){
//                int mid=left+(right-left)/2;
//                if(arr[mid]>=x){
//                    right=mid;
//                } else{
//                    left=mid+1;
//                }
//            }
//            int start=left-k>=0?left-k:0;
//            for(int i=start; i<left; i++){
//                result.add(arr[i]);
//            }
//            for(int i=left; i<arr.length; i++){
//                if(result.size()<k){
//                    result.add(arr[i]);
//                } else{
//                    if(arr[i]-x>=x-result.get(0)){
//                        break;
//                    } else{
//                        result.add(arr[i]);
//                        result.remove(0);
//                    }
//                }
//            }
//        }
//        return result;
//    }

//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        List<Integer> result=new ArrayList<>();
//        for(int num: arr){
//            result.add(num);
//        }
//        int left=result.get(0), right=result.get(result.size()-1);
//        while(result.size()>k){
//            if(x-left<=right-x){
//                result.remove(result.size()-1);
//            } else{
//                result.remove(0);
//            }
//        }
//        return result;
//    }

    // Binary search, use the two ends arr[i] and arr[i+k] to decide which direction should the range move to
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result=new ArrayList<>();
        if(arr.length<=k){
            for(int num: arr){
                result.add(num);
            }
        } else{
            int left=0, right=arr.length-k;
            while(left<right){
                int mid=left+(right-left)/2;
                if(x-arr[mid]>arr[mid+k]-x){
                    left=mid+1;
                } else{
                    right=mid;
                }
            }
            int count=0, start=left;
            while(count++<k){
                result.add(arr[start++]);
            }
        }
        return result;
    }
}
