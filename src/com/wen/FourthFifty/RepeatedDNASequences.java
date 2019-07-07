package com.wen.FourthFifty;

import java.util.*;

public class RepeatedDNASequences {
//    // For saving space, can use int and bit manipulation to represent each char(can use ASCII
//    // because given chars have different last 3 bits, or can use 00 01 10 11 because only 4 given chars)
//    public List<String> findRepeatedDnaSequences(String s) {
//        List<String> result=new ArrayList<>();
//        if(s==null || s.length()<11) {
//            return result;
//        }
//        Map<String, Integer> occurence=new HashMap<>();
//        Set<String> set=new HashSet<>();
//        for(int i=0; i<=s.length()-10; i++) {
//            String sequence=s.substring(i, i+10);
//            occurence.put(sequence, occurence.getOrDefault(sequence, 0)+1);
//            if(occurence.get(sequence)>1) {
//                set.add(sequence);
//            }
//        }
//        result.addAll(set);
//        return result;
//    }

    // Rolling hash
    public static List<String> findRepeatedDnaSequences(String s) {
        if(s==null || s.length()<=10){
            return new ArrayList<>();
        }
        Set<String> result=new HashSet<>();
        long base=256, mod=100007, highestPower=mod1(base, 9, mod);
        long hash=0;
        for(int i=0; i<10; i++){
            hash=(hash*base+s.charAt(i))%mod;
        }
        Map<Long, Set<String>> foundPatterns=new HashMap<>();
        Set<String> patterns=new HashSet<>();
        patterns.add(s.substring(0, 10));
        foundPatterns.put(hash, patterns);
        for(int i=1; i<=s.length()-10; i++){
            hash=(((hash-highestPower*s.charAt(i-1))*base+s.charAt(i+9))%mod+mod)%mod;
            String pattern=s.substring(i, i+10);
            if(foundPatterns.containsKey(hash)){
                if(foundPatterns.get(hash).contains(pattern)){
                    result.add(pattern);
                } else{
                    foundPatterns.get(hash).add(pattern);
                }
            } else{
                Set<String> newPatterns=new HashSet<>();
                newPatterns.add(pattern);
                foundPatterns.put(hash, newPatterns);
            }
        }
        return new ArrayList<String>(result);
    }

    public static long mod1(long D, long n, long Q) {
        long result=1;
        for(int i=1; i<=n; i++) {
            result=(result*D)%Q;
        }
        return result;
    }

    public static long mod2(long D, long n, long Q) {
        long result=1;
        long base=D;
        while(n>0) {
            if((n&1)==1) {
                result=(result*base)%Q;
            }
            base=(base*base)%Q;
            n>>=1;
        }
        return result;
    }
}
