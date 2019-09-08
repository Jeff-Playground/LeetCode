package com.wen.Airbnb;

public class HilbertCurve {
    public static void main(String args[]){
        System.out.println(hilbertCurve(1, 1, 2));
        System.out.println(hilbertCurve(0, 1, 1));
        System.out.println(hilbertCurve(2, 2, 2));
    }

    private static int hilbertCurve(int x, int y, int iter) {
        if(iter==0){
            return 1;
        }
        // This is the length of one block, which is 2^(iter-1)
        int len=1<<(iter-1);
        // This is the count in one block, which is 4^(iter-1)
        int block=1<<(2*(iter-1));
        if(x>=len && y>=len){
            // This is the upper right block
            // Shape is identical with previous iteration
            return 2*block+hilbertCurve(x-len, y-len, iter-1);
        } else if(x<len && y>=len){
            // This is the upper left block
            // Shape is identical with previous iteration
            return block+hilbertCurve(x, y-len, iter-1);
        } else if(x<len && y<len){
            // This is the lower left block(starting block)
            // Shape is clock-wise rotate 90
            return hilbertCurve(y, x, iter-1);
        } else{
            // This is the lower right block
            // Shape is anti clock-wise rotate 90
            return 3*block+hilbertCurve(len-1-y, 2*len-1-x, iter-1);
        }
    }
}
