package com.wen.Airbnb;

import java.util.*;

public class DisplayPage {
    public static void main(String args[]) {
        //hostId, ListId, points, city
        List<String> input = new ArrayList<>();
        input.add("1,28,310.6,SF");
        input.add("1,5,204.1,SF");
        input.add("20,7,203.2,Oakland");
        input.add("6,8,202.2,SF");
        input.add("6,10,199.1,SF");
        input.add("1,16,190.4,SF");
        input.add("6,29,185.2,SF");
        input.add("7,20,180.1,SF");
        input.add("6,21,162.1,SF");
        input.add("2,18,161.2,SF");
        input.add("2,30,149.1,SF");
        input.add("3,76,146.2,SF");
        input.add("2,14,141.1,San Jose");

        List<String> result = displayPages(input, 5);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

//    public static List<String> displayPages(List<String> input, int pageSize) {
//        List<String> result=new ArrayList<>();
//        if(input==null || input.size()==0){
//            return result;
//        }
//        int l=input.size();
//        Iterator<String> it=input.iterator();
//        Set<String> curPage=new HashSet<>();
//        int count=0;
//        while(it.hasNext()){
//            if(count==pageSize){
//                count=0;
//                curPage.clear();
//                it=input.iterator();
//            }
//            String entry=it.next();
//            String hostId=entry.split(",")[0];
//            if(!curPage.contains(hostId)){
//                curPage.add(hostId);
//                it.remove();
//                result.add(entry);
//                count++;
//            }
//            if(!it.hasNext() && result.size()<l){
//                it=input.iterator();
//                curPage.clear();
//            }
//        }
//        return result;
//    }

    public static List<String> displayPages(List<String> input, int pageSize) {
        List<String> result=new ArrayList<>();
        if(input==null || input.size()==0){
            return result;
        }
        int l=input.size();
        Set<Integer> visited=new HashSet<>();
        int count=0;
        while(visited.size()<l){
            Set<String> curPage=new HashSet<>();
            for(int i=0; i<l; i++){
                if(count==pageSize){
                    break;
                }
                if(visited.contains(i)){
                    continue;
                }
                String hostId=input.get(i).split(",")[0];
                if(!curPage.contains(hostId)){
                    curPage.add(hostId);
                    result.add(input.get(i));
                    visited.add(i);
                    count++;
                }
            }
            if(count==pageSize){
                count=0;
            }
        }
        return result;
    }
}
