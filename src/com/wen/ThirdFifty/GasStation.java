package com.wen.ThirdFifty;

public class GasStation {
    // Find the point where it can get the most remaining gas, because the answer is unique, only this point can be the
    // answer
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int total=0, max=0, start=0;
//        for(int i=gas.length-1; i>=0; i--){
//            total+=gas[i]-cost[i];
//            if(total>max){
//                start=i;
//                max=total;
//            }
//        }
//        return total<0 ? -1: start;
//    }

    // Problem said it's unique answer, so start=i+1, otherwise, it could be start>i+1
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int l=gas.length;
        int totalGas=0, totalCost=0, curGas=0, curCost=0, start=0;
        for(int i=0; i<l; i++) {
            curGas+=gas[i];
            curCost+=cost[i];
            totalGas+=gas[i];
            totalCost+=cost[i];
            if(curGas<curCost) {
                curGas=0;
                curCost=0;
                start=i+1;
            }
        }
        return totalGas>=totalCost?start:-1;
    }
}
