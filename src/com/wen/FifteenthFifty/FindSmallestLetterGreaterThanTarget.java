package com.wen.FifteenthFifty;

public class FindSmallestLetterGreaterThanTarget {
    // Binary search1, note the trick is to ensure [left, right] contains the answer
    public char nextGreatestLetter(char[] letters, char target) {
        int l=letters.length;
        int left=0, right=l;
        while(left<right){
            int mid=left+(right-left)/2;
            if(letters[mid]<=target){
                left=mid+1;
            } else{
                right=mid;
            }
        }
        return left<l?letters[left]:letters[0];
    }

//    // Binary search2, note the trick is to ensure [left, right] contains the answer
//    public char nextGreatestLetter(char[] letters, char target) {
//        int l=letters.length;
//        if(letters[l-1]<=target){
//            return letters[0];
//        } else{
//            int left=0, right=l-1;
//            while(left<right){
//                int mid=left+(right-left)/2;
//                if(letters[mid]<=target){
//                    left=mid+1;
//                } else{
//                    right=mid;
//                }
//            }
//            return letters[left];
//        }
//    }
}
