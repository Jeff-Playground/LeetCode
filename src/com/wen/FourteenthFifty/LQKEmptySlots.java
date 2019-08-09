package com.wen.FourteenthFifty;

public class LQKEmptySlots {
    public int kEmptySlots(int[] flowers, int k) {
        int N=flowers.length;
        if(k>N-2){
            return -1;
        }
        int[] days=new int[N+1];
        for(int i=0; i<N; i++){
            days[flowers[i]]=i+1;
        }
        int result=Integer.MAX_VALUE;
        for(int i=1; i<N-k; i++){
            int max=Math.max(days[i], days[i+k+1]);
            // This means there're still at least k days remaining(so at least k flowers haven't bloomed)
            if(N-max>=k){
                for(int j=i+1; j<i+k+1; j++){
                    if(days[j]<max){
                        max=-1;
                        break;
                    }
                }
                if(max!=-1){
                    result=Math.min(result, max);
                }
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
    }

//    // Binary indexed tree
//    public static int kEmptySlots(int[] flowers, int k) {
//        int N=flowers.length;
//        if(k>N-2){
//            return -1;
//        }
//        int[] blooming=new int[N+1];
//        int[] bloomingSum=new int[N+1];
//        for(int i=0; i<=N-k-1; i++){
//            blooming[flowers[i]]=1;
//            updateBloomingSum(bloomingSum, flowers[i], 1);
//            if(flowers[i]-k-1>=0 && blooming[flowers[i]-k-1]==1){
//                if(getBloomingSum(bloomingSum, flowers[i])-getBloomingSum(bloomingSum, flowers[i]-k-1)==1){
//                    return i+1;
//                }
//            }
//            if(flowers[i]+k+1<N+1 && blooming[flowers[i]+k+1]==1){
//                if(getBloomingSum(bloomingSum, flowers[i]+k+1)-getBloomingSum(bloomingSum, flowers[i])==1){
//                    return i+1;
//                }
//            }
//        }
//        return -1;
//    }
//
//    public static void updateBloomingSum(int[] bloomingSum, int index, int diff){
//        for(int i=index; i<bloomingSum.length; i+=i&(-i)){
//            bloomingSum[i]+=diff;
//        }
//    }
//
//    public static int getBloomingSum(int[] bloomingSum, int index){
//        int result=0;
//        for(int i=index; i>=1; i-=i&(-i)){
//            result+=bloomingSum[i];
//        }
//        return result;
//    }
}
