package com.wen.EighthFifty;

import java.util.*;

public class DesignTwitter {
    static class Twit{
        int time;
        int tweetId;

        public Twit(int time, int tweetId){
            this.time=time;
            this.tweetId=tweetId;
        }
    }

    public static class Twitter {
        int timer;
        Map<Integer, Set<Integer>> followedMap;
        Map<Integer, List<Twit>> tweetMap;

        /** Initialize your data structure here. */
        public Twitter() {
            timer=0;
            followedMap=new HashMap<>();
            tweetMap=new HashMap<>();
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            List<Twit> tweets=tweetMap.get(userId);
            if(tweets==null){
                tweets=new ArrayList<>();
                tweetMap.put(userId, tweets);
            }
            tweets.add(new Twit(timer++, tweetId));
            // User follows self to ensure getNewsFeed can get self feeds
            follow(userId, userId);
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by
         * users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            Set<Integer> followed=followedMap.get(userId);
            if(followed==null){
                return new ArrayList<>();
            }
            List<Integer> result=new ArrayList<>();
            PriorityQueue<Twit> pq=new PriorityQueue<>(10, (a, b)->b.time-a.time);
            for(int uId: followed){
                if(tweetMap.get(uId)!=null && tweetMap.get(uId).size()>0){
                    for(Twit t: tweetMap.get(uId)){
                        pq.offer(t);
                    }
                }
            }
            while(!pq.isEmpty() && result.size()<10){
                result.add(0,pq.poll().tweetId);
            }
            return result;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            Set<Integer> followees=followedMap.get(followerId);
            if(followees==null){
                followees=new HashSet<>();
                followedMap.put(followerId, followees);
            }
            followees.add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if(followerId!=followeeId){
                Set<Integer> followees=followedMap.get(followerId);
                if(followees!=null){
                    followees.remove(followeeId);
                }
            }
        }
    }
}
