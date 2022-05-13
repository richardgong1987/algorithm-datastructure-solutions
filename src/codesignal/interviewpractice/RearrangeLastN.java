package codesignal.interviewpractice;


public class RearrangeLastN {
    public static void main(String[] args) {
        RearrangeLastN s = new RearrangeLastN();
        System.out.println(s.solution(ListNode.getNode(new Integer[]{1, 2, 3, 4, 5}), 3));
        // 7, 1, 2, 3, 4, 5, 6
    }

    ListNode<Integer> solution(ListNode<Integer> l, int n) {

        if (null == l || n == 0) {
            return l;
        }

        ListNode<Integer> fast = l;
        ListNode<Integer> slow = l;

        while (n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }

        if (n >= 0 && fast == null) {
            return l;
        }


        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode<Integer> newHead = slow.next;
        slow.next = null;
        fast.next = l;

        return newHead;
    }

    ListNode<Integer> solution2(ListNode<Integer> l, int n) {
        ListNode<Integer> head = l;
        ListNode<Integer> p1 = l;
        ListNode<Integer> p2 = l;
        ListNode<Integer> prev = null;
        if (n == 0) {
            return l;
        }
        int count = 0;
        while (p2 != null && p2.next != null) {

            if (count >= (n - 1)) {
                prev = p1;
                p1 = p1.next;
            }

            count++;
            p2 = p2.next;
        }
        if (prev == null) {
            return l;
        }
        prev.next = null;
        p2.next = head;
        return p1;
    }
}
