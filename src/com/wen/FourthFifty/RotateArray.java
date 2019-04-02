package com.wen.FourthFifty;

public class RotateArray {
    // Each time make the first k elements legit, then keep processing the remaining elements(remaining should rotate by k%newN)
    public static void rotate(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return;
        }
        int n=nums.length, start=0;
        k%=n;
        while(n!=0 && k!=0) {
            for(int i=0; i<k; i++) {
                int temp=nums[start+i];
                nums[start+i]=nums[start+n-k+i];
                nums[start+n-k+i]=temp;
            }
            n-=k;
            start+=k;
            if(n!=0){
                k%=n;
            }
        }
    }

//    // Use index relation for rotated array
//    public void rotate(int[] nums, int k) {
//        if(nums==null || nums.length==0){
//            return;
//        }
//        int n=nums.length;
//        k=k%n;
//        if(k==0){
//            return;
//        }
//        int start=0, idx=0, pre=0, cur=nums[0];
//        for(int i=0; i<n; i++) {
//            pre=cur;
//            idx=(idx+k)%n;
//            cur=nums[idx];
//            nums[idx]=pre;
//            // This is to prevent infinite loop when (idx+k)%n goes back to start
//            if(idx==start) {
//                idx=++start;
//                cur=nums[idx];
//            }
//        }
//    }

//    // Three rotates
//    public void rotate(int[] nums, int k) {
//        if(nums==null || nums.length==0){
//            return;
//        }
//        int n=nums.length;
//        k=k%n;
//        if(k==0){
//            return;
//        }
//        rotate(nums, 0, n-k-1);
//        rotate(nums, n-k, n-1);
//        rotate(nums, 0, n-1);
//    }
//
//    private void rotate(int[] nums, int start, int end) {
//        while(start<end) {
//            int temp=nums[start];
//            nums[start]=nums[end];
//            nums[end]=temp;
//            start++;
//            end--;
//        }
//    }
}
