package com.wen.EighthFifty;

import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
//    // Min heap, similar to merge k sorted list
//    public int kthSmallest(int[][] matrix, int k) {
//        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->a[0]-b[0]);
//        int m=matrix.length, n=matrix[0].length;
//        for(int i=0; i<m && i<k; i++){
//            pq.offer(new int[]{matrix[i][0], i, 0});
//        }
//        int result=0;
//        while(k-->0){
//            int[] cur=pq.poll();
//            int v=cur[0], x=cur[1], y=cur[2];
//            if(k==0){
//                result=v;
//                break;
//            }
//            if(y+1<n){
//                pq.offer(new int[]{matrix[x][y+1], x, y+1});
//            }
//        }
//        return result;
//    }

//    // Binary search2, optimized the algorithm to find less or equal to count
//    public int kthSmallest(int[][] matrix, int k) {
//        int n=matrix.length;
//        int left=matrix[0][0], right=matrix[n-1][n-1];
//        while(left<right){
//            int mid=left+(right-left)/2;
//            int count=countOfLessOrEqual(matrix, mid);
//            if(count<k){
//                left=mid+1;
//            } else{
//                right=mid;
//            }
//        }
//        return left;
//    }
//
//    // The idea here is to do search column by column, and add all non-greater ones
//    private int countOfLessOrEqual(int[][] matrix, int target){
//        int n=matrix.length, i=n-1, j=0, count=0;
//        while(i>=0 && j<n){
//            if(matrix[i][j]>target){
//                i--;
//            } else{
//                count+=i+1;
//                j++;
//            }
//        }
//        return count;
//    }

    // Binary search1
    public static int kthSmallest(int[][] matrix, int k) {
        int m=matrix.length, n=matrix[0].length;
        int left=matrix[0][0], right=matrix[m-1][n-1];
        while(left<right){
            int mid=left+(right-left)/2, count=0;
            for(int i=0; i<m; i++){
                if(matrix[i][n-1]<=mid){
                    count+=n;
                } else if(matrix[i][0]>mid){
                    break;
                } else{
                    count+=getSmallerThanOrEqualToKCount(matrix[i], mid);
                }
            }
            if(count<k){
                left=mid+1;
            } else{
                right=mid;
            }
        }
        return left;
    }

    // Using another binary search
    private static int getSmallerThanOrEqualToKCount(int[] a, int k){
        int left=0, right=a.length-1;
        while(left<right){
            int mid=left+(right+1-left)/2;
            if(a[mid]>k){
                right=mid-1;
            } else{
                left=mid;
            }
        }
        return left-0+1;
    }
}
