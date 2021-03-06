package com.wen.SixteenthFifty;

import java.util.ArrayList;
import java.util.List;

public class LQMinimizeMaxDistanceToGasStation {
    // Binary search. Basically make a guess of what the max distance can be, then validate it. Here the count is the
    // number of gas stations need to be inserted, so when count<=k, means more stations can be inserted and mid is too
    // big, otherwise mid is too small.
    public static double minmaxGasDist(int[] stations, int k) {
        int l=stations.length;
        List<Integer> diff=new ArrayList<>();
        for(int i=1; i<l; i++){
            diff.add(stations[i]-stations[i-1]);
        }
        double left=0, right=Math.pow(10,8);
        while(right-left>Math.pow(10,-6)){
            double mid=left+(right-left)/2;
            int count=0, size=diff.size();
            for(int i=0; i<size; i++){
                count+=diff.get(i)/mid;
            }
            // Note here can't do right=mid-1 or left=mid+1, because it's important to ensure left<right always
            if(count<=k){
                right=mid;
            } else{
                left=mid;
            }
        }
        return left;
    }
}
