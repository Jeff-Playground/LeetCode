package com.wen.TenthFifty;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        int gl=g.length, sl=s.length, result=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0, j=0;
        while(i<gl && j<sl){
            if(s[j]>=g[i]){
                result++;
                i++;
                j++;
            } else{
                j++;
            }
        }
        return result;
    }
}
