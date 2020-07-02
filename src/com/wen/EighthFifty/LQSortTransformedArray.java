package com.wen.EighthFifty;

/*
Given a sorted array of integers nums and integer values a, b and c. Apply a quadratic function of the form
f(x) = ax2 + bx + c to each element x in the array.

The returned array must be in sorted order.

Expected time complexity: O(n)

Example 1:
Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
Output: [3,9,15,33]

Example 2:
Input: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
Output: [-23,-5,1,7]
 */

import java.util.PriorityQueue;

public class LQSortTransformedArray {
    // Time complexity O(n)
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int l=nums.length;
        int[] result=new int[l];
        if(a==0 && b>=0){
            for(int i=0; i<l; i++){
                result[i]=calculate(a, b, c, nums[i]);
            }
        } else if(a==0 && b<0){
            for(int i=0; i<l; i++){
                result[i]=calculate(a, b, c, nums[l-1-i]);
            }
        } else if(a>0){
            int left=0, right=l-1;
            int i=l-1;
            while(left<=right){
                int num1=calculate(a, b, c, nums[left]);
                int num2=calculate(a, b, c, nums[right]);
                if(num1>=num2){
                    result[i--]=num1;
                    left++;
                } else{
                    result[i--]=num2;
                    right--;
                }
            }
        } else if(a<0){
            int left=0, right=l-1;
            int i=0;
            while(left<=right){
                int num1=calculate(a, b, c, nums[left]);
                int num2=calculate(a, b, c, nums[right]);
                if(num1<=num2){
                    result[i++]=num1;
                    left++;
                } else{
                    result[i++]=num2;
                    right--;
                }
            }
        }
        return result;
    }

//    // Time complexity O(nlogn)
//    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
//        int[] result=new int[nums.length];
//        PriorityQueue<Integer> pq=new PriorityQueue<>();
//        for(int num: nums){
//            pq.offer(calculate(a, b, c, num));
//        }
//        for(int i=0; i<result.length; i++){
//            result[i]=pq.poll();
//        }
//        return result;
//    }

    private int calculate(int a, int b, int c, int num){
        return a*num*num+b*num+c;
    }
}
