package com.wen.ThirtySecondFifty;

/*
Given two sparse vectors, compute their dot product.

Implement class SparseVector:
    SparseVector(nums) Initializes the object with the vector nums
    dotProduct(vec) Compute the dot product between the instance of SparseVector and vec

A sparse vector is a vector that has mostly zero values, you should store the sparse vector efficiently and compute the
dot product between two SparseVector.

Follow up: What if only one of the vectors is sparse?



Example 1:
Input: nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
Output: 8
Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8


Example 2:
Input: nums1 = [0,1,0,0,0], nums2 = [0,0,0,0,2]
Output: 0
Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
v1.dotProduct(v2) = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0


Example 3:
Input: nums1 = [0,1,0,0,2,0,0], nums2 = [1,0,0,0,3,0,4]
Output: 6


Constraints:
n == nums1.length == nums2.length
1 <= n <= 10^5
0 <= nums1[i], nums2[i] <= 100
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LQDotProductOfTwoSparseVectors {
    // Use a List to store non-zero values with their indices
    class SparseVector {
        List<int[]> nonZeroValues;

        SparseVector(int[] nums) {
            nonZeroValues=new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                if(nums[i]!=0){
                    nonZeroValues.add(new int[]{i, nums[i]});
                }
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            List<int[]> vecNonZeroValues=vec.nonZeroValues;
            return dotProductHelper(nonZeroValues, vecNonZeroValues);
        }

        private int dotProductHelper(List<int[]> list1, List<int[]> list2){
            int i=0, j=0;
            int result=0;
            while(i<list1.size() && j<list2.size()){
                int[] v1=list1.get(i), v2=list2.get(j);
                if(v1[0]==v2[0]){
                    result+=v1[1]*v2[1];
                    i++;
                    j++;
                } else if(v1[0]<v2[0]){
                    i++;
                } else{
                    j++;
                }
            }
            return result;
        }
    }

//    // Use a Map to store non-zero values with their indices
//    class SparseVector {
//        Map<Integer, Integer> indexToNonZeroValues;
//
//        SparseVector(int[] nums) {
//            indexToNonZeroValues=new HashMap<>();
//            for(int i=0; i<nums.length; i++){
//                if(nums[i]!=0){
//                    indexToNonZeroValues.put(i, nums[i]);
//                }
//            }
//        }
//
//        // Return the dotProduct of two sparse vectors
//        public int dotProduct(SparseVector vec) {
//            Map<Integer, Integer> vecIndexToNonZeroValues=vec.indexToNonZeroValues;
//            return indexToNonZeroValues.size()<vecIndexToNonZeroValues.size()?dotProductHelper(indexToNonZeroValues, vecIndexToNonZeroValues):dotProductHelper(vecIndexToNonZeroValues, indexToNonZeroValues);
//        }
//
//        private int dotProductHelper(Map<Integer, Integer> smallerMap, Map<Integer, Integer> biggerMap){
//            int result=0;
//            for(int k: smallerMap.keySet()){
//                if(biggerMap.containsKey(k)){
//                    result+=smallerMap.get(k)*biggerMap.get(k);
//                }
//            }
//            return result;
//        }
//    }
}
