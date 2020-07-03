package com.wen.EighthFifty;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result=new ArrayList<>();
        for(int i=1; i<=9; i++){
            loHelper(i, n, result);
        }
        return result;
    }

    private void loHelper(int cur, int n, List<Integer> result){
        if(cur<=n){
            result.add(cur);
            for(int i=0; i<=9; i++){
                if(cur*10+i<=n){
                    loHelper(cur*10+i, n, result);
                } else{
                    break;
                }
            }
        }
    }

//    public List<Integer> lexicalOrder(int n) {
//        List<Integer> result=new ArrayList<>();
//        int cur=1;
//        for(int i=0; i<n; i++){
//            result.add(cur);
//            if(cur*10<=n){
//                cur*=10;
//            } else{
//                if(cur==n){
//                    cur/=10;
//                }
//                cur+=1;
//                while(cur%10==0){
//                    cur/=10;
//                }
//            }
//        }
//        return result;
//    }
}
