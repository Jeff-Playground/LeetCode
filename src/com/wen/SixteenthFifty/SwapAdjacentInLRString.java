package com.wen.SixteenthFifty;

public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String end) {
        if((start==null && end==null) || (start.length()==0 && start.length()==end.length())){
            return true;
        }
        if(start.length()!=end.length()){
            return false;
        }
        int l=start.length();
        int countL=0, countR=0;
        for(int i=0; i<l; i++){
            if(start.charAt(i)=='R'){
                countR++;
            }
            if(end.charAt(i)=='L'){
                countL++;
            }
            if(end.charAt(i)=='R'){
                countR--;
            }
            if(start.charAt(i)=='L'){
                countL--;
            }
            if(countL<0 || countR<0 || countL*countR!=0){
                return false;
            }
        }
        return countL==0 && countR==0;
    }

//    // Two pointers
//    public boolean canTransform(String start, String end) {
//        if((start==null && end==null) || (start.length()==0 && start.length()==end.length())){
//            return true;
//        }
//        if(start.length()!=end.length()){
//            return false;
//        }
//        int i=0, j=0, l=start.length();
//        while(i<l && j<l){
//            while(i<l && start.charAt(i)=='X'){
//                i++;
//            }
//            while(j<l && end.charAt(j)=='X'){
//                j++;
//            }
//            // Beware of this break, this can prevent runtime index out of bound exception
//            if(i==l || j==l){
//                break;
//            }
//            if(start.charAt(i)!=end.charAt(j)){
//                return false;
//            }
//            if((i<l && start.charAt(i)=='R' && i>j) || (i<l && start.charAt(i)=='L' && i<j)){
//                return false;
//            }
//            i++;
//            j++;
//        }
//        while(i<l && start.charAt(i)=='X'){
//            i++;
//        }
//        while(j<l && end.charAt(j)=='X'){
//            j++;
//        }
//        return i==l && j==l;
//    }
}
