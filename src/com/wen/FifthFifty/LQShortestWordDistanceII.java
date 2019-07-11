package com.wen.FifthFifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LQShortestWordDistanceII {
    class WordDistance{
        Map<String, List<Integer>> map=new HashMap<>();

        public WordDistance(List<String> words){
            for(int i=0; i<words.size(); i++){
                String word=words.get(i);
                List<Integer> indices=map.get(word);
                if(indices==null){
                    indices=new ArrayList<>();
                }
                indices.add(i);
            }
        }

        public int shortestDistance(String word1, String word2){
            List<Integer> indices1=map.get(word1);
            List<Integer> indices2=map.get(word2);
            int result=Integer.MAX_VALUE;
            int i=0, j=0;
            while(i<indices1.size() && j<indices2.size()){
                int index1=indices1.get(i), index2=indices2.get(j);
                result=Math.min(result, Math.abs(index1-index2));
                if(index1<index2){
                    i++;
                } else{
                    j++;
                }
            }
            return result;
        }
    }
}
