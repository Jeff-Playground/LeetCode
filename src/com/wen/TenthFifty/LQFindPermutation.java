package com.wen.TenthFifty;

public class LQFindPermutation {
    public static int[] findPermutation(String s) {
        int l=s.length(), n=l+1;
        int[] result=new int[n];
        int idx=0, iCount=0, dCount=0;
        boolean hasD=false;
        for(int i=0; i<=l; i++){
            char c=i<l?s.charAt(i):'$';
            if(c=='I' || c=='$'){
                if(hasD){
                    int min=idx+1, max=idx+iCount+dCount+1;
                    int mid=min+iCount;
                    for(int j=min; j<mid; j++){
                        result[idx++]=j;
                    }
                    for(int j=max; j>=mid; j--){
                        result[idx++]=j;
                    }
                    hasD=false;
                    // Note here assign iCount to be -1 because this I is included in the result already
                    iCount=-1;
                    dCount=0;
                } else if(c=='$'){
                    int min=idx+1, max=idx+iCount+dCount+1;
                    for(int j=min; j<=max; j++){
                        result[idx++]=j;
                    }
                }
                iCount++;
            } else{
                hasD=true;
                dCount++;
            }
        }
        return result;
    }
}
