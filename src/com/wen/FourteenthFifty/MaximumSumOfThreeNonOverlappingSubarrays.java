package com.wen.FourteenthFifty;

public class MaximumSumOfThreeNonOverlappingSubarrays {
    // sum[i] is the sum of the subarray of length k starting at i
    // left[i] is the starting index of the subarray with length k that has the maximum sum on the left of i(note ending index<=i)
    // right[i] is the starting index of the subarray with length k that has the maximum sum on the right of i
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int l=nums.length;
        int[] sum=new int[l];
        for(int i=l-1; i>=0; i--){
            sum[i]=(i+1<l?sum[i+1]:0)+nums[i];
        }
        for(int i=0; i<l-k; i++){
            sum[i]-=sum[i+k];
        }
        int[] left=new int[l], right=new int[l];
        for(int i=k-1; i<l-2*k; i++){
            if(i==k-1){
                left[i]=0;
            } else{
                // Note here it's >= to get the smaller index
                left[i]=sum[left[i-1]]>=sum[i-k+1]?left[i-1]:i-k+1;
            }
        }
        for(int i=l-k; i>=2*k; i--){
            if(i==l-k){
                right[i]=l-k;
            } else{
                // Note here it's > to get the smaller index
                right[i]=sum[right[i+1]]>sum[i]?right[i+1]:i;
            }
        }
        int[] result=new int[3];
        int max=Integer.MIN_VALUE;
        for(int i=k; i<=l-2*k; i++){
            if(sum[left[i-1]]+sum[i]+sum[right[i+k]]>max){
                max=sum[left[i-1]]+sum[i]+sum[right[i+k]];
                result[0]=left[i-1];
                result[1]=i;
                result[2]=right[i+k];
            }
        }
        return result;
    }
}
