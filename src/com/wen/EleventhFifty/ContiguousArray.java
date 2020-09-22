package com.wen.EleventhFifty;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int l=nums.length, result=0, sum=0;
        Map<Integer, Integer> idx=new HashMap<>();
        idx.put(0, -1);
        for(int i=0; i<l; i++){
            sum+=nums[i]==1?1:-1;
//            sum+=(nums[i]<<1)-1;
            if(idx.containsKey(sum)){
                result=Math.max(result, i-idx.get(sum));
            }
            idx.putIfAbsent(sum, i);
        }
        return result;
    }
}
