package com.leetcode;

//https://leetcode.com/problems/add-two-numbers/description/
// optimised soln
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }
}
public class Two_sum {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        l2 = insert(l2, 9);
        l2 = insert(l2, 9);
        l2 = insert(l2, 9);
        l2 = insert(l2, 9);
        l2 = insert(l2, 9);
        l2 = insert(l2, 9);
        l2 = insert(l2, 9);
        l2 = insert(l2, 9);
        l2 = insert(l2, 9);
        l2 = insert(l2, 9);

        ListNode n = new ListNode();
        n = addTwoNumbers(l1, l2);
        display(n);
//        display(l2);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode ans = null;
        if(l1.next == null && l2.next == null){
            int sum = l1.val + l2.val;
            while(sum > 0){
                ans = insert(ans, sum % 10);
                sum /= 10;
            }
            return ans;
        }
        long num1 = 0;
        while(l1 != null){
            num1 = num1 * 10;
            num1 += l1.val;
            l1= l1.next;
        }
        long num2 = 0;
        while(l2 != null){
            num2 = num2 * 10;
            num2 += l2.val;
            l2= l2.next;
        }
        long sum = num1 + num2;
        while(sum > 0){
            ans = insert(ans, sum % 10);
            sum /= 10;
        }
        return ans;
    }
    public static ListNode insert(ListNode head, long val){
        ListNode in = new ListNode((int)val);
        if(head == null){
            head = in;
        }
        else{
            ListNode tail = head;
            while(tail.next != null){
                tail = tail.next;
            }
            tail.next = in;
        }
        return head;
    }
    static ListNode reverse(ListNode l){
        ListNode curr = l;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        l = prev;
        return l;
    }
    static void display(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + ",");
            temp = temp.next;
        }
    }
}
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
