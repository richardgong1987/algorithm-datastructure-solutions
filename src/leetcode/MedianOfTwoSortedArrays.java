package leetcode;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
		MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
		double medianSortedArrays = medianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
		System.out.println(medianSortedArrays);
	}

	/**
	 * https://mp.weixin.qq.com/s/OE4lHO8-jOIxIfWO_1oNpQ
	 */
	public double findMedianSortedArrays(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;

		if (A.length > B.length) {
			return findMedianSortedArrays(B, A);
		}

		int start = 0;
		int end = m;
		int mid = (m + n + 1) / 2;

		while (start <= end) {
			int i = (start + end) / 2;
			int j = mid - i;
			if (i < end && B[j - 1] > A[i]) {
				/*i偏小了，需要右移*/
				start = i + 1;
			} else if (i > start && A[i - 1] > B[j]) {
				/*i偏大了，需要左移*/
				end = i - 1;
			} else {
				/*i刚好合适*/
				int maxLeft;
				if (i == 0) {
					/*数组A的元素都大于数组B的情况*/
					maxLeft = B[j - 1];
				} else if (j == 0) {
					/*数组A的元素都小于数组B的情况*/
					maxLeft = A[i - 1];
				} else {
					maxLeft = Math.max(A[i - 1], B[j - 1]);
				}

				if ((m + n) % 2 == 1) {
					/*如果大数组的长度是奇数，中位数就是左半部分的最大值*/
					return maxLeft;
				}

				int minRight;
				if (i == m) {
					minRight = B[j];
				} else if (j == n) {
					minRight = A[i];
				} else {
					minRight = Math.min(B[j], A[i]);
				}

				/*如果大数组的长度是偶数，取左侧最大值和右侧最小值的平均*/
				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
	}
}