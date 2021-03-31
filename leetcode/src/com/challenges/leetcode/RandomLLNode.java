package com.challenges.leetcode;

import java.util.Random;

/*
 * question: https://leetcode.com/problems/linked-list-random-node/
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class RandomLLNode {

    /**
     * @param head The linked list's head.
     * Note that the head is guaranteed to be not null, so it contains at least one node.
     */

    ListNode head;
    int size;
    public RandomLLNode(ListNode head) {
        this.head = head;
        this.size = 0;
        findSize();
        this.head = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        Random rand = new Random();
        int index = rand.nextInt(this.size);
        ListNode temp = this.head;
        while (index > 0) {
            temp = temp.next;
            index--;
        }
        return temp.val;
    }

    private void findSize() {
        while (this.head != null) {
            this.head = this.head.next;
            this.size++;
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

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
