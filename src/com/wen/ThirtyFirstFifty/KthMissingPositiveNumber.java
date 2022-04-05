package com.wen.ThirtyFirstFifty;

public class KthMissingPositiveNumber {
    // Binary search
    public int findKthPositive(int[] arr, int k) {
        return fkpHelper(arr, 1, 0, arr.length-1, k);
    }

    private int fkpHelper(int[] arr, int start, int left, int right, int k){
        if(left==right){
            for(int i=start; i<=arr[left]; i++){
                if(i!=arr[left]){
                    k--;
                    if(k==0){
                        return i;
                    }
                }
            }
            return arr[left]+k;
        }
        int mid=left+(right-left)/2;
        int missCount=arr[mid]-start+1-(mid-left+1);
        if(missCount>=k){
            return fkpHelper(arr, start, left, mid, k);
        } else{
            return fkpHelper(arr, arr[mid]+1, mid+1, right, k-missCount);
        }
    }

//    public int findKthPositive(int[] arr, int k) {
//        int idx=1, l=arr.length, count=0;
//        for(int i=0; i<l; i++){
//            int num=arr[i];
//            while(idx<num){
//                if(++count==k){
//                    return idx;
//                }
//                idx++;
//            }
//            idx++;
//        }
//        while(++count<k){
//            idx++;
//        }
//        return idx;
//    }
}
