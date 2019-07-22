package com.wen.SixthFifty;

public class IntegerToEnglishWords {
    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        String[] thousands=new String[]{"Thousand", "Million", "Billion"};
        String result=thousandToWords(num%1000);
        for(int i=0; i<3; i++){
            num/=1000;
            if(num%1000!=0){
                result=thousandToWords(num%1000)+" "+thousands[i]+" "+result;
            }
        }
        return result.trim();
    }

    public String thousandToWords(int num){
        String result="";
        String[] digits=new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens=new String[]{"", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        if(num>99){
            result+=digits[num/100]+" Hundred";
            num=num%100;
        }
        if(num<20){
            result+=" "+digits[num];
        } else{
            result+=" "+tens[num/10-1]+" "+digits[num%10];
        }
        return result.trim();
    }
}
