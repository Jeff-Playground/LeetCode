package com.wen.NinthFifty;

public class SentenceScreenFitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        StringBuilder sen=new StringBuilder();
        for(String word: sentence){
            sen.append(word+" ");
        }
        int l=sen.length(), n=sentence.length;
        int idx=0, result=0;
        for(int i=0; i<rows; i++){
            int colRemain=cols;
            while(colRemain>0){
                if(sentence[idx].length()<=colRemain){
                    colRemain-=sentence[idx].length();
                    if(colRemain>0){
                        colRemain--;
                    }
                    if(++idx==n){
                        result+=1+colRemain/l;
                        colRemain%=l;
                        idx=0;
                    }
                } else{
                    break;
                }
            }
        }
        return result;
    }

//    public int wordsTyping(String[] sentence, int rows, int cols) {
//        StringBuilder sen=new StringBuilder();
//        for(String word: sentence){
//            sen.append(word+" ");
//        }
//        int l=sen.length();
//        int cur=0;
//        for(int i=0; i<rows; i++){
//            cur+=cols;
//            if(sen.charAt(cur%l)==' '){
//                cur++;
//            } else{
//                while(cur>0 && sen.charAt((cur-1)%l)!=' '){
//                    cur--;
//                }
//            }
//        }
//        return cur/l;
//    }
}
