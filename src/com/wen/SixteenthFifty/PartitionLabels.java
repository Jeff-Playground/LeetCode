package com.wen.SixteenthFifty;

import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result=new ArrayList<>();
        Map<Character, Integer> map=new HashMap<>();
        int l=S.length();
        for(int i=0; i<l; i++){
            map.put(S.charAt(i), i);
        }
        int start=0, last=0, i=0;
        while(i<l){
            last=Math.max(last, map.get(S.charAt(i)));
            if(i==last){
                result.add(last-start+1);
                start=i+1;
            }
            i++;
        }
        return result;
    }

//    public List<Integer> partitionLabels(String S) {
//        List<Integer> result=new ArrayList<>();
//        int[] start=new int[26];
//        int[] end=new int[26];
//        Arrays.fill(start, -1);
//        Arrays.fill(end, -1);
//        int l=S.length();
//        for(int i=0; i<l; i++){
//            char c=S.charAt(i);
//            if(start[c-'a']==-1){
//                start[c-'a']=i;
//            } else{
//                end[c-'a']=i;
//            }
//        }
//        for(int i=0; i<26; i++){
//            if(end[i]==-1){
//                start[i]=-1;
//            }
//        }
//        Arrays.sort(start);
//        Arrays.sort(end);
//        int i=0;
//        while(i<26){
//            if(start[i]==-1){
//                i++;
//            } else{
//                if(result.isEmpty()) {
//                    for(int j=0; j<start[i]; j++) {
//                        result.add(1);
//                    }
//                }
//                result.add(start[i]);
//                while(i+1<26 && end[i]>start[i+1]){
//                    i++;
//                }
//                if(i+1==26) {
//                    i=25;
//                }
//                result.set(result.size()-1, end[i]-result.get(result.size()-1)+1);
//                int count=(i+1<26?start[i+1]:l)-end[i]-1;
//                while(count-->0) {
//                    result.add(1);
//                }
//                i++;
//            }
//        }
//        // No repeating chars in the given string
//        if(result.isEmpty()) {
//            while(l-->0) {
//                result.add(1);
//            }
//        }
//        return result;
//    }
}
