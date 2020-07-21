package com.wen.NinthFifty;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public static List<String> readBinaryWatch(int num) {
        if(num<0){
            throw new IllegalArgumentException("Invalid input!");
        }
        List<String> result=new ArrayList<>();
        rbwHelper(num, 0, -1, 0, -1, result);
        return result;
    }

    private static void rbwHelper(int cur, int hours, int hLast, int minutes, int mLast, List<String>result){
        if(cur==0){
            if(hours<=11 && minutes<=59){
                result.add(hours+":"+(minutes<10?"0"+minutes:minutes));
            }
        } else if(hLast==3 && mLast==5){
            return;
        } else{
            if(mLast<5){
                rbwHelper(cur-1, hours, hLast, minutes+(1<<(mLast+1)), mLast+1, result);
                rbwHelper(cur, hours, hLast, minutes, mLast+1, result);
            } else if(hLast<3){
                rbwHelper(cur-1, hours+(1<<(hLast+1)), hLast+1, minutes, mLast, result);
                rbwHelper(cur, hours, hLast+1, minutes, mLast, result);
            }
        }
    }
}
