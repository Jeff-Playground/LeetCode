package com.wen.SixthFifty;

import java.util.HashMap;
import java.util.Map;

public class LQWordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> pToS=new HashMap<>();
        Map<String, Character> sToP=new HashMap<>();
        return wordPatternMatch(pattern, str, pToS, sToP);
    }

    public boolean wordPatternMatch(String pattern, String str, Map<Character, String> pToS, Map<String, Character> sToP){
        if(pattern.isEmpty() && str.isEmpty()){
            return true;
        } else if(pattern.isEmpty() || str.isEmpty()){
            return false;
        } else{
            char[] pArray=pattern.toCharArray();
            int lp=pArray.length;
            char pc=pArray[0];
            if(pToS.containsKey(pc)){
                String vs=pToS.get(pc);
                if(!str.startsWith(vs)){
                    return false;
                } else{
                    int idx=pToS.get(pc).length();
                    if(sToP.containsKey(vs) && sToP.get(vs)==pc && wordPatternMatch(pattern.substring(1), str.substring(idx), pToS, sToP)){
                        return true;
                    }
                }
            } else{
                int ls=str.length();
                for(int j=1; j<=ls-lp+1; j++){
                    if(!sToP.containsKey(str.substring(0,j))) {
                        pToS.put(pc, str.substring(0,j));
                        sToP.put(str.substring(0,j), pc);
                        if(wordPatternMatch(pattern.substring(1), str.substring(j), pToS, sToP)){
                            return true;
                        }
                        pToS.remove(pc);
                        sToP.remove(str.substring(0,j));
                    }
                }
            }
        }
        return false;
    }
}
