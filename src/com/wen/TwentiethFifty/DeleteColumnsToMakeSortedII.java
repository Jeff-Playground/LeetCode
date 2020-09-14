package com.wen.TwentiethFifty;

import java.util.HashSet;
import java.util.Set;

public class DeleteColumnsToMakeSortedII {
//    // Greedy2
//    public int minDeletionSize(String[] A) {
//        if(A==null || A.length<=1){
//            return 0;
//        }
//        int result=0, m=A.length, n=A[0].length();
//        int[] sorted=new int[m];
//        for(int j=0; j<n; j++){
//            boolean inOrder=true;
//            for(int i=1; i<m; i++){
//                if(sorted[i]==0 && A[i-1].charAt(j)>A[i].charAt(j)){
//                    result++;
//                    inOrder=false;
//                    break;
//                }
//            }
//            if(inOrder){
//                for(int i=1; i<m; i++){
//                    if(sorted[i]==0 && A[i-1].charAt(j)<A[i].charAt(j)){
//                        sorted[i]=1;
//                    }
//                }
//            }
//        }
//        return result;
//    }

    // Greedy1
    public static int minDeletionSize(String[] A) {
        if(A==null || A.length<=1){
            return 0;
        }
        Set<Integer> deleted=new HashSet<>();
        for(int j=0; j<A[0].length(); j++){
            boolean inOrder=true;
            for(int i=1; i<A.length; i++){
                if(A[i-1].charAt(j)>A[i].charAt(j)){
                    int t=j-1;
                    while(t>=0 && (deleted.contains(t) || A[i-1].charAt(t)>=A[i].charAt(t))){
                        t--;
                    }
                    if(t==-1){
                        deleted.add(j);
                        inOrder=false;
                        break;
                    }
                } else if(A[i].charAt(j)==A[i-1].charAt(j)){
                    int t=j-1;
                    while(t>=0 && (deleted.contains(t) || A[i-1].charAt(t)>=A[i].charAt(t))){
                        t--;
                    }
                    if(t==-1){
                        inOrder=false;
                    }
                }
            }
            if(inOrder){
                break;
            }
        }
        return deleted.size();
    }
}
