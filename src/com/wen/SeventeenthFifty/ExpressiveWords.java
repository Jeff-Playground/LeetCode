package com.wen.SeventeenthFifty;

import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        int result=0, l=S.length();
        for(String word: words){
            int i=0, j=0;
            while(i<l){
                if(j<word.length() && S.charAt(i)==word.charAt(j)){
                    j++;
                } else if (i > 0 && S.charAt(i) == S.charAt(i - 1) && i + 1 < l && S.charAt(i) == S.charAt(i + 1)) {
                    i++;
                } else if(!(i > 1 && S.charAt(i) == S.charAt(i - 1) && S.charAt(i)==S.charAt(i-2))){
                    break;
                }
                i++;
            }
            if(i==l && j==word.length()){
                result++;
            }
        }
        return result;
    }

//    public int expressiveWords(String S, String[] words) {
//        if(words.length==0){
//            return 0;
//        }
//        int result=0;
//        if(S.length()==0){
//            for(String word: words){
//                if(word.length()==0){
//                    result++;
//                }
//            }
//        } else{
//            List<Integer> count=new ArrayList<>();
//            List<Character> chars=new ArrayList<>();
//            for(int i=0; i<S.length(); i++){
//                char c=S.charAt(i);
//                if(i==0 || S.charAt(i)!=S.charAt(i-1)){
//                    chars.add(c);
//                    count.add(1);
//                } else{
//                    count.set(count.size()-1, count.get(count.size()-1)+1);
//                }
//            }
//            for(String word: words){
//                int idx=-1, cnt=0;
//                boolean valid=true;
//                for(int i=0; i<word.length()+1; i++){
//                    char c=i<word.length()?word.charAt(i):'$';
//                    if(i==0 || c!=word.charAt(i-1)){
//                        if(idx>=0){
//                            int lastCount=count.get(idx);
//                            if(lastCount!=cnt && (lastCount<cnt || lastCount<3)){
//                                valid=false;
//                                break;
//                            }
//                        }
//                        if(i<word.length() && c!=chars.get(++idx)){
//                            valid=false;
//                            break;
//                        } else{
//                            cnt=1;
//                        }
//                    } else{
//                        cnt++;
//                    }
//                }
//                if(valid && idx==chars.size()-1){
//                    result++;
//                }
//            }
//        }
//        return result;
//    }
}
