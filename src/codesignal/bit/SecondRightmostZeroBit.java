package codesignal.bit;

public class SecondRightmostZeroBit {
	static int secondRightmostZeroBit(int n) {
		return ~(n |= -~n) & -~n;
	}

	static int secondRightmostZeroBit2(int n) {
		return (~(n | (n + 1))) & ((n | (n + 1)) + 1);
	}

	public static void main(String[] args) {
//		SecondRightmostZeroBit s = new SecondRightmostZeroBit();
//		System.out.println(s.solution(37));
		System.out.println(secondRightmostZeroBit2(15));
	}

	int solution(int n) {
		int sum = 1;
		int time = 0;
		while (n > 0) {
			if (isZeroBit(n)) {
				time++;
			}
			n = n >> 1;
			if (time == 2) {
				break;
			}
			sum = sum << 1;

		}
		return sum;
	}

	boolean isZeroBit(int n) {
		return (n & 1) == 0;
	}

}
