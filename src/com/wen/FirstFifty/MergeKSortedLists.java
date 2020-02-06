package com.wen.FirstFifty;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Using a heap, note this is not inserting all elements into heap and then get the top from heap,
    // the heap should only have k elements at most
    // N is the number of total nodes, k is the number of lists
    // Time complexity: O(Nlogk)
    // Space Complexity: O(1+k) for in-place + PriorityQueue
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) {
            return null;
        }
        PriorityQueue<ListNode> queue=new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });

        ListNode head = new ListNode(0);
        ListNode p = head;

        for(ListNode list: lists){
            if(list!=null){
                queue.offer(list);
            }
        }

        while(!queue.isEmpty()){
            ListNode n = queue.poll();
            p.next = n;
            p=p.next;
            if(n.next!=null){
                queue.offer(n.next);
            }
        }

        return head.next;
    }

//    // Recursive
//    // N is the number of total nodes, k is the number of lists
//    // Time complexity: O(Nlogk)
//    // Space Complexity: O(1) for in-place
//    public ListNode mergeKLists(ListNode[] lists) {
//        int n=lists.length;
//        if(n==0) {
//            return null;
//        }
//        while(n>1) {
//            int k=(n+1)/2;
//            for(int i=0; i<n/2; i++) {
//                lists[i]=mergeTwoLists(lists[i], lists[i+k]);
//            }
//            n=k;
//        }
//        return lists[0];
//    }
//
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if(l1==null) {
//            return l2;
//        }
//        if(l2==null) {
//            return l1;
//        }
//        if(l1.val>l2.val) {
//            l2.next=mergeTwoLists(l1, l2.next);
//            return l2;
//        } else {
//            l1.next=mergeTwoLists(l1.next, l2);
//            return l1;
//        }
//    }
}
