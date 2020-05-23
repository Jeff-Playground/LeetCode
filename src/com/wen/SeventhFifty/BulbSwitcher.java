package com.wen.SeventhFifty;

public class BulbSwitcher {
    public int bulbSwitch(int n) {
        int result=0, cur=1;
        while(cur*cur<=n){
            result++;
            cur++;
        }
        return result;
    }

//    public int bulbSwitch(int n) {
//        return (int)Math.sqrt(n);
//    }
}
