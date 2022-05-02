package codesignal.codearcade.core;

import java.util.Arrays;

public class AreSimilar {
	static boolean areSimilar(int[] a, int[] b) {

		int cnt = 0;
		boolean result;

		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				cnt++;
			}
		}

		Arrays.sort(a);
		Arrays.sort(b);

		if (Arrays.equals(a, b)) {
			result = cnt <= 2;
		} else {
			result = false;
		}
		return result;
	}

	public static void main(String[] args) {

	}
}
