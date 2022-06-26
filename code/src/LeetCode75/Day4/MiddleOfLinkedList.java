package LeetCode75.Day4;

import LeetCode75.Day3.ListNode;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode l1 = new ListNode().convertArrayToLinkedList(arr1);
        ListNode mid = middleNodeSlowAndFastPointers(l1);
        System.out.println(ListNode.toString(mid));

    }

    public static ListNode middleNodeSlowAndFastPointers(ListNode head) {
        ListNode slow;
        ListNode fast;

        slow = head;
        fast = head;

        // LOOK AT THE CONDITION
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode middleNodeBruteForce(ListNode head) {
        /*
         * traverse the linked list to find out its length
         * iterate from beginnig to length / 2 to get to the middle node
         * */

        int len = 0;

        ListNode d;
        d = head;

        while (d != null) {
            d = d.next;
            len += 1;
        }

        for (int i = 0; i < len / 2; i++) {
            head = head.next;
        }

        return head;
    }

}