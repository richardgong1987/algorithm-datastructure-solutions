package codesignal.interviewpractice.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    int[][] solution(int n) {
        List<List<Integer>> pos = new ArrayList<>();
        calcPos(pos, new ArrayList<>(), 0, n);
        int[][] result = new int[pos.size()][];
        for (int i = 0; i < pos.size(); ++i) {
            int[] r = new int[pos.get(i).size()];
            for (int j = 0; j < pos.get(i).size(); ++j) {
                r[j] = pos.get(i).get(j) + 1;
            }
            result[i] = r;
        }
        return result;
    }

    private void calcPos(List<List<Integer>> pos, List<Integer> current, int index, int n) {
        if (current.size() == n) {
            pos.add(current);
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (ok(current, i)) {
                List<Integer> newList = new ArrayList<>(current);
                newList.add(i);
                calcPos(pos, newList, index + 1, n);
            }
        }
    }

    private boolean ok(List<Integer> list, int index) {
        for (int i = 0; i < list.size(); ++i) {
            int y = list.get(i);
            if (y == index) {
                return false;
            }
            if (Math.abs(y - index) == Math.abs(i - list.size())) {
                return false;
            }
        }
        return true;
    }
}
