package codesignal.interviewpractice.lisnode;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseNodesInKGroups {
    public static void main(String[] args) {
        ReverseNodesInKGroups s = new ReverseNodesInKGroups();
        System.out.println(s.solution(ListNode.getNode(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}), 3));
    }

    ListNode<Integer> solution(ListNode<Integer> head, int k) {
        ListNode<Integer> dummy = new ListNode<>(-1);
        dummy.next = head;
        ListNode<Integer> begin = dummy;
        int count = 0;
        while (head != null) {
            count++;
            if (count % k == 0) {
                begin = reverseNode(begin, head.next);
            }
            head = head.next;
        }
        return dummy.next;
    }

    private ListNode<Integer> reverseNode(ListNode<Integer> begin, ListNode<Integer> end) {
        ListNode<Integer> prev = begin;
        ListNode<Integer> curr = begin.next;
        ListNode<Integer> first = curr;
        while (curr != end) {
            ListNode<Integer> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = curr;
        return first;
    }

    ListNode<Integer> solution2(ListNode<Integer> l, int k) {
        ListNode<Integer> p = l;
        int count = 0;
        while (p != null && count != k) {
            p = p.next;
            count++;
        }
        if (count == k) {
            p = solution(p, k);
            while (count-- > 0) {
                ListNode<Integer> temp = l.next;
                l.next = p;
                p = l;
                l = temp;
            }
            l = p;
        }
        return l;
    }

    ListNode<Integer> solution3(ListNode<Integer> l, int k) {
        ListNode<Integer> head = new ListNode<>(null);
        ListNode<Integer> p1 = l;
        ListNode<Integer> p2 = head;
        Deque<ListNode<Integer>> q = new LinkedList<>();
        int index = 0;
        while (p1 != null) {
            index++;
            q.push(p1);
            p1 = p1.next;

            if (index == k) {
                while (!q.isEmpty()) {
                    p2.next = q.pop();
                    p2.next.next = null;
                    p2 = p2.next;
                }
                index = 0;
            }
        }
        while (!q.isEmpty()) {
            p2.next = q.pollLast();
            p2.next.next = null;
            p2 = p2.next;
        }
        return head.next;
    }
}
