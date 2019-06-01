package com.wen.SixteenthFifty;

public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        int result=0;
        int[] nonPrime=new int[21];
        nonPrime[0]=1;
        nonPrime[1]=1;
        for(int i=2; i<=20; i++){
            if(nonPrime[i]==0){
                for(int j=2; j*i<21; j++){
                    nonPrime[j*i]=1;
                }
            }
        }

        for(int k=L; k<=R; k++){
            int count=0, cur=k;
            while(cur>0){
                count+=cur&1;
                cur>>=1;
            }
            if(nonPrime[count]==0){
                result++;
            }
        }
        return result;
    }
}
