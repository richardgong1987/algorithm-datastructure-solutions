package codesignal.interviewpractice;

import java.util.LinkedList;
import java.util.List;

public class DigitTreeSum {
    long solution(Tree<Integer> t) {
        return recursion(t, 0);
    }

    private long recursion(Tree<Integer> t, long result) {
        long total = 0;
        if (t.left == null && t.right == null) {
            total += (result * 10) + t.value;
        }
        if (t.left != null) {
            total += recursion(t.left, (result * 10) + t.value);
        }
        if (t.right != null) {
            total += recursion(t.right, (result * 10) + t.value);
        }
        return total;
    }

    long solution2(Tree<Integer> t) {
        if (t == null) return 0;

        if (t.left == null && t.right == null) {
            return t.value;
        }

        List<Long> result = new LinkedList<>();

        digitTreeSumHelper(t, 0, result);

        return result.stream().mapToLong(Long::longValue).sum();
    }

    void digitTreeSumHelper(Tree<Integer> t, long parent, List<Long> result) {
        if (t == null) {
            return;
        }
        if (t.left == null && t.right == null) {
            result.add(parent * 10 + t.value);
            return;
        }

        digitTreeSumHelper(t.left, parent * 10 + t.value, result);
        digitTreeSumHelper(t.right, parent * 10 + t.value, result);
    }
}
