package smartnewsInterview;

/**
 * An array is called "switching" if the odd and even elements are equal.
 * <p>
 * Example:
 * <p>
 * [2,4,2,4] is a switching array because the members in even positions (indexes 0 and 2) and odd positions (indexes 1 and 3) are equal.
 * <p>
 * If A = [3,7,3,7, 2, 1, 2], the switching sub-arrays are:
 * <p>
 * == > [3,7,3,7] and [2,1,2]
 * <p>
 * Therefore, the longest switching sub-array is [3,7,3,7] with length = 4.
 * <p>
 * As another example if A = [1,5,6,0,1,0], the the only switching sub-array is [0,1,0].
 * <p>
 * Another example: A= [7,-5,-5,-5,7,-1,7], the switching sub-arrays are [7,-1,7] and [-5,-5,-5].
 * <p>
 * Question:
 * <p>
 * Write a function that receives an array and find its longest switching sub-array.
 * <p>
 * I would like to know how you solve this problem and which strategies you use to solve this with a good time complexity?
 */
public class ArraySwitching {
	public int solution(int[] A) {
		// write your code in Java SE 8
		if (A.length == 1) {
			return 1;
		}
		int even = A[0];
		int odd = A[1];
		int start = 0;
		int maxLength = 0;
		for (int i = 2; i < A.length; i++) {
			/**
			 *
			 * (number & 1) == 0 :is mean: even
			 * (number & 1) == 1 :is mean: odd
			 *
			 */
			if ((i & 1) == 0 && A[i] != even || (i & 1) == 1 && A[i] != odd) {
				maxLength = Math.max(maxLength, i - start);
				start = i - 1;
				if ((i & 1) == 0) {
					even = A[i];
					odd = A[i - 1];
				} else {
					even = A[i - 1];
					odd = A[i];
				}
			}
		}
		return Math.max(maxLength, A.length - start);
	}
}
