package com.wen.FifthFifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LQGroupShiftedStrings {
    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map=new HashMap<>();
        for(String s: strings){
            String key="";
            if(s.length()>0){
                char c=s.charAt(0);
                for(int i=0; i<s.length(); i++){
                    int v=s.charAt(i)-c;
                    key+=v<0?v+26:v;
                }
                List<String> l=map.getOrDefault(key, new ArrayList<String>());
                l.add(s);
                map.put(key, l);
            } else{
                List<String> l=map.getOrDefault(key, new ArrayList<String>());
                l.add(s);
                map.put(key, l);
            }
        }
        List<List<String>> result=new ArrayList<>();
        for(List<String> l: map.values()){
            result.add(l);
        }
        return result;
    }
}
