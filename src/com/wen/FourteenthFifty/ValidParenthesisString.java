package com.wen.FourteenthFifty;

import java.util.Stack;

public class ValidParenthesisString {
    // Use both low and high to count the number of (
    //      low is the number of real (
    //      high is the number of ( plus *
    // The idea is to keep low as close to 0 as possible for all times, so if low>0, * is also treated as ) to reduce it,
    // and high is to ensure we cover the case where there're too many ) even with all * as (
    // Therefore, eventually, low should be 0 for valid strings
    public boolean checkValidString(String s) {
        int low=0, high=0;
        for(char c: s.toCharArray()){
            if(c=='('){
                low++;
                high++;
            } else if(c=='*'){
                if(low>0){
                    low--;
                }
                high++;
            } else if(c==')'){
                if(low>0){
                    low--;
                }
                if(--high<0){
                    return false;
                }
            }
        }
        return low==0;
    }

//    // Check from left to right first then right to left
//    // Be aware that right to left is needed to cover case like *( where first * can't be simply used as )
//    public boolean checkValidString(String s) {
//        int l=s.length();
//        int left=0, right=0, star=0;
//        for(int i=0; i<l; i++){
//            char c=s.charAt(i);
//            if(c=='('){
//                left++;
//            } else if(c==')'){
//                right++;
//            } else if(c=='*'){
//                star++;
//            }
//            if(left<right){
//                if(star>0){
//                    left++;
//                    star--;
//                } else{
//                    return false;
//                }
//            }
//        }
//        if(left-right>star){
//            return false;
//        }
//        left=right=star=0;
//        for(int i=l-1; i>=0; i--){
//            char c=s.charAt(i);
//            if(c==')'){
//                left++;
//            } else if(c=='('){
//                right++;
//            } else if(c=='*'){
//                star++;
//            }
//            if(left<right){
//                if(star>0){
//                    left++;
//                    star--;
//                } else{
//                    return false;
//                }
//            }
//        }
//        return left-right<=star;
//    }

//    // Check from left to right first then right to left
//    // Different from the other solution as this one treat all * as either ( or )
//    public boolean checkValidString(String s) {
//        int l=s.length();
//        int left=0;
//        for(int i=0; i<l; i++){
//            char c=s.charAt(i);
//            if(c=='(' || c=='*'){
//                left++;
//            } else if(c==')'){
//                left--;
//            }
//            if(left<0){
//                return false;
//            }
//        }
//        if(left==0){
//            return true;
//        }
//        int right=0;
//        for(int i=l-1; i>=0; i--){
//            char c=s.charAt(i);
//            if(c==')' || c=='*'){
//                right++;
//            } else if(c=='('){
//                right--;
//            }
//            if(right<0){
//                return false;
//            }
//        }
//        return true;
//    }

//    // Use two Stacks, one for ( and another for *, note eventually when popping the ( stack, if * is before the ( being
//    // checked, then the string is invalid
//    public boolean checkValidString(String s) {
//        Stack<Integer> left=new Stack<>(), star=new Stack<>();
//        for(int i=0; i<s.length(); i++){
//            char c=s.charAt(i);
//            if(c=='('){
//                left.push(i);
//            } else if(c=='*'){
//                star.push(i);
//            } else if(c==')'){
//                if(!left.isEmpty()){
//                    left.pop();
//                } else if(!star.isEmpty()){
//                    star.pop();
//                } else{
//                    return false;
//                }
//            }
//        }
//        while(!left.isEmpty()){
//            if(star.isEmpty() || star.peek()<left.peek()){
//                return false;
//            } else{
//                star.pop();
//                left.pop();
//            }
//        }
//        return true;
//    }
}
