package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result=new ArrayList<>();
        int l=words.length;
        int curWidth=0, start=0;
        for(int i=0; i<l; i++){
            if(curWidth==0){
                curWidth+=words[i].length();
                start=i;
            } else{
                if(curWidth+words[i].length()+1<=maxWidth){
                    curWidth+=words[i].length()+1;
                } else{
                    result.add(formLine(words, start, i-1, curWidth, maxWidth, true));
                    curWidth=words[i].length();
                    start=i;
                }
            }
        }
        result.add(formLine(words, start, l-1, curWidth, maxWidth, false));
        return result;
    }

    private String formLine(String[] words, int start, int end, int curWidth, int maxWidth, boolean notLastLine){
        StringBuilder sb=new StringBuilder();
        if(start==end){
            sb.append(words[start]);
            int spaceCount=maxWidth-curWidth;
            while(spaceCount-->0){
                sb.append(" ");
            }
        } else{
            int wordCount=end-start+1;
            if(notLastLine){
                int spaceCount=maxWidth-curWidth+wordCount-1;
                int extraSpaceCount=spaceCount%(wordCount-1), averageSpaceCount=spaceCount/(wordCount-1);
                for(int i=start; i<=end; i++){
                    sb.append(words[i]);
                    int temp=averageSpaceCount;
                    while(temp-->0){
                        sb.append(" ");
                    }
                    if(extraSpaceCount-->0){
                        sb.append(" ");
                    }
                }
                sb.setLength(sb.length()-averageSpaceCount);
            } else{
                int spaceCount=maxWidth-curWidth+wordCount-1;
                for(int i=start; i<=end; i++){
                    sb.append(words[i]+" ");
                    spaceCount--;
                }
                if(spaceCount<0){
                    sb.setLength(sb.length()-1);
                } else{
                    while(spaceCount-->0){
                        sb.append(" ");
                    }
                }
            }
        }
        return sb.toString();
    }
}
