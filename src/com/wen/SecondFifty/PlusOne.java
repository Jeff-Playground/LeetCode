package com.wen.SecondFifty;

public class PlusOne {
    // Producing result based on if it's 9
    public int[] plusOne(int[] digits) {
        int length=digits.length;
        int carry=1, i=length-1;
        while(i>=0) {
            if(digits[i]==9) {
                digits[i]=0;
            } else {
                digits[i]+=1;
                return digits;
            }
            i--;
        }
        if(i==-1) {
            if(digits[0]==0) {
                int[] newDigits=new int[length+1];
                newDigits[0]=carry;
                for(i=1; i<length+1; i++) {
                    newDigits[i]=digits[i-1];
                }
                return newDigits;
            }
        }
        return digits;
    }

//    // Normal adding
//    public int[] plusOne(int[] digits) {
//        int length=digits.length;
//        int carry=1, i=length-1;
//        while(carry==1 && i>=0) {
//            int sum=digits[i]+carry;
//            digits[i]=sum%10;
//            carry=sum/10;
//            i--;
//        }
//        if(carry==1) {
//            int[] newDigits=new int[length+1];
//            newDigits[0]=carry;
//            for(i=1; i<length+1; i++) {
//                newDigits[i]=digits[i-1];
//            }
//            return newDigits;
//        } else {
//            return digits;
//        }
//    }
}
