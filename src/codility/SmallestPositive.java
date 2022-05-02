package codility;

import java.util.Arrays;

public class SmallestPositive {

	public static int solution(int[] A) {
		Arrays.sort(A);

		int maxv = A[A.length - 1];
		if (maxv <= 0) {
			return 1;
		} else {
			int i;
			for (i = 1; i < (maxv + 1); i++) {
				if (!check(A, i)) return i;
			}
		}
		return maxv + 1;

	}

	static boolean check(int[] A, int b) {
		for (int i = 0; i < A.length; i++) {
			if (b == A[i]) return true;
		}
		return false;
	}

	public static void main(String[] args) {

	}
}
