package com.wen.FirstFifty;

public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(-1);
        ListNode current=result;
        while(l1!=null && l2!=null){
            if(l1.val>l2.val){
                current.next=l2;
                l2=l2.next;
            } else{
                current.next=l1;
                l1=l1.next;
            }
            current=current.next;
        }
        if(l1!=null){
            current.next=l1;
        } else {
            current.next=l2;
        }
        return result.next;
    }
}
