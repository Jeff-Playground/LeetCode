package com.wen.SecondFifty;

import java.util.*;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> result=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        set.add(0);
        result.add(0);
        while(!stack.isEmpty()){
            int t=stack.pop();
            for(int i=0; i<n; i++){
                int temp=t;
                if((temp & (1<<i))==0){
                    temp|=(1<<i);
                }else{
                    temp&=~(1<<i);
                }
                if(set.contains(temp)){
                    continue;
                }
                set.add(temp);
                stack.push(temp);
                result.add(temp);
                break;
            }
        }
        return result;
    }

//    public List<Integer> grayCode(int n) {
//        List<Integer> result=new ArrayList<>();
//        Set<Integer> set=new HashSet<>();
//        helper(n, set, 0, result);
//        return result;
//    }
//
//    private void helper(int n, Set<Integer> set, int out, List<Integer> result) {
//        if(!set.contains(out)){
//            set.add(out);
//            result.add(out);
//        }
//        for(int i=0; i<n; i++){
//            int temp=out;
//            if((temp & (1<<i))==0){
//                temp|=(1<<i);
//            }else{
//                temp&=~(1<<i);
//            }
//            if(set.contains(temp)){
//                continue;
//            }
//            helper(n, set, temp, result);
//            break;
//        }
//    }

//    // Mirror arrangement
//    public List<Integer> grayCode(int n) {
//        List<Integer> result=new ArrayList<>();
//        result.add(0);
//        for(int i=0; i<n; i++){
//            int size=result.size();
//            for(int j=size-1; j>=0; j--){
//                result.add(result.get(j) | 1<<i);
//            }
//        }
//        return result;
//    }

//    // Binary to gray code
//    public List<Integer> grayCode(int n) {
//        List<Integer> result=new ArrayList<>();
//        for(int i=0; i<Math.pow(2,n); i++){
//            result.add((i>>1)^i);
//        }
//        return result;
//    }
}
