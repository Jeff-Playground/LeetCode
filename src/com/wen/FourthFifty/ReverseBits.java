package com.wen.FourthFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseBits {
    public static int reverseBits(int n) {
        int result=0;
        for(int i=0; i<32; i++){
            int cur=n&1;
            result<<=1;
            result+=cur;
            n>>=1;
        }
        return result;
    }

//    public static int reverseBits(int n) {
//        String binary=Integer.toBinaryString(n);
//        String reversedBinary=String.format("%-32s", new StringBuilder(binary).reverse().toString()).replace(' ', '0');
//        if(reversedBinary.startsWith("1")){
//            reversedBinary=reversedBinary.substring(1);
//            return -1*(~Integer.parseInt(reversedBinary, 2)+1);
//        } else{
//            return Integer.parseInt(reversedBinary, 2);
//        }
//    }
}
