package com.wen.TenthFifty;

public class RepeatedSubstringPattern {
//    public static boolean repeatedSubstringPattern(String s) {
//        int l=s.length();
//        for(int i=1; i<=l/2; i++){
//            if(l%i==0){
//                String sub=s.substring(0, i);
//                int j=i;
//                while(j<l){
//                    if(!sub.equals(s.substring(j,j+i))){
//                        break;
//                    }
//                    j+=i;
//                }
//                if(j==l){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    // KMP
    // next[i] stands for the index of the repeated chars
    public static boolean repeatedSubstringPattern(String s) {
        int l=s.length();
        // Note here the length is l+1 because next[l] stands for the lastIndex+1=length of the repeating string
        int[] next=new int[l+1];
        int i=-1, j=0;
        next[0]=-1;
        while(j<l){
            if(i==-1 || s.charAt(i)==s.charAt(j)){
                i++;
                j++;
                next[j]=i;
            } else{
                i=next[i];
            }
        }
        return next[l]>0 && (next[l])%(l-(next[l]))==0;
    }
}
