package com.wen.ThirteenthFifty;

/*
Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays
(each array picks one) and calculate the distance. We define the distance between two integers a and b to be their
absolute difference |a-b|. Your task is to find the maximum distance.

Example 1:

Input:
[[1,2,3],
 [4,5],
 [1,2,3]]
Output: 4
Explanation:
One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.


Note:
Each given array will have at least 1 number. There will be at least two non-empty arrays.
The total number of the integers in all the m arrays will be in the range of [2, 10000].
The integers in the m arrays will be in the range of [-10000, 10000].
*/

public class LQMaximumDistanceInArrays {
    public int maxDiff(int[][] arrs) {
        int l=arrs.length, result=Integer.MIN_VALUE;
        int min=arrs[0][0], max=arrs[0][arrs.length-1];
        for(int i=1; i<l; i++){
            int cMin=arrs[i][0], cMax=arrs[i][arrs[i].length-1];
            // Note how this calculation doesn't require Math.abs(cMin-min) and Math.abs(cMax-max)
            int cur=Math.max(Math.abs(cMin-max), Math.abs(cMax-min));
            result=Math.max(cur, result);
            min=Math.min(min, cMin);
            max=Math.max(max, cMax);
        }
        return result;
    }
}
