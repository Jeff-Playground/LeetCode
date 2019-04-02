package com.wen.FourthFifty;

import java.util.*;

public class RepeatedDNASequences {
//    // For saving space, can use int and bit manipulation to represent each char(can use ASCII
//    // because given chars have differnt last 3 bits, or can use 00 01 10 11 because only 4 given chars)
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
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result=new HashSet<>();
        if(s==null || s.length()<11) {
            return new ArrayList<>();
        }
        Set<Long> hashValues=new HashSet<>();
        Set<String> patterns=new HashSet<>();
        long hash=0, Q=100007, D=256;
        // Moron way would lead to overflow
        long highestPower=mod2(D,9,Q);
        for(int i=0; i<10; i++) {
            hash=(hash*D+s.charAt(i))%Q;
        }
        hashValues.add(hash);
        patterns.add(s.substring(0, 10));
        for(int i=1; i<=s.length()-10; i++) {
            // Plus Q to ensure hash is always positive
            hash=(((hash-s.charAt(i-1)*highestPower)*D+s.charAt(i+9))%Q+Q)%Q;
            String temp=s.substring(i, i+10);
            if(hashValues.contains(hash)) {
                if(patterns.contains(temp)) {
                    result.add(temp);
                } else {
                    patterns.add(temp);
                }
            } else {
                hashValues.add(hash);
                patterns.add(temp);
            }
        }
        return new ArrayList<>(result);
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
