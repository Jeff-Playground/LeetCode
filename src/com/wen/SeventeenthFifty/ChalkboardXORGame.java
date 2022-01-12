package com.wen.SeventeenthFifty;

import java.util.HashMap;
import java.util.Map;

public class ChalkboardXORGame {
    // As long as the count of the numbers is even and xorAll!=0, it means there are different numbers otherwise xorAll
    // would be equal to 0 as equal numbers cancel out each other with xor. Therefore, the guaranteed winning trick is to
    // erase any number NOT equal to xorAll so the array after the erase still have a non-zero xor value. Because there
    // are even numbers of items, whoever erase the last number loses.
    // The idea is similar when the count is odd, except this time the first person to act is the last person to act.
    public boolean xorGame(int[] nums) {
        int xorAll=0;
        for(int num: nums){
            xorAll^=num;
        }
        return xorAll==0 || nums.length%2==0;
    }

//    // Minimax with cache, but still TLE
//    public boolean xorGame(int[] nums) {
//        int xorAll=0;
//        StringBuilder sb=new StringBuilder();
//        for(int num: nums){
//            xorAll^=num;
//            sb.append("0");
//        }
//        return xgHelper(nums, sb.toString(), nums.length, xorAll, new HashMap<>());
//    }
//
//    private boolean xgHelper(int[] nums, String status, int remain, int curXor, Map<String, Boolean> cache){
//        if(!cache.containsKey(status)){
//            if(remain==0 || curXor==0){
//                cache.put(status, true);
//            } else if(remain==1){
//                for(int i=0; i<status.length(); i++){
//                    if(status.charAt(i)=='0'){
//                        cache.put(status, nums[i]==0);
//                    }
//                }
//            } else{
//                boolean opponentCanWin=true;
//                for(int i=0; i<status.length(); i++){
//                    if(status.charAt(i)=='0'){
//                        opponentCanWin=xgHelper(nums, status.substring(0, i)+"1"+status.substring(i+1), remain-1, curXor^nums[i], cache);
//                        if(!opponentCanWin){
//                            break;
//                        }
//                    }
//                }
//                cache.put(status, !opponentCanWin);
//            }
//        }
//        return cache.get(status);
//    }
}
