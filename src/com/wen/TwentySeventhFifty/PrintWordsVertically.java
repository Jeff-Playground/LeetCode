package com.wen.TwentySeventhFifty;

import java.util.ArrayList;
import java.util.List;

public class PrintWordsVertically {
    public List<String> printVertically(String s) {
        List<String> result=new ArrayList<>();
        String[] splited=s.split("\\s");
        for(int j=0; j<splited.length; j++){
            String t=splited[j];
            int l=t.length();
            for(int i=0; i<l; i++){
                if(result.size()<i+1){
                    StringBuilder sb=new StringBuilder();
                    int count=j;
                    while(count-->0){
                        sb.append(" ");
                    }
                    sb.append(t.charAt(i));
                    result.add(sb.toString());
                } else{
                    StringBuilder sb=new StringBuilder(result.get(i));
                    int count=j-result.get(i).length();
                    while(count-->0){
                        sb.append(" ");
                    }
                    sb.append(t.charAt(i));
                    result.set(i, sb.toString());
                }
            }
        }
        return result;
    }
}
