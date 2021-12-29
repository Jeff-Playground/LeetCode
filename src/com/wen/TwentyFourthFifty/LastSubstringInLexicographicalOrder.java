package com.wen.TwentyFourthFifty;

public class LastSubstringInLexicographicalOrder {
    // Two pointers
    public String lastSubstring(String s) {
        int i=0, j=1, len=0, l=s.length();
        while(j+len<l){
            if(s.charAt(i+len)==s.charAt(j+len)){
                len++;
            } else if(s.charAt(i+len)<s.charAt(j+len)){
                // Note here for any s.substring(ix) where i<=ix<=i+len, there's a jx exists for which j<=jx<=j+len and
                // s.charAt(ix)==s.charAt(jx) and s.substring(jx)>s.substring(ix), so s.substring(ix) can't be the
                // solution, therefore we can update i to be Math.max(i+len+1, j) without missing out the right result
                i=Math.max(i+len+1, j);
                j=i+1;
                len=0;
            } else{
                // Similarly here for any s.substring(jx) where j<=jx<=j+len, there's a ix exists for which i<=ix<=i+len
                // and s.charAt(jx)==s.charAt(ix) and s.substring(ix)>s.substring(jx), so we can update j to be j+len+1
                // without missing out the right result
                j=j+len+1;
                len=0;
            }
        }
        return s.substring(i);
    }
}
