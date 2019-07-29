package com.wen.EighthFifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s==null || t==null || s.length()>t.length()){
            return false;
        }
        int sl=s.length(), tl=t.length();
        Map<Character, List<Integer>> tMap=new HashMap<>();
        for(int i=0; i<tl; i++){
            List<Integer> list=tMap.get(t.charAt(i));
            if(list==null){
                list=new ArrayList<>();
                tMap.put(t.charAt(i),list);
            }
            list.add(i);
        }
        int prev=-1;
        for (int i=0; i<sl; i++) {
            List<Integer> list=tMap.get(s.charAt(i));
            if(list==null){
                return false;
            } else{
                int left=0, right=list.size()-1;
                while(left<=right){
                    int mid=left+(right-left)/2;
                    if(list.get(mid)<=prev){
                        left=mid+1;
                    } else{
                        right=mid-1;
                    }
                }
                if(left>list.size()-1){
                    return false;
                } else{
                    prev=list.get(left);
                }
            }
        }
        return true;
    }

//    public boolean isSubsequence(String s, String t) {
//        if(s==null || t==null || s.length()>t.length()){
//            return false;
//        }
//        int sl=s.length(), tl=t.length();
//        int i=0, j=0;
//        while(i<sl && j<tl){
//            while(j<tl && t.charAt(j)!=s.charAt(i)){
//                j++;
//            }
//            if(j==tl){
//                break;
//            }
//            i++;
//            j++;
//        }
//        return i==sl;
//    }

//    public boolean isSubsequence(String s, String t) {
//        if(t==null || s==null || s.length()>t.length()) {
//            return false;
//        }
//        int sl=s.length(), tl=t.length();
//        boolean[][] dp=new boolean[sl+1][tl+1];
//        for(int j=0; j<=tl; j++) {
//            dp[0][j]=true;
//        }
//        for(int i=1; i<=sl; i++) {
//            for(int j=1; j<=tl; j++) {
//                if(i<=j) {
//                    dp[i][j]=dp[i][j-1] || (dp[i-1][j-1] && s.charAt(i-1)==t.charAt(j-1));
//                }
//            }
//        }
//        return dp[sl][tl];
//    }
}
