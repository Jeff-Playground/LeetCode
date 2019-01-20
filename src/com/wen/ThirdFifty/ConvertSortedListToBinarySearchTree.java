package com.wen.ThirdFifty;

public class ConvertSortedListToBinarySearchTree {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return new TreeNode(head.val);
        }
        ListNode slow=head, fast=head, last=head;
        while(fast.next!=null && fast.next.next!=null){
            last=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=slow.next;
        last.next=null;
        TreeNode cur=new TreeNode(slow.val);
        if(head!=slow){
            cur.left=sortedListToBST(head);
        }
        cur.right=sortedListToBST(fast);
        return cur;
    }
}
