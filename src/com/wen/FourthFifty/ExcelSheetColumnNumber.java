package com.wen.FourthFifty;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int result=0, exp=1;
        for(int i=s.length()-1; i>=0; i--){
            result+=(s.charAt(i)-'A'+1)*exp;
            exp*=26;
        }
        return result;
    }

//    public int titleToNumber(String s) {
//        int result=0, exp=26;
//        for(int i=0; i<s.length(); i++){
//            result*=26;
//            result+=s.charAt(i)-'A'+1;
//        }
//        return result;
//    }
}
