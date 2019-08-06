package com.wen.EleventhFifty;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {
    public class Codec {
        char[] dict="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        Map<String, String> longToShort=new HashMap<>();
        Map<String, String> shortToLong=new HashMap<>();
        long count=-1;

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if(!longToShort.containsKey(longUrl)){
                count++;
                long cur=count;
                String id="";
                while(cur!=0){
                    id+=dict[(int)cur%62];
                    cur/=62;
                }
                longToShort.put(longUrl, id);
                shortToLong.put(id, longUrl);
            }
            return "http://tinyurl.com/"+longToShort.get(longUrl);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String id=shortUrl.replace("http://tinyurl.com/", "");
            if(shortToLong.containsKey(id)){
                return shortToLong.get(id);
            } else{
                return "";
            }
        }
    }
}
