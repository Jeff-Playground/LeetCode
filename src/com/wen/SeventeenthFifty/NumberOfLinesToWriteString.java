package com.wen.SeventeenthFifty;

public class NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        int l=0, cur=0;
        for(char c: S.toCharArray()){
            cur+=widths[c-'a'];
            if(cur>=100){
                l+=100;
                cur=cur==100?0:widths[c-'a'];
            }
        }
        l+=cur;
        return new int[]{(l+99)/100, l%100};
    }
}
