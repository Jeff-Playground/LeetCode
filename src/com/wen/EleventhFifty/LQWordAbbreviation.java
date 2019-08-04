package com.wen.EleventhFifty;

import java.util.*;

public class LQWordAbbreviation {
    public static String[] wordsAbbreviation(String[] dict) {
        if(dict==null || dict.length==0){
            return new String[]{};
        }
        int l=dict.length;
        String[] result=new String[l];
        for(int i=0; i<l; i++){
            result[i]=getAbbr(dict[i], 0);
        }
        int[] offset=new int[l];
        for(int i=0; i<l-1; i++){
            while(true){
                Set<Integer> dups=new HashSet<>();
                for(int j=i+1; j<l; j++){
                    if(result[i].equals(result[j])){
                        dups.add(j);
                    }
                }
                if(dups.size()==0){
                    break;
                } else{
                    dups.add(i);
                    for(int index: dups){
                        result[index]=getAbbr(dict[index], ++offset[index]);
                    }
                }
            }
        }
        return result;
    }

    public static String getAbbr(String word, int offset) {
        if(word.length()<4 || offset>word.length()-4){
            return word;
        } else{
            return word.substring(0, offset+1)+(word.length()-offset-2+"")+word.charAt(word.length()-1);
        }
    }
}
