package com.wen.SixthFifty;

/*
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and
-, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make
a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

Example:
s = "++++"
"++"
"+--+"

Follow up:
Derive your algorithm's runtime complexity.
 */

public class LQFlipGameII {
    public boolean canWin(String s){
        int l=s.length();
        boolean result=true;
        for(int i=0; i<l-1; i++){
            if(s.charAt(i)=='+' && s.charAt(i+1)=='+' && !canWin(s.substring(0, i)+"--"+s.substring(i+2))){
                return true;
            }
        }
        return false;
    }
}
