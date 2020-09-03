package com.wen.TenthFifty;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder result=new StringBuilder();
        int cur=0;
        for(int i=S.length()-1; i>=0; i--){
            char c=S.charAt(i);
            if(c!='-'){
                if(c>='a' && c<='z'){
                    c-=32;
                }
                result.append(c);
                cur++;
                if(cur==K){
                    result.append("-");
                    cur=0;
                }
            }
        }
        result.reverse();
        if(result.length()>0 && result.charAt(0)=='-'){
            return result.substring(1);
        } else{
            return result.toString();
        }
    }
}
