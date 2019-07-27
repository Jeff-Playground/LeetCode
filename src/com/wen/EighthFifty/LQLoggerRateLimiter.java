package com.wen.EighthFifty;

import java.util.HashMap;
import java.util.Map;

public class LQLoggerRateLimiter {
    class Logger{
        Map<String, Integer> map=new HashMap<>();

        public Logger(){

        }

        public boolean shoudPrintMessage(int timestamp, String message){
            if(!map.containsKey(message)){
                map.put(message, timestamp);
                return true;
            } else if(timestamp-map.get(message)>=10){
                map.put(message, timestamp);
                return true;
            } else{
                return false;
            }
        }
    }
}
