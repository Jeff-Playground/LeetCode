package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    // Note a valid IP can start with 0, for example, "0.0.0.0" is valid
    public static List<String> restoreIpAddresses(String s) {
        List<String> result=new ArrayList<>();
        if(s==null || s.length()<4 || s.length()>12){
            return result;
        }
        restoreIpAddressesDFS(s, "", 0, result);
        return result;
    }

    private static void restoreIpAddressesDFS(String s, String out, int period, List<String> result) {
        if(period==4){
            if(s.isEmpty()){
                result.add(out);
            }
        } else{
            for(int i=0; i<3 && i<s.length(); i++){
                if(Integer.parseInt(s.substring(0,i+1))>=0 && Integer.parseInt(s.substring(0,i+1))<=255
                        && (!s.substring(0,i+1).startsWith("0") || s.substring(0,i+1).equals("0"))){
                    restoreIpAddressesDFS(s.substring(i+1), out+s.substring(0,i+1)+(period==3 ? "":"."), period+1, result);
                }
            }
        }
    }
}
