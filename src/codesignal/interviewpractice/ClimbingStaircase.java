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

        climb(L, null, n, k);

        return L;
    }

    void climb(List<List<Integer>> L, List<Integer> M, int n, int k) {
        if (n < 0) return;

        if (n == 0) {
            L.add(M);
            return; // stop
        }

        for (int i = 1; i <= k; i++) {
            if (n - i < 0) {
                break;
            }


            List<Integer> P = M == null ? new ArrayList<>() : new ArrayList<>(M);
            P.add(i);
            climb(L, P, n - i, k);
        }
    }
}