package com.wen.SixteenthFifty;

import java.util.*;

public class OpenTheLock {
    // BFS
    public int openLock(String[] deadends, String target) {
        Set<String> dead=new HashSet<>(Arrays.asList(deadends));
        Set<String> visited=new HashSet<>();
        String start="0000";
        if(dead.contains(start)){
            return -1;
        } else if(target.equals(start)){
            return 0;
        } else{
            Map<Character, List<Character>> turns=new HashMap<>();
            for(char c='0'; c<='9'; c++){
                turns.put(c, new ArrayList<>());
                turns.get(c).add(c-1>='0'?(char)(c-1):'9');
                turns.get(c).add(c+1<='9'?(char)(c+1):'0');
            }
            Queue<String> q=new LinkedList<>();
            q.offer(start);
            visited.add(start);
            int step=0;
            while(!q.isEmpty()){
                int size=q.size();
                step++;
                while(size-->0){
                    String cur=q.poll();
                    for(int i=0; i<4; i++){
                        char c=cur.charAt(i);
                        for(char t: turns.get(c)){
                            String next=cur.substring(0, i)+t+cur.substring(i+1);
                            if(!dead.contains(next) && !visited.contains(next)){
                                if(next.equals(target)){
                                    return step;
                                } else{
                                    q.offer(next);
                                    visited.add(next);
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }
    }
}
