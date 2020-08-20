package com.wen.TenthFifty;

public class UniqueSubstringsInWraparoundString {
    public int findSubstringInWraproundString(String p) {
        int[] length=new int[26];
        int start=0, end=0, l=p.length();
        while(end<l){
            while(end+1<l && (p.charAt(end+1)-p.charAt(end)==1 || p.charAt(end+1)-p.charAt(end)==-25)){
                end++;
            }
            int curL=1;
            for(int i=start; i<=end; i++){
                char c=p.charAt(i);
                length[c-'a']=Math.max(length[c-'a'], curL);
                curL++;
            }
            start=end+1;
            end=end+1;
        }
        int result=0;
        for(int i=0; i<26; i++){
            result+=length[i];
        }
        return result;
    }
}
