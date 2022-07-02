package codility.beBit;

import java.util.HashSet;
import java.util.Set;

/**
 *  https://stackoverflow.com/questions/69075779/count-nodes-within-k-distance-of-marked-nodes-in-grid
 */
public class RetailStore {
    public int solution(int k, int[][] A) {

        Set<String> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    set.add(i + "#" + j);
                }

            }
        }
        int nWest = Integer.MIN_VALUE;
        int sEast = Integer.MAX_VALUE;

        int sWest = Integer.MIN_VALUE;
        int nEast = Integer.MAX_VALUE;


        for (String house : set) {
            String[] hs = house.split("#");
            int a = Integer.valueOf(hs[0]);
            int b = Integer.valueOf(hs[1]);

            nWest = Math.max(nWest, a - b - k);
            sEast = Math.min(sEast, a - b + k);

            sWest = Math.max(sWest, a + b - k);
            nEast = Math.min(nEast, a + b + k);

        }
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 0) {
                    if (nWest <= i - j && i - j <= sEast) {
                        if (sWest <= i + j && i + j <= nEast) {
                            count++;
                        }
                    }
                }

            }
        }
        return count;

    }
}
