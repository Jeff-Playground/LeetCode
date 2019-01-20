package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result=new ArrayList<String>();
        if(words==null || words.length==0){
            return result;
        }
        int l=words.length, start=0, count=0, line=0, i=0;
        while(i<l){
            int pad=count==0?0:1;
            if(line+pad+words[i].length()<=maxWidth){
                line=line+pad+words[i].length();
                count++;
                i++;
            } else{
                String parsedLine="";
                if(count==1){
                    int sep=maxWidth-line;
                    char[] charArray = new char[sep];
                    Arrays.fill(charArray, ' ');
                    String spaces = new String(charArray);
                    parsedLine=words[start]+spaces;
                } else{
                    int sep=(maxWidth-line+count-1)/(count-1);
                    int remain=(maxWidth-line+count-1)-sep*(count-1);
                    char[] charArray = new char[sep];
                    Arrays.fill(charArray, ' ');
                    String spaces = new String(charArray);
                    parsedLine=words[start];
                    for(int j=start+1; j<i; j++){
                        if(remain==0){
                            parsedLine+=spaces+words[j];
                        } else{
                            parsedLine+=" "+spaces+words[j];
                            remain--;
                        }
                    }
                }
                result.add(parsedLine);
                start=i;
                line=0;
                count=0;
            }
        }
        if(i==l){
            int last=maxWidth-line;
            char[] charArray = new char[last];
            Arrays.fill(charArray, ' ');
            String spaces = new String(charArray);
            String parsedLine=words[start];
            for(int j=start+1; j<i; j++){
                parsedLine+=" "+words[j];
            }
            parsedLine+=spaces;
            result.add(parsedLine);
        }
        return result;
    }
}
