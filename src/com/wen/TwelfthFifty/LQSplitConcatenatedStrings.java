package com.wen.TwelfthFifty;

/*

Given a list of strings, you could concatenate these strings together into a loop, where for each string you could choose
to reverse it or not. Among all the possible loops, you need to find the lexicographically biggest string after cutting
the loop, which will make the looped string into a regular one.

Specifically, to find the lexicographically biggest string, you need to experience two phases:
Concatenate all the strings into a loop, where you can reverse some strings or not and connect them in the same order as
given.
Cut and make one breakpoint in any place of the loop, which will make the looped string into a regular one starting from
the character at the cut point.


And your job is to find the lexicographically biggest one among all the possible regular strings.

Example:

Input: "abc", "xyz"
Output: "zyxcba"
Explanation: You can get the looped string "-abcxyz-", "-abczyx-", "-cbaxyz-", "-cbazyx-",
where '-' represents the looped status.
The answer string came from the fourth looped one,
where you could cut from the middle character 'a' and get "zyxcba".


Note:

The input strings will only contain lowercase letters.
The total length of all the strings will not over 1,000.

 */

import java.util.List;

public class LQSplitConcatenatedStrings {
    // Note only the cut string is not necessarily in the result as the max string between s and rs
    public String splitLoopedString(List<String> strs) {
        if(strs==null || strs.size()==0){
            return "";
        }
        StringBuilder sb=new StringBuilder();
        for(String s: strs){
            String rs=new StringBuilder(s).reverse().toString();
            sb.append(s.compareTo(rs)>=0?s:rs);
        }
        String result=sb.toString();
        int idx=0;
        for(String s: strs){
            int l=s.length();
            String rs=new StringBuilder(s).reverse().toString();
            StringBuilder sbNew=new StringBuilder();
            sbNew.append(sb.substring(idx+l));
            sbNew.append(sb.substring(0, idx));
            for(int i=0; i<l; i++){
                if(s.charAt(i)>=result.charAt(0)){
                    String t=s.substring(i)+sbNew.toString()+s.substring(0, i);
                    result=t.compareTo(result)>0?t:result;
                }
                if(rs.charAt(i)>=result.charAt(0)){
                    String t=rs.substring(i)+sbNew.toString()+rs.substring(0, i);
                    result=t.compareTo(result)>0?t:result;
                }
            }
            idx+=l;
        }
        return result;
    }
}
