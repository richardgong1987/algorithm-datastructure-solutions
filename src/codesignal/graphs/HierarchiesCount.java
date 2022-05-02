package codesignal.graphs;

public class HierarchiesCount {
	int solution(int n, int[][] respectList) {
		int MOD = 1000000007;
		long[][] matrix = new long[n][n];
		for (int[] edge : respectList) {
			matrix[edge[0]][edge[0]]++;
			matrix[edge[1]][edge[1]]++;
			matrix[edge[0]][edge[1]] = MOD - 1;
			matrix[edge[1]][edge[0]] = MOD - 1;
		}
		long result = 1;
		for (int i = 0; i < matrix.length - 1; i++) {
			long modInverse = modInverse(matrix[i][i], MOD);
			result = (result * modInverse) % MOD;
			for (int j = i; j < matrix.length; j++) {
				matrix[i][j] = (modInverse * matrix[i][j]) % MOD;
			}
			for (int ii = i + 1; ii < matrix.length; ii++) {
				if (matrix[ii][i] == 0) continue;
				long multiple = MOD - matrix[ii][i];
				for (int jj = i; jj < matrix.length; jj++)
					matrix[ii][jj] = (matrix[ii][jj] + matrix[i][jj] * multiple) % MOD;
			}
		}
		return (int) ((modInverse(result, MOD) * n) % MOD);
	}

	private long modInverse(long a, long m) { // Thanks fermat!
		long exponent = m - 2; //m *must* be prime
		long result = 1;
		while (exponent > 0) {
			if (exponent % 2 == 1) result = (result * a) % m;
			exponent >>= 1;
			a = (a * a) % m;
		}
		return result;
	}
}
