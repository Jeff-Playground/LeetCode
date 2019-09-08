package com.wen.Airbnb;

import java.util.PriorityQueue;
import java.util.Random;

public class RoundPrice {
    public static void main(String args[]) {
        double[] input = new double[100];
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int num1 = rand.nextInt(5);
            double num2 = rand.nextDouble();
            double num = (double) num1 + num2;
            input[i] = num;
            sb.append(num).append(",");
        }
        System.out.println(sb.toString());
        sb.setLength(0);
        int[] result = roundUp(input);
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(",");
        }
        System.out.println(sb.toString());
    }

    public static int[] roundUp(double[] input) {
        int l=input.length;
        int[] result=new int[l];
        double total=0;
        int less=0;
        PriorityQueue<double[]> pq=new PriorityQueue<>((a, b)->Double.compare(b[0], a[0]));
        for(int i=0; i<l; i++){
            total+=input[i];
            less+=(int)input[i];
            double[] diff=new double[]{input[i]-(double)((int)input[i]), i};
            pq.offer(diff);
            result[i]=(int)input[i];
        }
        int count=(int)Math.round(total)-less;
        while(count-->0){
            result[(int)pq.poll()[1]]++;
        }
        return result;
    }
}
