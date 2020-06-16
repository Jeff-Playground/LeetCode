package com.wen.SeventhFifty;

import java.util.*;

public class LQGeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> result=new ArrayList<>();
        result.add(word.length()==0?"":""+word.length());
        for(int i=0; i<word.length(); i++){
            for(String cur: generateAbbreviations(word.substring(i+1))){
                result.add((i>0?i+"":"")+word.charAt(i)+cur);
            }
        }
        return result;
    }

//    public static List<String> generateAbbreviations(String word) {
//        List<String> result=new ArrayList<>();
//        gaHelper(word, 0, 0, "", result);
//        return result;
//    }
//
//    private static void gaHelper(String word, int idx, int count, String out, List<String> result){
//        if(idx==word.length()){
//            if(count>0){
//                out+=count;
//            }
//            result.add(out);
//        } else{
//            gaHelper(word, idx+1, count+1, out, result);
//            gaHelper(word, idx+1, 0, out+(count>0?count:"")+word.charAt(idx), result);
//        }
//    }

//    public List<String> generateAbbreviations(String word) {
//        List<String> result=new ArrayList<>();
//        result.add(word);
//        gaHelper(word, 0, result);
//        return result;
//    }
//
//    private void gaHelper(String word, int idx, List<String> result){
//        for(int i=idx; i<word.length(); i++){
//            for(int j=1; i+j<=word.length(); j++){
//                StringBuilder sb=new StringBuilder(word.substring(0, i));
//                sb.append(j).append(word.substring(i+j));
//                result.add(sb.toString());
//                gaHelper(sb.toString(), i+1+String.valueOf(j).length(), result);
//            }
//        }
//    }

//    public List<String> generateAbbreviations(String word) {
//        List<String> result=new ArrayList<>();
//        int l=word.length();
//        int max=(int)Math.pow(2, l);
//        StringBuilder sb=new StringBuilder();
//        for(int i=0; i<max; i++){
//            int idx=word.length()-1, pat=i, count=0;
//            sb.setLength(0);
//            while(idx>=0){
//                int cur=pat&1;
//                if(cur==0){
//                    if(count>0){
//                        sb.insert(0,count);
//                        count=0;
//                    }
//                    sb.insert(0,word.charAt(idx));
//
//                } else{
//                    count++;
//                }
//                pat>>=1;
//                idx--;
//            }
//            if(count>0){
//                sb.insert(0,count);
//            }
//            result.add(sb.toString());
//        }
//        return result;
//    }

//    public List<String> generateAbbreviations(String word) {
//        List<String> result=new ArrayList<>();
//        Queue<String> q=new LinkedList<>();
//        q.offer("");
//        for(char c: word.toCharArray()){
//            int size=q.size();
//            for(int i=0; i<size; i++){
//                String cur=q.poll();
//                String n1=cur+c;
//                List<String> curParsed=parseString(cur);
//                String n2=curParsed.get(0)+(Integer.parseInt(curParsed.get(1))+1);
//                q.offer(n1);
//                q.offer(n2);
//            }
//        }
//        while(!q.isEmpty()){
//            result.add(q.poll());
//        }
//        return result;
//    }
//
//    private List<String> parseString(String cur){
//        int idx=cur.length()-1;
//        while(idx>=0 && Character.isDigit(cur.charAt(idx))){
//            idx--;
//        }
//        return Arrays.asList(cur.substring(0, idx+1), idx==cur.length()-1?"0":cur.substring(idx+1));
//    }
}
