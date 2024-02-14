package com.leetcode;

public class Rotate_LL {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if(k <= 0 || head == null || head.next == null) return head;
            ListNode curr = head;
            int length = 0;
            // find length of LL
            while(curr != null){
                curr = curr.next;
                length++;
            }
            // number of rotations
            k = k % length;

            // return head if no rotation is required
            if(k == 0) return head;

            //set the current node as head and iterate till the node  after which we would need to bring it forward
            curr = head;
            int n = length - k;
            while(--n > 0) curr= curr.next;

            //set temp as the node next to the current node
            ListNode temp=curr.next;

            //set the next of current node as NULL
            curr.next=null;

            //set head1 as temp(from which we need to bring forward)
            ListNode head1=temp;

            //iterate to the end
            while(temp.next != null){
                temp = temp.next;
            }
            //set the next of the last node as head.
            temp.next=head;

            return head1;

        }
    }
}
