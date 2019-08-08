package com.wen.FifteenthFifty;

public class PrefixAndSuffixSearch {
    class WordFilter {
        String[] words;

        public WordFilter(String[] words) {
            this.words=words;
        }

        public int f(String prefix, String suffix) {
            for(int i=words.length-1; i>=0; i--){
                if(words[i].startsWith(prefix) && words[i].endsWith(suffix)){
                    return i;
                }
            }
            return -1;
        }
    }
}
