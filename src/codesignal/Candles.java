package codesignal;

public class Candles {
	public static void main(String[] args) {
		Candles s = new Candles();
		System.out.println(s.solution(5, 2));
	}

	int solution(int candlesNumber, int makeNew) {
		int totalBurned = 0;
		int leftovers = 0;

		while (candlesNumber > 0) {
			totalBurned += candlesNumber;
			leftovers += candlesNumber;

			candlesNumber = leftovers / makeNew;
			leftovers = leftovers % makeNew;
		}

		return totalBurned;
	}

}
