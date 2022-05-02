package codesignal;

import java.util.Arrays;

public class BoxBlurImage {
	/**
	 * This function will calculate the value x
	 * * 	  (i.e. blurred pixel value) for each 3 * 3 blur image
	 */
	public static int squareMatrix(int[][] square) {
		var totSum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// Calculate sum of all the pixels in 3 * 3 matrix
				totSum += square[i][j];
			}
		}
		return totSum / 9; // return the average of the sum of pixels
	}

	public static int getUnitSum(int[][] square, int rPointer, int cPointer) {
		int[][] sm = new int[3][3];
		for (int i = 0; i < 3; i++) {
			System.arraycopy(square[rPointer + i], cPointer, sm[i], 0, 3);
		}
		return squareMatrix(sm);
	}

	/**
	 * This function will calculate the blurred
	 * image for given n * n image.
	 */
	public static int[][] boxBlur(int[][] image) {
		// number of rows in the given image
		var nRows = image.length;
		// number of columns in the given image
		var nCol = image[0].length;

		int[][] result = new int[nRows - 3 + 1][nCol - 3 + 1];

		for (int rPointer = 0; rPointer <= nRows - 3; rPointer++) {
			int[] colResult = new int[nCol - 3 + 1];
			for (int cPointer = 0; cPointer <= nCol - 3; cPointer++) {
				colResult[cPointer] = getUnitSum(image, rPointer, cPointer);
			}
			result[rPointer] = colResult;
		}

		return result;
	}


	public static void main(String[] args) {
		{
			var image = new int[][]{{7, 4, 0, 1}, {5, 6, 2, 2}, {6, 10, 7, 8}, {1, 4, 2, 0}};
			int[][] ints = boxBlur(image);
			System.out.println(Arrays.deepToString(ints));
		}
		{
			var image = new int[][]{{36, 0, 18, 9}, {27, 54, 9, 0}, {81, 63, 72, 45}};
			int[][] ints = boxBlur(image);
			System.out.println(Arrays.deepToString(ints));
		}
	}
}
