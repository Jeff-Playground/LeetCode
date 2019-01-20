package com.wen.SecondFifty;

public class AddBinary {
    public String addBinary(String a, String b) {
        if(a==null || a.length()==0 || a.length()<b.length()) {
            return addBinary(b, a);
        }
        if(b==null || b.length()==0) {
            return a;
        }
        String result="";
        int m=a.length(), n=b.length();
        int i=n-1, carry=0;
        while(i>=0) {
            int aInt=Integer.parseInt(a.substring(i+m-n, i+m-n+1));
            int bInt=Integer.parseInt(b.substring(i, i+1));
            int sum=aInt+bInt+carry;
            if(sum>=2) {
                carry=1;
                sum-=2;
            } else {
                carry=0;
            }
            result=sum+result;
            i--;
        }
        i=m-n-1;
        while(carry==1 && i>=0) {
            int aInt=Integer.parseInt(a.substring(i, i+1));
            int sum=aInt+carry;
            if(sum>=2) {
                carry=1;
                sum-=2;
            } else {
                carry=0;
            }
            result=sum+result;
            i--;
        }
        if(carry==0) {
            result=a.substring(0, i+1)+result;
        } else {
            result=1+result;
        }
        return result;
    }
}
