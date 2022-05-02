package codesignal;

import java.util.Arrays;

public class CircularMatrix {

	static int MAX = 100;

	static int[][] solution(int n) {
		int m = n;


		int val = 1;

		int k = 0;
		int l = 0;
		int[][] a = new int[m][n];
		while (k < m && l < n) {
			for (int i = l; i < n; ++i) {
				a[k][i] = val++;
			}

			k++;

			for (int i = k; i < m; ++i) {
				a[i][n - 1] = val++;
			}
			n--;

			if (k < m) {
				for (int i = n - 1; i >= l; --i) {
					a[m - 1][i] = val++;
				}
				m--;
			}

			if (l < n) {
				for (int i = m - 1; i >= k; --i) {
					a[i][l] = val++;
				}
				l++;
			}
		}
		return a;
	}

	static void spiralFill(int m, int n, int a[][]) {
		// Initialize value to be filled in matrix
		int val = 1;

		/* k - starting row index
		m - ending row index
		l - starting column index
		n - ending column index */
		int k = 0;
		int l = 0;
		while (k < m && l < n) {
			/* Print the first row from the remaining
		rows */
			for (int i = l; i < n; ++i) {
				a[k][i] = val++;
			}

			k++;

			/* Print the last column from the remaining
		columns */
			for (int i = k; i < m; ++i) {
				a[i][n - 1] = val++;
			}
			n--;

			/* Print the last row from the remaining
		rows */
			if (k < m) {
				for (int i = n - 1; i >= l; --i) {
					a[m - 1][i] = val++;
				}
				m--;
			}

			/* Print the first column from the remaining
		columns */
			if (l < n) {
				for (int i = m - 1; i >= k; --i) {
					a[i][l] = val++;
				}
				l++;
			}
		}
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		int[][] a = new int[][]{
				{1, 2, 3, 4, 5, 6},
				{14, 15, 16, 17, 18, 7},
				{13, 12, 11, 10, 9, 8}
		};
		spiralFill(3, 6, new int[3][6]);
		System.out.println(Arrays.deepToString(a));
//		System.out.println(Arrays.deepToString(r));

	}

}
