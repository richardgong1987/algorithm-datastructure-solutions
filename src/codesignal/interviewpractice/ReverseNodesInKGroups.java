package codesignal.interviewpractice;

public class ReverseNodesInKGroups {
    ListNode<Integer> solution(ListNode<Integer> l, int k) {
        ListNode<Integer> head = new ListNode<>(null);
        ListNode<Integer> p1 = head;
        ListNode<Integer> p2 = l;
        ListNode<Integer> reversePrev = head;

        int index = 1;
        while (p2 != null) {
            if (index == k) {

                index = 1;
            } else {
                index++;
            }

            p2 = p2.next;
        }

        return head.next;
    }
}
