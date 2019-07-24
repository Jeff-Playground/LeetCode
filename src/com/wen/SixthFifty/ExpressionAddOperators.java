package com.wen.SixthFifty;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result=new ArrayList<>();
        if(num==null){
            return result;
        }
        addOperatorsDFS(num, target, "", 0, 0, result);
        return result;
    }

    public void addOperatorsDFS(String num, int target, String out, long pre, long lastNum, List<String> result){
        if(num.length()==0 && pre==target){
            result.add(out);
        }
        int l=num.length();
        for(int i=1; i<=l; i++){
            String curString=num.substring(0,i);
            if(curString.length()>1 && curString.startsWith("0")){
                return;
            }
            String remainString=num.substring(i);
            long cur=Long.parseLong(curString);
            if(out.length()>0){
                addOperatorsDFS(remainString, target, out+"+"+curString, pre+cur, cur, result);
                addOperatorsDFS(remainString, target, out+"-"+curString, pre-cur, -cur, result);
                addOperatorsDFS(remainString, target, out+"*"+curString, pre-lastNum+lastNum*cur, lastNum*cur, result);
            } else {
                addOperatorsDFS(remainString, target, curString, cur, cur, result);
            }
        }
    }
}
