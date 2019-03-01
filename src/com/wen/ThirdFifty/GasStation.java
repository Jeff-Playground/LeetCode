package com.wen.ThirdFifty;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0, max=0, start=0;
        for(int i=gas.length-1; i>=0; i--){
            total+=gas[i]-cost[i];
            if(total>max){
                start=i;
                max=total;
            }
        }
        return total<0 ? -1: start;
    }

//    // Problem said it's unique answer, so start=i+1, otherwise, it could be start>i+1
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int total=0, sum=0, start=0;
//        for(int i=0; i<gas.length; i++){
//            total+=gas[i]-cost[i];
//            sum+=gas[i]-cost[i];
//            if(sum<0){
//                start=i+1;
//                sum=0;
//            }
//        }
//        return total<0 ? -1: start;
//    }
}
