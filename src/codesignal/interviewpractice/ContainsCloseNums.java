package codesignal.interviewpractice;

import java.util.HashMap;
import java.util.Map;

public class ContainsCloseNums {
    public static void main(String[] args) {
        ContainsCloseNums s = new ContainsCloseNums();
        System.out.println(s.solution(new int[]{0, 1, 2, 3, 5, 2}, 2));

    }

    boolean solution(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            var num = nums[i];
            if (m.containsKey(num)) {
                if (Math.abs(m.get(num) - i) <= k) {
                    return true;
                }
            }
            m.put(num, i);
        }

        return false;
    }
}
