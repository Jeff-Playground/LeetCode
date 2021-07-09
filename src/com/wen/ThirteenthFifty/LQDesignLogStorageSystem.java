package com.wen.ThirteenthFifty;

/*
You are given several logs that each log contains a unique id and timestamp. Timestamp is a string that has the following
format: Year:Month:Day:Hour:Minute:Second, for example, 2017:01:01:23:59:59. All domains are zero-padded decimal numbers.

Design a log storage system to implement the following functions:

void put(int id, string timestamp): Given a log's unique id and timestamp, store the log in your storage system.

int[] retrieve(String start, String end, String granularity): Return the id of logs whose timestamps are within the range
from start to end. Start and end all have the same format as timestamp. However, granularity means the time level for
consideration. For example, start = "2017:01:01:23:59:59", end = "2017:01:02:23:59:59", granularity = "Day", it means that
we need to find the logs within the range from Jan. 1st 2017 to Jan. 2nd 2017.

Example 1:

put(1, "2017:01:01:23:59:59");
put(2, "2017:01:01:22:59:59");
put(3, "2016:01:01:00:00:00");
retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); // return [1,2,3], because you need to return all logs within
2016 and 2017.
retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"); // return [1,2], because you need to return all logs start
from 2016:01:01:01 to 2017:01:01:23, where log 3 is left outside the range.


Note:

There will be at most 300 operations of put or retrieve.
Year ranges from [2000,2017]. Hour ranges from [00,23].
Output for Retrieve has no order required.
 */

import java.util.*;

public class LQDesignLogStorageSystem {
    class LogSystem{
        Map<String, Integer> granuIdx;
        TreeMap<String, List<Integer>> sortedLog;

        public LogSystem(){
            granuIdx=new HashMap<>();
            granuIdx.put("Year", 0);
            granuIdx.put("Month", 1);
            granuIdx.put("Day", 2);
            granuIdx.put("Hour", 3);
            granuIdx.put("Minute", 4);
            granuIdx.put("Second", 5);
            sortedLog=new TreeMap<>((a, b)->a.compareTo(b));
        }

        public void put(int id, String timestamp){
            sortedLog.putIfAbsent(timestamp, new ArrayList<>());
            sortedLog.get(timestamp).add(id);
        }

        public int[] retrieve(String start, String end, String granularity){
            String updatedStart=updateTimestampByGranularity(start, granularity);
            String updatedEnd=updateTimestampByGranularity(end, granularity);
            List<Integer> result=new ArrayList<>();
            sortedLog.subMap(updatedStart, true, updatedEnd, true).values().forEach(item->result.addAll(item));
            return result.stream().mapToInt(i->i).toArray();
        }

        private String updateTimestampByGranularity(String timestamp, String granularity) {
            String[] splitedTimestamp=timestamp.split(":");
            int idx=granuIdx.get(granularity);
            StringBuilder sb=new StringBuilder();
            for(int i=0; i<splitedTimestamp.length; i++){
                if(i<idx){
                    sb.append(splitedTimestamp[i]);
                } else{
                    int segLength=splitedTimestamp[i].length();
                    while(segLength-->0){
                        sb.append('0');
                    }
                }
                sb.append(':');
            }
            return sb.substring(0, sb.length()-1);
        }
    }
}
