package com.wen.FourteenthFifty;

public class CountBinarySubstrings {
    // The idea is to find a longest segment which has both 0s and 1s, and for this segment it will have
    // Math.min(count0, count1) number of valid substrings
    // Keep iterating to find such segments
    public int countBinarySubstrings(String s) {
        if(s==null || s.isEmpty()){
            return 0;
        } else{
            int l=s.length();
            int left=0, right=-1, result=0;
            for(int i=0; i<l; i++){
                if(i+1==l || s.charAt(i)!=s.charAt(i+1)){
                    if(right!=-1){
                        result+=Math.min(right-left, i-right+1);
                        if(i+1<l){
                            left=right;
                            right=i+1;
                        }
                    } else{
                        if(i+1<l){
                            right=i+1;
                        }
                    }
                }
            }
            return result;
        }
    }
}
