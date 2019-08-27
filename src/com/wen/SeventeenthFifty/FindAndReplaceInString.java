package com.wen.SeventeenthFifty;

import java.util.Map;
import java.util.TreeMap;

public class FindAndReplaceInString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb=new StringBuilder();
        int l=indexes.length;
        if(l==0) {
            return S;
        }
        Map<Integer, Integer> sorted=new TreeMap<>();
        for(int i=0; i<l; i++){
            sorted.put(indexes[i], i);
        }
        Integer[] sortedIndexes= sorted.keySet().toArray(new Integer[l]);
        sb.append(S.substring(0, sortedIndexes[0]));
        for(int i=0; i<l; i++) {
            String cur=S.substring(sortedIndexes[i], i==l-1?S.length():sortedIndexes[i+1]);
            String source=sources[sorted.get(sortedIndexes[i])], target=targets[sorted.get(sortedIndexes[i])];
            if(cur.startsWith(source)){
                sb.append(target);
                sb.append(cur.substring(source.length()));
            } else{
                sb.append(cur);
            }
        }
        return sb.toString();
    }
}
