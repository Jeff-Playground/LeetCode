package com.wen.FourthFifty;

public class LQReverseWordsInAStringII {
    public char[] reverseWords(char[] str) {
        int i=0;
        for(int j=0; j<str.length; j++) {
            if(str[j]==' ') {
                reverse(str, i, j-1);
                i=j+1;
            }
        }
        reverse(str, i, str.length-1);
        reverse(str, 0, str.length-1);
        return str;
    }

    private void reverse(char[] str, int start, int end) {
        while(start<end) {
            char temp=str[start];
            str[start]=str[end];
            str[end]=temp;
            start++;
            end--;
        }
    }
}
