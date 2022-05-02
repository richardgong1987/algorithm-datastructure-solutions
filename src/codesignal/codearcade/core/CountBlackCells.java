package codesignal.codearcade.core;

public class CountBlackCells {
	public static void main(String[] args) {
		CountBlackCells s = new CountBlackCells();
		System.out.println(s.solution(3, 4));

		int[] a = new int[]{2, 2, 1};
		int[] b = new int[]{10, 11};
		int[] arr = new int[a.length + b.length];

		for (int i = 0; i < a.length; i++) {
			arr[i] = a[i];
		}

		for (int i = 0; i < b.length; i++) {
			arr[i + a.length] = b[i];
		}


	}

	int solution(int n, int m) {
		if (n == m) {
			return n + 2 * (n - 1);
		}
		if (n == 1 || m == 1) {
			return m * n;
		}

		return n + m - gcd(n, m) + (gcd(n, m) - 1) * 2;
	}

	int gcd(int n, int m) {
		while (m > 0) {
			int tmp = n;
			n = m;
			m = tmp % m;
		}
		return n;
	}
}
