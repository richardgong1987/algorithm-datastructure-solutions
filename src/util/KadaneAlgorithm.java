package util;


import static java.lang.System.*;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int i = maxSubarray(new int[]{34, -50, 42, 14, -5, 86});
        out.println(i);
    }

    public static int maxSubarray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i],nums[i]+nums[i-1]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
