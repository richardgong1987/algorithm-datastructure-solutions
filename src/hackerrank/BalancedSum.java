package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class BalancedSum {
    public static void main(String[] args) {
        System.out.println(balancedSum(new ArrayList<>(List.of(1, 2, 1))));
    }

    public static int balancedSum(List<Integer> arr) {
        for (int i = 1; i < arr.size() - 1; i++) {
            int lsum = getLsum(arr, i - 1);
            int rsum = getRsum(arr, i + 1);
            if (lsum == rsum) {
                return i;
            }
        }
        return -1;
    }

    public static int getLsum(List<Integer> arr, int end) {
        int sum = 0;
        for (int i = 0; i <= end; i++) {
            sum += arr.get(i);
        }
        return sum;
    }

    public static int getRsum(List<Integer> arr, int start) {
        int sum = 0;
        for (int i = start; i < arr.size(); i++) {
            sum += arr.get(i);
        }
        return sum;
    }
}
