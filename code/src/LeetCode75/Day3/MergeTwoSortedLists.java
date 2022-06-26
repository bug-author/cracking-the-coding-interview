package LeetCode75.Day3;
// leetcode 21

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};
        ListNode list1 = new ListNode();
        list1 = list1.convertArrayToLinkedList(arr1);
        System.out.print("List 1");
        System.out.println(ListNode.toString(list1));

        ListNode list2 = new ListNode();
        list2 = list2.convertArrayToLinkedList(arr2);

        System.out.print("List 2");
        System.out.println(ListNode.toString(list2));

        // merging
        ListNode mergedList = mergeTwoLists(list1, list2);
        System.out.println(ListNode.toString(mergedList));

    }


    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        ListNode head = node;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                node = node.next;
                list1 = list1.next;
            } else {
                node.next = list2;
                node = node.next;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            node.next = list1;
        } else {
            node.next = list2;
        }

        return head.next;
    }
}
