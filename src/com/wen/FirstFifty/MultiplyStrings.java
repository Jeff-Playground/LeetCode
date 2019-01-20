package com.wen.FirstFifty;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String result="";
        int l1=num1.length();
        int l2=num2.length();
        int[] d=new int[l1+l2];
        for(int i=l1-1; i>=0; i--) {
            for(int j=l2-1; j>=0; j--) {
                d[i+j+1]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        int carry=0;
        for(int k=l1+l2-1; k>=0; k--) {
            d[k]+=carry;
            carry=d[k]/10;
            d[k]%=10;
            result=String.valueOf(d[k])+result;
        }
        while(result.startsWith("0")) {
            result=result.substring(1);
        }
        return result;
    }
}
