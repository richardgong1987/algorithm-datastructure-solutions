package codesignal.interviewpractice;

import java.util.HashSet;
import java.util.Set;

public class PossibleSums {

    int solution(int[] coins, int[] quantity) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < quantity.length; i++) {
            int sum = quantity[i] * coins[i];
            set.add(sum);

        }

        return set.size();
    }
}
