package com.wen.FifteenthFifty;

public class SplitLinkedListInParts {

    public static class ListNode {
        int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur=root;
        int l=0;
        while(cur!=null){
            l++;
            cur=cur.next;
        }
        ListNode[] result=new ListNode[k];
        int min=l/k, numOfMore=l%k;
        cur=root;
        for(int i=0; i<k && cur!=null; i++){
            result[i]=cur;
            for(int j=1; j<min+(i<numOfMore?1:0); j++){
                cur=cur.next;
            }
            ListNode temp=cur.next;
            cur.next=null;
            cur=temp;
        }
        return result;
    }
}
