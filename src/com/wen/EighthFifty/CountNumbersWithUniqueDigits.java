package com.wen.EighthFifty;

public class CountNumbersWithUniqueDigits {
    // DFS
    public int countNumbersWithUniqueDigits(int n) {
        int result=1, max=(int)Math.pow(10, n), used=0;
        for(int i=1; i<10; i++){
            used|=(1<<i);
            result+=search(i, max, used);
            used&=~(1<<i);
        }
        return result;
    }

    private int search(int pre, int max, int used) {
        int result=0;
        if(pre<max) {
            result++;
            for (int i = 0; i < 10; i++) {
                if ((used & (1 << i)) == 0) {
                    used |= (1 << i);
                    int cur = 10 * pre + i;
                    result += search(cur, max, used);
                    used &= ~(1 << i);
                }
            }
        }
        return result;
    }

//    // DP
//    public int countNumbersWithUniqueDigits(int n) {
//        if(n==0){
//            return 1;
//        } else if(n>10){
//            return 0;
//        }
//        int[] dp=new int[n+1];
//        dp[1]=10;
//        for(int i=2; i<=n; i++){
//            dp[i]=dp[i-1];
//            int res=9, cur=9, temp=i-1;
//            while(temp-->0){
//                res*=cur--;
//            }
//            dp[i]+=res;
//        }
//        return dp[n];
//    }
}
