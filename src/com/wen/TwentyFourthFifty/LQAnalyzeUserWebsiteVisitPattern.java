package com.wen.TwentyFourthFifty;

/*
You are given two string arrays username and website and an integer array timestamp. All the given arrays are of the same
length and the tuple [username[i], website[i], timestamp[i]] indicates that the user username[i] visited the website
website[i] at time timestamp[i].

A pattern is a list of three websites (not necessarily distinct).

For example, ["home", "away", "love"], ["leetcode", "love", "leetcode"], and ["luffy", "luffy", "luffy"] are all patterns.

The score of a pattern is the number of users that visited all the websites in the pattern in the same order they appeared
in the pattern.

For example, if the pattern is ["home", "away", "love"], the score is the number of users x such that x visited "home"
then visited "away" and visited "love" after that.

Similarly, if the pattern is ["leetcode", "love", "leetcode"], the score is the number of users x such that x visited
"leetcode" then visited "love" and visited "leetcode" one more time after that.

Also, if the pattern is ["luffy", "luffy", "luffy"], the score is the number of users x such that x visited "luffy" three
different times at different timestamps.

Return the pattern with the largest score. If there is more than one pattern with the same largest score, return the
lexicographically smallest such pattern.



Example 1:
Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"],
timestamp = [1,2,3,4,5,6,7,8,9,10],
website = ["home","about","career","home","cart","maps","home","home","about","career"]
Output: ["home","about","career"]
Explanation: The tuples in this example are:
["joe","home",1],["joe","about",2],["joe","career",3],["james","home",4],["james","cart",5],["james","maps",6],
["james","home",7],["mary","home",8],["mary","about",9], and ["mary","career",10].
The pattern ("home", "about", "career") has score 2 (joe and mary).
The pattern ("home", "cart", "maps") has score 1 (james).
The pattern ("home", "cart", "home") has score 1 (james).
The pattern ("home", "maps", "home") has score 1 (james).
The pattern ("cart", "maps", "home") has score 1 (james).
The pattern ("home", "home", "home") has score 0 (no user visited home 3 times).


Example 2:
Input: username = ["ua","ua","ua","ub","ub","ub"], timestamp = [1,2,3,4,5,6], website = ["a","b","a","a","b","c"]
Output: ["a","b","a"]


Constraints:
3 <= username.length <= 50
1 <= username[i].length <= 10
timestamp.length == username.length
1 <= timestamp[i] <= 109
website.length == username.length
1 <= website[i].length <= 10
username[i] and website[i] consist of lowercase English letters.
It is guaranteed that there is at least one user who visited at least three websites.
All the tuples [username[i], timestamp[i], website[i]] are unique.
 */

import java.util.*;

public class LQAnalyzeUserWebsiteVisitPattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int l=username.length;
        List<Visit> history=new ArrayList<>();
        for(int i=0; i<l; i++){
            Visit v=new Visit(username[i], timestamp[i], website[i]);
            history.add(v);
        }
        Collections.sort(history, (a, b)->a.timestamp-b.timestamp);
        Map<String, List<String>> userVisits=new HashMap<>();
        for(Visit v: history){
            String user=v.username, web=v.website;
            userVisits.putIfAbsent(user, new ArrayList<>());
            userVisits.get(user).add(web);
        }
        Map<String, Integer> patternCount=new HashMap<>();
        int maxCount=0;
        for(List<String> uv: userVisits.values()){
            Set<String> patterns=getPatterns(uv);
            for(String p: patterns){
                patternCount.put(p, patternCount.getOrDefault(p, 0)+1);
                maxCount=Math.max(maxCount, patternCount.get(p));
            }
        }
        PriorityQueue<String> pq=new PriorityQueue<>();
        for(String k: patternCount.keySet()){
            if(patternCount.get(k)==maxCount){
                pq.offer(k);
            }
        }
        return Arrays.asList(pq.poll().split(","));
    }

    private Set<String> getPatterns(List<String> visits){
        Set<String> result=new HashSet<>();
        int l=visits.size();
        for(int i=0; i<l-2; i++){
            for(int j=i+1; j<l-1; j++){
                for(int k=j+1; k<l; k++){
                    StringBuilder sb=new StringBuilder(visits.get(i));
                    sb.append(",");
                    sb.append(visits.get(j));
                    sb.append(",");
                    sb.append(visits.get(k));
                    result.add(sb.toString());
                }
            }
        }
        return result;
    }

    private class Visit{
        String username, website;
        int timestamp;

        public Visit(String username, int timestamp, String website){
            this.username=username;
            this.timestamp=timestamp;
            this.website=website;
        }
    }
}
