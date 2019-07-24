package com.wen.SixthFifty;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LQUniqueWordAbbreviation {
    public class ValidWordAbbr {
        Map<String, String> dict;
        /*
         * @param dictionary: a list of words
         */public ValidWordAbbr(String[] dictionary) {
            dict=new HashMap<>();
            for(String word: dictionary){
                String abbr=calculateAbbr(word);
                if(dict.containsKey(abbr)){
                    if(!dict.get(abbr).equals(word)){
                        dict.put(abbr, "");
                    }
                } else{
                    dict.put(abbr, word);
                }
            }
        }

        public String calculateAbbr(String word){
            if(word.length()<=2){
                return word;
            } else{
                return word.charAt(0)+String.valueOf(word.length()-2)+word.charAt(word.length()-1);
            }
        }

        /*
         * @param word: a string
         * @return: true if its abbreviation is unique or false
         */
        public boolean isUnique(String word) {
            String abbr=calculateAbbr(word);
            if(dict.containsKey(abbr)){
                return dict.get(abbr).equals(word);
            } else{
                return true;
            }
        }
    }

//    public class ValidWordAbbr {
//        Map<String, Set<String>> dict;
//        /*
//         * @param dictionary: a list of words
//         */public ValidWordAbbr(String[] dictionary) {
//            dict=new HashMap<>();
//            for(String word: dictionary){
//                String abbr=calculateAbbr(word);
//                if(dict.containsKey(abbr)){
//                    dict.get(abbr).add(word);
//                } else{
//                    Set<String> words=new HashSet<>();
//                    words.add(word);
//                    dict.put(abbr, words);
//                }
//            }
//        }
//
//        public String calculateAbbr(String word){
//            if(word.length()<=2){
//                return word;
//            } else{
//                return word.charAt(0)+String.valueOf(word.length()-2)+word.charAt(word.length()-1);
//            }
//        }
//
//        /*
//         * @param word: a string
//         * @return: true if its abbreviation is unique or false
//         */
//        public boolean isUnique(String word) {
//            String abbr=calculateAbbr(word);
//            if(dict.containsKey(abbr)){
//                return dict.get(abbr).size()==1 && dict.get(abbr).contains(word);
//            } else{
//                return true;
//            }
//        }
//    }
}
