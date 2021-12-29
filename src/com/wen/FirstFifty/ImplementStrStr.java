package com.wen.FirstFifty;

import java.util.Arrays;

public class ImplementStrStr {
    // Boyer Moore string search algorithm
    public static int strStr(String haystack, String needle) {
        int hl=haystack.length(), nl=needle.length();
        if(nl==0){
            return 0;
        }
        if(nl>hl){
            return -1;
        }

        int[] badCharDist=new int[26];
        Arrays.fill(badCharDist, nl);
        for(int i=0; i<nl; i++){
            badCharDist[needle.charAt(i)-'a']=nl-1-i;
        }

        int[] goodSuffixDist=new int[nl];
        int lcpLength=0;
        goodSuffixDist[nl-1]=1;
        for(int i=nl-2; i>=0; i--){
            int suffixLength=nl-1-i;
            if(needle.startsWith(needle.substring(i+1))){
                lcpLength=suffixLength;
            }
            goodSuffixDist[i]=nl-lcpLength+suffixLength;
        }

        for(int i=0; i<nl-1; i++){
            int lcsLength=0;
            while(i-lcsLength>=0 && needle.charAt(i-lcsLength)==needle.charAt(nl-1-lcsLength)){
                lcsLength++;
            }
            if(lcsLength>0 && nl-1-lcsLength>0){
                goodSuffixDist[nl-1-lcsLength]=nl-1-i+lcsLength;
            }
        }

        int i=nl-1;
        while(i<hl){
            int j=nl-1;
            while(j>=0 && haystack.charAt(i)==needle.charAt(j)){
                i--;
                j--;
            }
            if(j==-1){
                return i+1;
            } else{
                i+=Math.max(badCharDist[haystack.charAt(i)-'a'], goodSuffixDist[i]);
            }
        }
        return -1;
    }

//    // z algorithm, just for practice, will TLE
//    public int strStr(String haystack, String needle) {
//        int hl=haystack.length(), nl=needle.length();
//        if(nl==0){
//            return 0;
//        }
//        if(nl>hl){
//            return -1;
//        }
//        StringBuilder nh=new StringBuilder(needle);
//        nh.append('#');
//        nh.append(haystack);
//        int nhl=nh.length();
//        int[] z=new int[nhl];
//        int left=0, right=0;
//        for(int i=nl+1; i<nhl; i++){
//            if(i<right){
//                z[i]=Math.min(z[i-left], right-i+1);
//            }
//            while(i+z[i]<nhl && nh.charAt(i+z[i])==nh.charAt(z[i])){
//                z[i]++;
//            }
//            if(z[i]==nl){
//                return i-(nl+1);
//            }
//            if(i+z[i]-1>right){
//                left=i;
//                right=i+z[i]-1;
//            }
//        }
//        return -1;
//    }

//    // Rabin Karp
//    public static int strStr(String haystack, String needle) {
//        int hl=haystack.length(), nl=needle.length();
//        if(nl==0){
//            return 0;
//        }
//        if(nl>hl){
//            return -1;
//        }
//        int mod=1_000_000_007, base=26;
//        // Note here highest, target and cur are long to avoid overflow during *base
//        long highest=1, target=0, cur=0;
//        for(int i=0; i<nl-1; i++){
//            highest=(highest*base)%mod;
//        }
//        for(int i=0; i<nl; i++){
//            target=((target*base)%mod+needle.charAt(i)-'a')%mod;
//            cur=((cur*base)%mod+haystack.charAt(i)-'a')%mod;
//        }
//        if(cur==target && haystack.substring(0, nl).equals(needle)){
//            return 0;
//        }
//        int i=nl;
//        while(i<hl){
//            cur= (int) ((((cur-highest*(haystack.charAt(i-nl)-'a')+mod)%mod*base)%mod+haystack.charAt(i)-'a')%mod);
//            if(cur==target && haystack.substring(i-nl+1, i+1).equals(needle)){
//                return i-nl+1;
//            }
//            i++;
//        }
//        return -1;
//    }

//    // KMP
//    public static int strStr(String haystack, String needle) {
//        if(needle.length()==0){
//            return 0;
//        }
//        if(needle.length()>haystack.length() || haystack.length()==0){
//            return -1;
//        }
//        int[] next=new int[needle.length()];
//        next[0]=-1;
//        int i=-1, j=0;
//        while(j<needle.length()-1){
//            if(i==-1 || needle.charAt(i)==needle.charAt(j)){
//                i++;
//                j++;
//                if(needle.charAt(i)!=needle.charAt(j)){
//                    next[j]=i;
//                } else{
//                    next[j]=next[i];
//                }
//            } else{
//                i=next[i];
//            }
//        }
//        i=0; j=0;
//        while(i<haystack.length() && j<needle.length()){
//            if(j==-1 || haystack.charAt(i)==needle.charAt(j)){
//                i++;
//                j++;
//                if(j==needle.length()){
//                    return i-needle.length();
//                }
//            } else{
//                j=next[j];
//            }
//        }
//        return -1;
//    }

//    // Brute force
//    public int strStr(String haystack, String needle) {
//        if(needle.length()==0){
//            return 0;
//        }
//        if(needle.length()>haystack.length() || haystack.length()==0){
//            return -1;
//        }
//        for(int i=0; i<=(haystack.length()-needle.length()); i++){
//            if(haystack.charAt(i)==needle.charAt(0)){
//                int j=0;
//                for(j=0; j<needle.length(); j++){
//                    if(haystack.charAt(i+j)!=needle.charAt(j)){
//                        break;
//                    }
//                }
//                if(j==needle.length()){
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
}
