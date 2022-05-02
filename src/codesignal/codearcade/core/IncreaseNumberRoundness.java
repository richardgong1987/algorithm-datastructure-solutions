package codesignal.codearcade.core;

public class IncreaseNumberRoundness {
	public static void main(String[] args) {
		IncreaseNumberRoundness s = new IncreaseNumberRoundness();
		System.out.println(s.solution(11000));
	}
	boolean solution(int n) {
		while (n % 10 == 0) {
			n = n / 10;
		}
		while (n % 10 != 0) {
			n = n / 10;
		}

		return n != 0;
	}

}
