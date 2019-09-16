package com.wen.Airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GuessNumber {
     private static String target = "3536";
     public static void main(String args[]) {
         System.out.println(guess());
     }

     private static int guessServer(String guess) {
     	int count = 0;
 		for (int i = 0; i < 4; i++) {
 			if (target.charAt(i) == guess.charAt(i)) {
 				count++;
 			}
 		}
 		return count;
     }

     public static String guess() {
     	int l=target.length();
         List<Character> cands = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6'));
         Iterator<Character> iter=cands.iterator();
         char maxCand='$';
         int max=0;
         StringBuilder sb=new StringBuilder();
         while(iter.hasNext()) {
         	char cur=iter.next();
         	sb.setLength(0);
         	for(int i=0; i<l; i++) {
         		sb.append(cur);
         	}
         	int guess=guessServer(sb.toString());
         	if(guess>max) {
         		maxCand=cur;
         		max=guess;
         	} else if(guess==0) {
         		iter.remove();
         	}
         }
         System.out.println("Max candidate: "+maxCand);
         char[] result=new char[l];
         Arrays.fill(result, maxCand);
         for(int i=0; i<l; i++) {
         	for(int j=0; j<cands.size(); j++) {
         		char cur=cands.get(j);
         		if(cur!=maxCand) {
             		result[i]=cur;
             		int guess=guessServer(new String(result));
             		if(guess<max) {
             			System.out.println("Found for index "+i+": "+maxCand);
             			result[i]=maxCand;
             			break;
             		} else if(guess>max) {
             			System.out.println("Found for index "+i+": "+result[i]);
             			max++;
             			break;
             		}
         		}
         	}
         }
         return new String(result);
     }
}
