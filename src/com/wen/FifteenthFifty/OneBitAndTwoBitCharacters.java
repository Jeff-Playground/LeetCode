package com.wen.FifteenthFifty;

public class OneBitAndTwoBitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int l=bits.length;
        int i=0;
        while(i<l){
            if(i==l-1 && bits[i]==0){
                return true;
            }
            if(bits[i]==0){
                i++;
            } else{
                i+=2;
            }
        }
        return false;
    }

//    // This works because bits is guaranteed to end with 0
//    public boolean isOneBitCharacter(int[] bits) {
//        int l=bits.length;
//        int i=0;
//        while(i<l-1){
//            if(bits[i]==0){
//                i++;
//            } else{
//                i+=2;
//            }
//        }
//        return i==l-1;
//    }

//    // Further simplified
//    public boolean isOneBitCharacter(int[] bits) {
//        int l=bits.length;
//        int i=0;
//        while(i<l-1){
//            i+=bits[i]+1;
//        }
//        return i==l-1;
//    }

//    // Further simplified, but recursive
//    public boolean isOneBitCharacter(int[] bits) {
//        return isOneBitCharacterHelper(bits, 0);
//    }
//
//    private boolean isOneBitCharacterHelper(int[] bits, int idx){
//        if(idx==bits.length-1){
//            return true;
//        } else if(idx<bits.length-1){
//            return isOneBitCharacterHelper(bits, idx+bits[idx]+1);
//        } else{
//            return false;
//        }
//    }
}
