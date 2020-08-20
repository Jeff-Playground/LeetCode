package com.wen.TenthFifty;

public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        if(IP==null || IP.isEmpty() || IP.length()>39){
            return "Neither";
        } else{
            if(IP.indexOf('.')>-1){
                String[] split=IP.split("\\.");
                if(split.length==4 && !IP.startsWith(".") && !IP.endsWith(".")){
                    for(String s: split){
                        if(isNumber(s) && (s.length()==1 || s.length()>1 && s.length()<4 && s.charAt(0)!='0')){
                            int val=Integer.valueOf(s);
                            if(val<0 || val>255){
                                return "Neither";
                            }
                        } else {
                            return "Neither";
                        }
                    }
                    return "IPv4";
                } else{
                    return "Neither";
                }
            } else if(IP.indexOf(':')>-1){
                String[] split=IP.split(":");
                if(split.length==8 && !IP.startsWith(":") && !IP.endsWith(":")){
                    for(String s: split){
                        if(s.length()>=1 && s.length()<=4){
                            if(!isHexadecimal(s)){
                                return "Neither";
                            }
                        } else {
                            return "Neither";
                        }
                    }
                    return "IPv6";
                } else{
                    return "Neither";
                }
            } else{
                return "Neither";
            }
        }
    }

    private boolean isHexadecimal(String s){
        if(s==null || s.length()==0){
            return false;
        }
        for(char c: s.toCharArray()){
            if(!(isNumber(c) || isLowerChar(c) || isUpperChar(c))){
                return false;
            }
        }
        return true;
    }

    private boolean isNumber(String s){
        if(s==null || s.length()==0){
            return false;
        }
        for(char c: s.toCharArray()){
            if(!isNumber(c)){
                return false;
            }
        }
        return true;
    }

    private boolean isNumber(char c){
        return c>='0' && c<='9';
    }

    private boolean isLowerChar(char c){
        return c>='a' && c<='f';
    }

    private boolean isUpperChar(char c){
        return c>='A' && c<='F';
    }
}
