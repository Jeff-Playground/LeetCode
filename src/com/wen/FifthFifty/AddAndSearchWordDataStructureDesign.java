package com.wen.FifthFifty;

public class AddAndSearchWordDataStructureDesign {
    class WordDictionary {
        private WordDictionary[] tries;
        boolean isEnd;

        /** Initialize your data structure here. */
        public WordDictionary() {
            tries=new WordDictionary[26];
            isEnd=false;
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            if(word.isEmpty()){
                return;
            } else{
                char c=word.charAt(0);
                if(tries[c-'a']==null){
                    tries[c-'a']=new WordDictionary();
                }
                if(word.length()>1){
                    tries[c-'a'].addWord(word.substring(1));
                } else {
                    tries[c-'a'].isEnd=true;
                }
            }
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            if(word.isEmpty()){
                return true;
            } else{
                char c=word.charAt(0);
                if(word.length()>1){
                    if(c=='.'){
                        for(WordDictionary trie: tries){
                            if(trie!=null && trie.search(word.substring(1))){
                                return true;
                            }
                        }
                    } else{
                        if(tries[c-'a']!=null){
                            return tries[c-'a'].search(word.substring(1));
                        }
                    }
                } else{
                    if(c=='.'){
                        for(WordDictionary trie: tries){
                            if(trie!=null && trie.isEnd){
                                return true;
                            }
                        }
                    } else{
                        if(tries[c-'a']!=null){
                            return tries[c-'a'].isEnd;
                        }
                    }
                }
                return false;
            }
        }
    }
}
