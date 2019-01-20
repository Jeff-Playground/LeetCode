package com.wen.FirstFifty;

import java.util.*;

public class GroupAnagrams {
    // Hashmap to store characters' occurrence as key
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map=new HashMap<String, List<String>>();
        for(String s: strs) {
            char[] c=s.toCharArray();
            Arrays.sort(c);
            String sorted=new String(c);
            if(map.containsKey(sorted)) {
                map.get(sorted).add(s);
            } else {
                List<String> temp=new ArrayList<String>();
                temp.add(s);
                map.put(sorted, temp);
            }
        }
        result.addAll(map.values());
        return result;
    }

//    // Hashmap to store characters sequence as keys
//    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> result = new ArrayList<List<String>>();
//        Map<String, List<String>> map=new HashMap<String, List<String>>();
//        for(String s: strs) {
//            int[] count=new int[26];
//            for(char c: s.toCharArray()) {
//                count[c-'a']++;
//            }
//            String countStr="";
//            for(int c: count) {
//                countStr+=c+"/";
//            }
//            if(map.containsKey(countStr)) {
//                map.get(countStr).add(s);
//            } else {
//                List<String> temp=new ArrayList<String>();
//                temp.add(s);
//                map.put(countStr, temp);
//            }
//        }
//        result.addAll(map.values());
//        return result;
//    }
}
