package leetcode.binarysearch;

import java.util.TreeSet;

public class MinimumAbsoluteSumDifference {
    public static void main(String[] args) {

    }

    private static final int MOD = 1_000_000_007;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int res = 0;
        int reduce = 0;        // max value we may substract from result after replacing

        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            int n1 = nums1[i];
            int n2 = nums2[i];

            int curr = Math.abs(n1 - n2);
            res = (res + curr) % MOD;

            Integer lo = set.floor(n2);
            if (lo != null) {
                reduce = Math.max(reduce, curr - Math.abs(lo - n2));
            }

            Integer hi = set.ceiling(n2);
            if (hi != null) {
                reduce = Math.max(reduce, curr - Math.abs(hi - n2));
            }
        }

        return (res - reduce + MOD) % MOD;
    }
}
