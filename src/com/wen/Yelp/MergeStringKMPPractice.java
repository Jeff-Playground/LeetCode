package com.wen.Yelp;

public class MergeStringKMPPractice {

    public static void main(String[] args){
        String s1="abcd", s2="bcdf";
        String merged=mergeString(s1, s2);
        System.out.println("Merged: "+merged);

        s1="abcd";
        s2="dabc";
        String merged1=mergeString(s1, s2);
        System.out.println("Merged: "+merged1);
    }

    private static String mergeString(String s1, String s2) {
        int l1=s1.length(), l2=s2.length();
        int[] next1=buildNextArray(s1), next2=buildNextArray(s2);
        int max1=getMaxCommonSuffixPreffix(s1, s2, next2);
        int max2=getMaxCommonSuffixPreffix(s2, s1, next1);
        if(max1<max2){
            return s2.substring(0, l2-max2)+s1;
        } else{
            return s1.substring(0, l1-max1)+s2;
        }
    }

    private static int getMaxCommonSuffixPreffix(String s1, String s2, int[] next2){
        int result=0, l1=s1.length(), l2=s2.length();
        int i=l1-l2<0?0:l1-l2, j=0;
        while(i<l1){
            if(j==-1 || s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
                if(i==l2){
                    result=j;
                }
            } else{
                j=next2[j];
            }
        }
        return result;
    }

    private static int[] buildNextArray(String s){
        int l=s.length();
        int[] next=new int[l];
        next[0]=-1;
        int i=-1, j=0;
        while(j<l-1){
            if(i==-1 || s.charAt(i)==s.charAt(j)){
                i++;
                j++;
                if(s.charAt(i)!=s.charAt(j)){
                    next[j]=i;
                } else{
                    next[j]=next[i];
                }
            } else{
                i=next[i];
            }
        }
        return next;
    }
}
