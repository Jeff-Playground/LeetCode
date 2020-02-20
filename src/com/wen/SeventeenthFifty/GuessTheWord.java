package com.wen.SeventeenthFifty;

import java.util.HashSet;
import java.util.Set;

public class GuessTheWord {
    interface Master {
        public int guess(String word);
    }

    // Minimax
    public void findSecretWord(String[] wordlist, Master master) {
        int N=wordlist.length;
        int[][] simCount=new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                if(j==i){
                    simCount[i][j]=6;
                } else{
                    int match=0;
                    for(int k=0; k<6; k++){
                        if(wordlist[i].charAt(k)==wordlist[j].charAt(k)){
                            match++;
                        }
                    }
                    simCount[i][j]=simCount[j][i]=match;
                }
            }
        }

        Set<Integer> options=new HashSet<>();
        for(int i=0; i<N; i++){
            options.add(i);
        }
        int count=10;
        while(count-->0){
            int minIdx=getMinIdx(simCount, options);
            int match=master.guess(wordlist[minIdx]);
            if(match==6){
                return;
            }
            for(int j=0; j<N; j++){
                if(simCount[minIdx][j]!=match){
                    options.remove(j);
                }
            }
        }
    }

    // Get the similar words count for each word, and find the max value among 0-6
    // Then in all words, find the index which makes this max value the smallest
    // Because this can ensure the counts are distributed among 0-6 move evenly, and eventually can get rid of more
    // words in each check.
    private int getMinIdx(int[][] simCount, Set<Integer> options){
        int N=simCount.length;
        int simMin=Integer.MAX_VALUE, minIdx=-1;
        for(int opt: options){
            int[] count=new int[7];
            int simMax=Integer.MIN_VALUE;
            for(int j=0; j<N; j++){
                if(options.contains(j)){
                    count[simCount[opt][j]]++;
                    if(count[simCount[opt][j]]>simMax){
                        simMax=count[simCount[opt][j]];
                    }
                }
            }
            if(simMax<simMin){
                simMin=simMax;
                minIdx=opt;
            }
        }
        return minIdx;
    }
}
