package com.wen.FourteenthFifty;

public class KthSmallestNumberInMultiplicationTable {
    // Similar to binary search2 except optimized the algorithm to count less than or equal to elements, instead of iteration
    // do mid/j to calculate the value of i
    public int findKthNumber(int m, int n, int k) {
        int left=1, right=m*n;
        while(left<right){
            int mid=left+(right-left)/2, count=0, i=m, j=1;
            while(j<=n){
                i=Math.min(i, mid/j);
                count+=i;
                j++;
            }
            if(count<k){
                left=mid+1;
            } else{
                right=mid;
            }
        }
        return left;
    }

//    // Binary search2, optimized the algorithm to count less than or equal to elements
//    public int findKthNumber(int m, int n, int k) {
//        int left=1, right=m*n;
//        while(left<right){
//            int mid=left+(right-left)/2, count=0, i=m, j=1;
//            while(j<=n){
//                if(i*j<=mid){
//                    count+=i;
//                    j++;
//                } else{
//                    i--;
//                }
//            }
//            if(count<k){
//                left=mid+1;
//            } else{
//                right=mid;
//            }
//        }
//        return left;
//    }

//    // Binary search1
//    public int findKthNumber(int m, int n, int k) {
//        int left=1, right=m*n;
//        while(left<right){
//            int mid=left+(right-left)/2, count=0;
//            for(int i=1; i<=m; i++){
//                count+=mid>n*i?n:mid/i;
//            }
//            if(count<k){
//                left=mid+1;
//            } else{
//                right=mid;
//            }
//        }
//        return left;
//    }
}
