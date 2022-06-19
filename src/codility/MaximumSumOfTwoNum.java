package codility;

import java.util.*;

/**
 * https://jaydeepwise.medium.com/maximum-sum-of-two-numbers-microsoft-online-onsite-interview-codility-platform-ee0653a5005f
 */
public class MaximumSumOfTwoNum {
    public static void main(String[] args) {
        MaximumSumOfTwoNum x = new MaximumSumOfTwoNum();
        int solution = x.solution(new int[]{42, 33, 60});
        System.out.println(solution);
    }

    private int subSum(int n) {
        int sum = 0;
        while (n >= 10) {
            sum += n % 10;
            n = n / 10;
        }

        sum += n;

        return sum;
    }

    public int solution(int[] A) {
        // write your code in Java SE 11
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = -1;
        for (int j : A) {
            int tmp = subSum(j);
            map.computeIfAbsent(tmp, k -> new ArrayList<>());
            map.get(tmp).add(j);
        }

        for (Map.Entry<Integer, List<Integer>> it : map.entrySet()) {
            List<Integer> value = it.getValue();
            int size = value.size();
            if (size > 1) {
                Collections.sort(value);
                sum = Math.max(sum, value.get(size - 1)+value.get(size - 2));
            }
        }
        return sum;
    }
}
