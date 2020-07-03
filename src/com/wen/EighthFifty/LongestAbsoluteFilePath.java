package com.wen.EighthFifty;

import java.util.ArrayList;
import java.util.List;

public class LongestAbsoluteFilePath {
    // Note "\n" and "\t" are treated as 1 character
    public static int lengthLongestPath(String input) {
        String[] lines=input.split("\n");
        List<Integer> levels=new ArrayList<>();
        int result=0;
        for(String line: lines){
            int lastTab=line.lastIndexOf("\t");
            int level=lastTab+1;
            int length=lastTab==-1?line.length():line.length()-1-lastTab;
            if(!line.contains(".")){
                if(levels.size()>level){
                    levels.set(level, length);
                } else{
                    levels.add(length);
                }
            } else{
                int pathLength=0;
                for(int i=0; i<level; i++){
                    pathLength+=levels.get(i)+1;
                }
                pathLength+=length;
                result=Math.max(result, pathLength);
            }
        }
        return result;
    }
}
