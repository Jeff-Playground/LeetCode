package com.wen.FourthFifty;

public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        String result="";
        while(n!=0){
            n--;
            result=(char)('A'+(n%26))+result;
            n=n/26;
        }
        return result;
    }
}
