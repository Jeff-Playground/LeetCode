package com.wen.FifthFifty;

import java.util.Arrays;

public class CountPrimes {
//    public int countPrimes(int n) {
//        int result=0;
//        int[] primes=new int[n];
//        Arrays.fill(primes, 1);
//        for(int i=2; i<n; i++) {
//            if(primes[i]==1) {
//                result++;
//                for(int j=2; i*j<n; j++) {
//                    primes[i*j]=0;
//                }
//            }
//        }
//        return result;
//    }

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        // Loop's ending condition is i * i <= num instead of i <= sqrt(num)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
