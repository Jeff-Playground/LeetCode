package com.wen.SecondFifty;

public class LengthOfLastWord {
    // Index of character in string
    public int lengthOfLastWord(String s) {
        return s.trim().length()-s.trim().lastIndexOf(' ')-1;
    }

//    // Regular expression split
//    public int lengthOfLastWord(String s) {
//        if(s==null || s.trim().length()==0) {
//            return 0;
//        }
//        String[] words=s.split("\\s+");
//        return words[words.length-1].length();
//    }
}
