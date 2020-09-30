package com.wen.EleventhFifty;

public class ReverseStringII {
    public static String reverseStr(String s, int k) {
        StringBuilder sb=new StringBuilder();
        int start=0, end=0, l=s.length();
        while(end<l){
            if(end-start+1<k){
                end++;
            } else if(end-start+1==k){
                int cur=end++;
                while(cur>=start){
                    sb.append(s.charAt(cur--));
                }
            } else if(end-start+1<=2*k){
                sb.append(s.charAt(end++));
            } else{
                start=end;
            }
        }
        end--;
        if(end-start+1<=k){
            while(end>=start){
                sb.append(s.charAt(end--));
            }
        }
        return sb.toString();
    }
}
