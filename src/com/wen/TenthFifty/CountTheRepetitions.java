package com.wen.TenthFifty;

public class CountTheRepetitions {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int l1=s1.length(), l2=s2.length();
        int[] repeatCount=new int[n1+1], nextMatch=new int[n1+1];
        int j=0;
        for(int k=1; k<=n1; k++){
            for(int i=0; i<l1; i++){
                if(s1.charAt(i)==s2.charAt(j)){
                    j++;
                    if(j==l2){
                        j=0;
                        repeatCount[k]++;
                    }
                }
            }
            if(k+1<=n1){
                nextMatch[k+1]=j;
                repeatCount[k+1]=repeatCount[k];
            }
            for(int start=1; start<k; start++){
                if(nextMatch[start]==j){
                    int repeatLength=k-start+1;
                    int count=(n1-start+1)/repeatLength;
                    int remain=repeatCount[start-1+(n1-start+1)%repeatLength];
                    return (remain+count*(repeatCount[k]-repeatCount[start-1]))/n2;
                }
            }
        }
        return repeatCount[n1]/n2;
    }
}
