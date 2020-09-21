package com.wen.EleventhFifty;

public class DetectCapital {
    // If has upper case characters but not all upper case and not the first one, then false
    public boolean detectCapitalUse(String word) {
        int count=0, l=word.length();
        for(int i=0; i<l; i++){
            char c=word.charAt(i);
            if(c>='A' && c<='Z'){
                count++;
                if(i-0+1!=count){
                    return false;
                }
            } else{
                if(count>1){
                    return false;
                }
            }
        }
        return true;
    }
}
