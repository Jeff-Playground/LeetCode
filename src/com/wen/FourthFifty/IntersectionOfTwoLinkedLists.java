package com.wen.FourthFifty;

public class IntersectionOfTwoLinkedLists {
    public static class ListNode {
        int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        ListNode curA=headA, curB=headB;
        while(curA!=curB){
            curA=curA!=null?curA.next:headB;
            curB=curB!=null?curB.next:headA;
        }
        return curA;
    }

//    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        int lengthA=0, lengthB=0;
//        ListNode tempA=headA;
//        while(tempA!=null){
//            lengthA++;
//            tempA=tempA.next;
//        }
//        ListNode tempB=headB;
//        while(tempB!=null){
//            lengthB++;
//            tempB=tempB.next;
//        }
//        tempA=headA;
//        tempB=headB;
//        if(lengthA>lengthB){
//            for(int i=lengthA-lengthB; i>=0; i--){
//                tempA=tempA.next;
//            }
//        } else if(lengthB>lengthA){
//            for(int i=lengthB-lengthA; i>0; i--){
//                tempB=tempB.next;
//            }
//        }
//        while(tempA!=null && tempB!=null){
//            if(tempA==tempB){
//                return tempA;
//            }
//            tempA=tempA.next;
//            tempB=tempB.next;
//        }
//        return null;
//    }
}
