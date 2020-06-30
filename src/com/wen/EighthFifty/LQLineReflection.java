package com.wen.EighthFifty;

/*
Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

Example 1:
Input: [[1,1],[-1,1]]
Output: true

Example 2:
Input: [[1,1],[-1,-1]]
Output: false

Follow up:
Could you do better than O(n^2) ?

Hint:
Find the smallest and largest x-value for all points.
If there is a line then it should be at y = (minX + maxX) / 2.
For each point, make sure that it has a reflected point in the opposite side.
 */

import java.util.*;

public class LQLineReflection {
//    public static boolean isReflected(int[][] points) {
//        int n=points.length;
//        Arrays.sort(points, (a, b)->a[1]!=b[1]?a[1]-b[1]:a[0]-b[0]);
//        int left=-1, right=-1, start=0;
//        double mirror=Double.MAX_VALUE;
//        while(start<n){
//            left=start;
//            right=start;
//            while(right+1<n && points[right][1]==points[right+1][1]){
//                right++;
//            }
//            start=right+1;
//            while(left<right){
//                if(mirror==Double.MAX_VALUE){
//                    mirror=((double)points[right][0]+(double)points[left][0])/2;
//                } else{
//                    if(((double)points[right][0]+(double)points[left][0])/2!=mirror){
//                        return false;
//                    }
//                }
//                left++;
//                right--;
//            }
//            if(left==right && (double)points[left][0]!=mirror){
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean isReflected(int[][] points) {
        int n=points.length;
        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        Map<Integer, Set<Integer>> pMap=new HashMap<>();
        for(int i=0; i<n; i++){
            max=Math.max(max, points[i][0]);
            min=Math.min(min, points[i][0]);
            Set<Integer> cur=pMap.getOrDefault(points[i][1], new HashSet<>());
            cur.add(points[i][0]);
            pMap.put(points[i][1], cur);
        }
        double mirror=((double)min+(double)max)/2;
        for(int[] p: points){
            if(!pMap.get(p[1]).contains((int)(mirror*2-p[0]))){
                return false;
            }
        }
        return true;
    }
}
