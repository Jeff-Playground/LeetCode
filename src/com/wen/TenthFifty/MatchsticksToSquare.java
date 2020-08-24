package com.wen.TenthFifty;

import java.util.TreeMap;

public class MatchsticksToSquare {
    // DFS
    public static boolean makesquare(int[] nums) {
        if(nums==null || nums.length<=3){
            return false;
        }
        int sum=0;
        TreeMap<Integer, Integer> count=new TreeMap<>();
        for(int num: nums){
            sum+=num;
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        if(sum%4!=0){
            return false;
        } else{
            int edge=sum/4;
            return msHelper(edge, count, 0, 0);
        }
    }

    private static boolean msHelper(int edge, TreeMap<Integer, Integer> count, int cur, int finished){
        if(cur==edge && finished==3){
            return true;
        } else{
            if(cur==edge){
                cur=0;
                finished++;
                return msHelper(edge, count, cur, finished);
            } else{
                int remain=edge-cur;
                Integer possible=count.floorKey(remain);
                boolean result=false;
                if(possible==null){
                    return result;
                } else{
                    for(int key: count.descendingKeySet()){
                        if(key<=possible && count.get(key)>0){
                            count.put(key, count.get(key)-1);
                            if(msHelper(edge, count, cur+key, finished)){
                                result=true;
                            }
                            count.put(key, count.get(key)+1);
                            if(result){
                                break;
                            }
                        }
                    }
                    return result;
                }
            }
        }
    }
}
