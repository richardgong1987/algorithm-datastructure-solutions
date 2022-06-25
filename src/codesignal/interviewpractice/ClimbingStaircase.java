package codesignal.interviewpractice;

import java.util.ArrayList;
import java.util.List;

public class ClimbingStaircase {
    public static void main(String[] args) {
        ClimbingStaircase c = new ClimbingStaircase();
        System.out.println(c.solution(4, 2));
    }

    List<List<Integer>> solution(int n, int k) {
        List<List<Integer>> L = new ArrayList<>();

        if (n == 0 || k == 0) {
            L.add(new ArrayList<>());
            return L;
        }

        climb(L, new ArrayList<>(), n, k);

        return L;
    }

    void climb(List<List<Integer>> L, List<Integer> M, int n, int k) {
        if (n < 0) return;
        // obtain result
        if (n == 0) {
            L.add(new ArrayList<>(M));
            return; // stop
        }

        for (int i = 1; i <= k; i++) {
            // select
            M.add(i);
            climb(L, M, n - i, k);
            // deselect
            M.remove(M.size() - 1);
        }
    }
}
