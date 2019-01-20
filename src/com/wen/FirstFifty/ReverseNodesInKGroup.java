package com.wen.FirstFifty;

public class ReverseNodesInKGroup {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
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

    // Loop
//    public ListNode reverseKGroup(ListNode head, int k) {
//        if(k==1 || head==null || head.next==null){
//            return head;
//        }
//        ListNode dummy=new ListNode(-1);
//        dummy.next=head;
//        ListNode pre=dummy;
//        ListNode left=dummy;
//        ListNode right=dummy;
//        int i=k+1;
//        while(i==k+1){
//            ListNode temp=pre;
//            int j=1;
//            while(j<k+1){
//                if(temp.next==null){
//                    break;
//                } else{
//                    temp= temp.next;
//                    j++;
//                }
//            }
//            if(j<k+1){
//                break;
//            }
//            left=pre.next;
//            right=left.next;
//            i=2;
//            while(i<k+1){
//                if(right==null){
//                    break;
//                } else{
//                    left.next=right.next;
//                    right.next=pre.next;
//                    pre.next=right;
//                    right=left.next;
//                    i++;
//                }
//            }
//            pre=left;
//            i=k+1;
//        }
//        return dummy.next;
//    }
}
