package com.wen.FirstFifty;

import java.util.*;

public class CombinationSum {
//    // Add candidates without sorting
//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> result=new ArrayList<>();
//        if(candidates==null || candidates.length==0){
//            return result;
//        }
//        List<Integer> out=new ArrayList<>();
//        combinationSumDFS(candidates, target, 0, out, result);
//        return result;
//    }
//
//    public static void combinationSumDFS(int[] candidates, int target, int start, List<Integer> out, List<List<Integer>> result){
//        if(target<0){
//            return;
//        } else if(target==0){
//            List<Integer> temp=new ArrayList<>(out);
//            result.add(temp);
//        } else{
//            for(int i=start; i<candidates.length; i++){
//                out.add(candidates[i]);
//                combinationSumDFS(candidates, target-candidates[i], i, out, result);
//                out.remove(out.size()-1);
//            }
//        }
//    }

    // Sort first then add candidates, more efficient
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        combinationSumHelper(candidates, target, new ArrayList<>(), 0, result);
        return result;
    }

    private static void combinationSumHelper(int[] candidates, int target, List<Integer> cur, int i, List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(cur));
        } else if(i<candidates.length){
            int max=target/candidates[i];
            if(max>0){
                for(int count=0; count<=max; count++){
                    if(count>0){
                        cur.add(candidates[i]);
                    }
                    combinationSumHelper(candidates, target-count*candidates[i], cur, i+1, result);
                }
                while(max-->0){
                    cur.remove(cur.size()-1);
                }
            }
        }
    }

//    // Like knapsack
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Map<Integer, List<List<Integer>>> dp=new HashMap<>();
//        dp.put(0, new ArrayList<>());
//        dp.get(0).add(new ArrayList<>());
//        Arrays.sort(candidates);
//        for(int i=1; i<=target; i++){
//            for(int j=0; j<candidates.length; j++){
//                int c=candidates[j];
//                if(c<=i){
//                    if(dp.containsKey(i-c)){
//                        List<List<Integer>> prev=dp.get(i-c);
//                        dp.putIfAbsent(i, new ArrayList<>());
//                        for(List<Integer> p: prev){
//                            // Note this is required to avoid permutation distinct duplicates
//                            if(p.isEmpty() || c>=p.get(p.size()-1)){
//                                List<Integer> cur=new ArrayList<>(p);
//                                cur.add(c);
//                                dp.get(i).add(cur);
//                            }
//                        }
//                    }
//                } else{
//                    break;
//                }
//            }
//        }
//        return dp.containsKey(target)?dp.get(target):new ArrayList<>();
//    }
}
