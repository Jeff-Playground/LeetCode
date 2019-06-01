package com.wen.ThirteenthFifty;

public class SolveTheEquation {
    public String solveEquation(String equation) {
        if(equation==null || equation.length()==0 || equation.indexOf('=')==-1){
            throw new IllegalArgumentException("Invalid equation!");
        }
        String result="";
        int pos=1, left=1;
        String last="";
        int v=0, x=0, l=equation.length();
        for(int i=0; i<=l; i++){
            if(i==l || equation.charAt(i)=='+' || equation.charAt(i)=='-' || equation.charAt(i)=='='){
                if(!last.isEmpty()){
                    if(last.endsWith("x")){
                        last=last.substring(0, last.length()-1);
                        x+=left*pos*(last.isEmpty()?1:Integer.parseInt(last));
                    } else{
                        v+=left*pos*(Integer.parseInt(last));
                    }
                }
                last="";
                pos=1;
                if(i<l && equation.charAt(i)=='-'){
                    pos=-1;
                }
                if(i<l && equation.charAt(i)=='='){
                    left=-1;
                }
            } else{
                last+=equation.charAt(i);
            }
        }
        if(x==0 && v==0){
            result="Infinite solutions";
        } else if(x==0 && v!=0){
            result="No solution";
        } else{
            result="x="+(-v/x);
        }
        return result;
    }
}
