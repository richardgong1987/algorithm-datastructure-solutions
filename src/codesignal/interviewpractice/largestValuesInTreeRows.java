package codesignal.interviewpractice;

import java.util.*;

public class largestValuesInTreeRows {
    public static void main(String[] args) {
        largestValuesInTreeRows s = new largestValuesInTreeRows();
//        System.out.println(s.solution());

    }

    // Binary trees are already defined with this interface:
    int[] solution(Tree<Integer> t) {
        if (t == null) {
            return new int[0];
        }
        Queue<Tree<Integer>> queue = new LinkedList<>();
        queue.offer(t);
        List<Integer> levelMax = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            int tmpMax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                Tree<Integer> cur = queue.poll();
                if (cur.value > tmpMax) {
                    tmpMax = cur.value;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            levelMax.add(tmpMax);
        }
        int[] result = new int[levelMax.size()];
        for (int i = 0; i < levelMax.size(); i++) {
            result[i] = levelMax.get(i);
        }
        return result;
    }
    int[] solution2(Tree<Integer> t) {
        if (t == null) {
            return new int[0];
        }

        Map<Integer, List<Integer>> memo = new HashMap<>();
        preOrder(t, 0, memo);
        int[] result = new int[memo.size()];
        for (Map.Entry<Integer, List<Integer>> it : memo.entrySet()) {
            result[it.getKey()] = Collections.max(it.getValue());
        }
        return result;
    }

    void preOrder(Tree<Integer> node, int depth, Map<Integer, List<Integer>> memo) {
        if (node == null) {
            return;
        }
        memo.computeIfAbsent(depth, k -> new ArrayList<>());

        memo.get(depth).add(node.value);

        preOrder(node.left, depth + 1, memo);
        preOrder(node.right, depth + 1, memo);
    }

}
