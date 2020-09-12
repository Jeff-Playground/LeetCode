package com.wen.TwentyFourthFifty;

import java.util.*;

public class LastSubstringInLexicographicalOrder {
    // Longest common prefix suffix array, just for practice, will TLE
    public static String lastSubstring(String s) {
        int l=s.length();
        int[] suffixArray=new int[l];
        for(int i=0; i<l; i++){
            suffixArray[i]=i;
        }
        makeIncompleteSuffixArray(s, suffixArray, 0, l-1, 0);
        return s.substring(suffixArray[l-1]);
    }

    private static void makeIncompleteSuffixArray(String s, int[] sa, int start, int end, int idx){
        if(start==end){
            return;
        }
        int[] count=new int[26];
        for(int i=start; i<=end; i++){
            if(sa[i]+idx<s.length()){
                count[s.charAt(sa[i]+idx)-'a']++;
            }
        }
        int saIdx=end, lastCount=-1;
        for(int i=25; i>=0; i--){
            if(count[i]>0){
                lastCount=count[i];
                for(int j=end; j>=start; j--){
                    if(sa[j]+idx<s.length() && s.charAt(sa[j]+idx)==(char)('a'+i)){
                        sa[saIdx--]=sa[j];
                        if(--count[i]==0){
                            break;
                        }
                    }
                }
                break;
            }
        }
        makeIncompleteSuffixArray(s, sa, end-lastCount+1, end, idx+1);
    }

//    public String lastSubstring(String s) {
//        char max=s.charAt(0);
//        int l=s.length(), last=0;
//        String result=s;
//        for(int i=1; i<l; i++){
//            char c=s.charAt(i);
//            if(c>max){
//                result=s.substring(i);
//                max=c;
//                last=i;
//            } else if(c==max){
//                if(i!=last+1 && s.substring(i).compareTo(result)>0){
//                    result=s.substring(i);
//                }
//                last=i;
//            }
//        }
//        return result;
//    }

//    public String lastSubstring(String s) {
//        char c=s.charAt(0);
//        List<Integer> idx=new ArrayList<>();
//        idx.add(0);
//        int l=s.length(), last=0;
//        for(int i=1; i<l; i++){
//            char cur=s.charAt(i);
//            if(cur==c){
//                if(i!=last+1){
//                    idx.add(i);
//                }
//                last=i;
//            } else if(cur>c){
//                c=cur;
//                idx=new ArrayList<>();
//                idx.add(i);
//                last=i;
//            }
//        }
//        Queue<List<Integer>> q=new LinkedList<>();
//        for(int i: idx){
//            List<Integer> temp=new ArrayList<>();
//            temp.add(i);
//            q.offer(temp);
//        }
//        while(q.size()>1){
//            int size=q.size();
//            TreeMap<Character, List<List<Integer>>> level=new TreeMap<>();
//            for(int i=0; i<size; i++){
//                List<Integer> curList=q.poll();
//                int cur=curList.get(curList.size()-1);
//                if(cur+1<l){
//                    curList.add(cur+1);
//                    level.putIfAbsent(s.charAt(cur+1), new ArrayList<>());
//                    level.get(s.charAt(cur+1)).add(curList);
//                }
//            }
//            for(List<Integer> max: level.get(level.lastKey())){
//                q.offer(max);
//            }
//        }
//        List<Integer> result=q.poll();
//        return s.substring(result.get(0));
//    }
}
