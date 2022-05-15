package codesignal.interviewpractice.treebasic;

import codesignal.interviewpractice.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class KthSmallestInBST {
    int solution(Tree<Integer> t, int k) {
        int index = 0;
        Deque<Tree<Integer>> stack = new LinkedList<>();

        while (t != null || !stack.isEmpty()) {
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
            if (!stack.isEmpty()) {
                Tree<Integer> node = stack.pop();
                index++;
                if (index == k) {
                    return node.value;
                }
                t = node.right;
            }
        }
        return t.value;
    }

    int solution2(Tree<Integer> t, int k) {
        return preOder(t, k);
    }

    int preOder(Tree<Integer> t, int k) {
        if (t == null) {
            return 0;
        }

        preOder(t.left, k);
        preOder(t.right, k);
        if (t.left == null && t.right == null) {

        }
        return 0;
    }
}
