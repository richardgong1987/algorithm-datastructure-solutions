package codility;

import java.util.*;

public class SmallestPositiveInteger {
    public static void main(String[] args) {
        SmallestPositiveInteger s = new SmallestPositiveInteger();
        System.out.println(s.solution(new int[]{1, 3, 6, 4, 1, 2}));
    }

    /**
     * This is a demo task.
     * <p>
     * Write a function:
     * <p>
     * class Solution { public int solution(int[] A); }
     * <p>
     * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
     * <p>
     * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
     * <p>
     * Given A = [1, 2, 3], the function should return 4.
     * <p>
     * Given A = [−1, −3], the function should return 1.
     * <p>
     * Write an efficient algorithm for the following assumptions:
     * <p>
     * N is an integer within the range [1..100,000];
     * each element of array A is an integer within the range [−1,000,000..1,000,000].
     * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
     */
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            set.add(i);
        }

        int i = 1;
        while (set.contains(i)) {
            i++;
        }

        return i;
    }
}
