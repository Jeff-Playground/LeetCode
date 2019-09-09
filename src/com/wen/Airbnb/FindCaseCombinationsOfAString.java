package com.wen.Airbnb;

import java.util.ArrayList;
import java.util.List;

public class FindCaseCombinationsOfAString {
    public static void main(String args[]) {
        String input = "aBc";
        List<String> result = caseCombination(input);
        for (String word : result) {
            System.out.println(word);
        }
    }

    // DFS and backtracking
    private static List<String> caseCombination(String input) {
        List<String> result=new ArrayList<>();
        char[] inputChars=input.toCharArray();
        caseCombinationDFS(result, inputChars, 0, new StringBuilder());
        return result;
    }

    private static void caseCombinationDFS(List<String> result, char[] inputChars, int curIdx, StringBuilder last) {
        if(curIdx==inputChars.length){
            result.add(last.toString());
        } else{
            last.append(Character.toUpperCase(inputChars[curIdx]));
            caseCombinationDFS(result, inputChars, curIdx+1, last);
            last.setLength(last.length()-1);
            last.append(Character.toLowerCase(inputChars[curIdx]));
            caseCombinationDFS(result, inputChars, curIdx+1, last);
            last.setLength(last.length()-1);
        }
    }

//    // Bit manipulation
//    private static List<String> caseCombination(String input) {
//        List<String> result=new ArrayList<>();
//        int l=input.length();
//        char[] inputChars=input.toCharArray();
//        for(int i=0; i<1<<l; i++){
//            char[] cur=new char[l];
//            for(int j=0; j<l; j++){
//                cur[j]=((i>>j)&1)==1?Character.toUpperCase(inputChars[j]):Character.toLowerCase(inputChars[j]);
//            }
//            result.add(new String(cur));
//        }
//        return result;
//    }
}
