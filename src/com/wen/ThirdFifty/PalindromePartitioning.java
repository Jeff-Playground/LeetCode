package com.wen.ThirdFifty;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        if(s==null || s.length()==0){
            return result;
        }
        List<String> out=new ArrayList<>();
        partitionDFS(s, 0,out, result);
        return result;
    }

    private static void partitionDFS(String s, int start, List<String> out, List<List<String>> result) {
        if(start==s.length()){
            result.add(new ArrayList<>(out));
            return;
        }
        for(int i=start+1; i<s.length()+1; i++){
            if(isPalindrome(s, start, i)){
                out.add(s.substring(start, i));
                partitionDFS(s, i, out, result);
                out.remove(out.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while(start<end-1){
            if(s.charAt(start)!=s.charAt(end-1)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
