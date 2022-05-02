package codesignal.bit;

public class ArrayPacking {
	public static void main(String[] args) {

		int[] a = new int[]{0, 0, 0, 0};
		int[] input = new int[]{24, 85, 0};
		System.arraycopy(input, 0, a, 0, input.length);

		int i = a[3] << 24 | a[2] << 16 | a[1] << 8 | a[0];

		System.out.println(i);

	}
}
