package Chapter2;

import java.util.HashMap;
import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode(0, null, null);
        LinkedListNode head = first;
        LinkedListNode second = first;
        for (int i = 0; i < 8; i++) {
            second = new LinkedListNode(i % 2, null, null);
            first.setNext(second);
            second.setPrevious(first);
            first = second;
        }
        System.out.println(head.printForward());
        removeDuplicates(head);
        System.out.println(head.printForward());
    }

    static void removeDuplicates(LinkedListNode head) {
        HashSet<Integer> hashSet = new HashSet<>();
        LinkedListNode p = null;

        while (head != null) {
            if(hashSet.contains(head.data)){
                p.next = head.next;
            }
            else{
                hashSet.add(head.data);
                p = head;
            }
            head = head.next;
        }


    }
}

