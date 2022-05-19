package codility;

import java.util.Arrays;

public class RollDice {
    public static void main(String[] args) {
        RollDice s = new RollDice();
        System.out.println(Arrays.toString(s.solution(new int[]{1, 5, 6}, 4, 3)));
        System.out.println(Arrays.toString(s.solution2(new int[]{1, 5, 6}, 4, 3)));
    }

    public int solution(String S) {
        // write your code in Java SE 8
        int length = S.length();
        if (length == 1) {
            return 0;
        }
        if (length % 2 == 0) {
            return -1;
        }
        int left = 0;
        int right = length - 1;
        while (left < right) {
            if (S.charAt(left) != S.charAt(right)) {
                return -1;
            }
            left++;
            right--;
        }
        return left;
    }

    public int[] solution(int[] A, int F, int M) {
        int sum = Arrays.stream(A).sum();

        int diffSum = M * (A.length + F) - sum;
        if (diffSum / F > 6) return new int[]{0}; // Not Possible case


        int avg = diffSum / F;

        int[] farr = new int[F];
        for (int x = 0; x < F; x++) {
            if (x == F - 1) {
                farr[x] = diffSum;
                continue;
            }
            farr[x] = avg;
            diffSum -= avg;
        }
        return farr;
    }

    public int[] solution2(int[] A, int F, int M) {
        int sumA = Arrays.stream(A).sum();

        int target = M * (F + A.length) - sumA;

        double eachRollActual = target / (double) F;

        int eachRoll = target / F;


        if (eachRollActual < 0 || eachRollActual > 6) {
            return new int[]{0};
        }

        int[] ans = new int[F];

        int rem = target % F;
        for (int i = 0; i < F; i++) {
            ans[i] = eachRoll + (rem <= 0 ? 0 : 1);
            rem--;
        }

        return ans;
    }
}
