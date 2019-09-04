package com.wen.SeventhFifty;

import java.util.*;

public class PalindromePairs {
    // Optimized by adding a set to cache exsiting lengths
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result=new ArrayList<>();
        Map<String, Integer> pos=new HashMap<>();
        Set<Integer> lengths=new HashSet<>();
        for(int i=0; i<words.length; i++) {
            pos.put(words[i], i);
            lengths.add(words[i].length());
        }
        for(String word: words) {
            StringBuilder sb=new StringBuilder(word).reverse();
            if(pos.containsKey(sb.toString()) && !word.equals(sb.toString())) {
                result.add(Arrays.asList(pos.get(word), pos.get(sb.toString())));
            }
            int l=word.length();
            if(!word.isEmpty() && isPalindrome(word) && pos.containsKey("")) {
                result.add(Arrays.asList(pos.get(word), pos.get("")));
                result.add(Arrays.asList(pos.get(""), pos.get(word)));
            }
            for(int i=1; i<l; i++) {
                if(lengths.contains(l-i) && isPalindrome(sb.substring(0, i)) && pos.containsKey(sb.substring(i))) {
                    int idx=pos.get(sb.substring(i));
                    result.add(Arrays.asList(pos.get(word), idx));
                }
                if(lengths.contains(l-i) && isPalindrome(sb.substring(l-i)) && pos.containsKey(sb.substring(0, l-i))) {
                    int idx=pos.get(sb.substring(0, l-i));
                    result.add(Arrays.asList(idx, pos.get(word)));
                }
            }
        }
        return result;
    }

//    public List<List<Integer>> palindromePairs(String[] words) {
//        List<List<Integer>> result=new ArrayList<>();
//        Map<String, Integer> pos=new HashMap<>();
//        for(int i=0; i<words.length; i++) {
//            pos.put(words[i], i);
//        }
//        for(String word: words) {
//            StringBuilder sb=new StringBuilder(word).reverse();
//            if(pos.containsKey(sb.toString()) && !word.equals(sb.toString())) {
//                result.add(Arrays.asList(pos.get(word), pos.get(sb.toString())));
//            }
//            int l=word.length();
//            if(!word.isEmpty() && isPalindrome(word) && pos.containsKey("")) {
//                result.add(Arrays.asList(pos.get(word), pos.get("")));
//                result.add(Arrays.asList(pos.get(""), pos.get(word)));
//            }
//            for(int i=1; i<l; i++) {
//                if(isPalindrome(sb.substring(0, i)) && pos.containsKey(sb.substring(i))) {
//                    int idx=pos.get(sb.substring(i));
//                    result.add(Arrays.asList(pos.get(word), idx));
//                }
//                if(isPalindrome(sb.substring(l-i)) && pos.containsKey(sb.substring(0, l-i))) {
//                    int idx=pos.get(sb.substring(0, l-i));
//                    result.add(Arrays.asList(idx, pos.get(word)));
//                }
//            }
//        }
//        return result;
//    }

    private boolean isPalindrome(String s) {
        int l=s.length();
        for(int i=0; i<(l+1)/2; i++) {
            if(s.charAt(i)!=s.charAt(l-1-i)) {
                return false;
            }
        }
        return true;
    }
}
