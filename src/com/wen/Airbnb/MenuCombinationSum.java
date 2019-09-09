package com.wen.Airbnb;

import java.util.ArrayList;
import java.util.List;

public class MenuCombinationSum {
    private static double maxDiff=1.0E-2;
    public static void main(String args[]) {
        double[] prices = {2.40, 0.101, 6.00, 2.48, 0.022, 2.503};
        List<List<Double>> result = getCombos(prices, 2.50);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(i + "th result:");
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.println(result.get(i).get(j));
            }
        }
    }

    private static List<List<Double>> getCombos(double[] prices, double target) {
        List<List<Double>> result=new ArrayList<>();
        getCombosDFS(prices, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private static void getCombosDFS(double[] prices, double target, int curIdx, double last, List<Double> cur, List<List<Double>> result) {
        if(curIdx==prices.length){
            if(Math.abs(target-last)<maxDiff){
                result.add(new ArrayList<>(cur));
            }
        } else{
            if(last<target || Math.abs(target-last)<maxDiff){
                cur.add(prices[curIdx]);
                getCombosDFS(prices, target, curIdx+1, last+prices[curIdx], cur, result);
                cur.remove(cur.size()-1);
                getCombosDFS(prices, target, curIdx+1, last, cur, result);
            }
        }
    }
}
