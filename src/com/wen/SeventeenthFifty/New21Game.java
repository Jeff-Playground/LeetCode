package com.wen.SeventeenthFifty;

public class New21Game {
//    // DP, where dp[i] stands for the probability for getting i points, this gives the right answer, but will TLE
//    // Basically, the idea is calculate each possible approach by P(i-k)*lastCardPossibility where lastCardPossibility
//    // is the probability to get k for the last card, note for each draw the probability is always:
//    // lastCardPossibility=1/maxPts
//    // Also note in the end, sum up only the probabilities >=k, because that's when the draw stops
//    // BTW, sum(dp[i])==1 for k<=i<=maxPossiblePts
//    public static double new21Game(int n, int k, int maxPts) {
//        if(k==0){
//            return 1.0;
//        }
//        int maxPossiblePts=k-1+maxPts;
//        if(n>=maxPossiblePts){
//            return 1.0;
//        }
//        double lastCardPossibility=1.0/maxPts;
//        double[] dp=new double[maxPossiblePts+1];
//        dp[0]=1.0;
//        for(int i=1; i<=maxPossiblePts; i++){
//            if(i<=maxPts && i<=k){
//                for(int j=0; j<i; j++){
//                    dp[i]+=lastCardPossibility*dp[j];
//                }
//            } else if(i>maxPts && i<=k){
//                for(int j=i-maxPts; j<i; j++){
//                    dp[i]+=lastCardPossibility*dp[j];
//                }
//            } else if(i<=maxPts && i>k){
//                for(int j=0; j<k; j++){
//                    dp[i]+=lastCardPossibility*dp[j];
//                }
//            } else{
//                for(int j=i-maxPts; j<k; j++){
//                    dp[i]+=lastCardPossibility*dp[j];
//                }
//            }
//        }
//        double result=0;
//        for(int i=k; i<=n; i++){
//            result+=dp[i];
//        }
//        return result;
//    }

    // DP, same idea as above, except optimized so dp[i] stands for the probability of the sum for all probabilities where
    // drew total less than or equal to i
    public static double new21Game(int n, int k, int maxPts){
        if(k==0 || n>k-1+maxPts){
            return 1.0;
        }
        int maxPossiblePts=k-1+maxPts;
        double[] dp=new double[maxPossiblePts+1];
        double lastCardProbability=1.0/maxPts;
        dp[0]=1.0;
        for(int i=1; i<=maxPossiblePts; i++){
            if(i<=k && i<=maxPts){
                dp[i]=lastCardProbability*dp[i-1]+dp[i-1];
            } else if(i>k && i<=maxPts){
                dp[i]=lastCardProbability*dp[k-1]+dp[i-1];
            } else if(i<=k && i>maxPts){
                dp[i]=lastCardProbability*(dp[i-1]-dp[i-maxPts-1])+dp[i-1];
            } else{
                dp[i]=lastCardProbability*(dp[k-1]-dp[i-maxPts-1])+dp[i-1];
            }
        }
        return dp[n]-dp[k-1];
    }
}
