package com.wen.FifteenthFifty;

import java.util.*;

public class AccountsMerge {
    // BFS
    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result=new ArrayList<>();
        int l=accounts.size();
        Map<String, Set<Integer>> map=new HashMap<>();
        for(int i=0; i<l; i++){
            List<String> account=accounts.get(i);
            for(int j=1; j<account.size(); j++){
                String email=account.get(j);
                map.putIfAbsent(email, new HashSet<>());
                map.get(email).add(i);
            }
        }
        int[] visited=new int[l];
        for(int i=0; i<l; i++){
            if(visited[i]==0){
                Queue<Integer> q=new LinkedList<>();
                q.offer(i);
                Set<String> emails=new HashSet<>();
                while(!q.isEmpty()){
                    int cur=q.poll();
                    visited[cur]=1;
                    List<String> account=accounts.get(cur);
                    for(int j=1; j<account.size(); j++){
                        String email=account.get(j);
                        emails.add(email);
                        for(int idx: map.get(email)){
                            if(visited[idx]==0){
                                visited[idx]=1;
                                q.offer(idx);
                            }
                        }
                    }
                }
                List<String> eList=new ArrayList<>(emails);
                Collections.sort(eList);
                eList.add(0, accounts.get(i).get(0));
                result.add(eList);
            }
        }
        return result;
    }

//    // Union find
//    public List<List<String>> accountsMerge(List<List<String>> accounts) {
//        Map<String, String> root=new HashMap<>();
//        Map<String, String> owner=new HashMap<>();
//        Map<String, TreeSet<String>> union=new HashMap<>();
//        for (List<String> account : accounts) {
//            for (int i = 1; i < account.size(); i++) {
//                root.put(account.get(i), account.get(i));
//                owner.put(account.get(i), account.get(0));
//            }
//        }
//        for (List<String> account : accounts) {
//            String p = findRoot(root, account.get(1));
//            for (int i = 2; i < account.size(); i++)
//                root.put(findRoot(root, account.get(i)), p);
//        }
//        for(List<String> account: accounts){
//            String fr=findRoot(root, account.get(1));
//            union.putIfAbsent(fr, new TreeSet<>());
//            for(int i=1; i<account.size(); i++){
//                union.get(fr).add(account.get(i));
//            }
//        }
//        List<List<String>> result=new ArrayList<>();
//        for(String r: union.keySet()){
//            List<String> emails=new ArrayList<>(union.get(r));
//            emails.add(0, owner.get(r));
//            result.add(emails);
//        }
//        return result;
//    }
//
//    private String findRoot(Map<String, String> root, String cur) {
//        while(!root.get(cur).equals(cur)){
//            root.put(root.get(cur), root.get(root.get(cur)));
//            cur=root.get(cur);
//        }
//        return cur;
//    }
}
