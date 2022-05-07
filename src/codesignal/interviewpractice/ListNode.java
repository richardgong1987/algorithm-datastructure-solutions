package codesignal.interviewpractice;


public class ListNode<T> {
    public static <C> ListNode<C> getNode(C[] arr) {
        ListNode<C> root = null;
        ListNode<C> p = null;
        for (C i : arr) {
            ListNode<C> node = new ListNode<>(i);
            if (root == null) {
                p = root = node;
            } else {
                p.next = node;
                p = p.next;
            }
        }
        return root;
    }

    public ListNode(T x) {
        value = x;
    }

    T value;
    ListNode<T> next;
}
