package codesignal;

public class AdditionWithoutCarrying {
	public static void main(String[] args) {
		AdditionWithoutCarrying a = new AdditionWithoutCarrying();
		int solution = a.solution(456, 1734);
		System.out.println(solution);
	}

	int solution2(int param1, int param2) {
		int sum = 0;
		if (param1 > param2) {
			int tmp = param2;
			param2 = param1;
			param1 = tmp;
		}
		while (param2 > 0) {
			int a = param1 % 10;
			int b = param2 % 10;
			sum += ((a + b) % 10);
			param1 = param1 / 10;
			param2 = param2 / 10;
		}
		System.out.println(sum);
		return sum;
	}

	int solution(int param1, int param2) {
		if (param1 == 0 && param2 == 0) {
			return 0;
		}
		int result = ((param1 % 10) + (param2 % 10)) % 10;
		return solution(param1 / 10, param2 / 10) * 10 + result;

	}
}
