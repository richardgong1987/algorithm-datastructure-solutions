package codesignal.bit;

public class killKthBit {
	int solution(int n, int k) {
		// 37 => 100101
		// 1  => 000001
		// 1 << (k - 1) => 1 << 2 => 000100
		// ~(1 << (k - 1)) => 111011
		// n&~(1<<(k-1)) => 100101 & 111011
		return n & (~(1 << (k - 1)));
	}

	int killKthBit(int n, int k) {
		// 37               => 100101
		// 1                => 000001
		// 1 << (k - 1)     => 1 << 2   => 000100
		// ~(1 << (k-1))    => 111011
		// n&~(1<<(k-1))    => 100101 & 111011 = 100001
		return n & ~(1 << (k - 1));
	}
}
