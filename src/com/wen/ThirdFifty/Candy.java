package com.wen.ThirdFifty;

import java.util.Arrays;

public class Candy {
    // Use count to store the length of the decreasing array, when array stopped, add the sum of the arithmetic 
    // progression to result, and reset pre and count
    public static int candy(int[] ratings) {
        if(ratings==null || ratings.length==0){
            return 0;
        }
        int result=1, n=ratings.length, pre=1, count=0;
        for(int i=1; i<n; i++){
            if(ratings[i]>=ratings[i-1]){
                if(count>0){
                    result+=(count+1)*count/2;
                    // Doing this because count is actually the decreasing array length-1, the first element is not 
                    // necessarily (count+1), it can be larger if the element before it has a value >=(count+1). pre 
                    // was the initial value given to it, if it's smaller then count+1, then it needs to be pushed up
                    if(count>=pre){
                        result+=count-pre+1;
                    }
                    count=0;
                    pre=1;
                }
                pre=ratings[i]==ratings[i-1]?1:pre+1;
                result+=pre;
            } else{
                count++;
            }
        }
        if(count>0){
            result+=(count+1)*count/2;
            if(count>=pre){
                result+=count-pre+1;
            }
        }
        return result;
    }

//    // My way
//    // For each decreasing array inside, push up the values by find the location of the last element of the array
//    public int candy(int[] ratings) {
//        if(ratings==null || ratings.length==0){
//            return 0;
//        }
//        int result=0, n=ratings.length, pre=-1, decreasingHeadValue=0;
//        int[] nums=new int[n];
//        nums[0]=1;
//        for(int i=0; i<n-1; i++){
//            if(ratings[i+1]>ratings[i]){
//                pre=-1;
//                nums[i+1]=nums[i]+1;
//            } else if(ratings[i+1]==ratings[i]){
//                pre=-1;
//                nums[i+1]=1;
//            } else{
//                if(pre==-1){
//                    pre=i;
//                    decreasingHeadValue=1;
//                }
//                if(nums[i]==1 && pre<i){
//                    result+=i-pre;
//                    decreasingHeadValue++;
//                }
//                if(nums[pre]==decreasingHeadValue){
//                    nums[pre]++;
//                }
//                nums[i+1]=1;
//            }
//        }
//        for(int num:nums){
//            result+=num;
//        }
//        return result;
//    }

//    public int candy(int[] ratings) {
//        if(ratings==null || ratings.length==0){
//            return 0;
//        }
//        int result=0, n=ratings.length;
//        int[] nums=new int[n];
//        Arrays.fill(nums, 1);
//        for(int i=0; i<n-1; i++){
//            if(ratings[i+1]>ratings[i]){
//                nums[i+1]=nums[i]+1;
//            }
//        }
//        for(int i=n-1; i>0; i--){
//            if(ratings[i-1]>ratings[i]){
//                nums[i-1]=Math.max(nums[i-1], nums[i]+1);
//            }
//        }
//        for(int num:nums){
//            result+=num;
//        }
//        return result;
//    }
}
