package codesignal.codearcade.bit;

public class EqualPairofBits {
	int solution(int n, int m) {
		return ~(n ^ m) & ((n ^ m) + 1);
	}
	int solution2(int n, int m) {
		return ~(n ^ m) & -(~(n ^ m));
	}
	/**

	 Similar to previous post of “Different Rightmost Bit”, if we do XOR operation between the two numbers, we have 1 in every position that differs.

	 n = 1010 = 1010
	 m = 1110 = 1011

	 n ^ m =

	   1010
	 ^
	   1011
	 -------
	 = 0001

	 Since 1 bit means the two number differed in that position, the rightmost 0 bit is the rightmost position of equal bits.

	 Let’s take a complement of this.
	 ~0001 = 1110

	 Now, the rightmost 1 bit is the rightmost position of equal bits.

	 There are two options to take now.
	 With our x = n ^ m,

	 ~x & (x+1): AND operation with its complement and x+1
	 ~x & -(~x): AND operation with its complement and negative complement
	 Example is shown in the previous “Different Rightmost Bit” post


	 */


}
