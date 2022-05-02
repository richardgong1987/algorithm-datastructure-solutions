package codesignal.bit;

public class SwapAdjacentBits {
	public static String toBinaryString(int n) {
		return String.format("%32s", Integer.toBinaryString(n))
				.replaceAll(" ", "0");
	}

	// Function to swap adjacent bits of a given number
	public static int swapAdjacentBits(int n) {
		return (((n & 0xAAAAAAAA) >> 1) | ((n & 0x55555555) << 1));
	}

	public static void main(String[] args) {
		int n = 13;

		System.out.println(n + " in binary is " + toBinaryString(n));
		n = swapAdjacentBits(n);
		System.out.println("\nAfter Swapping…");
		System.out.println(n + " in binary is " + toBinaryString(n));
	}
}
