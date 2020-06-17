package com.wen.SeventhFifty;

public class CreateMaximumNumber {
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int l1=nums1.length, l2=nums2.length;
        int[] result=new int[k];
        for(int i=Math.max(0, k-l2); i<=l1 && i<=k; i++){
            int[] n1=findMax(nums1, i);
            int[] n2=findMax(nums2, k-i);
            result=getGreater(result, merge(n1, n2));
        }
        return result;
    }

    private static int[] getGreater(int[] nums1, int[] nums2){
        for(int i=0; i<nums1.length; i++){
            if(nums1[i]>nums2[i]){
                return nums1;
            } else if(nums1[i]<nums2[i]){
                return nums2;
            }
        }
        return nums1;
    }

    private static int[] merge(int[] nums1, int[] nums2){
        int l1=nums1.length, l2=nums2.length, l=l1+l2;
        int[] result=new int[l];
        int i1=0, i2=0, ri=0;
        while(ri<l){
            if(i1<l1 && i2<l2){
                if(nums1[i1]!=nums2[i2]){
                    result[ri++]=nums1[i1]>nums2[i2]?nums1[i1++]:nums2[i2++];
                } else{
                    int i=i1+1, j=i2+1;
                    while(i<l1 && j<l2 && nums1[i]==nums2[j]){
                        i++;
                        j++;
                    }
                    if(i<l1 && (j==l2 || nums1[i]>nums2[j])){
                        result[ri++]=nums1[i1++];
                    } else{
                        result[ri++]=nums2[i2++];
                    }
                }
            } else if(i1<l1){
                result[ri++]=nums1[i1++];
            } else if(i2<l2){
                result[ri++]=nums2[i2++];
            }
        }
        return result;
    }

    private static int[] findMax(int[] nums, int k){
        int l=nums.length, exclude=l-k;
        int[] result=new int[k];
        int start=0, ri=0;
        while(exclude>0 && ri<k){
            int max=Integer.MIN_VALUE, iMax=-1;
            for(int i=start; i<l && i<start+exclude+1; i++){
                if(nums[i]>max){
                    iMax=i;
                    max=nums[i];
                }
            }
            result[ri++]=nums[iMax];
            exclude-=iMax-start;
            start=iMax+1;
        }
        while(ri<k){
            result[ri++]=nums[start++];
        }
        return result;
    }
}
