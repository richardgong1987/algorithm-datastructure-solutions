package codesignal;

public class DigitDegree {
	public static void main(String[] args) {
		DigitDegree digitDegree = new DigitDegree();
		System.out.println(digitDegree.solution(91));
	}
	int solution(int n) {
		var count = 0;
		while (n >= 10) {
			count++;
			var sum = 0;
			while (n > 0) {
				sum += n % 10;
				n /= 10;
			}
			n = sum;
		}
		return count;
	}
}
