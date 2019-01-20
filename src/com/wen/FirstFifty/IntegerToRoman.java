package com.wen.FirstFifty;

public class IntegerToRoman {
    public static String intToRoman(int num) {
        char[] roman = new char[]{'M','D','C','L','X','V','I'};
        int[] value = new int[]{1000,500,100,50,10,5,1};
        String result = "";
        for(int i=0; i<7; i+=2){
            int n=num/value[i];
            num = num%value[i];
            if(n<4){
                for(int j=0; j<n; j++){
                    result+=roman[i];
                }
            }else if(n==4){
                result=result+roman[i]+roman[i-1];
            }else if(n>4&&n<9){
                result+=roman[i-1];
                for(int j=0; j<n-5; j++){
                    result+=roman[i];
                }
            }else{
                result=result+roman[i]+roman[i-2];
            }
        }
        return result;
    }
}
