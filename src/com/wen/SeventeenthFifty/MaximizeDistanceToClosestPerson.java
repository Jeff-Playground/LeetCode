package com.wen.SeventeenthFifty;

public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int count=0, max=0;
        boolean empty=true;
        for(int i=0; i<=seats.length; i++){
            if((i==seats.length || seats[i]==1) && count>0){
                max=Math.max(max, (i==seats.length || empty)?count*2:count);
                count=0;
                empty=false;
            } else if(i<seats.length && seats[i]==0){
                count++;
            } else if(i<seats.length && seats[i]==1){
                empty=false;
            }
        }
        return (max+1)/2;
    }
}
