package com.wen.NineteenthFifty;

public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] A) {
        int result=0;
        if(A==null || A.length<=1){
            return result;
        }
        for(int j=0; j<A[0].length(); j++){
            boolean delete=false;
            for(int i=1; i<A.length; i++){
                if(A[i].charAt(j)<A[i-1].charAt(j)){
                    delete=true;
                    break;
                }
            }
            if(delete){
                result++;
            }
        }
        return result;
    }
}
