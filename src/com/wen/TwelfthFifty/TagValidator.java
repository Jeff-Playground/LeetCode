package com.wen.TwelfthFifty;

import java.util.Stack;

public class TagValidator {
    public static boolean isValid(String code) {
        Stack<String> stack=new Stack<>();
        for(int i=0; i<code.length(); i++){
            if(i>0 && stack.isEmpty()){
                return false;
            }
            if(i+9<code.length() && code.substring(i, i+9).equals("<![CDATA[")){
                int j=i+9;
                i=code.indexOf("]]>", j);
                if(i==-1){
                    return false;
                } else{
                    i+=2;
                }
            } else if(i+2<code.length() && code.substring(i, i+2).equals("</")){
                int j=i+2;
                i=code.indexOf(">", j);
                if(i==-1){
                    return false;
                } else{
                    String tag=code.substring(j, i);
                    if(stack.isEmpty() || !stack.pop().equals(tag)){
                        return false;
                    }
                }
            } else if(i+1<code.length() && code.substring(i, i+1).equals("<")){
                int j=i+1;
                i=code.indexOf(">", j);
                if(i<0 || i==j || i-j>9){
                    return false;
                } else{
                    for(int k=j; k<i; k++){
                        if(code.charAt(k)<'A' || code.charAt(k)>'Z'){
                            return false;
                        }
                    }
                    String tag=code.substring(j, i);
                    stack.push(tag);
                }
            }
        }
        return stack.isEmpty();
    }

//    // Brute force
//    public static boolean isValid(String code) {
//        if(code==null || code.isEmpty()){
//            return false;
//        } else{
//            int startLeft=code.indexOf("<"), startRight=code.indexOf(">");
//            int endLeft=code.lastIndexOf("</"), endRight=code.lastIndexOf(">");
//            if(startLeft==0 && startRight>startLeft && startRight<endLeft && endRight>endLeft && endRight==code.length()-1){
//                String tagName=code.substring(startLeft+1, startRight);
//                if(tagName.equals(code.substring(endLeft+2, endRight))){
//                    if(isValidTagName(tagName)){
//                        String tagContent=code.substring(startRight+1, endLeft).trim();
//                        return isValidTagContent(tagContent);
//                    } else{
//                        return false;
//                    }
//                } else{
//                    return false;
//                }
//            } else{
//                return false;
//            }
//        }
//    }
//
//    private static boolean isValidTagContent(String tagContent){
//        if(!tagContent.isEmpty()){
//            int cdataLeft=tagContent.indexOf("<![CDATA[");
//            if(cdataLeft!=-1){
//                int cdataRight=tagContent.indexOf("]]>", cdataLeft+9);
//                if(cdataRight==-1){
//                    return false;
//                } else{
//                    return isValidTagContent(tagContent.substring(0, cdataLeft)+tagContent.substring(cdataRight+3));
//                }
//            } else{
//                int startLeft=tagContent.indexOf("<");
//                if(startLeft!=-1){
//                    int startRight=tagContent.indexOf(">", startLeft+1);
//                    if(startRight!=-1){
//                        String tagName=tagContent.substring(startLeft+1, startRight);
//                        if(isValidTagName(tagName)){
//                            String startTag="<"+tagName+">", endTag="</"+tagName+">";
//                            int endIdx=tagContent.indexOf(endTag, startRight+1);
//                            if(endIdx!=-1){
//                                int startIdx=tagContent.lastIndexOf(startTag, endIdx);
//                                if(isValidTagContent(tagContent.substring(startIdx+startTag.length(), endIdx))){
//                                    return isValidTagContent(tagContent.substring(startLeft, startIdx)
//                                            +tagContent.substring(endIdx+endTag.length()));
//                                } else{
//                                    return false;
//                                }
//                            } else{
//                                return false;
//                            }
//                        } else{
//                            return false;
//                        }
//                    } else{
//                        return false;
//                    }
//                } else{
//                    return true;
//                }
//            }
//        }
//        return true;
//    }
//
//    private static boolean isValidTagName(String tagName){
//        int l=tagName.length();
//        if(l<1 || l>9){
//            return false;
//        } else{
//            for(char c: tagName.toCharArray()){
//                if(c<'A' || c>'Z'){
//                    return false;
//                }
//            }
//            return true;
//        }
//    }
}
