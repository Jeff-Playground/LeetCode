package com.wen.FourteenthFifty;

import java.util.Arrays;

public class MaximumSwap {
    // Greedy, optimized to only store the last idx pairs need swapping
    public int maximumSwap(int num) {
        String numString=""+num;
        int l=numString.length();
        int maxIdx=l-1, swapIdx=-1, largerIdx=maxIdx;
        for(int i=l-2; i>=0; i--){
            if(numString.charAt(i)<numString.charAt(maxIdx)){
                swapIdx=i;
                largerIdx=maxIdx;
            } else if(numString.charAt(i)>numString.charAt(maxIdx)){
                maxIdx=i;
            }
        }
        if(swapIdx==-1){
            return num;
        } else{
            StringBuilder sb=new StringBuilder();
            sb.append(numString.substring(0, swapIdx));
            sb.append(numString.charAt(largerIdx));
            sb.append(numString.substring(swapIdx+1, largerIdx));
            sb.append(numString.charAt(swapIdx));
            sb.append(numString.substring(largerIdx+1));
            return Integer.valueOf(sb.toString());
        }
    }

//    // Greedy
//    public int maximumSwap(int num) {
//        String numString=""+num;
//        int l=numString.length();
//        int[] nextMax=new int[l];
//        Arrays.fill(nextMax, -1);
//        int curMax=l-1;
//        for(int i=l-2; i>=0; i--){
//            if(numString.charAt(i)<numString.charAt(curMax)){
//                nextMax[i]=curMax;
//            } else if(numString.charAt(i)>numString.charAt(curMax)){
//                curMax=i;
//            }
//        }
//        StringBuilder sb=new StringBuilder();
//        for(int i=0; i<l; i++){
//            if(nextMax[i]==-1){
//                sb.append(numString.charAt(i));
//            } else{
//                sb.append(numString.charAt(nextMax[i]));
//                sb.append(numString.substring(i+1, nextMax[i]));
//                sb.append(numString.charAt(i));
//                sb.append(numString.substring(nextMax[i]+1));
//                break;
//            }
//        }
//        return Integer.valueOf(sb.toString());
//    }
}
