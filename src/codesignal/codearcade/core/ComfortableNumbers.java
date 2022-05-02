package codesignal.codearcade.core;

public class ComfortableNumbers {
    int digitSum(int n) {
        int sum = 0;

        while (n != 0) {
            sum += (n % 10);
            n = n / 10;
        }

        return sum;
    }

    int solution(int L, int R) {
        int totalPairs = 0;

        for (int i = L; i <= R; i++) {
            for (int j = i + 1; j <= R; j++) {
                int sA = digitSum(i);
                int sB = digitSum(j);
                if (j >= (i - sA) && j <= (i + sA) && i >= (j - sB) && i <= (j + sB)) {
                    totalPairs++;
                }
            }
        }
        return totalPairs;
    }
}
