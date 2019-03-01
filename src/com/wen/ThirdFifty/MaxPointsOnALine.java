package com.wen.ThirdFifty;

import com.wen.SecondFifty.MinimumPathSum;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {
    public static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        public Point(int a, int b) { x = a; y = b; }
    }

    public static int maxPoints(Point[] points) {
        int result=0;
        for(int i=0; i<points.length; i++){
            Map<Map<Integer, Integer>, Integer> map = new HashMap<>();
            int duplicates=1;
            for(int j=i+1; j<points.length; j++){
                if(points[i].x==points[j].x && points[i].y==points[j].y){
                    duplicates++;
                    continue;
                }
                int dx=points[i].x-points[j].x;
                int dy=points[i].y-points[j].y;
                int d=greatestCommonDivisor(dx, dy);
                Map<Integer, Integer> cur=new HashMap<>();
                cur.put(dx/d, dy/d);
                map.put(cur, map.getOrDefault(cur, 0)+1);
            }
            result=Math.max(result, duplicates);
            for(Map.Entry<Map<Integer, Integer>, Integer> entry: map.entrySet()){
                result= Math.max(result, entry.getValue()+duplicates);
            }
        }
        return result;
    }

    // Stein method
    // This works better with positive numbers, the sign is introduced to handle case when a and b are of different signs
    private static int greatestCommonDivisor(int a, int b) {
        int sign=1;
        if(a>0){
            sign=1;
        } else if(a<0){
            sign=-1;
        } else{
            sign=b>=0?1:-1;
        }
        a=a<0?-a:a;
        b=b<0?-b:b;
        if(a==0){
            return b*sign;
        }
        if(b==0){
            return a*sign;
        }
        if(a%2==0 && b%2==0){
            return 2*greatestCommonDivisor(a>>1, b>>1)*sign;
        } else if(a%2==0){
            return greatestCommonDivisor(a>>1, b)*sign;
        } else if(b%2==0){
            return greatestCommonDivisor(a, b>>1)*sign;
        } else{
            return greatestCommonDivisor(Math.abs(a-b)>>1, Math.min(a, b))*sign;
        }
    }

//    // Euclid method
//    private static int greatestCommonDivisor(int a, int b) {
//        return b==0? a :greatestCommonDivisor(b, a%b);
//    }
}
