package com.wen.SeventhFifty;

public class CountingBits {
    public int[] countBits(int num) {
        int[] result=new int[num+1];
        for(int i=1; i<num+1; i++){
            result[i]=result[i&(i-1)]+1;
        }
        return result;
    }

//    public int[] countBits(int num) {
//        int[] result=new int[num+1];
//        for(int i=1; i<num+1; i++){
//            result[i]=result[i/2]+i%2;
//        }
//        return result;
//    }

//    public int[] countBits(int num) {
//        int[] result=new int[num+1];
//        if(num>0){
//            int pow=0;
//            while(Math.pow(2, pow)<num){
//                pow++;
//            }
//            for(int i=0; i<=pow; i++){
//                for(int j=(int)Math.pow(2, i); j<(int)Math.pow(2, i+1) && j<num+1; j++){
//                    result[j]=result[j-(int)Math.pow(2, i)]+1;
//                }
//            }
//        }
//        return result;
//    }
}
