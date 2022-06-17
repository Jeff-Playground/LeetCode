package com.wen.FourteenthFifty;

public class RepeatedStringMatch {
    // KMP
    public int repeatedStringMatch(String a, String b) {
        if(b.isEmpty()){
            return 0;
        } else if(a.isEmpty()){
            return -1;
        } else{
            int al=a.length(), bl=b.length();
            int[] next=new int[bl];
            int i=-1, j=0;
            next[j]=i;
            while(j<bl-1){
                if(i==-1 || b.charAt(i)==b.charAt(j)){
                    i++;
                    j++;
                    if(b.charAt(i)==b.charAt(j)){
                        next[j]=next[i];
                    } else{
                        next[j]=i;
                    }
                } else{
                    i=next[i];
                }
            }
            int result=1;
            i=j=0;
            int tl=al;
            while(j<bl){
                if(j==-1 || a.charAt(i%al)==b.charAt(j)){
                    if(i>al*result-1){
                        result++;
                    }
                    i++;
                    j++;
                    if(i-j>=al){
                        return -1;
                    } else if(j==bl){
                        return result;
                    }
                } else{
                    j=next[j];
                }
            }
            return -1;
        }
    }
}
