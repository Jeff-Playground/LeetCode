package com.wen.SixthFifty;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result=new ArrayList<>();
        if(num!=null && !num.isEmpty()){
            addOperatorsDFS(num, target, result, "", 0, 0);
        }
        return result;
    }

    private void addOperatorsDFS(String num, int target, List<String> result, String out, long curValue, long lastNum){
        if(num.isEmpty()){
            if(curValue==target){
                result.add(out);
            }
        } else{
            int l=num.length();
            for(int i=1; i<=l; i++){
                String cur=num.substring(0, i);
                if(cur.length()>1 && cur.startsWith("0")){
                    return;
                } else{
                    long curNum=Long.parseLong(cur);
                    if(out.length()>0){
                        addOperatorsDFS(num.substring(i), target, result, out+'+'+cur, curValue+curNum, curNum);
                        addOperatorsDFS(num.substring(i), target, result, out+'-'+cur, curValue-curNum, -curNum);
                        addOperatorsDFS(num.substring(i), target, result, out+'*'+cur, curValue-lastNum+lastNum*curNum, lastNum*curNum);
                    } else{
                        addOperatorsDFS(num.substring(i), target, result, cur, curValue+curNum, curNum);
                    }
                }
            }
        }
    }
}
