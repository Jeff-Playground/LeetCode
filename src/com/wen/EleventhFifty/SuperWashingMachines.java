package com.wen.EleventhFifty;

public class SuperWashingMachines {
    public int findMinMoves(int[] machines) {
        int n=machines.length;
        if(n==1){
            return 0;
        }
        int total=0;
        for(int machine: machines){
            total+=machine;
        }
        int each=total/n, remain=total%n;
        int result=0;
        if(remain!=0){
            return -1;
        } else{
            int count=0;
            for(int i=0; i<n; i++){
                machines[i]-=each;
                count+=machines[i];
                // Here use machines[i] instead of Math.abs(machines[i]) because a negative machine can receive from both sides,
                // but a positive machine can output only 1 at a time, so 8 needs 8 outs, but -8 may only need 4 ins from both sides
                // (4, -8, 4)
                // result=Math.max(Math.max(result, Math.abs(count)), Math.abs(machines[i]));
                result=Math.max(Math.max(result, Math.abs(count)), machines[i]);
            }
            return result;
        }
    }
}
