package com.wen.ThirtythFifty;

import java.util.*;

public class PathCrossing {
    public boolean isPathCrossing(String path) {
        if(path==null || path.length()<=1){
            return false;
        }
        Map<Character, int[]> move=new HashMap<>();
        move.put('N', new int[]{1, 0});
        move.put('S', new int[]{-1, 0});
        move.put('E', new int[]{0, 1});
        move.put('W', new int[]{0, -1});
        Set<List<Integer>> visited=new HashSet<>();
        List<Integer> cur=Arrays.asList(0,0);
        visited.add(cur);
        for(int i=0; i<path.length(); i++){
            char c=path.charAt(i);
            int[] curMove=move.get(c);
            List<Integer> next=Arrays.asList(cur.get(0)+curMove[0], cur.get(1)+curMove[1]);
            if(visited.contains(next)){
                return true;
            } else{
                visited.add(next);
                cur=next;
            }
        }
        return false;
    }
}
