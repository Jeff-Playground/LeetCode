package com.wen.NinthFifty;

public class LQValidWordSquare {
    public boolean validWordSquare(String[] words) {
        if(words==null || words.length==0){
            return false;
        }
        int l=words.length;
        for(int i=0; i<l; i++){
            if(words[i].length()!=l){
                return false;
            }
        }
        for(int i=0; i<l; i++){
            for(int j=i; j<l; j++){
                if(words[i].charAt(j)!=words[j].charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
