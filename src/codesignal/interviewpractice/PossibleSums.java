package codesignal.interviewpractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PossibleSums {
    int solution(int[] coins, int[] quantity) {
        HashSet<Integer> sums = new HashSet<>();
        solve(coins, quantity, 0, 0, sums);
        return sums.size() - 1;
    }
    void solve(int[] coins, int[] quantity, int idx, int sum, HashSet<Integer> sums) {
        if (idx == coins.length) {
            sums.add(sum);
            return;
        }

        for (int i = 0; i <= quantity[idx]; i++) {
            solve(coins, quantity, idx + 1, sum + coins[idx] * i, sums);
        }
    }




    int solution2(int[] coins, int[] quantity) {
        Set<Integer> table = new HashSet<>();
        table.add(0);
        for (int i = 0; i < quantity.length; i++) {
            List<Integer> sums = new ArrayList<>(table);
            for (Integer k : sums) {
                for (int l = 1; l <= quantity[i]; l++) {
                    table.add(k + l * coins[i]);
                }
            }
        }
        return table.size() - 1;
    }
}
