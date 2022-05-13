package codesignal.interviewpractice.treebasic;

import codesignal.interviewpractice.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class HasPathWithGivenSum {
    public static void main(String[] args) {
        HasPathWithGivenSum s = new HasPathWithGivenSum();
        System.out.println(s.solution(new Tree<>(5), 5));
    }

    boolean solution(Tree<Integer> t, int s) {
        //If just one of left or right was null, then it was not a child node and false can be returned safely
        if (t == null) return false;

        //If this is a child AND sum is input, then we have a path
        if (t.left == null && t.right == null) {
            return (s == t.value);
        }

        return solution(t.left, s - t.value) || solution(t.right, s - t.value);
    }

    boolean solution2(Tree<Integer> t, int s) {
        if (t == null) {
            return false;
        }

        Deque<Pair> q = new LinkedList<>();
        q.push(new Pair(t, s - t.value));

        boolean isHas = false;
        while (!q.isEmpty()) {
            Pair node = q.pop();
            if (node.t.left == null && node.t.right == null) {
                isHas = node.s == 0 || isHas;
            }
            if (node.t.left != null) {
                q.push(new Pair(node.t.left, node.s - node.t.left.value));

            }
            if (node.t.right != null) {
                q.push(new Pair(node.t.right, node.s - node.t.right.value));
            }
        }

        return isHas;
    }

    class Pair {
        Tree<Integer> t;
        int s;

        Pair(Tree<Integer> t, int s) {
            this.t = t;
            this.s = s;
        }
    }
}
