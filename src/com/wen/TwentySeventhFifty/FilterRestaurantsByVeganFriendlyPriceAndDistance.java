package com.wen.TwentySeventhFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FilterRestaurantsByVeganFriendlyPriceAndDistance {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> result=new ArrayList<>();
        int l=restaurants.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->restaurants[a][1]!=restaurants[b][1]?restaurants[b][1]-restaurants[a][1]:restaurants[b][0]-restaurants[a][0]);
        for(int i=0; i<l; i++){
            int[] r=restaurants[i];
            if((veganFriendly==0 || r[2]==veganFriendly) && r[3]<=maxPrice && r[4]<=maxDistance){
                pq.offer(i);
            }
        }
        while(!pq.isEmpty()){
            result.add(restaurants[pq.poll()][0]);
        }
        return result;
    }
}
