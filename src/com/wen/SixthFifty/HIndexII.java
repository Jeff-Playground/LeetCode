package com.wen.SixthFifty;

public class HIndexII {
    // citations.length - i equals the number of papers that has higher citations than the ith paper
    public int hIndex(int[] citations) {
        int l=citations.length;
        for(int i=0; i<l; i++){
            if(citations[i]>=l-i){
                return l-i;
            }
        }
        return 0;
    }
}
