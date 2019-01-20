package com.wen.FirstFifty;

public class CountAndSay {
    public static String countAndSay(int n) {
        String result="1";
        while(n>1){
            String temp="";
            for(int i=0; i<result.length(); i++){
                char c=result.charAt(i);
                int count=1;
                while(i+1<result.length() && result.charAt(i+1)==c){
                    count++;
                    i++;
                }
                temp+=String.valueOf(count)+c;
            }
            result=temp;
            n--;
        }
        return result;
    }
}
