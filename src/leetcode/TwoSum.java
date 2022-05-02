package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		int[] ints = twoSum.twoSum(new int[]{3, 3}, 6);
		System.out.println(Arrays.toString(ints));
	}

	public int[] twoSum(int[] nums, int target) {

		HashMap<Integer, Integer> store = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int findKey = target - nums[i];
			if (store.containsKey(findKey)) {
				return new int[]{store.get(findKey), i};
			}
			store.put(nums[i], i);
		}
		return null;
	}
}
