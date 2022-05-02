package codesignal.bit;

public class ReverseBits {
	public static void main(String[] args) {
		System.out.println(reverseDigits(97));
	}

	/* Iterative function to reverse
   digits of num*/
	static int reverseDigits(int num) {
		int revNum = 0;
		while (num > 0) {
			revNum = revNum * 2 + num % 2;
			num = num / 2;
		}
		return revNum;
	}
}
