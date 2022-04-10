package com.wen.EleventhFifty;

import java.util.Random;

public class RandomPickWithWeight {
    // Binary indexed tree(This is more for practice as no frequent updates involved here)
    public static class Solution {

        private Random r;
        private int[] bit;
        private int[] w;

        public Solution(int[] w) {
            this.r=new Random();
            int l=w.length;
            this.w=new int[l];
            this.bit=new int[l+1];
            for(int i=0; i<l; i++){
                updateBIT(i, w[i]);
            }
        }

        private void updateBIT(int idx, int val){
            int diff=val-w[idx];
            w[idx]=val;
            for(int i=idx+1; i<bit.length; i+=(i&(-i))){
                bit[i]+=diff;
            }
        }

        // Get the sum of all numbers before idx inclusively
        private int getSum(int idx){
            int result=0;
            for(int i=idx+1; i>0; i-=(i&(-i))){
                result+=bit[i];
            }
            return result;
        }

        public int pickIndex() {
            int rd=r.nextInt(getSum(w.length-1))+1;
            int left=0, right=w.length-1;
            while(left<right){
                int mid=left+(right-left)/2;
                if(getSum(mid)<rd){
                    left=mid+1;
                } else{
                    right=mid;
                }
            }
            return left;
        }
    }

//    // Binary search
//    class Solution {
//
//        private Random r;
//        private int[] w;
//
//        public Solution(int[] w) {
//            this.w=w;
//            this.r=new Random();
//            for(int i=1; i<w.length; i++){
//                w[i]+=w[i-1];
//            }
//        }
//
//        public int pickIndex() {
//            int rd=r.nextInt(w[w.length-1])+1;
//            int left=0, right=w.length-1;
//            while(left<right){
//                int mid=left+(right-left)/2;
//                if(w[mid]<rd){
//                    left=mid+1;
//                } else{
//                    right=mid;
//                }
//            }
//            return left;
//        }
//    }
}
