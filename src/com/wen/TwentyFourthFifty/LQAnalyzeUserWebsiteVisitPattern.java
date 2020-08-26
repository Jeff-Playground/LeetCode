package com.wen.TwentyFourthFifty;

/*
We are given some website visits: the user with name username[i] visited the website website[i] at time timestamp[i].

A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits.  (The websites in a 3-sequence are not necessarily distinct.)

Find the 3-sequence visited by the largest number of users. If there is more than one solution, return the lexicographically smallest such 3-sequence.

Example 1:

Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"], timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
Output: ["home","about","career"]
Explanation:
The tuples in this example are:
["joe", 1, "home"]
["joe", 2, "about"]
["joe", 3, "career"]
["james", 4, "home"]
["james", 5, "cart"]
["james", 6, "maps"]
["james", 7, "home"]
["mary", 8, "home"]
["mary", 9, "about"]
["mary", 10, "career"]
The 3-sequence ("home", "about", "career") was visited at least once by 2 users.
The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.
Note:

3 <= N = username.length = timestamp.length = website.length <= 50
1 <= username[i].length <= 10
0 <= timestamp[i] <= 10^9
1 <= website[i].length <= 10
Both username[i] and website[i] contain only lowercase characters.
It is guaranteed that there is at least one user who visited at least 3 websites.
No user visits two websites at the same time.
 */

import java.util.*;

public class LQAnalyzeUserWebsiteVisitPattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int l= username.length;
        List<Pair> data=new ArrayList<>();
        for(int i=0; i<l; i++){
            data.add(new Pair(username[i], timestamp[i], website[i]));
        }
        Collections.sort(data, (a, b)->a.time-b.time);
        Map<String, List<String>> visit=new HashMap<>();
        for(Pair e: data){
            visit.putIfAbsent(e.user, new ArrayList<>());
            visit.get(e.user).add(e.website);
        }
        Map<String, Integer> count=new HashMap<>();
        int maxCount=0;
        String maxSeq="";
        for(String user: visit.keySet()){
            Set<String> seqs=getCombination(visit.get(user));
            for(String seq: seqs){
                count.put(seq, count.getOrDefault(seq, 0)+1);
                if(count.get(seq)>maxCount){
                    maxCount=count.get(seq);
                    maxSeq=seq;
                } else if(count.get(seq)==maxCount && seq.compareTo(maxSeq)<0){
                    maxSeq=seq;
                }
            }
        }
        return Arrays.asList(maxSeq.split(","));
    }

    private Set<String> getCombination(List<String> websites) {
        Set<String> result=new HashSet<>();
        int l=websites.size();
        for(int i=0; i<l-2; i++){
            for(int j=i+1; j<l-1; j++){
                for(int k=j+1; k<l; k++){
                    result.add(websites.get(i)+","+websites.get(j)+","+websites.get(k));
                }
            }
        }
        return result;
    }

    private class Pair{
        public String user;
        public int time;
        public String website;

        public Pair(String user, int time, String website){
            this.user=user;
            this.time=time;
            this.website=website;
        }
    }
}
