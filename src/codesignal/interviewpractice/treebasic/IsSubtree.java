package codesignal.interviewpractice.treebasic;

import codesignal.interviewpractice.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class IsSubtree {
    public static void main(String[] args) {
        ArrayList<Integer> o = new ArrayList<>();

    }

    boolean solution(Tree<Integer> t1, Tree<Integer> t2) {
        if (t2 == null) return true;

        if (t1 == null) return false;

        if (areIdentical(t1, t2)) return true;

        return solution(t1.left, t2) || solution(t1.right, t2);
    }


    boolean areIdentical(Tree<Integer> root1, Tree<Integer> root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return (root1.value.equals(root2.value) && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right));
    }

    boolean solution2(Tree<Integer> t1, Tree<Integer> t2) {
        Deque<Tree<Integer>> stack1 = new LinkedList<>();
        Deque<Tree<Integer>> stack2 = new LinkedList<>();

        List<Integer> result1 = new ArrayList<>();
        List<Integer> result2 = new ArrayList<>();
        Tree<Integer> root1 = t1;
        Tree<Integer> root2 = t2;

        while (root1 != null || !stack1.isEmpty()) {
            while (root1 != null) {
                result1.add(root1.value);
                stack1.push(root1);
                root1 = root1.left;
            }
            if (!stack1.isEmpty()) {
                Tree<Integer> pop = stack1.pop();
                root1 = pop.right;
            }
        }

        while (root2 != null || !stack2.isEmpty()) {
            while (root2 != null) {
                result2.add(root2.value);
                stack2.push(root2);
                root2 = root2.left;
            }

            if (!stack2.isEmpty()) {
                Tree<Integer> pop = stack2.pop();
                root2 = pop.right;
            }
        }

        if (result2.isEmpty()) {
            return false;
        }
        return false;
    }
}
