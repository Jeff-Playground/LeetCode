package com.wen.ThirteenthFifty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers {
//    // DFS with backtracking
//    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
//        int[] cache=new int[2];
//        cache[0]=0;
//        cache[1]=Integer.MAX_VALUE;
//        soHelper(price, special, needs, cache, 0);
//        return cache[1];
//    }
//
//    private static void soHelper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int[] cache, int idx){
//        if(idx<special.size()){
//            List<Integer> curSpecial=special.get(idx);
//            boolean valid=true;
//            for(int j=0; j<needs.size(); j++){
//                if(curSpecial.get(j)>needs.get(j)){
//                    valid=false;
//                    break;
//                }
//            }
//            if(valid){
//                for(int j=0; j<needs.size(); j++){
//                    needs.set(j, needs.get(j)-curSpecial.get(j));
//                }
//                cache[0]+=curSpecial.get(needs.size());
//                soHelper(price, special, needs, cache, idx);
//                cache[0]-=curSpecial.get(needs.size());
//                for(int j=0; j<needs.size(); j++){
//                    needs.set(j, needs.get(j)+curSpecial.get(j));
//                }
//                soHelper(price, special, needs, cache, idx);
//            } else{
//                soHelper(price, special, needs, cache, idx+1);
//            }
//        } else{
//            for(int i=0; i<needs.size(); i++){
//                cache[0]+=needs.get(i)*price.get(i);
//            }
//            cache[1]=Math.min(cache[1], cache[0]);
//            for(int i=0; i<needs.size(); i++){
//                cache[0]-=needs.get(i)*price.get(i);
//            }
//        }
//    }

//    // DFS with backtracking
//    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
//        int l=price.size(), m=special.size(), result=0;
//        for(int i=0; i<l; i++){
//            result+=price.get(i)*needs.get(i);
//        }
//        for(int i=0; i<m; i++){
//            boolean valid=true;
//            List<Integer> curSpecial=special.get(i);
//            for(int j=0; j<l; j++){
//                if(curSpecial.get(j)>needs.get(j)){
//                    valid=false;
//                    break;
//                }
//            }
//            if(valid){
//                for(int j=0; j<l; j++){
//                    needs.set(j, needs.get(j)-curSpecial.get(j));
//                }
//                result=Math.min(result, shoppingOffers(price, special, needs)+curSpecial.get(l));
//                for(int j=0; j<l; j++){
//                    needs.set(j, needs.get(j)+curSpecial.get(j));
//                }
//            }
//        }
//        return result;
//    }

    // DFS backtracking with memorization
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return soHelper(price, special, needs, new HashMap<>());
    }

    private static int soHelper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<String, Integer> cache){
        int result=0, l=price.size();
        StringBuilder key=new StringBuilder();
        for(int i=0; i<l; i++){
            result+=price.get(i)*needs.get(i);
            key.append(needs.get(i)+",");
        }
        if(cache.containsKey(key.toString())){
            return cache.get(key.toString());
        } else{
            for(List<Integer> offer: special){
                boolean valid=true;
                for(int i=0; i<l; i++){
                    if(offer.get(i)>needs.get(i)){
                        valid=false;
                        break;
                    }
                }
                if(valid){
                    for(int i=0; i<l; i++){
                        needs.set(i, needs.get(i)-offer.get(i));
                    }
                    result=Math.min(result, soHelper(price, special, needs, cache)+offer.get(l));
                    for(int i=0; i<l; i++){
                        needs.set(i, needs.get(i)+offer.get(i));
                    }
                }
            }
            cache.put(key.toString(), result);
            return result;
        }
    }
}
