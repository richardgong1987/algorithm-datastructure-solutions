package codesignal.interviewpractice;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class GraphDistances {
    int[] solution(int[][] g, int s) {
        int[] costs = new int[g.length];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[s] = 0;

        Deque<Integer> stack = new LinkedList<>();
        stack.push(s);

        while (!stack.isEmpty()) {
            int p = stack.pop();
            for (int i = 0; i < g.length; i++) {
                if (g[p][i] == -1) continue;
                int newcost = costs[p] + g[p][i];
                if (costs[i] > newcost) {
                    costs[i] = newcost;
                    stack.push(i);
                }
            }
        }
        return costs;
    }
}
