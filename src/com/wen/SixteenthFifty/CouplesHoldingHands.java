package com.wen.SixteenthFifty;

import java.util.HashMap;
import java.util.Map;

public class CouplesHoldingHands {
//    // Union find
//    public int minSwapsCouples(int[] row) {
//        int l=row.length, count=0;
//        int[] root=new int[l/2];
//        for(int i=0; i<l/2; i++){
//            root[i]=i;
//        }
//        for(int i=0; i+1<l; i+=2){
//            int r1=findRoot(root, row[i]/2), r2=findRoot(root, row[i+1]/2);
//            if(r1!=r2){
//                root[r2]=r1;    // Union, here means make the unified group members reaching each other
//                count++;        // This means by doing count times swaps, can reach either element within the formed group
//            }
//        }
//        return count;
//    }
//
//    private int findRoot(int[] root, int v){
//        while(root[v]!=v){
//            root[v]=root[root[v]];
//            v=root[v];
//        }
//        return v;
//    }

    // Map is basically storing which groups need to be swapped
    public static int minSwapsCouples(int[] row) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i+1<row.length; i+=2){
            minSwapsCouplesHelper(map, row[i]/2, row[i+1]/2);
        }
        return map.size();
    }

    public static void minSwapsCouplesHelper(Map<Integer, Integer> map, int first, int second){
        if(first!=second){
            int min=Math.min(first, second), max=Math.max(first, second);
            if(map.containsKey(min)){
                // It means the existing swap doesn't cover the current necessary swap
                if(map.get(min)!=max){
                    minSwapsCouplesHelper(map, map.get(min), max);
                }
            } else{
                map.put(min, max);
            }
        }
    }

//    // Greedy
//    public int minSwapsCouples(int[] row) {
//        if(row==null || row.length==0){
//            return 0;
//        }
//        int i=0, count=0;
//        while(i+1<row.length){
//            if((row[i]^1)!=row[i+1]){
//                for(int j=i+2; j<row.length; j++){
//                    if(row[j]==(row[i]^1)){
//                        row[j]=row[i+1];
//                        row[i+1]=row[i]^1;
//                        count++;
//                    }
//                }
//            }
//            i++;
//        }
//        return count;
//    }
}
