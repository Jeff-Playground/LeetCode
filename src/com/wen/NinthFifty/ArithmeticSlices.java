package com.wen.NinthFifty;

public class ArithmeticSlices {
    // DP, optimized to get rid of the int[] array
    public int numberOfArithmeticSlices(int[] A) {
        int result=0, l=A.length;
        int last=0;
        for(int i=2; i<l; i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                last=last+1;
            } else{
                last=0;
            }
            result+=last;
        }
        return result;
    }

//    // DP
//    public int numberOfArithmeticSlices(int[] A) {
//        int result=0, l=A.length;
//        int[] dp=new int[l];
//        for(int i=2; i<l; i++){
//            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
//                dp[i]=dp[i-1]+1;
//            }
//            result+=dp[i];
//        }
//        return result;
//    }

//    // Greedy2
//    public int numberOfArithmeticSlices(int[] A) {
//        int result=0, l=A.length, length=2;
//        for(int i=2; i<l; i++){
//            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
//                length++;
//            } else{
//                if(length>2){
//                    result+=(1+length-2)*(length-2)/2;
//                    length=2;
//                }
//            }
//        }
//        if(length>2){
//            result+=(1+length-2)*(length-2)/2;
//        }
//        return result;
//    }

//    // Greedy1
//    public int numberOfArithmeticSlices(int[] A) {
//        int result=0, l=A.length;
//        if(l<3){
//            return result;
//        } else{
//            for(int i=0; i<=l-3; i++){
//                int first=A[i], second=A[i+1], third=A[i+2];
//                if(third-second==second-first){
//                    result++;
//                    int diff=second-first;
//                    int j=i+3;
//                    for(; j<=l-1; j++){
//                        if(A[j]-A[j-1]==diff){
//                            result+=j-i-1;
//                        } else{
//                            i=j-1;
//                            break;
//                        }
//                    }
//                    if(j==l){
//                        break;
//                    }
//                }
//            }
//            return result;
//        }
//    }
}
