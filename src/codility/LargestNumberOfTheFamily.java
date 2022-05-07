package codility;

import java.util.ArrayList;
import java.util.List;

public class LargestNumberOfTheFamily {
    public static void main(String[] args) {
        LargestNumberOfTheFamily s = new LargestNumberOfTheFamily();
        System.out.println(s.solution(213));
    }

    public int solution(int N) {
        List<Integer> digit = getDigit(N);
        digit.sort(((a, b) -> b - a));
        int result = 0;
        for (Integer i : digit) {
            result = result * 10 + i;

        }
        return result;
    }

    List<Integer> getDigit(int n) {
        List<Integer> list = new ArrayList<>();
        while (n > 0) {
            list.add(n % 10);
            n = n / 10;
        }
        return list;
    }
}
