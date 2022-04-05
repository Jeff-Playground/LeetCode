package com.wen.SixteenthFifty;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CustomSortString {
    // Count sort
    public String customSortString(String S, String T) {
        int[] tCount=new int[26];
        for(char c: T.toCharArray()){
            tCount[c-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(char c: S.toCharArray()){
            while(tCount[c-'a']-->0){
                sb.append(c);
            }
        }
        for(int i=0; i<26; i++){
            while(tCount[i]-->0){
                sb.append((char)('a'+i));
            }
        }
        return sb.toString();
    }

//    // Heap
//    public String customSortString(String order, String s) {
//        Map<Character, Integer> sortedIdx=new HashMap<>();
//        for(int i=0; i<order.length(); i++){
//            sortedIdx.put(order.charAt(i), i);
//        }
//        PriorityQueue<Character> pq=new PriorityQueue<>((a, b)->sortedIdx.get(a)-sortedIdx.get(b));
//        StringBuilder sb=new StringBuilder();
//        for(char c: s.toCharArray()){
//            if(sortedIdx.containsKey(c)){
//                pq.offer(c);
//            } else{
//                sb.append(c);
//            }
//        }
//        while(!pq.isEmpty()){
//            sb.append(pq.poll());
//        }
//        return sb.toString();
//    }
}
