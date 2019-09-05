package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {
//    public static List<String> fullJustify(String[] words, int maxWidth) {
//        List<String> result = new ArrayList<>();
//        if (words == null || words.length == 0) {
//            return result;
//        }
//        int l=words.length, i=0;
//        StringBuilder line=new StringBuilder();
//        while(i<l){
//            line.setLength(0);
//            int start=i, end=i+1, length=words[start].length();
//            while(end<l && length<=maxWidth){
//                length+=1+words[end++].length();
//            }
//            if(end<l || length>maxWidth){
//                end--;
//                if(end>start){
//                    length-=1+words[end--].length();
//                }
//                int count=end-start+1, spaces=maxWidth-length+count-1;
//                line.append(words[start++]);
//                if(count>1){
//                    int sep=spaces/(count-1), remain=spaces%(count-1);
//                    while(start<=end){
//                        int spCount=sep+((remain-->0)?1:0);
//                        while(spCount-->0){
//                            line.append(" ");
//                        }
//                        line.append(words[start++]);
//                    }
//                } else{
//                    int spCount=spaces;
//                    while(spCount-->0){
//                        line.append(" ");
//                    }
//                }
//            } else{
//                line.append(words[start++]);
//                while(start<end){
//                    line.append(" ");
//                    line.append(words[start++]);
//                }
//                int spCount=maxWidth-length;
//                while(spCount-->0){
//                    line.append(" ");
//                }
//            }
//            result.add(line.toString());
//            i=end+1;
//        }
//        return result;
//    }

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
