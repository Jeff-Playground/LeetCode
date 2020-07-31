package com.wen.NinthFifty;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        StringBuilder sb=new StringBuilder();
        int l1=num1.length(), l2=num2.length();
        int i1=l1-1, i2=l2-1;
        int carry=0;
        while(i1>=0 || i2>=0){
            int n1=i1>=0?num1.charAt(i1--)-'0':0;
            int n2=i2>=0?num2.charAt(i2--)-'0':0;
            int sum=n1+n2+carry;
            carry=sum>9?1:0;
            sb.insert(0, (char)('0'+(sum%10)));
        }
        if(carry==1){
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
