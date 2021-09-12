package com.wen.ThirteenthFifty;

public class DecodeWaysII {
    // DP, dp[i][0] stands for char at i is decoded by combining with the previous
    // char, dp[i][1] stands for char at i is decoded on itself
    public static int numDecodings(String s) {
        int mod=1_000_000_007;
        int l=s.length();
        long[][] dp=new long[l][2];
        if(s.charAt(0)=='*'){
            dp[0][1]=9;
        } else if(s.charAt(0)=='0'){
            return 0;
        } else{
            dp[0][1]=1;
        }
        for(int i=1; i<l; i++){
            char c=s.charAt(i), pc=s.charAt(i-1);
            if(pc=='0'){
                if(c=='0'){
                    return 0;
                } else{
                    dp[i][0]=0;
                    if(c=='*'){
                        dp[i][1]=9*(dp[i-1][0]+dp[i-1][1])%mod;
                    } else{
                        dp[i][1]=(dp[i-1][0]+dp[i-1][1])%mod;
                    }
                }
            } else if(pc=='1'){
                if(c=='0'){
                    dp[i][0]=dp[i-1][1];
                    dp[i][1]=0;
                } else{
                    if(c=='*'){
                        dp[i][0]=9*dp[i-1][1]%mod;
                        dp[i][1]=(dp[i-1][0]+dp[i-1][1])*9%mod;
                    } else{
                        dp[i][0]=dp[i-1][1];
                        dp[i][1]=(dp[i-1][0]+dp[i-1][1])%mod;
                    }
                }
            } else if(pc=='2'){
                if(c=='0'){
                    dp[i][0]=dp[i-1][1];
                    dp[i][1]=0;
                } else{
                    if(c=='*'){
                        dp[i][0]=6*dp[i-1][1]%mod;
                        dp[i][1]=(dp[i-1][0]+dp[i-1][1])*9%mod;
                    } else{
                        dp[i][0]=c<='6'?dp[i-1][1]:0;
                        dp[i][1]=(dp[i-1][0]+dp[i-1][1])%mod;
                    }
                }
            } else if(pc=='*'){
                // Note all the /9 here may introduce bad data because a number that can
                // be divided by 9 may not be dividable after doing the mod calculation
//                if(c=='0'){
//                    dp[i][0]=dp[i-1][1]/9*2;
//                    dp[i][1]=0;
//                } else{
//                    if(c=='*'){
//                        dp[i][0]=(dp[i-1][1]+dp[i-1][1]/9*6)%mod;
//                        dp[i][1]=(dp[i-1][0]+dp[i-1][1])*9%mod;
//                    } else{
//                        dp[i][0]=c<='6'?dp[i-1][1]/9*2:dp[i-1][1]/9;
//                        dp[i][1]=(dp[i-1][0]+dp[i-1][1])%mod;
//                    }
//                }
                // dp[i-1][1]/9==dp[i-2][0]+dp[i-2][1]
                // oneNinth is 1/9 of *
                // note i-2 might be negative
                long oneNinth=i-2>=0?dp[i-2][0]+dp[i-2][1]:dp[i-1][1]/9;
                if(c=='0'){
                    dp[i][0]=oneNinth*2;
                    dp[i][1]=0;
                } else{
                    if(c=='*'){
                        dp[i][0]=(dp[i-1][1]+oneNinth*6)%mod;
                        dp[i][1]=(dp[i-1][0]+dp[i-1][1])*9%mod;
                    } else{
                        dp[i][0]=(c<='6'?oneNinth*2:oneNinth)%mod;
                        dp[i][1]=(dp[i-1][0]+dp[i-1][1])%mod;
                    }
                }
            } else{
                if(c=='0'){
                    return 0;
                } else{
                    dp[i][0]=0;
                    if(c=='*'){
                        dp[i][1]=(dp[i-1][0]+dp[i-1][1])*9%mod;
                    } else{
                        dp[i][1]=(dp[i-1][0]+dp[i-1][1])%mod;
                    }
                }
            }
        }
        return (int)(dp[l-1][0]+dp[l-1][1])%mod;
    }
}
