package com.wen.TenthFifty;

/*
Given a list of points that form a polygon when joined sequentially, find if this polygon is convex.

Note:
There are at least 3 and at most 10,000 points.
Coordinates are in the range -10,000 to 10,000.
You may assume the polygon formed by given points is always a simple polygon. In other words, we ensure that exactly two edges intersect at each vertex, and that edges otherwise don't intersect each other.

Example 1:
[[0,0],[0,1],[1,1],[1,0]]
Answer: True

Example 2:
[[0,0],[0,10],[10,10],[10,0],[5,5]]
Answer: False
 */

public class LQConvexPolygon {
    // Vector cross product's direction must stay same when use two consecutive edges to compute it
    public static boolean isConvex(int[][] point) {
        int l=point.length, pre=0;
        for(int i=0; i<l; i++){
            int dx1=point[(i+1)%l][0]-point[i][0], dy1=point[(i+1)%l][1]-point[i][1];
            int dx2=point[(i+2)%l][0]-point[(i+1)%l][0], dy2=point[(i+2)%l][1]-point[(i+1)%l][1];
            int cp=dy2*dx1-dy1*dx2;
            if(cp!=0){
                if(cp*pre<0){
                    return false;
                } else{
                    pre=cp;
                }
            }
        }
        return true;
    }

//    public boolean isConvex(int[][] points) {
//        int l=points.length, pre=0;
//        for(int i=0; i<l; i++){
//            int dx1=points[(i+1)%l][0]-points[i][0], dy1=points[(i+1)%l][1]-points[i][1];
//            int dx2=points[(i+2)%l][0]-points[(i+1)%l][0], dy2=points[(i+2)%l][1]-points[(i+1)%l][1];
//            int cp=dx1*dy2-dy1*dx2;
//            if(pre*cp<0){
//                return false;
//            }
//            if(pre==0){
//                pre=cp;
//            }
//        }
//        return true;
//    }
}
