package com.wen.ThirdFifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        if(points==null || points.length==0) {
            return 0;
        }
        int result=0, l=points.length;
        for(int i=0; i<l; i++) {
            int x=points[i][0], y=points[i][1];
            int duplicates=1;
            Map<List<Integer>, Integer> slopes=new HashMap<>();
            // Don't need to consider points before because the slope for before nodes has covered the missed situation
            for(int j=i+1; j<l; j++) {
                int dx=x-points[j][0], dy=y-points[j][1];
                if(dx==0 && dy==0) {
                    duplicates++;
                } else {
                    int gcd=gcd(Math.abs(dx), Math.abs(dy));
                    List<Integer> slope=new ArrayList<>();
                    if(dx>0) {
                        slope.add(dx/gcd);
                        slope.add(dy/gcd);
                    } else if(dx==0){
                        slope.add(0);
                        slope.add(Math.abs(dy)/gcd);
                    } else {
                        slope.add(-dx/gcd);
                        slope.add(-dy/gcd);
                    }
                    slopes.put(slope, slopes.getOrDefault(slope, 0)+1);
                }
            }
            // Need it so when only given 1 point, the result is 1
            result=Math.max(result, duplicates);
            for(int count: slopes.values()) {
                result=Math.max(result, count+duplicates);
            }
        }
        return result;
    }

    // Stein's method
    private static int gcd(int a, int b) {
        if(a<b) {
            return gcd(b, a);
        }
        if(b==0) {
            return a;
        }
        if(a%2==0 && b%2==0) {
            return 2*gcd(a>>1, b>>1);
        } else if(a%2==0) {
            return gcd(a>>1, b);
        } else if(b%2==0) {
            return gcd(a, b>>1);
        } else {
            return gcd(b, a-b);
        }
    }
}
