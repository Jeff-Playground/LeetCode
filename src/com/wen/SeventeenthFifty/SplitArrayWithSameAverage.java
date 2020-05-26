package com.wen.SeventeenthFifty;

import java.util.*;

public class SplitArrayWithSameAverage {
    // 0-1 knapsack, dp.get(Arrays.asList(i, j)) stands for the possible count of numbers that adds up to j in the first
    // i numbers
    public static boolean splitArraySameAverage(int[] A) {
        int l=A.length, sum=0;
        for(int num: A){
            sum+=num;
        }
        Set<Integer> count=new HashSet<>();
        for(int i=1; i<l/2+1; i++){
            if(sum*i%l==0){
                count.add(i);
            }
        }
        if(count.isEmpty()){
            return false;
        } else{
            Map<List<Integer>, Set<Integer>> dp=new HashMap<>();
            for(int i=0; i<=l; i++){
                dp.put(Arrays.asList(i,0), new HashSet<>(Arrays.asList(0)));
            }
            for(int i=1; i<=l; i++){
                for(int j=1; j<sum; j++){
                    Set<Integer> cur=new HashSet<>();
                    if(dp.get(Arrays.asList(i-1, j))!=null){
                        cur.addAll(dp.get(Arrays.asList(i-1, j)));
                    }
                    if(A[i-1]<=j){
                        Set<Integer> possible=dp.get(Arrays.asList(i-1, j-A[i-1]));
                        if(possible!=null){
                            for(int e: possible){
                                if(sum*(e+1)%l==0 && sum*(e+1)/l==j){
                                    return true;
                                } else{
                                    cur.add(e+1);
                                }
                            }
                        }
                    }
                    if(!cur.isEmpty()){
                        dp.put(Arrays.asList(i, j), cur);
                    }
                }
            }
            return false;
        }
    }

//    // 0-1 knapsack, dp.get(j) stands for the length of numbers that adds up to j
//    public static boolean splitArraySameAverage(int[] A) {
//        if(A==null || A.length<2){
//            return false;
//        }
//        int l=A.length, sum=0;
//        for(int num: A){
//            sum+=num;
//        }
//        boolean possible=false;
//        for(int i=1; !possible && i<=l; i++){
//            if(sum*i%l==0){
//                possible=true;
//            }
//        }
//        if(possible) {
//            List<Set<Integer>> dp = new ArrayList<>();
//            for (int j = 0; j <= sum; j++) {
//                dp.add(new HashSet<>());
//            }
//            for (int i = 1; i <= l; i++) {
//                for (int j = sum; j >= 1; j--) {
//                    Set<Integer> cur = dp.get(j);
//                    if (A[i - 1] <= j) {
//                        if (A[i - 1] == j) {
//                            cur.add(1);
//                        }
//                        // This is to avoid concurrent modification exception when A[i-1]==0
//                        Set<Integer> prev = A[i - 1] == 0 ? new HashSet<>(dp.get(j - A[i - 1])) : dp.get(j - A[i - 1]);
//                        for (int prevLength : prev) {
//                            cur.add(prevLength + 1);
//                        }
//                    }
//                }
//            }
//            for (int j = 1; j < sum; j++) {
//                if (dp.get(j).size() > 0) {
//                    for (int length : dp.get(j)) {
//                        if (j * l == sum * length) {
//                            return true;
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }

//    // 0-1 knapsack, dp[i][j] stands for whether there exists i numbers adds up to j
//    public boolean splitArraySameAverage(int[] A) {
//        if(A==null || A.length<2){
//            return false;
//        }
//        int l=A.length, max=l/2, sum=0;
//        for(int num: A){
//            sum+=num;
//        }
//        boolean possible=false;
//        for(int i=1; !possible && i<=max; i++){
//            if(sum*i%l==0){
//                possible=true;
//            }
//        }
//        if(possible){
//            // Note here dp[i][j] stands for all the first i numbers can add to sum j, every number must be added
//            boolean[][] dp=new boolean[max+1][sum+1];
//            dp[0][0]=true;
//            for(int num: A){
//                // Note here i had to be reversed to avoid same number used twice
//                for(int i=max; i>=1; i--){
//                    for(int j=num; j<=sum; j++){
//                        dp[i][j]=dp[i][j] || dp[i-1][j-num];
//                    }
//                }
//            }
//            for(int i=1; i<=max; i++){
//                if(sum*i%l==0 && dp[i][sum*i/l]){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

//    // DP, dp.get(i) stands for the sums of i numbers in the array
//    public static boolean splitArraySameAverage(int[] A) {
//        if(A==null || A.length<2){
//            return false;
//        }
//        int l=A.length, max=l/2, sum=0;
//        for(int num: A){
//            sum+=num;
//        }
//        boolean possible=false;
//        for(int i=1; !possible && i<=max; i++){
//            if(sum*i%l==0){
//                possible=true;
//            }
//        }
//        if(possible){
//            Map<Integer, Set<Integer>> dp=new HashMap<>();
//            dp.put(0,new HashSet<>(Arrays.asList(0)));
//            for(int i=1; i<=max; i++){
//                dp.put(i, new HashSet<>());
//            }
//            for(int num: A){
//                for(int i=max; i>=1; i--){
//                    for(int pre: dp.get(i-1)){
//                        dp.get(i).add(pre+num);
//                    }
//                }
//            }
//            for(int i=1; i<=max; i++){
//                if(sum*i%l==0 && dp.get(i).contains(sum*i/l)){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
