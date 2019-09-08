package com.wen.SixteenthFifty;

public class LQPourWater {
    public int[] pourWater(int[] heights, int V, int K) {
        int n=heights.length, l=K, r=K;
        while(V-->0){
            l=K;
            r=K;
            while(l>0 && heights[l]>=heights[l-1]){
                l--;
            }
            while(l<K && heights[l]==heights[l+1]){
                l++;
            }
            while(r<n-1 && heights[r]>=heights[r+1]){
                r++;
            }
            while(r>K && heights[r]==heights[r-1]){
                r--;
            }
            if(heights[l]<heights[K]){
                heights[l]++;
            } else{
                heights[r]++;
            }
        }
        return heights;
    }
}
