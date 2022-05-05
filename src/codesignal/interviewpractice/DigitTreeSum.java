package codesignal.interviewpractice;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    long solution3(Tree<Integer> t) {
        long ans = 0;

        if (t == null) {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(t, 0));

        while (!q.isEmpty()) {
            Pair p = q.remove();
            long x = p.num * 10 + p.x.value;

            if (p.x.left == null && p.x.right == null) {
                ans += x;
            }

            if (p.x.left != null) {
                q.add(new Pair(p.x.left, x));
            }

            if (p.x.right != null) {
                q.add(new Pair(p.x.right, x));
            }
        }

        return ans;
    }

    static class Pair {
        Tree<Integer> x;
        long num;

        Pair(Tree<Integer> x, long num) {
            this.x = x;
            this.num = num;
        }
    }
}
