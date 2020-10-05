package com.wen.TwelfthFifty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    // The position will be at a point where it has most ends of bricks from all levels
    public static int leastBricks(List<List<Integer>> wall) {
        int l=wall.size();
        Map<Integer, Integer> pos=new HashMap<>();
        for(List<Integer> level: wall){
            int last=0;
            for(int i=0; i<level.size()-1; i++){
                int w=level.get(i);
                pos.put(last+w, pos.getOrDefault(last+w, 0)+1);
                last+=w;
            }
        }
        int count=0;
        for(int key: pos.keySet()){
            count=Math.max(count, pos.get(key));
        }
        return l-count;
    }
}
