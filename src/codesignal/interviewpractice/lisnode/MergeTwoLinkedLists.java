package codesignal.interviewpractice.lisnode;

import codesignal.interviewpractice.ListNode;

public class MergeTwoLinkedLists {
    ListNode<Integer> solution2(ListNode<Integer> l1, ListNode<Integer> l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.value < l2.value) {
            l1.next = solution(l1.next, l2);
            return l1;
        } else {
            l2.next = solution(l1, l2.next);
            return l2;
        }
    }

    ListNode<Integer> solution(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> result = new ListNode<>(0);
        ListNode<Integer> p = result;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 != null ? l1 : l2;
        return result.next;
    }
}
