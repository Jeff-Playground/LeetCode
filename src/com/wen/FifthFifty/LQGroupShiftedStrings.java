package com.wen.FifthFifty;

/*
We can shift a string by shifting each of its letters to its successive letter.

For example, "abc" can be shifted to be "bcd".
We can keep shifting the string to form a sequence.

For example, we can keep shifting "abc" to form the sequence: "abc" -> "bcd" -> ... -> "xyz".

Given an array of strings "strings", group all strings[i] that belong to the same shifting sequence. You may return the
answer in any order.



Example 1:
Input: strings = ["abc","bcd","acef","xyz","az","ba","a","z"]
Output: [["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]]

Example 2:
Input: strings = ["a"]
Output: [["a"]]


Constraints:
1 <= strings.length <= 200
1 <= strings[i].length <= 50
strings[i] consists of lowercase English letters.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LQGroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result=new ArrayList<>();
        Map<String, List<String>> group=new HashMap<>();
        for(String s: strings){
            char first=s.charAt(0);
            StringBuilder key=new StringBuilder();
            for(char c: s.toCharArray()){
                key.append((char)('a'+(c-first+26)%26));
            }
            group.putIfAbsent(key.toString(), new ArrayList<>());
            group.get(key.toString()).add(s);
        }
        group.values().forEach(e->result.add(e));
        return result;
    }
}
