package com.wen.ThirdFifty;

public class SortList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode slow=head, fast=head, end=head;
        while(fast!=null && fast.next!=null){
            end=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        end.next=null;
        return merge(sortList(head), sortList(slow));
    }

    // Recursive merge
    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next=merge(l1.next, l2);
            return l1;
        } else{
            l2.next=merge(l1, l2.next);
            return l2;
        }
    }

//    // Iterative merge
//    private ListNode merge(ListNode l1, ListNode l2) {
//        ListNode dummy=new ListNode(-1);
//        ListNode cur=dummy;
//        while(l1!=null && l2!=null){
//            if(l1.val<l2.val){
//                cur.next=l1;
//                l1=l1.next;
//            } else{
//                cur.next=l2;
//                l2=l2.next;
//            }
//            cur=cur.next;
//        }
//        if(l1!=null){
//            cur.next=l1;
//        }
//        if(l2!=null){
//            cur.next=l2;
//        }
//        return dummy.next;
//    }
}
