package com.wen.SixthFifty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LQPalindromePermutationII {
    // DFS
    public List<String> generatePalindromes(String s) {
        List<String> result=new ArrayList<>();
        if(s==null || s.length()==0){
            return result;
        }
        int[] occur=new int[256];
        int l=s.length();
        Set<Character> set=new HashSet<>();
        for(int i=0; i<l; i++){
            char c=s.charAt(i);
            occur[c]++;
            if(occur[c]%2==0){
                set.remove(c);
            } else{
                set.add(c);
            }
        }
        if(set.size()==0){
            generatePalindromesDFS(l, "", occur, result);
        } else if(set.size()==1){
            char mid=(char)set.toArray()[0];
            occur[mid]--;
            generatePalindromesDFS(l, mid+"", occur, result);
        }
        return result;
    }

    public void generatePalindromesDFS(int l, String cur, int[] occur, List<String> result){
        if(cur.length()==l || cur.length()==l-1){
            result.add(cur);
        } else{
            for(int i=0; i<256; i++){
                if(occur[i]>0){
                    occur[i]-=2;
                    generatePalindromesDFS(l, ((char)i)+cur+((char)i), occur, result);
                    occur[i]+=2;
                }
            }
        }
    }
}
