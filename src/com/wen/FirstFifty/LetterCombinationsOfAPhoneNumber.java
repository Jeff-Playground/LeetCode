package com.wen.FirstFifty;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    // DFS
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if(digits.length()==0){
            return result;
        }
        Map<Character, String> dict=new HashMap<>();
        dict.put('2', "abc");
        dict.put('3', "def");
        dict.put('4', "ghi");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");
        dfs(digits, 0, dict, "", result);
        return result;
    }

    private void dfs(String digits, int idx, Map<Character, String> dict, String cur, List<String> result){
        if(idx==digits.length()){
            result.add(cur);
        } else{
            String v=dict.get(digits.charAt(idx));
            for(char c: v.toCharArray()){
                dfs(digits, idx+1, dict, cur+c, result);
            }
        }
    }

//    // BFS
//    public List<String> letterCombinations(String digits) {
//        List<String> result=new ArrayList<>();
//        if(digits.length()==0){
//            return result;
//        }
//        Map<Character, String> dict=new HashMap<>();
//        dict.put('2', "abc");
//        dict.put('3', "def");
//        dict.put('4', "ghi");
//        dict.put('5', "jkl");
//        dict.put('6', "mno");
//        dict.put('7', "pqrs");
//        dict.put('8', "tuv");
//        dict.put('9', "wxyz");
//        Queue<String> q=new LinkedList<>();
//        q.offer("");
//        for(char c: digits.toCharArray()){
//            String v=dict.get(c);
//            int size=q.size();
//            while(size-->0){
//                String cur=q.poll();
//                for(char x: v.toCharArray()){
//                    q.offer(cur+x);
//                }
//            }
//        }
//        while(!q.isEmpty()){
//            result.add(q.poll());
//        }
//        return result;
//    }
}
