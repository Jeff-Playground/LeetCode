package com.wen.SeventhFifty;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        String dept="JFK";
        List<String> result=new ArrayList<>();
        Map<String, PriorityQueue<String>> map=new HashMap<>();
        for(List<String> ticket: tickets) {
            String orig=ticket.get(0);
            String dest=ticket.get(1);
            PriorityQueue<String> dests=map.getOrDefault(orig, new PriorityQueue<>((a, b)->(a.compareTo(b))));
            dests.add(dest);
            map.putIfAbsent(orig, dests);
        }
        Stack<String> stack=new Stack<>();
        stack.push(dept);
        while(!stack.isEmpty()) {
            String orig=stack.peek();
            if(map.get(orig)==null || map.get(orig).size()==0) {
                result.add(orig);
                stack.pop();
            } else {
                stack.push(map.get(orig).poll());
            }
        }
        Collections.reverse(result);
        return result;
    }

//    // DFS to find euler path
//    public List<String> findItinerary(List<List<String>> tickets) {
//        String dept="JFK";
//        List<String> result=new ArrayList<>();
//        Map<String, PriorityQueue<String>> map=new HashMap<>();
//        for(List<String> ticket: tickets) {
//            String orig=ticket.get(0);
//            String dest=ticket.get(1);
//            PriorityQueue<String> dests=map.getOrDefault(orig, new PriorityQueue<>((a, b)->(a.compareTo(b))));
//            dests.add(dest);
//            map.put(orig, dests);
//        }
//        findItineraryDFS(map, dept, result);
//        Collections.reverse(result);
//        return result;
//    }
//
//    private void findItineraryDFS(Map<String, PriorityQueue<String>> map, String dept, List<String> result) {
//        while(map.get(dept)!=null && map.get(dept).size()>0) {
//            String dest=map.get(dept).poll();
//            findItineraryDFS(map, dest, result);
//        }
//        result.add(dept);
//    }
}
