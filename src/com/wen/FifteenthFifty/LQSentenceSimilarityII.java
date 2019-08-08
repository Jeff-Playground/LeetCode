package com.wen.FifteenthFifty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LQSentenceSimilarityII {
    // Can be solved with BFS/DFS

    // Union find
    public boolean areSentencesSimilarTwo(List<String> words1, List<String> words2, List<List<String>> pairs) {
        int l1=words1.size(), l2=words2.size();
        if(l1!=l2){
            return false;
        }
        Map<String, String> root=new HashMap<>();
        for(List<String> pair: pairs){
            String val1=pair.get(0), val2=pair.get(1);
            root.putIfAbsent(val1, val1);
            if(root.containsKey(val2)){
                String r1=findRoot(root, val1), r2=findRoot(root, val2);
                union(root, r1, r2);
            } else{
                root.put(val2, val1);
            }
        }
        for(int i=0; i<l1; i++){
            if(words1.get(i).equals(words2.get(i))){
                continue;
            }
            if(!root.containsKey(words1.get(i)) || !root.containsKey(words2.get(i))){
                return false;
            }
            if(!findRoot(root, words1.get(i)).equals(findRoot(root, words2.get(i)))){
                return false;
            }
        }
        return true;
    }

    public String findRoot(Map<String, String> root, String val){
        while(!val.equals(root.get(val))){
            root.put(val, root.get(root.get(val)));
            val=root.get(val);
        }
        return val;
    }

    public void union(Map<String, String> root, String val1, String val2){
        String r1=findRoot(root, val1), r2=findRoot(root, val2);
        if(!r1.equals(r2)){
            root.put(r2, r1);
        }
    }
}
