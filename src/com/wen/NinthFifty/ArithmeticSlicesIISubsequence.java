package com.wen.NinthFifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArithmeticSlicesIISubsequence {
    public int numberOfArithmeticSlices(int[] A) {
        if(A==null || A.length<3){
            return 0;
        }
        int result=0, l=A.length;
        List<Map<Long, Integer>> dp=new ArrayList<>();
        for(int i=0; i<l; i++){
            dp.add(new HashMap<>());
            for(int j=0; j<i; j++){
                long diff=(long)A[i]-(long)A[j];
                int cur=dp.get(i-1).getOrDefault(diff, 0);
                dp.get(i-1).put(diff, cur+1);
                // Here check dp.get(j-1).containsKey(diff) can eliminate the case when there're duplicates before A[i]
                // as they won't be in dp.get(j-1), for example when [2,2,3,4]
                if(j-1>=0 && dp.get(j-1).containsKey(diff)){
                    result+=dp.get(j-1).get(diff);
                    dp.get(i-1).put(diff, cur+1+dp.get(j-1).get(diff));
                }
            }
        }
        return result;
    }
}
