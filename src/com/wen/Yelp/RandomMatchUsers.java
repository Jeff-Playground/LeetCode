package com.wen.Yelp;

import java.util.*;

public class RandomMatchUsers {
    public static void main(String[] args){
        List<String> input= Arrays.asList("Alan", "Da", "Jen", "Kevin", "Neha", "Rachel");
        List<List<String>> result=matchUsers(input);
        result.forEach(e->System.out.println(e.get(0)+"-"+e.get(1)));


    }

    private static List<List<String>> matchUsers(List<String> users){
        List<List<String>> result=new ArrayList<>();
        Random r=new Random();
        int l=users.size();
        for(int i=0; i<l; i++){
            int temp=r.nextInt(l-i)+i;
            if(temp!=i){
                String cur=users.get(i);
                users.set(i, users.get(temp));
                users.set(temp, cur);
            }
        }
        int i=0;
        while(i+1<l){
            result.add(Arrays.asList(users.get(i), users.get(i+1)));
            i+=2;
        }
        return result;
    }
}
