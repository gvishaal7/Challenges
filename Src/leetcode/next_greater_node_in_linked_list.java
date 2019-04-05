/*
 * question link: https://leetcode.com/problems/next-greater-node-in-linked-list/
 */

class next_greater_node_in_linked_list {
    public int[] nextLargerNodes(ListNode head) {
        int[] output = new int[10000];
        int index = 0;
        
        ListNode temp = head.next;
        while(head.next != null) {
            while(temp.next != null && temp.val <= head.val) {
                temp = temp.next;
            }
            if(temp.next == null && temp.val <= head.val) {
                output[index] = 0;
            }
            else {
                output[index] = temp.val;
            }
            head = head.next;
            temp = head.next;
            index++;
        }
        output[index] = 0;
        index++;
        return Arrays.copyOf(output,index);
    }
}
