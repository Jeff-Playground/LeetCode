package com.wen.Airbnb;

import java.util.Arrays;

public class HilbertCurve {
    public static void main(String args[]){
        System.out.println(hilbertCurveCoordinatesToNumber(new int[]{1,1}, 2));
        System.out.println(Arrays.toString(hilbertCurveNumberToCoordinates(3, 2)));

        System.out.println(hilbertCurveCoordinatesToNumber(new int[]{0,1}, 1));
        System.out.println(Arrays.toString(hilbertCurveNumberToCoordinates(2, 1)));

        System.out.println(hilbertCurveCoordinatesToNumber(new int[]{2,2}, 2));
        System.out.println(Arrays.toString(hilbertCurveNumberToCoordinates(9, 2)));

        System.out.println(hilbertCurveCoordinatesToNumber(new int[]{5,1}, 3));
        System.out.println(Arrays.toString(hilbertCurveNumberToCoordinates(57, 3)));

        System.out.println(hilbertCurveCoordinatesToNumber(new int[]{5,6}, 3));
        System.out.println(Arrays.toString(hilbertCurveNumberToCoordinates(40, 3)));

        System.out.println(hilbertCurveCoordinatesToNumber(new int[]{2,6}, 3));
        System.out.println(Arrays.toString(hilbertCurveNumberToCoordinates(25, 3)));
    }

    // (x, y) starts from (0, 0)
    private static int hilbertCurveCoordinatesToNumber(int[] coordinates, int iter) {
        if(iter==0){
            return 1;
        }
        int x=coordinates[0], y=coordinates[1];
        // This is the length of one block, which is 2^(iter-1)
        int len=1<<(iter-1);
        // This is the count in one block, which is 4^(iter-1)
        int block=1<<(2*(iter-1));
        if(x<len && y<len){
            // This is the lower left block(starting block)
            // Shape to previous iteration is (x->y, y->x) without moving
            return hilbertCurveCoordinatesToNumber(new int[]{y, x}, iter-1);
        } else if(x<len && y>=len){
            // This is the upper left block
            // Shape is moving down by len
            return block+hilbertCurveCoordinatesToNumber(new int[]{x, y-len}, iter-1);
        } else if(x>=len && y>=len){
            // This is the upper right block
            // Shape is moving to left by len and down by len
            return 2*block+hilbertCurveCoordinatesToNumber(new int[]{x-len, y-len}, iter-1);
        } else{
            // This is the lower right block
            // Shape to previous iteration is moving to left by 2*len and move down by len then (x->-y, y->-x)
            return 3*block+hilbertCurveCoordinatesToNumber(new int[]{len-1-y, 2*len-1-x}, iter-1);
        }
    }

    private static int[] hilbertCurveNumberToCoordinates(int num, int iter){
        if(iter==0){
            return new int[]{0,0};
        }
        // This is the length of one block, which is 2^(iter-1)
        int len=1<<(iter-1);
        // This is the count in one block, which is 4^(iter-1)
        int block=1<<(2*(iter-1));
        int count=(num-1)/block;
        int[] prev=hilbertCurveNumberToCoordinates(num-block*count, iter-1);
        int x=prev[0], y=prev[1];
        if(count==0){
            // This is the lower left block(starting block)
            return new int[]{y, x};
        } else if(count==1){
            // This is the upper left block
            return new int[]{x, y+len};
        } else if(count==2){
            // This is the upper right block
            return new int[]{x+len, y+len};
        } else{
            // This is the lower right block
            return new int[]{2*len-1-y, len-1-x};
        }
    }
}
