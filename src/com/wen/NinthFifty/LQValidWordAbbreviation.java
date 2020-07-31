package com.wen.NinthFifty;

public class LQValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i=0, j=0, wl=word.length(), al=abbr.length();
        while(i<wl && j<al){
            if(isNumber(abbr.charAt(j))){
                int start=j, end=j+1;
                while(end<al && isNumber(abbr.charAt(end))){
                    end++;
                }
                if(start!=end-1 && abbr.charAt(start)=='0'){
                    return false;
                }
                int count=Integer.parseInt(abbr.substring(start, end));
                i+=count;
                j=end;
            } else{
                if(word.charAt(i++)!=abbr.charAt(j++)){
                    return false;
                }
            }
        }
        return i==wl && j==al;
    }

    private boolean isNumber(char c){
        return c>='0' && c<='9';
    }
}
