package LeetCode75.Day3;
// leetcode 206

public class ReverseLinkedList {
    public static void main(String[] args){
        int[] arr1 =  {1,2,3,4};
        ListNode list1 = new ListNode().convertArrayToLinkedList(arr1);
        System.out.println("Linked List");
        System.out.println(ListNode.toString(list1));

        System.out.println("Reversed Linked List");
        ListNode rev = reverseList(list1);
        System.out.println(ListNode.toString(rev));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = new ListNode();
        ListNode next = new ListNode();

        current = head;

        while (current != null){
            next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }

        return prev;
    }
}
