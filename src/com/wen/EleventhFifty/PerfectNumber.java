package com.wen.EleventhFifty;

public class PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if(num<=1){
            return false;
        }
        int sum=1;
        for(int check=2; check*check<num; check++){
            if(num%check==0){
                sum+=check+num/check;
            }
        }
        return sum==num;
    }
}
