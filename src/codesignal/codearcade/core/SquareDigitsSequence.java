package codesignal.codearcade.core;

import java.util.ArrayList;

public class SquareDigitsSequence {
	public static void main(String[] args) {
		SquareDigitsSequence s = new SquareDigitsSequence();
		System.out.println(s.solution(103));
	}

	int solution(int a) {
		int count = 1;
		int b = a;
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(a);
		while (true) {
			int c = 0;
			count++;
			while (b > 0) {
				c += (b % 10) * (b % 10);
				b /= 10;
			}
			if (arr.contains(c)) {
				break;
			}
			arr.add(c);
			b = c;

		}
		return count;
	}


}
