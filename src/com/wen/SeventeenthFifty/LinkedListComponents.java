package com.wen.SeventeenthFifty;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinkedListComponents {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int numComponents(ListNode head, int[] G) {
        if(head==null){
            return 0;
        } else if(head.next==null){
            return 1;
        }
        Set<Integer> nodes=new HashSet<>();
        int total=0;
        for(int num: G){
            total++;
            nodes.add(num);
        }
        ListNode cur=head;
        while(cur.next!=null){
            if(nodes.contains(cur.val) && nodes.contains(cur.next.val)){
                total--;
            }
            cur=cur.next;
        }
        return total;
    }

//    // Union find
//    public int numComponents(ListNode head, int[] G) {
//        if(head==null){
//            return 0;
//        } else if(head.next==null){
//            return 1;
//        }
//        Map<Integer, Integer> root=new HashMap<>();
//        int total=0;
//        for(int num: G){
//            total++;
//            root.put(num, num);
//        }
//        ListNode cur=head;
//        while(cur.next!=null){
//            if(root.containsKey(cur.val) && root.containsKey(cur.next.val)){
//                int r1=findRoot(root, cur.val), r2=findRoot(root, cur.next.val);
//                if(r1!=r2){
//                    union(root, r1, r2);
//                    total--;
//                }
//            }
//            cur=cur.next;
//        }
//        return total;
//    }
//
//    private int findRoot(Map<Integer, Integer> root, int v){
//        while(root.get(v)!=v){
//            v=root.get(v);
//        }
//        return v;
//    }
//
//    private void union(Map<Integer, Integer> root, int r1, int r2){
//        root.put(r2, r1);
//    }
}
