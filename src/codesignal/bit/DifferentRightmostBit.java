package codesignal.bit;

public class DifferentRightmostBit {
	/**
	 Explanation

	 Let’s take n = 11 and m = 13 for example.
	 11 = 1011
	 13 = 1101

	 If we do XOR operation with n and m, we have 1 in every position that differs between the two.
	 11 ^ 13 = 1011 ^ 1101 = 0110 = 6

	 since we have a bit representation of the positions that differ, we need to find the rightmost 1.

	 there is a trick to this. given a number x,
	 x & -x gives the rightmost 1

	 x  =  6 = 0110
	 -x = -6 = 1010

	 x & -x = 0110 & 1010 = 0010

	 So, (n^m) & -(n^m) is our answer.

	 */
	int solution(int n, int m) {
		return (n ^ m) & -(n ^ m);
	}
}
