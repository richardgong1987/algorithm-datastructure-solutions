package codesignal.interviewpractice;

import java.util.*;

public class AddTwoHugeNumbers {
    public static void main(String[] args) {
        AddTwoHugeNumbers addTwoHugeNumbers = new AddTwoHugeNumbers();
        ListNode<Integer> a = ListNode.getNode(new Integer[]{123, 4, 5});
        ListNode<Integer> b = ListNode.getNode(new Integer[]{100, 100, 100});
        System.out.println(addTwoHugeNumbers.solution(a, b));

    }

    ListNode<Integer> solution(ListNode<Integer> a, ListNode<Integer> b) {
        int L = 10000;
        Deque<Integer> U = new LinkedList<>();
        Deque<Integer> V = new LinkedList<>();

        while(a != null) {
            U.push(a.value);
            a = a.next;
        }

        while(b != null) {
            V.push(b.value);
            b = b.next;
        }

        // compose the nodes backwards
        int C = 0;
        ListNode<Integer> prevNode = null;
        while(C > 0 || (!U.isEmpty() || !V.isEmpty())) {
            int X = U.isEmpty() ? 0 : U.pop();
            int Y = V.isEmpty() ? 0 : V.pop();

            int Z = X+Y+C;  // opA + opB + carry
            C = Z / L;
            ListNode<Integer> currentNode = new ListNode<>(Z % L);
            currentNode.next = prevNode;
            prevNode = currentNode;
        }

        return prevNode;
    }
}
