package codility.nomura_interview;

/**
 * https://algo.monster/problems/max_network_rank
 */
public class MaxNetworkRank {
    public static void main(String[] args) {

    }

    public int solution(int[] A, int[] B, int N) {
        // write your code in Java SE 11
        int[] edgeCnt = new int[N];
        int m = A.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            edgeCnt[A[i] - 1]++;
            edgeCnt[B[i] - 1]++;
        }
        for (int j : A) {
            max = Math.max(edgeCnt[j], max);
        }
        return max;
    }
}
