package com.wen.FirstFifty;

public class ReverseNodesInKGroup {
    public static class ListNode {
        int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

//    // Recursive
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode p = head;
//        int i = 0;
//        while(p != null && i < k) {
//            p = p.next;
//            i++;
//        }
//        if(i == k) {
//            p = reverseKGroup(p, k);
//            while(i-- > 0) {
//                ListNode tmp = head.next;
//                head.next = p;
//                p = head;
//                head = tmp;
//            }
//            head = p;
//        }
//        return head;
//    }

//    // Loop
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode dummy=new ListNode(-1);
//        ListNode next=head, cur=head, curNew=dummy;
//        while(next!=null){
//            int i=1;
//            while(next!=null && i<k){
//                next=next.next;
//                i++;
//            }
//            if(i==k && next!=null){
//                next=next.next;
//                ListNode tail=cur;
//                while(cur!=next){
//                    ListNode temp1=curNew.next;
//                    curNew.next=cur;
//                    ListNode temp2=cur.next;
//                    cur.next=temp1;
//                    cur=temp2;
//                }
//                curNew=tail;
//            } else{
//                curNew.next=cur;
//                break;
//            }
//        }
//        return dummy.next;
//    }

    // Recursive
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1){
            return head;
        }
        int i=1;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode next=head;
        while(next!=null && i<k){
            next=next.next;
        }
        if(i==k && next!=null){
            next=next.next;
            ListNode cur=head;
            while(cur!=next){
                ListNode temp=dummy.next;
                ListNode curNext=cur.next;
                dummy.next=cur;
                cur.next=temp;
                cur=curNext;
            }
            head.next=reverseKGroup(next, k);
        } else{
            return head;
        }
        return dummy.next;
    }
}
