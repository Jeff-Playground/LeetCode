package com.wen.TwelfthFifty;

/*

Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

Each process only has one parent process, but may have one or more children processes. This is just like a tree structure.
Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive
integers.

We use two list of integers to represent a list of processes, where the first list contains PID for each process and the
second list contains the corresponding PPID.

Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will
be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order
is required for the final answer.

Example 1:

Input:
pid =  [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5
Output: [5,10]
Explanation:
           3
         /   \
        1     5
             /
            10
Kill 5 will also kill 10.


Note:

The given kill id is guaranteed to be one of the given PIDs.
n >= 1.

 */

import java.util.*;

public class LQKillProcess {
    // BFS
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int l=pid.size();
        Map<Integer, Set<Integer>> relation=new HashMap<>();
        for(int i=0; i<l; i++){
            int id1=ppid.get(i), id2=pid.get(i);
            relation.putIfAbsent(id1, new HashSet<>());
            relation.get(id1).add(id2);
        }
        List<Integer> result=new ArrayList<>();
        result.add(kill);
        Queue<Integer> q=new LinkedList<>();
        q.offer(kill);
        while(!q.isEmpty()){
            int cur=q.poll();
            if(relation.containsKey(cur)){
                Set<Integer> child=relation.get(cur);
                for(int id: child){
                    q.offer(id);
                    result.add(id);
                }
            }
        }
        return result;
    }

//    // DFS
//    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
//        int l=pid.size();
//        Map<Integer, Set<Integer>> relation=new HashMap<>();
//        for(int i=0; i<l; i++){
//            int id1=ppid.get(i), id2=pid.get(i);
//            relation.putIfAbsent(id1, new HashSet<>());
//            relation.get(id1).add(id2);
//        }
//        List<Integer> result=new ArrayList<>();
//        kill(kill, relation, result);
//        return result;
//    }
//
//    private void kill(int kill, Map<Integer, Set<Integer>> relation, List<Integer> result){
//        result.add(kill);
//        if(relation.containsKey(kill)){
//            for(int id: relation.get(kill)){
//                kill(id, relation, result);
//            }
//        }
//    }
}
