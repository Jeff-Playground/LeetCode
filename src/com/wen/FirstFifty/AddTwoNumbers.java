package com.wen.FirstFifty;

public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum;
            if (l1 == null) {
                l1 = l2;
                l2 = null;
            }
            if (l2 == null) {
                if (carry == 0) {
                    current.next = l1;
                    break;
                }
                sum = l1.val;
            } else {
                sum = l1.val + l2.val;
                l2 = l2.next;
            }
            l1 = l1.next;
            sum += carry;
            current.next = new ListNode(sum % 10);
            current = current.next;
            carry = sum / 10;
        }
        if (carry != 0) {
            current.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
