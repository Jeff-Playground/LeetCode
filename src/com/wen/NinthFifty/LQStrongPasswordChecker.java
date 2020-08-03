package com.wen.NinthFifty;

import java.util.HashMap;
import java.util.Map;

public class LQStrongPasswordChecker {
    public static int strongPasswordChecker(String s) {
        int upper=1, lower=1, digit=1;
        Map<Integer, Integer> repeatIdx=new HashMap<>();
        int lastIdx=-1, lastCount=0;
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i);
            if(c>='A' && c<='Z'){
                upper=0;
            } else if(c>='a' && c<='z'){
                lower=0;
            } else if(c>='0' && c<='9'){
                digit=0;
            }
            if(lastCount==0){
                lastIdx=0;
                lastCount=1;
            } else{
                if(s.charAt(lastIdx)==c){
                    if(++lastCount>2){
                        repeatIdx.put(lastIdx, i-lastIdx+1);
                    }
                } else{
                    lastIdx=i;
                    lastCount=1;
                }
            }
        }
        int result=0;
        int missing=upper+lower+digit;
        if(s.length()<6){
            int add=6-s.length();
            result+=add+Math.max(0, missing-add);
        } else{
            int remove=Math.max(0, s.length()-20), needUpdate=0;
            result+=remove;
            for(int k=1; k<3; k++){
                for(int idx: repeatIdx.keySet()){
                    if(remove<=0){
                        break;
                    }
                    int repeatLength=repeatIdx.get(idx);
                    if(repeatLength%3==k-1){
                        repeatIdx.put(idx, repeatLength-=k);
                        remove-=k;
                    }
                }
            }
            for(int idx: repeatIdx.keySet()){
                int repeatLength=repeatIdx.get(idx);
                if(repeatLength>=3 && remove>0){
                    int needRemove=repeatLength-2;
                    repeatLength-=remove;
                    remove-=needRemove;
                }
                if(repeatLength>=3){
                    needUpdate+=repeatLength/3;
                }
            }
            result+=Math.max(missing, needUpdate);
        }
        return result;
    }
}
