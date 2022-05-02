package codesignal;

public class Minesweeper {
	static boolean check(int x, int y, int xSize, int ySize) {
		return x > -1 && x < xSize && y > -1 && y < ySize;
	}

	public static int[][] solution(boolean[][] matrix) {
		int rowLen = matrix.length;
		int colLen = matrix[0].length;

		int[][] v = new int[rowLen][colLen];

		int[] xStandard = {-1, 1, 0, 0, -1, 1, -1, 1};

		int[] yStandard = {0, 0, -1, 1, -1, -1, 1, 1};

		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				for (int k = 0; k < 8; k++) {
					if (check(j + xStandard[k], i + yStandard[k], colLen, rowLen) && matrix[i + yStandard[k]][j + xStandard[k]]) {
						v[i][j]++;
					}
				}
			}
		}
		return v;
	}


	public static void main(String[] args) {

	}
}
