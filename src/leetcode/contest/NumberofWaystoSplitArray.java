package leetcode.contest;

import java.util.Arrays;

public class NumberofWaystoSplitArray {
    public static void main(String[] args) {
        NumberofWaystoSplitArray s = new NumberofWaystoSplitArray();
        System.out.println(s.waysToSplitArray(new int[]{10, 4, -8, 7}));
    }

    public int waysToSplitArray(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        int result = 0;

        int lSum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            lSum += nums[i];
            int rSum = sum - lSum;
            if (lSum >= rSum) {
                result++;
            }
        }


        return result;
    }
}
