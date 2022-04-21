package com.wen.ThirtyFirstFifty;

public class KthMissingPositiveNumber {
//    // Binary search recursively
//    public int findKthPositive(int[] arr, int k) {
//        return fkpHelper(arr, 1, 0, arr.length-1, k);
//    }
//
//    private int fkpHelper(int[] arr, int start, int left, int right, int k){
//        if(left==right){
//            if(arr[left]-start>=k){
//                return start+k-1;
//            } else{
//                return arr[left]+k-(arr[left]-start);
//            }
//        }
//        int mid=left+(right-left)/2;
//        int missCount=arr[mid]-start+1-(mid-left+1);
//        if(missCount>=k){
//            return fkpHelper(arr, start, left, mid, k);
//        } else{
//            return fkpHelper(arr, arr[mid]+1, mid+1, right, k-missCount);
//        }
//    }

    // Binary search iteratively
    public int findKthPositive(int[] arr, int k) {
        int start=1, l=arr.length;
        int left=0, right=l-1;
        if(arr[left]-1>=k){
            return k;
        } else if(arr[right]-l<k){
            return arr[right]+k-(arr[right]-l);
        } else{
            while(left<right){
                int mid=left+(right-left)/2;
                int leftMissing=arr[mid]-start+1-(mid-left+1);
                if(leftMissing<k){
                    k-=leftMissing;
                    start=arr[mid]+1;
                    left=mid+1;
                } else{
                    right=mid;
                }
            }
            if(arr[left]-start>=k){
                return start+k-1;
            } else{
                return arr[left]+k-(arr[left]-start);
            }
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
