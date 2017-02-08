/*
Question : https://www.hackerrank.com/challenges/ctci-linked-list-cycle
*/

/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
    boolean cycle = false;
    try {
        if(head!=null) {
            if(head.next !=null) {
                Node double_pointer = head.next;
                Node new_head = head;
                while(double_pointer.next != new_head) {
                    new_head = new_head.next;
                    double_pointer = double_pointer.next.next;
                    if(double_pointer.next == new_head) {
                        cycle = true;
                        break;
                    }
                }
            }
            else {
                cycle = false;
            }
            
        }
        else {
            cycle = false;
        }
        
    } catch(Exception e) {
        e.printStackTrace();
    }
    return cycle;
 
}
