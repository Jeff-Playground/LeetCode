package com.wen.FifthFifty;

import java.util.Arrays;
import java.util.List;

public class LQStrobogrammaticNumberIII {
    public int strobogrammaticInRange(String low, String high){
        if(low.compareTo(high)>0){
            return 0;
        }
        int[] result=new int[]{0};
        List<String> seed= Arrays.asList("", "0", "1", "8");
        for(int i=low.length(); i<high.length(); i++){
            strobogrammaticInRangeDFS(low, high, i, "", result);
            strobogrammaticInRangeDFS(low, high, i, "0", result);
            strobogrammaticInRangeDFS(low, high, i, "1", result);
            strobogrammaticInRangeDFS(low, high, i, "8", result);
        }
        return result[0];
    }

    private void strobogrammaticInRangeDFS(String low, String high, int length, String seed, int[] result) {
        if(seed.length()>=low.length() && seed.length()<=high.length()){
            if(seed.length()==high.length() && seed.compareTo(high)>0){
                return;
            }
            if(!(seed.length()==low.length() && seed.compareTo(low)<0) && !(seed.length()!=1 && seed.charAt(0)=='0')){
                result[0]++;
            }
        }
        if(seed.length()+2>high.length()){
            return;
        }
        strobogrammaticInRangeDFS(low, high, length, "0"+seed+"0", result);
        strobogrammaticInRangeDFS(low, high, length, "1"+seed+"1", result);
        strobogrammaticInRangeDFS(low, high, length, "6"+seed+"9", result);
        strobogrammaticInRangeDFS(low, high, length, "8"+seed+"8", result);
        strobogrammaticInRangeDFS(low, high, length, "9"+seed+"6", result);
    }
}
