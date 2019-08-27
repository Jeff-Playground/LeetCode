package com.wen.SeventeenthFifty;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        int i=S.length()-1, j=T.length()-1, cnt1=0, cnt2=0;
        while(i>=0 || j>=0){
            while(i>=0 && (S.charAt(i)=='#' || cnt1>0)){
                if(S.charAt(i)=='#'){
                    cnt1++;
                } else{
                    cnt1--;
                }
                i--;
            }
            while(j>=0 && (T.charAt(j)=='#' || cnt2>0)){
                if(T.charAt(j)=='#'){
                    cnt2++;
                } else{
                    cnt2--;
                }
                j--;
            }
            if(i<0 || j<0){
                return i==j;
            }
            if(S.charAt(i--)!=T.charAt(j--)){
                return false;
            }
        }
        return i==j;
    }

//    public boolean backspaceCompare(String S, String T) {
//        return backspaceCompareHelper(S).equals(backspaceCompareHelper(T));
//    }
//
//    private String backspaceCompareHelper(String S){
//        StringBuilder sb=new StringBuilder();
//        for(char c: S.toCharArray()){
//            if(c=='#'){
//                if(sb.length()>0){
//                    sb.setLength(sb.length()-1);
//                }
//            } else{
//                sb.append(c);
//            }
//        }
//        return sb.toString();
//    }
}
