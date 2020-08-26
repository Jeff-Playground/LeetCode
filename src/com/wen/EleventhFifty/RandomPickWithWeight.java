package com.wen.EleventhFifty;

import java.util.Random;

public class RandomPickWithWeight {
    class Solution {

        private Random r;
        private int[] w;

        public Solution(int[] w) {
            this.w=w;
            this.r=new Random();
            for(int i=1; i<w.length; i++){
                w[i]+=w[i-1];
            }
        }

        public int pickIndex() {
            int rd=r.nextInt(w[w.length-1])+1;
            int left=0, right=w.length-1;
            while(left<right){
                int mid=left+(right-left)/2;
                if(w[mid]<rd){
                    left=mid+1;
                } else{
                    right=mid;
                }
            }
            return left;
        }
    }
}
