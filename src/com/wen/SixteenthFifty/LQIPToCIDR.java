package com.wen.SixteenthFifty;

import java.util.ArrayList;
import java.util.List;

public class LQIPToCIDR {
    public static List<String> ipToCIDR(String ip, int n){
        List<String> result=new ArrayList<>();
        long ipVal=0;
        for(String val: ip.split("\\.")) {
            ipVal=ipVal*256+Long.parseLong(val);
        }
        while(n>0) {
            long step=ipVal&(-ipVal);
            while(step>n) {
                step>>=1;
            }
            result.add(convertCIDR(ipVal, step));
            ipVal+=step;
            n-=step;
        }
        return result;
    }

    private static String convertCIDR(long ipVal, long step) {
        String result="";
        int count=4;
        while(count-->0) {
            long val=ipVal&255;
            ipVal>>=8;
            result=String.valueOf(val)+"."+result;
        }
        return result.substring(0, result.length()-1)+"/"+String.valueOf(step);
    }
}
