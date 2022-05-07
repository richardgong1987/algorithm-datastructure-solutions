package codesignal.interviewpractice;

public class RemoveKFromList {
    public static void main(String[] args) {
        ListNode<Integer> node = ListNode.getNode(new Integer[]{123, 456, 789, 0});
        RemoveKFromList s = new RemoveKFromList();
        System.out.println(s.solution(node, 0));
        System.out.println(s.solution2(node, 0));
    }

    ListNode<Integer> solution(ListNode<Integer> node, int k) {

        if (node == null) {
            return null;
        }

        node.next = solution(node.next, k);

        if (node.value == k) {
            return node.next;
        }

        return node;

    }

    ListNode<Integer> solution2(ListNode<Integer> l, int k) {
        ListNode<Integer> head = new ListNode<>(null);
        head.next = l;
        ListNode<Integer> current = l;
        ListNode<Integer> previous = head;

        while (current != null) {
            if (current.value == k) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }

        return head.next;
    }

    ListNode<Integer> solution3(ListNode<Integer> l, int k) {
        ListNode<Integer> root = null;
        ListNode<Integer> result = null;

        while (l != null) {
            ListNode<Integer> tmp = new ListNode<>(l.value);
            if (l.value != k) {
                if (root == null) {
                    result = root = tmp;
                } else {
                    root.next = tmp;
                    root = root.next;
                }
            }
            l = l.next;
        }
        return result;
    }
}
