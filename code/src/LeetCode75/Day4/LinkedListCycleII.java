package LeetCode75.Day4;
// leetcode 142

import LeetCode75.Day3.ListNode;

public class LinkedListCycleII {
    public static void main(String[] args) {
        // currently unsure about how to reverse engineer
        // the implementation of cyclic linked lists
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = new ListNode();
        ListNode fast = new ListNode();

        slow = head;
        fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow){
                // new confusing shit
                while (head != slow){
                    slow = slow.next;
                    head = head.next;
                }

                return slow;
            }
        }

        return null;
    }

}
