package com.wen.NinthFifty;

import java.util.Stack;

public class AddTwoNumbersII {
    public class ListNode {
        int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    // Find the carryNode where nodes after it has value of 9, and do add starting from most significant bits
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1=getLength(l1), n2=getLength(l2), diff=Math.abs(n1-n2);
        if(n1<n2){
            ListNode temp=l1;
            l1=l2;
            l2=temp;
        }
        ListNode result=new ListNode(0), cur=result, carryNode=result;
        while(diff-->0){
            cur.next=new ListNode(l1.val);
            l1=l1.next;
            cur=cur.next;
            if(cur.val!=9){
                carryNode=cur;
            }
        }
        while(l1!=null){
            int val=l1.val+l2.val;
            if(val>9){
                val%=10;
                carryNode.val++;
                while(carryNode.next!=null){
                    carryNode.next.val=0;
                    carryNode=carryNode.next;
                }
            }
            cur.next=new ListNode(val);
            if(val!=9){
                carryNode=cur.next;
            }
            cur=cur.next;
            l1=l1.next;
            l2=l2.next;
        }
        return result.val==1?result:result.next;
    }

//    // Do adding recursively
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int n1=getLength(l1), n2=getLength(l2);
//        ListNode result=new ListNode(1);
//        result.next=n1>n2?atnHelper(l1, l2, n1-n2):atnHelper(l2, l1, n2-n1);
//        if(result.next.val>9){
//            result.next.val=result.next.val%10;
//            return result;
//        }
//        return result.next;
//    }
//
//    private ListNode atnHelper(ListNode l1, ListNode l2, int diff){
//        if(l1==null){
//            return null;
//        } else{
//            ListNode cur=diff==0?new ListNode(l1.val+l2.val):new ListNode(l1.val);
//            ListNode next=diff==0?atnHelper(l1.next, l2.next, 0):atnHelper(l1.next, l2, diff-1);
//            if(next!=null && next.val>9){
//                next.val=next.val%10;
//                cur.val++;
//            }
//            cur.next=next;
//            return cur;
//        }
//    }

    private int getLength(ListNode l){
        int result=0;
        ListNode cur=l;
        while(cur!=null){
            result++;
            cur=cur.next;
        }
        return result;
    }

//    // Use stack to reverse the lists and do sum
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode result=new ListNode(-1);
//        Stack<ListNode> s1=new Stack<>();
//        Stack<ListNode> s2=new Stack<>();
//        ListNode cur=l1;
//        while(cur!=null){
//            s1.push(cur);
//            cur=cur.next;
//        }
//        cur=l2;
//        while(cur!=null){
//            s2.push(cur);
//            cur=cur.next;
//        }
//        int carry=0;
//        while(!s1.isEmpty() || !s2.isEmpty()){
//            ListNode n1=!s1.isEmpty()?s1.pop():null, n2=!s2.isEmpty()?s2.pop():null;
//            int sum=carry+(n1!=null?n1.val:0)+(n2!=null?n2.val:0);
//            carry=sum/10;
//            ListNode sumNode=new ListNode(sum%10);
//            sumNode.next=result.next;
//            result.next=sumNode;
//        }
//        if(carry==1){
//            ListNode last=new ListNode(1);
//            last.next=result.next;
//            result.next=last;
//        }
//        return result.next;
//    }
}
