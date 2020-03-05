package com.wen.EleventhFifty;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestUncommonSubsequenceII {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b)->b.length()-a.length()==0?a.compareTo(b):b.length()-a.length());
        int l=strs.length;
        int i=0;
        Set<String> visited=new HashSet<>();
        while(i<l){
            String cur=strs[i];
            if(i==l-1 || !cur.equals(strs[i+1])){
                boolean contains=false;
                for(String v: visited){
                    int j=0;
                    for(char c: v.toCharArray()){
                        if(c==cur.charAt(j)){
                            j++;
                            if(j==cur.length()){
                                break;
                            }
                        }
                    }
                    if(j==cur.length()){
                        contains=true;
                        break;
                    }
                }
                if(!contains){
                    return cur.length();
                }
                i++;
            } else{
                while(i<l-1 && strs[i+1].equals(cur)){
                    i++;
                }
                visited.add(cur);
            }
        }
        return -1;
    }
}
