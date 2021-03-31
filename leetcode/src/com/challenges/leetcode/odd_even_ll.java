/*
question link : https://leetcode.com/problems/odd-even-linked-list/description/
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

package com.challenges.leetcode;

class odd_even_ll {

    public ListNode oddEvenList(ListNode head) {
        if (head != null && head.next != null) {
            ListNode odd = head;
            ListNode odd1 = odd;
            ListNode even = head.next;
            ListNode even1 = even;
            while (odd.next != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = even1;
            return odd1;
        }
        else {
            return head;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
