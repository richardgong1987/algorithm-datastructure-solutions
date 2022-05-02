package codesignal;

public class IsSumofConsecutive2 {
	public static void main(String[] args) {
		IsSumofConsecutive2 s = new IsSumofConsecutive2();
		System.out.println(s.solution(9));
	}

	int solution(int n) {
		int count = 0;
		int i;
		int m;

		for (i = 1, m = i; m < n; i++, m += i) {
			if ((n - m) % (i + 1) == 0) {
				count++;
			}
		}
		return count;
	}

}
