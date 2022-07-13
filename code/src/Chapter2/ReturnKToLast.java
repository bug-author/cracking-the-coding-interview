package Chapter2;

// 2.2 Retirn Kth to Last
// LeetCode 19 Remove Nth Node from End of List
public class ReturnKToLast {

    public static void main(String[] args) {
        ListNode nodeE1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))); // Example 1
    }

    static ListNode removeBruteForce(ListNode head, int n) {
        // remove nth to last
        // test case : nodeE1, n = 2
        // brute force
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count += 1;
            p = p.next;
        }
        System.out.println(count);
        int i = 0;
        p = head;

        if (count - n == 0) {
            return head.next;
        }

        while (p != null) {
            i += 1;
            if (count - n == i) {
                p.next = p.next.next;
                break;
            }

            p = p.next;

        }

        System.out.println(count);

        return head;

    }
}
