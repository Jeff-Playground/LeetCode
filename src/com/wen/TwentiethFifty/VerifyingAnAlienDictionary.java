package com.wen.TwentiethFifty;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] dict=new int[26];
        for(int i=0; i<order.length(); i++){
            char c=order.charAt(i);
            dict[c-'a']=i;
        }
        for(int i=1; i<words.length; i++){
            String prev=words[i-1], cur=words[i];
            boolean valid=false;
            for(int j=0; j<prev.length() && j<cur.length(); j++){
                char c1=prev.charAt(j), c2=cur.charAt(j);
                if(c1!=c2){
                    if(dict[c1-'a']>dict[c2-'a']){
                        return false;
                    }
                    valid=true;
                    break;
                }
            }
            if(!valid && prev.length()>cur.length()){
                return false;
            }
        }
        return true;
    }
}
