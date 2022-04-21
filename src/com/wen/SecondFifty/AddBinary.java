package com.wen.SecondFifty;

public class AddBinary {
    public String addBinary(String a, String b) {
        int al=a.length(), bl=b.length();
        int i=al-1, j=bl-1;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        while(i>=0 || j>=0){
            int ac=i>=0?a.charAt(i--)-'0':0, bc=j>=0?b.charAt(j--)-'0':0;
            int add=ac+bc+carry;
            carry=add>1?1:0;
            add%=2;
            sb.append((char)(add+'0'));
        }
        if(carry==1){
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
