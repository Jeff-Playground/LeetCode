package com.wen.FifthFifty;

public class BitwiseANDOfNumbersRange {
    // When n>m, the bitwise AND of the lowest bit will always be 0, so the problem becomes to find a point when n>>k==m>>k, and the result should be n>>k<<k
    public int rangeBitwiseAnd(int m, int n) {
        while(m<n) {
            n&=n-1;
        }
        return n;
    }

//    public int rangeBitwiseAnd(int m, int n) {
//        return m<n?rangeBitwiseAnd(m>>1, n>>1)<<1:m;
//    }

//    public int rangeBitwiseAnd(int m, int n) {
//        int bit=0;
//        while(m!=n) {
//            m>>=1;
//            n>>=1;
//            bit++;
//        }
//        return m<<bit;
//    }

//    public int rangeBitwiseAnd(int m, int n) {
//        int mask=Integer.MAX_VALUE;
//        while((m&mask)!=(n&mask)) {
//            mask<<=1;
//        }
//        return m&mask;
//    }

//    // Normal way
//    public int rangeBitwiseAnd(int m, int n) {
//        if(m==0) {
//            return 0;
//        }
//        if(m==n) {
//            return m;
//        }
//        int result=0, bit=0;
//        while((m>>bit)!=0) {
//            int value=1;
//            int mask=1<<bit;
//            for(int i=m; i<=n; i++) {
//                int i0=i&mask;
//                if(i0==0) {
//                    value=0;
//                    break;
//                }
//                // This is to prevent overflow when n==Integer.MAX_VALUE
//                if(i==Integer.MAX_VALUE) {
//                    break;
//                }
//            }
//            result+=value<<bit;
//            bit++;
//        }
//        return result;
//    }
}
