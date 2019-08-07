package com.wen.FifteenthFifty;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
    public static List<String> removeComments(String[] source) {
        List<String> result=new ArrayList<>();
        int l=source.length;
        boolean isBlockComment=false;
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<l; i++){
            String line=source[i];
            for(int j=0; j<line.length(); j++){
                char c=line.charAt(j);
                String cur=""+c+(j<line.length()-1?line.charAt(j+1):"");
                if(isBlockComment){
                    if(!cur.equals("*/")){
                        continue;
                    } else{
                        isBlockComment=false;
                        j++;
                    }
                } else{
                    if(cur.equals("/*")){
                        isBlockComment=true;
                        j++;
                    } else if(cur.equals("//")){
                        break;
                    } else{
                        sb.append(c);
                    }
                }
            }
            if(sb.length()>0 && !isBlockComment){
                result.add(sb.toString());
                sb.setLength(0);
            }
        }
        return result;
    }
}
