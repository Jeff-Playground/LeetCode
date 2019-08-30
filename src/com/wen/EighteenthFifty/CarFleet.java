package com.wen.EighteenthFifty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int result=0;
        double cur=0;
        Map<Integer, Double> time=new TreeMap<>();
        int l=position.length;
        for(int i=0; i<l; i++){
            // Note this trick makes the order reversed
            time.put(-position[i], (double)(target-position[i])/speed[i]);
        }
        for(Double t: time.values()){
            if(t<=cur){
                continue;
            }
            cur=t;
            result++;
        }
        return result;
    }

//    public int carFleet(int target, int[] position, int[] speed) {
//        if(position==null || position.length==0){
//            return 0;
//        }
//        int result=1;
//        Map<Integer, Integer> indices=new HashMap<>();
//        int l=position.length;
//        for(int i=0; i<l; i++){
//            indices.put(position[i], i);
//        }
//        Arrays.sort(position);
//        int lastP=position[l-1], lastV=speed[indices.get(lastP)];
//        for(int i=l-2; i>=0; i--){
//            int curP=position[i], curV=speed[indices.get(curP)];
//            if(curV>lastV){
//                float t=(float)(lastP-curP)/(curV-lastV);
//                if(target-lastP>=lastV*t){
//                    continue;
//                }
//            }
//            result++;
//            lastP=curP;
//            lastV=curV;
//        }
//        return result;
//    }
}
