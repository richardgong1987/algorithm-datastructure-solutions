package codesignal.interviewpractice;

import java.util.Deque;
import java.util.LinkedList;

public class IsListPalindrome {

    boolean solution(ListNode<Integer> head) {
        ListNode<Integer> slow = head;
        Deque<Integer> stack = new LinkedList<>();

        while (slow != null) {
            stack.push(slow.value);
            slow = slow.next;
        }

        while (head != null) {
            int i = stack.pop();
            if (head.value != i) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    boolean solution2(ListNode<Integer> l) {

        ListNode<Integer> p1 = l;
        ListNode<Integer> p2 = reverse(l);
        while (p1 != null) {
            if (!p1.value.equals(p2.value)) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public ListNode reverse(ListNode<Integer> head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

}
