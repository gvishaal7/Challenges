/*

question link : https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem

*/

/*
  Merge two linked lists 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
package com.challenges.hackerrank;

public class MergeTwoSortedLL {
    Node mergeLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method
        if (headA == null && headB == null) {
            return null;
        }
        else if (headA == null && headB != null) {
            return headB;
        }
        else if (headB == null && headA != null) {
            return headA;
        }
        else {
            Node temp = null;
            while (headA.next != null || headB.next != null) {
                if (headA.data <= headB.data) {
                    temp = addNodes(headA, temp);
                    headA = headA.next;
                }
                else {
                    temp = addNodes(headB, temp);
                    headB = headB.next;
                }
            }
            if (headA.data <= headB.data) {
                temp = addNodes(headA, temp);
                temp = addNodes(headB, temp);
            }
            else {
                temp = addNodes(headB, temp);
                temp = addNodes(headA, temp);
            }
            return temp;
        }
    }

    Node addNodes(Node head, Node temp) {
        if (temp == null) {
            temp = new Node();
            temp.data = head.data;
            temp.next = null;
        }
        else {
            Node temp1 = temp;
            Node newNode = new Node();
            newNode.data = head.data;
            newNode.next = null;
            while (temp1.next != null) {
                temp1 = temp1.next;
            }
            temp1.next = newNode;
            temp1 = temp1.next;
        }
        return temp;
    }
}
