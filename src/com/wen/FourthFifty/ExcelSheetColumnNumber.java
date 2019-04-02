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
}
