package codesignal.practicetest;

import java.util.Arrays;

public class Zigzag {
    public static void main(String[] args) {
        Zigzag s = new Zigzag();
        System.out.println(Arrays.toString(s.solution(new int[]{1, 2, 1, 3, 4})));
    }

    int[] solution(int[] numbers) {
        int len = numbers.length - 2;
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            int a = numbers[i];
            int b = numbers[i + 1];
            int c = numbers[i + 2];
            result[i] = 0;
            if ((a < b && b > c) || (a > b && b < c)) {
                result[i] = 1;
            }

        }

        return result;

    }

}
