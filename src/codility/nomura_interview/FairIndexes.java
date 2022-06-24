package codility.nomura_interview;

import java.util.Arrays;

/**
 * https://algo.monster/problems/fair_indexes
 */
public class FairIndexes {
    public static void main(String[] args) {
        FairIndexes f = new FairIndexes();
        int solution = f.solution(new int[]{0, 4, -1, 0, 3}, new int[]{0, -2, 5, 0, 3});
        System.out.println(solution);
    }

    public int solution(int[] A, int[] B) {
        // write your code in Java SE 11

        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();

        int cnt = 0;
        int tmpA = A[0];
        int tmpB = B[0];

        for (int i = 0; i < A.length; i++) {
            if (i != 1 && tmpA == tmpB && 2 * tmpA == sumA && 2 * tmpB == sumB) {
                cnt++;
            }
            tmpA += A[i];
            tmpA += B[i];
        }

        return cnt;

    }
}
