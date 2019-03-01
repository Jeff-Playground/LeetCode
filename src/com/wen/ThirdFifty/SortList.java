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
        ListNode slow=head, fast=head, pre=head;
        while(fast!=null && fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        pre.next=null;
        // Note for optimized merge method this can't be return merge(head, slow) because the merge method assumes it's merging two sorted list
        return merge(sortList(head), sortList(slow));
    }

    // Optimized merge method
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

//    // Normal merge method
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
