package com.wen.NinthFifty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LQMinimumUniqueWordAbbreviation {
    public String minAbbreviation(String target, String[] dictionary) {
        Set<List<Integer>> patterns=new HashSet<>();
        for(String word: dictionary){
            getPattern(patterns, word, target);
        }
        String result=target;
        for(int i=0; i<target.length(); i++){
            StringBuilder sb=new StringBuilder();
            maHelper(target, patterns, i, 0, new ArrayList<>(), sb);
            if(sb.length()!=0){
                result=sb.toString();
                break;
            }
        }
        return result;
    }

    private void maHelper(String target, Set<List<Integer>> patterns, int length, int cur, List<Integer> key, StringBuilder sb){
        if(key.size()==length){
            if(!patterns.contains(key)){
                String result=generateString(target, key);
                if(sb.length()==0 || sb.length()>result.length()){
                    sb.setLength(0);
                    sb.append(result);
                }
            }
        } else{
            for(int i=cur; i<target.length(); i++){
                key.add(i);
                maHelper(target, patterns, length, i+1, key, sb);
                key.remove(key.size()-1);
            }
        }
    }

    private String generateString(String target, List<Integer> indices){
        StringBuilder sb=new StringBuilder();
        int last=-1;
        for(int idx: indices){
            int l=idx-last-1;
            if(l>0){
                sb.append(String.valueOf(l));
            }
            sb.append(target.charAt(idx));
            last=idx;
        }
        if(last<target.length()-1){
            int l=target.length()-1-last;
            sb.append(String.valueOf(l));
        }
        return sb.toString();
    }

    private void getPattern(Set<List<Integer>> patterns, String word, String target){
        int l=target.length();
        if(l==word.length()){
            List<List<Integer>> cur=new ArrayList<>();
            cur.add(new ArrayList<>());
            for(int i=0; i<l; i++){
                if(word.charAt(i)==target.charAt(i)){
                    int size=cur.size();
                    for(int j=0; j<size; j++){
                        List<Integer> copy=new ArrayList<>(cur.get(j));
                        copy.add(i);
                        cur.add(copy);
                    }
                }
            }
            patterns.addAll(cur);
        }
    }
}
