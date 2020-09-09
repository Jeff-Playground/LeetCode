package com.wen.TenthFifty;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ZumaGame {
//    // DFS1
//    public int findMinStep(String board, String hand) {
//        int result=Integer.MAX_VALUE;
//        Map<Character, Integer> hMap=new HashMap<>();
//        for(char c: hand.toCharArray()){
//            hMap.put(c, hMap.getOrDefault(c, 0)+1);
//        }
//        result=fmsHelper(board, hMap);
//        return result==Integer.MAX_VALUE?-1:result;
//    }
//
//    private int fmsHelper(String board, Map<Character, Integer> hand){
//        int result=Integer.MAX_VALUE;
//        board=removeConsecutive(board);
//        if(board.isEmpty()){
//            return 0;
//        }
//        for(int left=0, right=0; right<=board.length(); right++){
//            if(right==board.length() || board.charAt(left)!=board.charAt(right)){
//                int need=3-(right-left);
//                char c=board.charAt(left);
//                if(hand.containsKey(c) && hand.get(c)>=need){
//                    hand.put(c, hand.get(c)-need);
//                    int cur=fmsHelper(board.substring(0, left)+board.substring(right), hand);
//                    if(cur!=Integer.MAX_VALUE){
//                        result=Math.min(result, cur+need);
//                    }
//                    hand.put(c, hand.get(c)+need);
//                }
//                left=right;
//            }
//        }
//        return result;
//    }

    // DFS2
    public static int findMinStep(String board, String hand) {
        int result=Integer.MAX_VALUE;
        Set<Character> visited=new HashSet<>();
        for(int i=0; i<hand.length(); i++){
            char c=hand.charAt(i);
            if(!visited.contains(c)){
                visited.add(c);
                for(int j=0; j<board.length(); j++){
                    if(board.charAt(j)==c){
                        StringBuilder newBoard=new StringBuilder(board), newHand=new StringBuilder(hand);
                        newBoard.insert(j, c);
                        newBoard=new StringBuilder(removeConsecutive(newBoard.toString()));
                        if(newBoard.length()==0){
                            return 1;
                        }
                        newHand.deleteCharAt(i);
                        int cur=findMinStep(newBoard.toString(), newHand.toString());
                        if(cur!=-1){
                            result=Math.min(result, cur+1);
                        }
                    }
                }
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
    }

    private static String removeConsecutive(String board){
        for(int left=0, right=0; right<=board.length(); right++){
            if(right==board.length() || board.charAt(left)!=board.charAt(right)){
                if(right-left>=3){
                    return removeConsecutive(board.substring(0, left)+board.substring(right));
                } else{
                    left=right;
                }
            }
        }
        return board;
    }
}
