package codesignal.interviewpractice.treebasic;

import codesignal.interviewpractice.Tree;

import java.util.*;

public class IsTreeSymmetric {
    boolean solution(Tree<Integer> t) {
        if (t == null) {
            return true;
        }
        return helper(t.left, t.right);
    }

    boolean helper(Tree<Integer> left, Tree<Integer> right) {
        //base case
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        // ask a boolean from left, a boolean from right and return result upwards
        return (left.value.equals(right.value)) && helper(left.left, right.right) && helper(left.right, right.left);
    }


    boolean solution2(Tree<Integer> t) {
        if (t == null) {
            return true;
        }

        Deque<Tree<Integer>> q = new LinkedList<>();
        q.push(t.left);
        q.push(t.right);


        while (!q.isEmpty()) {
            Tree<Integer> l = q.pop();
            Tree<Integer> r = q.pop();

            if (l == null && r == null) {
                continue;
            }

            if (l == null || r == null || !l.value.equals(r.value)) {
                return false;
            }

            q.push(l.left);
            q.push(r.right);


            q.push(r.left);
            q.push(l.right);

        }
        return true;
    }

}
