package LeetCode75.Day3;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode convertArrayToLinkedList(int[] arr) {
        ListNode head = new ListNode();
        ListNode d = head;
        for (int number : arr) {
            ListNode temp = new ListNode(number);
            head.next = temp;
            head = head.next;
        }

        return d.next; // d starts from 0 (default value for int)
    }

    public static String toString(ListNode node) {
        String retStr = "\n";

        ListNode current = new ListNode();
        current = node;
        while (current != null) {
            retStr += current.val + " ";
            current = current.next;
        }

        retStr += "\n";

        return retStr;
    }
}
