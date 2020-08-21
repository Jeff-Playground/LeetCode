package com.wen.TenthFifty;

public class LQConvexPolygon {
    // Vector cross product's direction must stay same when use two consecutive edges to compute it
    public static boolean isConvex(int[][] point) {
        int l=point.length, pre=0;
        for(int i=0; i<l; i++){
            int dx1=point[(i+1)%l][0]-point[i][0];
            int dx2=point[(i+2)%l][0]-point[(i+1)%l][0];
            int dy1=point[(i+1)%l][1]-point[i][1];
            int dy2=point[(i+2)%l][1]-point[(i+1)%l][1];
            int cur=dy2*dx1-dy1*dx2;
            if(cur!=0){
                if(cur*pre<0){
                    return false;
                } else{
                    pre=cur;
                }
            }
        }
        return true;
    }
}
