package com.wen.TwentyNinthFifty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> outDegree=new HashMap<>();
        for(List<String> path: paths){
            outDegree.put(path.get(0), outDegree.getOrDefault(path.get(0),0)+1);
            outDegree.putIfAbsent(path.get(1), 0);
        }
        for(String key: outDegree.keySet()){
            if(outDegree.get(key)==0){
                return key;
            }
        }
        return null;
    }
}
