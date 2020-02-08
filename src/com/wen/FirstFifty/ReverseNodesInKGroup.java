package com.wen.FirstFifty;

public class ReverseNodesInKGroup {
    public static class ListNode {
        int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    // Recursive
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        int i = 0;
        while(p != null && i < k) {
            p = p.next;
            i++;
        }
        if(i == k) {
            p = reverseKGroup(p, k);
            while(i-- > 0) {
                ListNode tmp = head.next;
                head.next = p;
                p = head;
                head = tmp;
            }
            head = p;
        }
        return head;
    }

//    // Iterative
//    public static ListNode reverseKGroup(ListNode head, int k) {
//        ListNode dummy=new ListNode(-1);
//        dummy.next=head;
//        ListNode cur=head, last=dummy, tail=dummy;
//        int count=1;
//        while(cur!=null){
//            while(cur.next!=null && count<k){
//                cur=cur.next;
//                count++;
//            }
//            if(count==k){
//                cur=cur.next;
//                count=1;
//                tail=last.next;
//                last.next=cur;
//                ListNode t1=tail, t2=t1.next;
//                for(int i=0; i<k; i++){
//                    t1.next=last.next;
//                    last.next=t1;
//                    t1=t2;
//                    t2=t1!=null?t1.next:null;
//                }
//                last=tail;
//            } else{
//                break;
//            }
//        }
//        return dummy.next;
//    }
}
