package com.wen.TenthFifty;

/*
Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

Example 1:

Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    After flipping, the maximum number of consecutive 1s is 4.

Note:
The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000

Follow up:
What if the input numbers come in one by one as an infinite stream? In other words, you can't store all numbers coming
from the stream as it's too large to hold in memory. Could you solve it efficiently?
 */

import java.util.LinkedList;
import java.util.Queue;

public class LQMaxConsecutiveOnesII {
//    // Sliding window, handles when nums can be a data stream
//    // Use a Queue to store the indices of 0s
//    public static int findMaxConsecutiveOnes(int[] nums) {
//        Queue<Integer> q=new LinkedList<>();
//        int result=0, idx=0, l=nums.length, start=0;
//        while(idx<l){
//            if(nums[idx]==0){
//                q.offer(idx);
//                while(q.size()>1){
//                    start=q.poll()+1;
//                }
//            }
//            result=Math.max(result, idx-start+1);
//            idx++;
//        }
//        return result;
//    }

//    // Sliding window2
//    public static int findMaxConsecutiveOnes(int[] nums) {
//        int left=0, right=0, countZero=0, l=nums.length, result=0;
//        while(right<l){
//            if(nums[right]==0){
//                countZero++;
//                while(countZero>1){
//                    if(nums[left++]==0){
//                        countZero--;
//                    }
//                }
//            }
//            result=Math.max(result, right-left+1);
//            right++;
//        }
//        return result;
//    }

    // countCur is the count of current consecutive ones, countLast is the last count of consecutive ones + 1
    public static int findMaxConsecutiveOnes(int[] nums) {
        int result=0, countCur=0, countLast=0;
        for(int num: nums){
            countCur++;
            if(num==0){
                countLast=countCur;
                countCur=0;
            }
            result=Math.max(result, countCur+countLast);
        }
        return result;
    }
}
