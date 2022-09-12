package com.wen.FifteenthFifty;

import java.util.ArrayList;
import java.util.List;

public class CountDifferentPalindromicSubsequences {
    public int countPalindromicSubsequences(String s) {
        int l=s.length();
        // memo[i][j] stands for the count of different palindromic subsequences in substring(i,j+1)
        int[][] memo=new int[l][l];
        List<List<Integer>> pos=new ArrayList<>();
        for(int i=0; i<26; i++){
            pos.add(null);
        }
        for(int i=0; i<l; i++){
            int p=s.charAt(i)-'a';
            if(pos.get(p)==null){
                pos.set(p, new ArrayList<>());
            }
            pos.get(p).add(i);
        }
        return cpsHelper(s, 0, l-1, pos, memo);
    }

    private int cpsHelper(String s, int start, int end, List<List<Integer>> pos, int[][] memo){
        if(start>end){
            return 0;
        }
        if(memo[start][end]==0){
            int mod=1_000_000_007;
            long result=0;
            for(int i=0; i<26; i++){
                if(pos.get(i)!=null){
                    int newStart=find(pos.get(i), start, true), newEnd=find(pos.get(i), end, false);
                    if(newStart==-1 || newStart>end){
                        continue;
                    }
                    // ++ for pattern c
                    result++;
                    // ++ for pattern c...c
                    if(newStart!=newEnd){
                        result++;
                    }
                    // Note in here, everything is wrapped in c...c
                    result+=cpsHelper(s, newStart+1, newEnd-1, pos, memo);
                }
            }
            memo[start][end]=(int)(result%mod);
        }
        return memo[start][end];
    }

    private int find(List<Integer> pos, int value, boolean isStart){
        int left=0, right=pos.size()-1;
        if((isStart && pos.get(right)<value) || (!isStart && pos.get(left)>value)){
            return -1;
        }
        while(left<right){
            int mid=left+(right-left)/2;
            if(isStart){
                if(pos.get(mid)<value){
                    left=mid+1;
                } else{
                    right=mid;
                }
            } else{
                if(pos.get(mid)>value){
                    right=mid;
                } else{
                    left=mid+1;
                }
            }
        }
        if(isStart){
            return pos.get(left);
        } else{
            return pos.get(right)>value?pos.get(right-1):pos.get(right);
        }
    }

//    // DP, dp[i][j] stands for the count of different palindromic suseuqences in s.substring(i, j+1)
//    public int countPalindromicSubsequences(String s) {
//        int l=s.length();
//        int[][] dp=new int[l][l];
//        int mod=1_000_000_007;
//        for(int len=1; len<=l; len++){
//            for(int i=0; i<=l-len; i++){
//                int j=i+len-1;
//                if(len==1){
//                    dp[i][j]=1;
//                } else{
//                    if(s.charAt(i)==s.charAt(j)){
//                        int left=i+1, right=j-1;
//                        while(left<=right && s.charAt(left)!=s.charAt(i)){
//                            left++;
//                        }
//                        while(right>=left && s.charAt(right)!=s.charAt(i)){
//                            right--;
//                        }
//                        // Assume c stands for s.charAt(i)
//                        if(left>right){
//                            // c...c
//                            // everything in between can either be . or c.c, therefore *2, also plus 2 for c and cc
//                            dp[i][j]=dp[i+1][j-1]*2+2;
//                        } else if(left==right){
//                            // c...c...c, everything in between can either be . or c.c, therefore *2, also plus 1 for cc
//                            // note ccc is already included when *2
//                            dp[i][j]=dp[i+1][j-1]*2+1;
//                        } else{
//                            // c...c...c...c, everything in between can either be c or c.c, therefore *2, but minus ...
//                            // in the middle because c...c is included twice when *2, note c, cc, ccc and cccc are all
//                            // included when *2 already
//                            dp[i][j]=dp[i+1][j-1]*2-dp[left+1][right-1];
//                        }
//                    } else{
//                        dp[i][j]=dp[i][j-1]+dp[i+1][j]-dp[i+1][j-1];
//                    }
//                }
//                // Note how overflow can be solved here, since all dp[i][j]<mod, the overflow will NOT exceed mod because
//                // there's only *2,*(-1), +1 and +2
//                dp[i][j]=dp[i][j]<0?dp[i][j]+mod:dp[i][j]%mod;
//            }
//        }
//        return dp[0][l-1];
//    }
}
