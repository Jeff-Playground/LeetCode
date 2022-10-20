package com.wen.SixteenthFifty;

public class ReachANumber {
    // BFS here would TLE because the complexity can go up exponentially
    // There are a few things:
    // - A negative target is the same with the corresponding positive target in regards to steps
    // - Going to the negative direction with a distance of d would create a total of 2*d in the negative direction
    //   comparing to keeping going the positive direction
    // Therefore, the trick is adjust target to be positive, then identify the first step when keeping going positive
    // and the total distance is no less than target:
    // - If it's equal to the target, then current step is the result
    // - If it's bigger than target, assume d is the difference
    //   - If d is even, then there must be one step from previous we can take to the negative direction to offset d,
    //     to be more specific, it's step d/2
    //   - If d is odd
    //     - If step is even, then the next step would be odd and together create a new difference that's even, so
    //       similarly we can take the step (d+step+1)/2 in the negative direction to offset the new difference
    //     - If step is odd, then take the next 2 steps, and the second step would be odd too, together the new
    //       difference will be even, and we can take the step (d+step+1+step+2)/2 in this case
    public int reachNumber(int target) {
        int step=1;
        target=Math.abs(target);
        while((1+step)*step/2<target){
            step++;
        }
        int cur=(1+step)*step/2;
        if(cur==target){
            return step;
        } else{
            int d=cur-target;
            if(d%2==0){
                return step;
            } else{
                if(step%2==0){
                    return step+1;
                } else{
                    return step+2;
                }
            }
        }
    }
}
