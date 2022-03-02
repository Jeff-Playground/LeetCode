package com.wen.TwentyThirdFifty;

/*
In a social group, there are N people, with unique integer ids from 0 to N-1.

We have a list of logs, where each logs[i] = [timestamp, id_A, id_B] contains a non-negative integer timestamp, and the
ids of two different people.

Each log represents the time in which two different people became friends.  Friendship is symmetric: if A is friends with
B, then B is friends with A.

Let's say that person A is acquainted with person B if A is friends with B, or A is a friend of someone acquainted with B.

Return the earliest time for which every person became acquainted with every other person. Return -1 if there is no such
earliest time.


Example 1:

Input: logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], N = 6
Output: 20190301

Explanation:
The first event occurs at timestamp = 20190101 and after 0 and 1 become friends we have the following friendship groups [0,1], [2], [3], [4], [5].
The second event occurs at timestamp = 20190104 and after 3 and 4 become friends we have the following friendship groups [0,1], [2], [3,4], [5].
The third event occurs at timestamp = 20190107 and after 2 and 3 become friends we have the following friendship groups [0,1], [2,3,4], [5].
The fourth event occurs at timestamp = 20190211 and after 1 and 5 become friends we have the following friendship groups [0,1,5], [2,3,4].
The fifth event occurs at timestamp = 20190224 and as 2 and 4 are already friend anything happens.
The sixth event occurs at timestamp = 20190301 and after 0 and 3 become friends we have that all become friends.

Note:
1 <= N <= 100
1 <= logs.length <= 10^4
0 <= logs[i][0] <= 10^9
0 <= logs[i][1], logs[i][2] <= N - 1
It's guaranteed that all timestamps in logs[i][0] are different.
Logs are not necessarily ordered by some criteria.

 */

import java.util.PriorityQueue;

public class LQTheEarliestMomentWhenEveryoneBecomeFriends {
    public int earliestAcq(int[][] logs, int N) {
        if(N==1){
            return logs[0][0];
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->a[0]-b[0]);
        for(int[] e: logs){
            pq.offer(e);
        }
        UnionFind uf=new UnionFind(N);
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int time=cur[0], x=cur[1], y=cur[2];
            uf.union(x, y);
            if(uf.allConnected()){
                return time;
            }
        }
        return -1;
    }

    private class UnionFind{
        private int[] root, rank;
        private int count;

        public UnionFind(int l){
            root=new int[l];
            rank=new int[l];
            count=l;
            for(int i=0; i<l; i++){
                root[i]=i;
                rank[i]=1;
            }
        }

        public int find(int x){
            while(root[x]!=x){
                root[x]=root[root[x]];
                x=root[x];
            }
            return x;
        }

        public void union(int x, int y){
            int rx=find(x), ry=find(y);
            if(rx!=ry){
                if(rank[rx]>rank[ry]){
                    root[ry]=rx;
                } else if(rank[rx]<rank[ry]){
                    root[rx]=ry;
                } else{
                    root[rx]=ry;
                    rank[ry]++;
                }
                count--;
            }
        }

        public boolean allConnected(){
            return count==1;
        }
    }
}
