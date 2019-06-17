package com.wen.TwentyFirstFifty;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    public static List<String> commonChars(String[] A) {
        List<String> list=new ArrayList<>();
        if(A==null || A.length<1){
            return list;
        }
        int n=A.length;
        int[] result=new int[26];
        for(int i=A[0].length()-1; i>=0; i--){
            result[A[0].charAt(i)-'a']++;
        }
        for(int j=1; j<n; j++){
            int[] occur=new int[26];
            for(int i=A[j].length()-1; i>=0; i--){
                if(result[A[j].charAt(i)-'a']>0){
                    occur[A[j].charAt(i)-'a']++;
                }
            }
            for(int i=0; i<26; i++){
                result[i]=Math.min(result[i], occur[i]);
            }
        }
        for(int i=0; i<26; i++){
            int count=result[i];
            while(count>0){
                list.add((char)('a'+i)+"");
                count--;
            }
        }
        return list;
    }
}
