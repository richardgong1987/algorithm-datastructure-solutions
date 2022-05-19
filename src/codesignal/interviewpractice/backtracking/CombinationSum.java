package codesignal.interviewpractice.backtracking;

import java.util.stream.IntStream;

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum s = new CombinationSum();
        System.out.println(s.solution(new int[]{8, 1, 8, 6, 8}, 12));
    }

    String solution;
    int[] nums;

    String solution(int[] a, int sum) {
        nums = IntStream.of(a).distinct().sorted().toArray();
        solution = "";
        combinations("(", sum, 0);
        nums = null;
        String sol = solution;
        solution = null;
        if (sol.length() == 0) return "Empty";
        return sol;
    }

    void combinations(String s, int sum, int pos) {
        String s2;
        if (s.length() > 1) s2 = s + " ";
        else s2 = s;
        while (pos < nums.length && sum >= nums[pos]) {
            if (nums[pos] == sum) solution += s2 + nums[pos] + ")";
            else {
                combinations(s2 + nums[pos], sum - nums[pos], pos);
            }
            ++pos;
        }
    }
}
