package com.wen.TenthFifty;

import java.util.Random;

public class RandomPointInNonOverlappingRectangles {
//    // Reservoir sampling
//    class Solution {
//
//        private int[][] rects;
//
//        public Solution(int[][] rects) {
//            this.rects=rects;
//        }
//
//        public int[] pick() {
//            int[] result=new int[2];
//            int sum=0;
//            int[] select=new int[4];
//            Random r=new Random();
//            for(int[] rect: rects){
//                int count=(rect[2]-rect[0]+1)*(rect[3]-rect[1]+1);
//                sum+=count;
//                if(r.nextInt(sum)<count){
//                    select=rect;
//                }
//            }
//            result[0]=r.nextInt(select[2]-select[0]+1)+select[0];
//            result[1]=r.nextInt(select[3]-select[1]+1)+select[1];
//            return result;
//        }
//    }

    // Binary search
    class Solution {
        private int[][] rects;
        private int[] counts;

        public Solution(int[][] rects) {
            this.rects=rects;
            int l=rects.length;
            this.counts=new int[l];
            for(int i=0; i<l; i++){
                int[] rect=rects[i];
                counts[i]=(rect[2]-rect[0]+1)*(rect[3]-rect[1]+1);
                counts[i]+=i>0?counts[i-1]:0;
            }
        }

        public int[] pick() {
            Random r=new Random();
            int cur=r.nextInt(counts[counts.length-1]+1);
            int left=0, right=counts.length-1;
            while(left<right){
                int mid=left+(right-left)/2;
                if(counts[mid]<cur){
                    left=mid+1;
                } else{
                    right=mid;
                }
            }
            int[] select=rects[left];
            int[] result=new int[2];
            result[0]=r.nextInt(select[2]-select[0]+1)+select[0];
            result[1]=r.nextInt(select[3]-select[1]+1)+select[1];
            return result;
        }
    }
}
