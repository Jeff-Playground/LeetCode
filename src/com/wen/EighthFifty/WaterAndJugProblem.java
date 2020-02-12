package com.wen.EighthFifty;

public class WaterAndJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        if(z>x+y){
            return false;
        }
        return z==0 || z%gcd(x, y)==0;
    }

    // Stein's method
    public int gcd(int x, int y){
        if(x<y){
            return gcd(y, x);
        }
        if(y==0){
            return x;
        }
        if(x%2==0 && y%2==0){
            return 2*gcd(x>>1, y>>1);
        } else if(x%2==0){
            return gcd(x>>1, y);
        } else if(y%2==0){
            return gcd(x, y>>1);
        } else{
            return gcd(x-y, y);
        }
    }

//    // Euclid's method
//    public int gcd(int x, int y){
//        return y==0?x:gcd(y, x%y);
//    }
}
