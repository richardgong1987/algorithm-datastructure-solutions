package codesignal.interviewpractice;

import java.util.*;

public class TraverseTree {
    int[] solution(Tree<Integer> t) {
        if (t == null) {
            return new int[0];
        }
        Queue<Tree<Integer>> q = new LinkedList<>();
        List<Integer> values = new ArrayList<>();
        q.offer(t);
        while (!q.isEmpty()) {
            Tree<Integer> currentNode = q.poll();
            values.add(currentNode.value);
            if (currentNode.left != null) {
                q.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                q.offer(currentNode.right);
            }
        }
        return values.stream().mapToInt(Integer::intValue).toArray();
    }

}
