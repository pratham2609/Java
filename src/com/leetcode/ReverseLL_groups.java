package com.leetcode;
public class ReverseLL_groups {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    int length(ListNode head)
    {
        ListNode temp = head;
        int count = 0;
        while(temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;

        int len = length(head);

        // size is greater or not
        if(k > len) return head;


        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        int count = 0;

        while(count < k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (curr != null) head.next = reverseKGroup(next, k);

        // prev is now head of input list
        return prev;

    }
}
